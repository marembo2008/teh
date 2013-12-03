/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.teh.main;

import com.anosym.teh.request.Exchange;
import com.anosym.teh.request.PostRequest;
import com.anosym.teh.request.auth.FirstLoginRequest;
import com.anosym.teh.request.auth.LoginRequest;
import com.anosym.teh.request.auth.logout.LogoutRequest;
import com.anosym.teh.request.auth.otp.OTOAuthLoginRequest;
import com.anosym.teh.request.auth.otp.OTPSendRequest;
import com.anosym.teh.request.auth.otp.OTPVerifyRequest;
import com.anosym.teh.request.marketdata.IntraDayGraphRequest;
import com.anosym.teh.request.marketdata.MarketDepthRequest;
import com.anosym.teh.request.marketdata.SecurityInfoRequest;
import com.anosym.teh.request.scrip.ScripSearchOnTextAndExchangeRequest;
import com.anosym.teh.response.ADXContract;
import com.anosym.teh.response.Response;
import com.anosym.teh.response.auth.LoginResponse;
import com.anosym.teh.response.auth.LoginResponse.LoginInfo;
import com.anosym.teh.response.marketdata.Chart;
import com.anosym.teh.response.marketdata.IntraDayGraphResponse;
import com.anosym.teh.response.marketdata.MarketDepth;
import com.anosym.teh.response.marketdata.MarketDepthResponse;
import com.anosym.teh.response.marketdata.SecurityInfo;
import com.anosym.teh.response.marketdata.SecurityInfoResponse;
import com.anosym.teh.response.marketdata.controller.IntraDayGraphJpaController;
import com.anosym.teh.response.marketdata.controller.MarketDepthJpaController;
import com.anosym.teh.response.marketdata.controller.SecurityInfoJpaController;
import com.anosym.teh.response.scrip.Scrip;
import com.anosym.teh.response.scrip.ScripDataResponse;
import com.anosym.teh.response.scrip.controller.ScripJpaController;
import com.anosym.utilities.cl.CommandLineArgument;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author marembo
 */
public class TehMain {

    public static final String userId = "INV32-CHND";
    public static final String password =/* "master12"; /*/ "a123456";
    public static final String ip = "192.168.0.43";
    public static final String token = "8599433655";
    public static final String otpPassword = "";
    private static LoginResponse login;
    private static boolean requestdata = true;
    private static Exchange[] exchanges;
    private static String[] args;
    private static volatile int last_updated_index;
    private static final Queue<MarketDepth> MARKETDEPTH = new ConcurrentLinkedQueue<MarketDepth>();
    private static final List<PostRequest> REQUESTS = new ArrayList<PostRequest>();
    private static final int REQUEST_THREADS = 4;
    private static final int RESPONSE_THREADS = 4;
    private static final String REQUEST_THREAD_OPTION = "req";
    private static final String RESPONSE_THREAD_OPTION = "res";
    private static final Map<Exchange, List<Scrip>> SCRIPS = new EnumMap<Exchange, List<Scrip>>(Exchange.class);

