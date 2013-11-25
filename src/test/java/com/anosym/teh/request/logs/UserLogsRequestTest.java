/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.teh.request.logs;

import com.anosym.teh.response.Response;
import com.anosym.teh.response.logs.UserLogsResponse;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author marembo
 */
public class UserLogsRequestTest {

  public UserLogsRequestTest() {
  }

  @Before
  public void setUp() {
  }

  @After
  public void tearDown() {
  }

  @Test
  public void testGetResponse() {
    String responseXml = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?> \n"
            + "<omnereports>\n"
            + " <userlogs>\n"
            + "  <omnesingleentry>\n"
            + "   <logmessage>\n"
            + "    <messageid>LOGIN</messageid> \n"
            + "    <userid>RAJANI02</userid> \n"
            + "    <time>1336481796</time> \n"
            + "   </logmessage>\n"
            + "  </omnesingleentry>\n"
            + "  <omnesingleentry>\n"
            + "   <logmessage>\n"
            + "    <messageid>LOGIN</messageid> \n"
            + "    <userid>RAJANI02</userid> \n"
            + "    <time>1336480940</time> \n"
            + "   </logmessage>\n"
            + "  </omnesingleentry>\n"
            + "  <omnesingleentry>\n"
            + "   <logmessage>\n"
            + "    <messageid>ORDER</messageid> \n"
            + "    <clientcode>RAJANI02</clientcode> \n"
            + "    <pendingqty>1</pendingqty> \n"
            + "    <exchange>NSE</exchange> \n"
            + "    <productcode>NRML</productcode> \n"
            + "    <tradingsymbol>ZEENEWS-EQ</tradingsymbol> \n"
            + "    <nestorderreqid>1</nestorderreqid> \n"
            + "    <ordervalidity>DAY</ordervalidity>"
            + "    <price>12</price> \n"
            + "    <status>open</status> \n"
            + "    <transactiontype>BUY</transactiontype> \n"
            + "    <nestordernumber>120508000000021</nestordernumber> \n"
            + "    <exchangeorderno>120508000000008</exchangeorderno> \n"
            + "    <triggerprice>0</triggerprice> \n"
            + "    <customerfirm>C</customerfirm> \n"
            + "    <filledqty>0</filledqty> \n"
            + "    <dislcosedqty>0</dislcosedqty> \n"
            + "    <totalqty>1</totalqty> \n"
            + "    <orderentrytime>08/05/2012 18:07:05</orderentrytime> \n"
            + "    <pricetype>LIMIT</pricetype> \n"
            + "    <text /> \n"
            + "   </logmessage>\n"
            + "  </omnesingleentry>\n"
            + " </userlogs>\n"
            + "</omnereports>";
    Response r = new UserLogsRequest("", "").getResponse(responseXml);
    assertTrue(r.getClass().isAssignableFrom(UserLogsResponse.class));
    UserLogsResponse ulr = (UserLogsResponse) r;
    UserLogsResponse.UserMessage loginMessage = ulr.getUserLogMessages()[0].getLogMessage();
    UserLogsResponse.UserMessage orderMessage = ulr.getUserLogMessages()[2].getLogMessage();
    assertTrue(loginMessage.getClass().isAssignableFrom(UserLogsResponse.UserLoginMessage.class));
    assertTrue(orderMessage.getClass().isAssignableFrom(UserLogsResponse.UserOrderMessage.class));
    UserLogsResponse.UserOrderMessage uom = (UserLogsResponse.UserOrderMessage) orderMessage;
    String expected = "120508000000008";
    String actual = uom.getExchangeOrderNumber();
    assertEquals(expected, actual);
    expected = "RAJANI02";
    actual = ((UserLogsResponse.UserLoginMessage) loginMessage).getUserId();
    assertEquals(expected, actual);
  }
}