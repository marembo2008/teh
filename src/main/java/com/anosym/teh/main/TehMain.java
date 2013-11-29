/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.teh.main;

import com.anosym.teh.request.Exchange;
import com.anosym.teh.request.auth.FirstLoginRequest;
import com.anosym.teh.request.auth.LoginRequest;
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
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
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

    public static void main(String[] args) {
//        doMarketDataRequest();
        Thread t = new Thread(new Runnable() {

            @Override
            public void run() {
                while (requestdata) {
                    doGetQuoteWithMarketDepth();
                }
            }
        });
        t.start();

    }

    public static boolean doDefaultLoginRequest() {
        if (login == null) {
            LoginRequest lr = new LoginRequest(userId, password, ip);
            Response r = lr.doRequest();
//            System.out.println(r);
            if (r instanceof LoginResponse) {
                login = (LoginResponse) r;
                return true;
            }
        }
        return false;
    }

    public static void doMarketDataRequest() {
        if (doDefaultLoginRequest()) {
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
        if (doDefaultLoginRequest()) {
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
        if (doDefaultLoginRequest()) {
            LoginInfo info = login.getLoginInfo();
            ScripSearchOnTextAndExchangeRequest request = new ScripSearchOnTextAndExchangeRequest(
                    info.getLoginId(), info.getLoginToken(), null, ex, null);
            Response r = request.doRequest();
//            System.out.println(r);
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
//    System.out.println(r1);
        if (r1 instanceof SecurityInfoResponse) {
            SecurityInfoResponse infoResponse = (SecurityInfoResponse) r1;
            return infoResponse.getSecurityInfo();
        }
        return null;
    }

    public static void doGetQuoteWithMarketDepth() {
        Exchange[] exchanges = {Exchange.MCX, Exchange.NSE, Exchange.NCDEX};
        for (Exchange exc : exchanges) {
            Scrip[] scrips = getScrips(exc);
            if (scrips != null) {
                MarketDepthJpaController mdjc = new MarketDepthJpaController();
                LoginInfo info = login.getLoginInfo();
                for (Scrip sd : scrips) {
                    try {
                        MarketDepthRequest mdr = new MarketDepthRequest(
                                info.getLoginId(),
                                info.getLoginToken(),
                                exc,
                                sd.getSymbol());
                        Response mdr_ = mdr.doRequest();
//                        System.out.println(mdr_);
                        if (mdr_ instanceof MarketDepthResponse) {
                            MarketDepthResponse mdResponse = (MarketDepthResponse) mdr_;
                            MarketDepth md = mdResponse.getScripDetail();
                            md.setBestBuys(mdResponse.getBestBuys());
                            md.setBestSells(mdResponse.getBestSells());
                            mdjc.createOrUpdate(mdResponse.getScripDetail());
                        }
                    } catch (Exception ex) {
                    }
                }
            }
        }
    }

    public static void doGetQuoteWithMarketDepth_fromADXContracts() {
        List<ADXContract> adxcs = loadADXContracts();
        if (adxcs != null && doDefaultLoginRequest()) {
            ScripJpaController sjc = new ScripJpaController();
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
        if (doDefaultLoginRequest()) {
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
}
