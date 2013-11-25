/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.teh.request.auth.image;

import com.anosym.teh.request.auth.image.ImageAuthenticationRequest;
import com.anosym.teh.response.Response;
import com.anosym.teh.response.auth.image.ImageAuthenticationFailureResponse;
import com.anosym.teh.response.auth.image.ImageAuthenticationResponse;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author marembo
 */
public class ImageAuthenticationRequestTest {

  public ImageAuthenticationRequestTest() {
  }

  @Before
  public void setUp() {
  }

  @After
  public void tearDown() {
  }

  @Test
  public void testGetResponse_positive() {
    String responseXml = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?> \n"
            + "<imagemsg>\n"
            + " <omneimagetag>\n"
            + "  <omneimage>5014</omneimage> \n"
            + " </omneimagetag>\n"
            + "</imagemsg>";
    Class expected = ImageAuthenticationResponse.class;
    Response response = new ImageAuthenticationRequest().getResponse(responseXml);
    Class actual = response.getClass();
    assertEquals(expected, actual);
    int expectedIndex = 5014;
    int actualIndex = ((ImageAuthenticationResponse) response).getImageIndex().getIndex();
    assertEquals(expectedIndex, actualIndex);
  }

  @Test
  public void testGetResponse_negative() {
    String responseXml = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?> \n"
            + "<imagemsg>\n"
            + " <message>Image not Set.Please Set your Secure Access Image</message>  "
            + "</imagemsg>";
    Class expected = ImageAuthenticationFailureResponse.class;
    Response response = new ImageAuthenticationRequest().getResponse(responseXml);
    Class actual = response.getClass();
    assertEquals(expected, actual);
    String expectedErrorMessage = "Image not Set.Please Set your Secure Access Image";
    String actualErrorMessage = ((ImageAuthenticationFailureResponse) response).getMessage();
    assertEquals(expectedErrorMessage, actualErrorMessage);
  }

}