    public static void main(String[] args) {
        TehMain.args = args;
        CommandLineArgument.init(args);
        if (CommandLineArgument.hasParameterId("market")) {
            String param = CommandLineArgument.clParameter("market");
            String[] params = param.split(",");
            exchanges = new Exchange[params.length];
            for (int i = 0; i < params.length; i++) {
                exchanges[i] = Exchange.valueOf(params[i].toUpperCase());
            }
            loadScrips();
            startMarketDepth();
            int requestThreads = REQUEST_THREADS;
            int responseThreads = RESPONSE_THREADS;
            if (CommandLineArgument.hasParameterId(REQUEST_THREAD_OPTION)) {
                requestThreads = Integer.parseInt(CommandLineArgument.clParameter(REQUEST_THREAD_OPTION));
            }
            if (CommandLineArgument.hasParameterId(RESPONSE_THREAD_OPTION)) {
                responseThreads = Integer.parseInt(CommandLineArgument.clParameter(RESPONSE_THREAD_OPTION));
            }
            startRequests(1);
            startMarketDepthData(responseThreads);
            new Thread(new Runnable() {

                @Override
                public void run() {
                    int last_updated = TehMain.last_updated_index;
                    while (true) {
                        synchronized (TehMain.class) {
                            try {
                                TehMain.class.wait(120000);
                                if (last_updated == TehMain.last_updated_index) {
                                    //we are hung
                                    restartApplication(TehMain.args);
                                } else {
                                    last_updated = last_updated_index;
                                }
                            } catch (InterruptedException ex) {
                                Logger.getLogger(TehMain.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    }
                }
            }).start();
        } else {
            System.out.println("Usage java -jar teh.jar --market=m1,m2,..");
        }

    }

    private static void startMarketDepth() {
        if (doDefaultLogin()) {
            for (Exchange ex : exchanges) {
                doGetQuoteWithMarketDepth(ex);
            }
        }
    }

    private static void loadScrips() {
        ScripJpaController sjc = new ScripJpaController();
        for (Exchange ex : exchanges) {
            try {
                Scrip[] scrips = getScrips(ex);
                if (scrips != null) {
                    System.out.println("SCRIPS: " + scrips.length);
                    SCRIPS.put(ex, Arrays.asList(scrips));
                }
            } finally {
                logout();
            }
        }
    }

    private static void logout() {
        LogoutRequest request = new LogoutRequest(
                login.getLoginInfo().getLoginToken(),
                login.getLoginInfo().getLoginId());
        System.out.println(request.doRequest());
        login = null;
    }

    public static boolean doDefaultLogin() {
        if (login == null) {
            LoginRequest lr = new LoginRequest(userId, password, ip);
            Response r = lr.doRequest();
            if (r instanceof LoginResponse) {
                login = (LoginResponse) r;
                return true;
            }
        }
        return false;
    }

    public static void doMarketDataRequest() {
        if (doDefaultLogin()) {
            SecurityInfoJpaController sijc = new SecurityInfoJpaController();
            ScripJpaController sjc = new ScripJpaController();
            LoginInfo loginInfo = login.getLoginInfo();
            //WE CAN ONLY HAVE TWO TYPES OF EXCHANGE FOR THIS TYPE OF REQUEST.
            Exchange[] scripExchanges = {Exchange.NSE, Exchange.BSE};
            for (Exchange e : scripExchanges) {
                ScripSearchOnTextAndExchangeRequest request = new ScripSearchOnTextAndExchangeRequest(
                        loginInfo.getLoginId(), loginInfo.getLoginToken(), null, e, null);
                Response r = request.doRequest();
                System.out.println(r);
                if (r instanceof ScripDataResponse) {
                    ScripDataResponse response = (ScripDataResponse) r;
                    //get the market data
                    for (Scrip sd : response.getScrips()) {
                        try {
                            sjc.createOrUpdate(sd);
                            SecurityInfoRequest sir = new SecurityInfoRequest(
                                    loginInfo.getLoginId(),
                                    loginInfo.getLoginToken(),
                                    e,
                                    sd.getSymbol());
                            Response r1 = sir.doRequest();
                            System.out.println(r1);
                            if (r1 instanceof SecurityInfoResponse) {
                                SecurityInfoResponse infoResponse = (SecurityInfoResponse) r1;
                                SecurityInfo info = infoResponse.getSecurityInfo();
                                sijc.createOrUpdate(info);
                            }
                        } catch (Exception ex) {
                            Logger.getLogger(TehMain.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            }
        }
    }

    private static List<ADXContract> loadADXContracts() {
        String filePath = "C:\\Users\\marembo\\Downloads\\symbols.csv";
        List<ADXContract> l = new ArrayList<ADXContract>();
        File file = new File(filePath);
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] tsd = line.split(",");
                ADXContract adxc = new ADXContract();
                adxc.setTokenId(Integer.parseInt(tsd[0]));
                adxc.setSymbol(tsd[1]);
                l.add(adxc);
            }
        } catch (IOException ex) {
            Logger.getLogger(TehMain.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NumberFormatException ex) {
            Logger.getLogger(TehMain.class.getName()).log(Level.SEVERE, null, ex);
        }
        return l;
    }

    public static void doMarketDataRequestFromADXContracts() {
        if (doDefaultLogin()) {
            //WE CAN ONLY HAVE TWO TYPES OF EXCHANGE FOR THIS TYPE OF REQUEST.
//            Exchange[] scripExchanges = {Exchange.NSE, Exchange.BSE};
//            ADXContractJpaController adxcjc = new ADXContractJpaController();
            List<ADXContract> adxcs = loadADXContracts();
            System.out.println(adxcs);
            //get the market data
            for (ADXContract adxc : adxcs) {
                SecurityInfoRequest sir = new SecurityInfoRequest(
                        userId, login.getLoginInfo().getLoginToken(), Exchange.NSE, adxc.getSymbol());
                Response r1 = sir.doRequest();
                System.out.println(r1);
                if (r1 instanceof SecurityInfoResponse) {
                    SecurityInfoResponse infoResponse = (SecurityInfoResponse) r1;
                    SecurityInfo info = infoResponse.getSecurityInfo();
                    if (info != null) {
                        SecurityInfoJpaController sijc = new SecurityInfoJpaController();
                        try {
                            sijc.createOrUpdate(info);
                        } catch (Exception ex) {
                            Logger.getLogger(TehMain.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            }
        }
    }

    public static Scrip[] getScrips(Exchange ex) {
        if (doDefaultLogin()) {
            LoginInfo info = login.getLoginInfo();
            ScripSearchOnTextAndExchangeRequest request = new ScripSearchOnTextAndExchangeRequest(
                    info.getLoginId(), info.getLoginToken(), null, ex, null);
            Response r = request.doRequest();
            if (r instanceof ScripDataResponse) {
                return ((ScripDataResponse) r).getScrips();
            }
        }
        return null;
    }

    public static SecurityInfo getSecurityInfo(Scrip scrip) {
        LoginInfo info = login.getLoginInfo();
        SecurityInfoRequest sir = new SecurityInfoRequest(
                info.getLoginId(),
                info.getLoginToken(),
                Exchange.MCX,
                scrip.getSymbol());
        Response r1 = sir.doRequest();
        if (r1 instanceof SecurityInfoResponse) {
            SecurityInfoResponse infoResponse = (SecurityInfoResponse) r1;
            return infoResponse.getSecurityInfo();
        }
        return null;
    }

    public static void doGetQuoteWithMarketDepth(Exchange exc) {
        System.err.println("Exchange...." + exc);
        List<Scrip> scrips = SCRIPS.get(exc);
        System.err.println("Scrips: " + ((scrips != null) ? scrips.size() : 0));
        if (scrips != null) {
            for (final Scrip sd : scrips) {
                REQUESTS.add(new MarketDepthRequest(
                        login.getLoginInfo().getLoginId(),
                        login.getLoginInfo().getLoginToken(),
                        exc,
                        sd.getSymbol()));
            }
        }
    }

    private static void startRequests(int requestThreads) {
        System.out.println("Number of REQUESTS: " + requestThreads);
        int size = REQUESTS.size() / requestThreads;
        for (int i = 0; i < requestThreads; i++) {
            handleRequests(i * size, size);
        }
    }

    private static void handleRequests(int threadId, final int size) {
        new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    int i = 0;
                    for (;;) {
                        PostRequest pr = REQUESTS.get(i);
                        Response mdr_ = pr.doRequest();
                        if (mdr_ instanceof MarketDepthResponse) {
                            MarketDepthResponse mdResponse = (MarketDepthResponse) mdr_;
                            MarketDepth md = mdResponse.getScripDetail();
                            md.setBestBuys(mdResponse.getBestBuys());
                            md.setBestSells(mdResponse.getBestSells());
                            MARKETDEPTH.offer(md);
                            synchronized (MARKETDEPTH) {
                                MARKETDEPTH.notifyAll();
                            }
                            last_updated_index++;
                        } else {
                            System.out.println(mdr_);
                        }
                        i = (i + 1) % size;
                    }
                } finally {
                    System.out.println("Thread stopped");
                }
            }
        }, "TEH-MDR-" + threadId).start();
    }

    private static void startMarketDepthData(int responseThreads) {
        System.out.println("Number of RESPONSE THREADS: " + responseThreads);
        for (int i = 0; i < responseThreads; i++) {
            handleMarketDepthData(i);
        }
    }

    private static void handleMarketDepthData(int threadId) {
        new Thread(new Runnable() {

            final MarketDepthJpaController mdjc = new MarketDepthJpaController();

            {
                //Initialize this entity manager.
                mdjc.getEntityManager();
            }

            @Override
            public void run() {
                try {
                    while (true) {
                        synchronized (MARKETDEPTH) {
                            while (MARKETDEPTH.isEmpty()) {
                                try {
                                    MARKETDEPTH.wait();
                                } catch (InterruptedException ex) {
                                    Logger.getLogger(TehMain.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                        }
                        MarketDepth md;
                        synchronized (MARKETDEPTH) {
                            //several of them might have been woken up at the same time.
                            if (MARKETDEPTH.isEmpty()) {
                                continue;
                            }
                            System.out.println("Market Depth size: " + MARKETDEPTH.size() + "=" + Thread.currentThread().getName());
                            md = MARKETDEPTH.poll();
                        }
                        try {
                            mdjc.createOrUpdate(md);
                        } catch (Exception ex) {
                            Logger.getLogger(TehMain.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                } finally {
                    System.out.println("Thread stopped");
                }
            }
        }, "TEH-MD-" + threadId).start();
    }

    public static void doGetQuoteWithMarketDepth_fromADXContracts() {
        List<ADXContract> adxcs = loadADXContracts();
        if (adxcs != null && doDefaultLogin()) {
            LoginInfo info = login.getLoginInfo();
            for (ADXContract sd : adxcs) {
                try {
//                    sjc.createOrUpdate(sd);
                    MarketDepthRequest mdr = new MarketDepthRequest(
                            info.getLoginId(),
                            info.getLoginToken(),
                            Exchange.MCX,
                            sd.getTokenId() + "");
                    Response mdr_ = mdr.doRequest();
                    System.out.println(mdr_);
                    if (mdr_ instanceof MarketDepthResponse) {
                        MarketDepthResponse mdResponse = (MarketDepthResponse) mdr_;
                    }
                } catch (Exception ex) {
                }
            }
        }
    }

    public static void doIntraDayGraphRequest() {
        if (doDefaultLogin()) {
            //WE CAN ONLY HAVE TWO TYPES OF EXCHANGE FOR THIS TYPE OF REQUEST.
            for (Exchange e : login.getLoginInfo().getLoginExchange()) {
                ScripSearchOnTextAndExchangeRequest request = new ScripSearchOnTextAndExchangeRequest(
                        userId, login.getLoginInfo().getLoginToken(), null, e, null);
                Response r = request.doRequest();
                System.out.println(r);
                if (r instanceof ScripDataResponse) {
                    ScripDataResponse response = (ScripDataResponse) r;
                    //get the market data
                    List<SecurityInfo> infos = new ArrayList<SecurityInfo>();
                    for (Scrip sd : response.getScrips()) {
                        IntraDayGraphRequest sir = new IntraDayGraphRequest(
                                userId, login.getLoginInfo().getLoginToken(), sd.getSymbol(), e.name(), null);
                        Response r1 = sir.doRequest();
                        System.out.println(r1);
                        if (r1 instanceof IntraDayGraphResponse) {
                            IntraDayGraphResponse infoResponse = (IntraDayGraphResponse) r1;
                            Chart chart = infoResponse.getChart();
                            IntraDayGraphJpaController sijc = new IntraDayGraphJpaController();
                            try {
                                sijc.createOrUpdate(chart);
                            } catch (Exception ex) {
                                Logger.getLogger(TehMain.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            infos.clear();
                        }
                    }
                }
            }
        }
    }

    public static Response verifyOtpRequest() {
        OTPVerifyRequest otpvr = new OTPVerifyRequest(userId, password);
        Response r = otpvr.doRequest();
        System.out.println(r);
        return r;
    }

    public static <T> T initOtpAuthentication() {
        OTOAuthLoginRequest alr = new OTOAuthLoginRequest(userId, password, ip);
        Response response = alr.doRequest();
        System.out.println(response);
        return (T) response;
    }

    public static void sendOtpMailRequest() {
        OTPSendRequest otpsr = new OTPSendRequest(userId);
        Response r = otpsr.doRequest();
        System.out.println(r);
    }

    public static Response doFirstTimeLogin() {
        FirstLoginRequest flr = new FirstLoginRequest(userId, password);
        Response r = flr.doRequest();
        System.out.println(r);
        return r;
    }

    public static void restartApplication(String args[]) {
        try {
            final String javaBin = "java";
            final File currentJar = new File(TehMain.class.getProtectionDomain().getCodeSource().getLocation().toURI());

            /* is it a jar file? */
            if (!currentJar.getName().endsWith(".jar")) {
                return;
            }

            /* Build command: java -jar application.jar */
            final ArrayList<String> command = new ArrayList<String>();
            command.add(javaBin);
            command.add("-jar");
            command.add(currentJar.getPath());
            for (String arg : args) {
                command.add(arg);
            }
            final ProcessBuilder builder = new ProcessBuilder(command);
            builder.start();
            System.exit(0);
        } catch (URISyntaxException ex) {
            Logger.getLogger(TehMain.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(TehMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
