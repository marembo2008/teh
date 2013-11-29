/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.teh.request.marketdata;

import com.anosym.teh.response.marketdata.MarketDepthResponse;
import java.math.BigDecimal;
import java.util.Calendar;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author marembo
 */
public class MarketDepthRequestTest {

  public MarketDepthRequestTest() {
  }

  @Before
  public void setUp() {
  }

  @After
  public void tearDown() {
  }

  @Test
  public void testGetResponse() {
    String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n"
            + "<omnereports>\n"
            + "<mbp>\n"
            + "<lasttradedprice>720.95</lasttradedprice>\n"
            + "<lasttradedqty>50</lasttradedqty>\n"
            + " <lasttradedtime>1310637830</lasttradedtime>\n"
            + "<percentagechange>-0.72</percentagechange>\n"
            + "<abschange>-5.25</abschange>\n"
            + "<symbol>ABB</symbol>\n"
            + "<series>EQ</series>\n"
            + "<weightedavg>721.33</weightedavg>\n"
            + "<openrate>730.00</openrate>\n"
            + "<previouscloserate>726.20</previouscloserate>\n"
            + "<highrate>730.00</highrate>\n"
            + "<lowrate>715.00</lowrate>"
            + "<trend>-</trend>\n"
            + "<volume>26090</volume>\n"
            + "<triggerpercent>26090</triggerpercent>\n"
            + "<totalbuyqty>11337</totalbuyqty>\n"
            + "<totalsellqty>12438</totalsellqty>\n"
            + "<lowercircuitlimit>0.00</lowercircuitlimit>\n"
            + "<highercircuitlimit>0.00</highercircuitlimit>\n"
            + "<openinterest>0</openinterest>\n"
            + "<value>1881.95</value>\n"
            + "<yearlyhighprice>0.00</yearlyhighprice>\n"
            + "<yearlylowprice>0.00</yearlylowprice>\n"
            + "<tradingsymbol>WIPRO-EQ</tradingsymbol>\n"
            + "<companyname>WIPRO LTD</companyname>\n"
            + "</mbp>\n"
            + "<best5buy>\n"
            + "<omnesingleentry>\n"
            + "<bestbuysize1>5</bestbuysize1>\n"
            + "<bestbuyprice1>721.00</bestbuyprice1>\n"
            + "<bestbuyorders1>1</bestbuyorders1>\n"
            + "</omnesingleentry>\n"
            + "<omnesingleentry>\n"
            + "<bestbuysize2>5</bestbuysize2>\n"
            + "<bestbuyprice2>720.60</bestbuyprice2>\n"
            + "<bestbuyorders2>1</bestbuyorders2>\n"
            + "</omnesingleentry>\n"
            + "<omnesingleentry>\n"
            + "<bestbuysize3>10</bestbuysize3>\n"
            + "<bestbuyprice3>720.55</bestbuyprice3>\n"
            + "<bestbuyorders3>1</bestbuyorders3>\n"
            + "</omnesingleentry>\n"
            + "<omnesingleentry>\n"
            + "<bestbuysize4>25</bestbuysize4>\n"
            + "<bestbuyprice4>720.35</bestbuyprice4>\n"
            + "<bestbuyorders4>1</bestbuyorders4>\n"
            + "</omnesingleentry>\n"
            + "<omnesingleentry>\n"
            + "<bestbuysize5>25</bestbuysize5>\n"
            + "<bestbuyprice5>720.20</bestbuyprice5>\n"
            + "<bestbuyorders5>1</bestbuyorders5>\n"
            + "</omnesingleentry>\n"
            + "</best5buy>\n"
            + "<best5sell>\n"
            + "<omnesingleentry>\n"
            + "<bestsellsize1>92</bestsellsize1>\n"
            + "<bestsellprice1>722.35</bestsellprice1>\n"
            + "<bestsellorders1>4</bestsellorders1>\n"
            + "</omnesingleentry>\n"
            + "<omnesingleentry>\n"
            + "<bestsellsize2>60</bestsellsize2>\n"
            + "<bestsellprice2>722.40</bestsellprice2>"
            + "<bestsellorders2>1</bestsellorders2>\n"
            + "</omnesingleentry>\n"
            + "<omnesingleentry>\n"
            + "<bestsellsize3>1</bestsellsize3>\n"
            + "<bestsellprice3>722.50</bestsellprice3>\n"
            + "<bestsellorders3>1</bestsellorders3>\n"
            + "</omnesingleentry>\n"
            + "<omnesingleentry>\n"
            + "<bestsellsize4>25</bestsellsize4>\n"
            + "<bestsellprice4>722.70</bestsellprice4>\n"
            + "<bestsellorders4>1</bestsellorders4>\n"
            + "</omnesingleentry>\n"
            + "<omnesingleentry>\n"
            + "<bestsellsize5>107</bestsellsize5>\n"
            + "<bestsellprice5>723.00</bestsellprice5>\n"
            + "<bestsellorders5>3</bestsellorders5>\n"
            + "</omnesingleentry>\n"
            + "</best5sell>\n"
            + "</omnereports>";
    MarketDepthResponse mdr = (MarketDepthResponse) new MarketDepthRequest(null, null, null, null).getResponse(xml);
    BigDecimal expected = new BigDecimal("723.00");
    BigDecimal actual = mdr.getBestSells()[4].getBestSellPrice();
    assertEquals(expected, actual);
    expected = new BigDecimal("720.55");
    actual = mdr.getBestBuys()[2].getBestBuyPrice();
    assertEquals(expected, actual);
    Calendar expected_ = Calendar.getInstance();
    expected_.setTimeInMillis(1310637830000l);
    Calendar actual_ = mdr.getScripDetail().getLastTradedTime();
    assertEquals(expected_, actual_);
  }
}