/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.teh.request.marketdata.views;

import com.anosym.teh.response.marketdata.views.TopNValuesResponse;
import java.math.BigDecimal;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author marembo
 */
public class TopNValuesRequestTest {

  public TopNValuesRequestTest() {
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
            + "<topandbottomvalues>\n"
            + "<topnvalues>\n"
            + "<top1>\n"
            + "<exchange>NFO</exchange>\n"
            + "<symbolname>RCOM</symbolname>\n"
            + "<group>-</group>\n"
            + "<scripname>FUTSTK</scripname>\n"
            + "<scripcode>-</scripcode>\n"
            + "<expirydate>30 Jun, 2011</expirydate>\n"
            + "<optiontype>XX</optiontype>\n"
            + "<optionprice>-1</optionprice>\n"
            + " <lasttradedprice>419.5</lasttradedprice>\n"
            + " <prevclose>432.4</prevclose>"
            + "<percentchange>-2.98</percentchange>\n"
            + "<value>2782400000.00</value>\n"
            + "</top1>\n"
            + "<top2>\n"
            + "<exchange>NFO</exchange>\n"
            + "<symbolname>SUZLON</symbolname>\n"
            + "<group>-</group>\n"
            + "<scripname>FUTSTK</scripname>\n"
            + "<scripcode>-</scripcode>\n"
            + "<expirydate>30 Jun, 2011</expirydate>\n"
            + "<optiontype>XX</optiontype>\n"
            + "<optionprice>-1</optionprice>\n"
            + " <lasttradedprice>419.5</lasttradedprice>\n"
            + " <prevclose>432.4</prevclose>\n"
            + " <percentchange>-2.98</percentchange>\n"
            + "<value>2252000000.00</value>\n"
            + "</top2>"
            + "</topnvalues>\n"
            + "<bottomnvalues>\n"
            + "<bot1>\n"
            + "<exchange>NFO</exchange>\n"
            + "<symbolname>MINIFTY</symbolname>\n"
            + "<group>-</group>\n"
            + "<scripname>FUTIDX</scripname>\n"
            + "<scripcode>-</scripcode>\n"
            + "<expirydate>30 Jun, 2011</expirydate>\n"
            + "<optiontype>XX</optiontype>\n"
            + "<optionprice>-1</optionprice>\n"
            + " <lasttradedprice>419.5</lasttradedprice>\n"
            + " <prevclose>432.4</prevclose>\n"
            + " <percentchange>-2.98</percentchange>\n"
            + "<value>4000.00</value>\n"
            + "</bot1>\n"
            + "<bot2>\n"
            + "<exchange>NFO</exchange>\n"
            + "<symbolname>BANKNIFTY</symbolname>\n"
            + "<group>-</group>\n"
            + "<scripname>FUTIDX</scripname>\n"
            + "<scripcode>-</scripcode>\n"
            + "<expirydate>30 Jun, 2011</expirydate>\n"
            + "<optiontype>XX</optiontype>\n"
            + "<optionprice>-1</optionprice>\n"
            + " <lasttradedprice>419.5</lasttradedprice>\n"
            + " <prevclose>432.4</prevclose>\n"
            + " <percentchange>-2.98</percentchange>\n"
            + "<value>5000.00</value>\n"
            + "</bot2>"
            + "</bottomnvalues>\n"
            + "</topandbottomvalues>\n"
            + "</omnereports>";
    TopNValuesResponse response = (TopNValuesResponse) new TopNValuesRequest(null, null, null, null).getResponse(xml);
    BigDecimal expected = new BigDecimal("2252000000.00");
    BigDecimal actual = response.getValues().getTopValues()[1].getValue();
    Assert.assertEquals(expected, actual);
    String expectedS = "FUTIDX";
    String actualS = response.getValues().getBottomValues()[1].getScripName();
    Assert.assertEquals(expectedS, actualS);
  }
}