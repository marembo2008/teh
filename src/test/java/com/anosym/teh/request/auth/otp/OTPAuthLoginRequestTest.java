/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.teh.request.auth.otp;

import com.anosym.teh.response.auth.otp.OTPAuthLoginResponse;
import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author marembo
 */
public class OTPAuthLoginRequestTest {

    public OTPAuthLoginRequestTest() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void getGetResponse() {
        String responseXml = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>"
                + "<omnelogin>\n"
                + " <message>OK</message>"
                + " <omneotp>"
                + "  <loginid>USER0002</loginid>"
                + "  <memberid>Omnesys</memberid>"
                + "  <omneotptag>please enter one time password</omneotptag>"
                + " </omneotp>\n"
                + "</omnelogin>";
        OTPAuthLoginResponse response = (OTPAuthLoginResponse) new OTOAuthLoginRequest("", "", "").getResponse(responseXml);
        String expectedLoginId = "USER0002";
        String actualLoginId = response.getAuthDetail().getLoginId();
        Assert.assertEquals(expectedLoginId, actualLoginId);
    }
}