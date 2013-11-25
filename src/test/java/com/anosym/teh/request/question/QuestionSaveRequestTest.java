/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.teh.request.question;

import com.anosym.teh.response.Response;
import com.anosym.teh.response.image.SaveDataResponse;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author marembo
 */
public class QuestionSaveRequestTest {

  public QuestionSaveRequestTest() {
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
            + "<modifyuser>\n"
            + " <modifymsg>Task Successfully Completed</modifymsg> \n"
            + "</modifyuser>";
    Response response = new QuestionSaveRequest().getResponse(responseXml);
    String expectedMessage = "Task Successfully Completed";
    String actualMessage = ((SaveDataResponse) response).getMessage();
    Assert.assertEquals(expectedMessage, actualMessage);
  }

}
