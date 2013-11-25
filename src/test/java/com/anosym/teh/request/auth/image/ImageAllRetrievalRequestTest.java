/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.teh.request.auth.image;

import com.anosym.teh.response.Response;
import com.anosym.teh.response.image.ImageAllRetrievalFailureResponse;
import com.anosym.teh.response.image.ImageAllRetrievalResponse;
import java.util.Arrays;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author marembo
 */
public class ImageAllRetrievalRequestTest {

  public ImageAllRetrievalRequestTest() {
  }

  @Before
  public void setUp() {
  }

  @After
  public void tearDown() {
  }

  @Test
  public void testGetResponse_Positive() {
    String responseXML = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?> \n"
            + "<omneimagetag>\n"
            + "<omneimage>\n"
            + " <imageindex>5013</imageindex> \n"
            + " <imageindex>5008</imageindex> \n"
            + " <imageindex>5001</imageindex> \n"
            + " <imageindex>5005</imageindex> \n"
            + " <imageindex>5015</imageindex> \n"
            + " </omneimage>\n"
            + " </omneimagetag>";
    Class expectedClass = ImageAllRetrievalResponse.class;
    Response response = new ImageAllRetrievalRequest().getResponse(responseXML);
    Class actualClass = response.getClass();
    assertEquals(expectedClass, actualClass);
    int[] expectedIndeces = {5013, 5008, 5001, 5005, 5015};
    int[] actualIndeces = ((ImageAllRetrievalResponse) response).getImageIndeces();
    assertTrue(Arrays.equals(expectedIndeces, actualIndeces));
  }

  @Test
  public void testGetResponse_Negative() {
    String responseXML = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?> \n"
            + "<omneimagetag>\n"
            + "<imagemsg>\n"
            + "NO_DATA"
            + "</imagemsg>\n"
            + "</omneimagetag>";
    Class expectedClass = ImageAllRetrievalFailureResponse.class;
    Response response = new ImageAllRetrievalRequest().getResponse(responseXML);
    Class actualClass = response.getClass();
    assertEquals(expectedClass, actualClass);
    String expectedMessage = "NO_DATA";
    String actualMessage = ((ImageAllRetrievalFailureResponse) response).getMessage();
    assertEquals(expectedMessage, actualMessage);
  }

}
