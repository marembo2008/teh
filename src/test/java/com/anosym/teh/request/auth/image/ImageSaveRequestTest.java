/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.teh.request.auth.image;

import com.anosym.teh.request.auth.image.ImageSaveRequest;
import com.anosym.teh.response.image.SaveDataResponse;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author marembo
 */
public class ImageSaveRequestTest {

  public ImageSaveRequestTest() {
  }

  @Before
  public void setUp() {
  }

  @After
  public void tearDown() {
  }

  @Test
  public void testGetResponse() {
    String responseXML = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?> \n"
            + "<modifyuser>\n"
            + " <modifymsg>Enter Valid Details</modifymsg> \n"
            + "</modifyuser>";
    String expected = "Enter Valid Details";
    String actual = ((SaveDataResponse) new ImageSaveRequest().getResponse(responseXML)).getMessage();
    Assert.assertEquals(expected, actual);
  }

}
