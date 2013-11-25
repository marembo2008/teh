/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.teh.request.auth.image;

import com.anosym.teh.request.auth.image.ImageRetrievalRequest;
import com.anosym.teh.response.Response;
import com.anosym.teh.response.image.ImageRetrievalAuthenticationFailureResponse;
import com.anosym.teh.response.image.ImageRetrievalFailureResponse;
import com.anosym.teh.response.auth.image.ImageAuthenticationResponse;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author marembo
 */
public class ImageRetrievalRequestTest {

  public ImageRetrievalRequestTest() {
  }

  @Before
  public void setUp() {
  }

  @After
  public void tearDown() {
  }

  @Test
  public void testGetResponse_AuthenticationFailure() {
    String responseXml = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?> \n"
            + "<imagemsg>\n"
            + " <omneimagetag>\n"
            + "  <omneimage>Invalid Image Index</omneimage> \n"
            + " </omneimagetag>\n"
            + "</imagemsg>";
    Class expectedClass = ImageRetrievalAuthenticationFailureResponse.class;
    ImageAuthenticationResponse iar = new ImageAuthenticationResponse();
    iar.setImageIndex(new ImageAuthenticationResponse.ImageIndex(45));
    Response response = new ImageRetrievalRequest(iar).getResponse(responseXml);
    Class actualClass = response.getClass();
    assertEquals(expectedClass, actualClass);
    String expectedMessage = "Invalid Image Index";
    String actualMessage = ((ImageRetrievalAuthenticationFailureResponse) response).getError().getErrorMessage();
    assertEquals(expectedMessage, actualMessage);
  }

  @Test
  public void testGetResponse_Failure() {
    String responseXml = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?> \n"
            + "<imagemsg>\n"
            + " <message>Invalid Member Id</message> \n"
            + "</imagemsg>";
    Class expectedClass = ImageRetrievalFailureResponse.class;
    ImageAuthenticationResponse iar = new ImageAuthenticationResponse();
    iar.setImageIndex(new ImageAuthenticationResponse.ImageIndex(45));
    Response response = new ImageRetrievalRequest(iar).getResponse(responseXml);
    Class actualClass = response.getClass();
    assertEquals(expectedClass, actualClass);
    String expectedMessage = "Invalid Member Id";
    String actualMessage = ((ImageRetrievalFailureResponse) response).getMessage();
    assertEquals(expectedMessage, actualMessage);
  }

}
