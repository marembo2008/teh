/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.teh.request.auth.question;

import com.anosym.teh.response.Response;
import com.anosym.teh.response.DefaultResponse;
import com.anosym.teh.response.auth.question.QuestionAuthenticationResponse;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author marembo
 */
public class QuestionAuthenticationRequestTest {

  public QuestionAuthenticationRequestTest() {
  }

  @Before
  public void setUp() {
  }

  @After
  public void tearDown() {
  }

  @Test
  public void testGetResponse_Positive() {
    String responseXML = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?> "
            + "<omnelogin>"
            + " <message>OK</message> "
            + " <omnequestions>"
            + "  <loginid>XML1</loginid> "
            + "  <memberid>Omnesys</memberid> "
            + "  <omnequestionstag>"
            + "   <omnesinglequest>Your left eye power? (e.g. Plus 0.25/Minus 1.50)</omnesinglequest> "
            + "   <omnesingleindex>34</omnesingleindex> "
            + "  </omnequestionstag>"
            + "  <omnequestionstag>"
            + "   <omnesinglequest>In which Month dose your Fathers Birthday come? (e.g. July, May., etc)</omnesinglequest> "
            + "   <omnesingleindex>3</omnesingleindex> "
            + "  </omnequestionstag>"
            + "  <omnequestionstag>"
            + "   <omnesinglequest>Preferred brand of perfume? (e.g. Jaguar, Burberry, etc)</omnesinglequest> "
            + "   <omnesingleindex>42</omnesingleindex> "
            + "  </omnequestionstag>"
            + " </omnequestions>"
            + "</omnelogin>";
    String s = responseXML.substring(702);
    System.out.println(s);
    Class expectedClass = QuestionAuthenticationResponse.class;
    Response response = new QuestionAuthenticationRequest().getResponse(responseXML);
    Class actualClass = response.getClass();
    assertEquals(expectedClass, actualClass);
    QuestionAuthenticationResponse qar = (QuestionAuthenticationResponse) response;
    String actualLoginId = qar.getQuestions().getLoginId();
    String actualmemberId = qar.getQuestions().getMemberId();
    String actualMessage = qar.getMessage();
    QuestionAuthenticationResponse.Question q = qar.getQuestions().getQuestions()[0];
    String actualQuestion = q.getQuestion();
    String actualQuestionIndex = q.getIndex();
    assertEquals("XML1", actualLoginId);
    assertEquals("Omnesys", actualmemberId);
    assertEquals("OK", actualMessage);
    assertEquals("Your left eye power? (e.g. Plus 0.25/Minus 1.50)", actualQuestion);
    assertEquals("34", actualQuestionIndex);
  }

  @Test
  public void testGetResponse_Negative() {
    String responseXml = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?> \n"
            + "<omnelogin>\n"
            + " <message>User Blocked Contact System Administrator</message> \n"
            + "</omnelogin>";
    Class expectedClass = DefaultResponse.class;
    Response response = new QuestionAuthenticationRequest().getResponse(responseXml);
    Class actualClass = response.getClass();
    assertEquals(expectedClass, actualClass);
    String expectedMessage = "User Blocked Contact System Administrator";
    String actualMessage = ((DefaultResponse) response).getMessage();
    assertEquals(expectedMessage, actualMessage);
  }
}
