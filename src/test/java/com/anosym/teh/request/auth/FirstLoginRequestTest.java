/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.teh.request.auth;

import com.anosym.teh.response.Response;
import com.anosym.teh.response.auth.LoginResponse;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author marembo
 */
public class FirstLoginRequestTest {

  public FirstLoginRequestTest() {
  }

  @Before
  public void setUp() {
  }

  @After
  public void tearDown() {
  }

  @Test
  public void testGetResponse_Positive() {
    String responseXml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"
            + "<omnelogin>\n"
            + "<message>OK</message>\n"
            + "<omneloginmsg>\n"
            + "<loginid>RAJANI01</loginid>\n"
            + "<logintoken>4297285933</logintoken>\n"
            + "<memberid>Edelweiss</memberid>\n"
            + "<usertype>INVESTOR_CLIENT</usertype>\n"
            + "<logintime>19/03/2012 15:59:11</logintime>\n"
            + "<guisubscription>RAJANI01</guisubscription>\n"
            + "<loginexchange><exchange>NSE</exchange>\n"
            + "</loginexchange><loginproducts>\n"
            + "<product>CNC</product>\n"
            + "<product>MIS</product>\n"
            + "<product>NRML</product>\n"
            + "</loginproducts>\n"
            + "<loginpricetype>\n"
            + "<pricetype>LIMIT</pricetype>\n"
            + "<pricetype>MARKET</pricetype>\n"
            + "<pricetype>SL</pricetype>\n"
            + "<pricetype>SL-M</pricetype>\n"
            + "</loginpricetype><logingroups>\n"
            + "<group>NO_DATA</group>\n"
            + "</logingroups>\n"
            + "<logindefaultmw/>\n"
            + "<loginaccountid>RAJANI01</loginaccountid>\n"
            + "<loginaccountname>RAJANI01</loginaccountname>\n"
            + "<loginpasswordreset>N</loginpasswordreset>\n"
            + "<expirymessage>NO_DATA</expirymessage>\n"
            + "<broker>Edelweiss</broker>\n"
            + "<brokerbranchid>Bombay</brokerbranchid>\n"
            + "</omneloginmsg>\n"
            + "</omnelogin>";
    Class expectedClass = LoginResponse.class;
    Response response = new FirstLoginRequest("", "").getResponse(responseXml);
    Class actualClass = response.getClass();
    Assert.assertEquals(expectedClass, actualClass);
    String expectedLoginId = "RAJANI01";
    String actualLoginId = ((LoginResponse) response).getLoginInfo().getLoginId();
    Assert.assertEquals(expectedLoginId, actualLoginId);
    System.out.println(response);
  }
}