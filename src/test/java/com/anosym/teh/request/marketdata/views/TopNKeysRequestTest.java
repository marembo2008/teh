/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.teh.request.marketdata.views;

import com.anosym.teh.response.marketdata.views.TopNKeysResponse;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author marembo
 */
public class TopNKeysRequestTest {

  public TopNKeysRequestTest() {
  }

  @Before
  public void setUp() {
  }

  @After
  public void tearDown() {
  }

  @Test
  public void testGetResponse() {
    String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?> \n"
            + "<omnereports>\n"
            + "<topnkeys>\n"
            + "<omnesingleentry>\n"
            + "<category>TRADE_VOLUME</category>\n"
            + "<basketlist>\n"
            + "<basket>NSE_FO_OPEN_MARKET</basket>\n"
            + "<basket>NSE_OPEN_MARKET</basket>\n"
            + "</basketlist>\n"
            + "</omnesingleentry>\n"
            + "<omnesingleentry>\n"
            + "<category>OPEN_INTRST_VOLUME</category>\n"
            + "<basketlist>\n"
            + "<basket>NSE_FO_OPEN_MARKET</basket>\n"
            + "</basketlist>\n"
            + "</omnesingleentry>\n"
            + "<omnesingleentry>\n"
            + "<category>%CHANGE_PREV_CLOSE</category>\n"
            + "<basketlist>\n"
            + "<basket>NSE_FO_OPEN_MARKET</basket>\n"
            + "<basket>NSE_OPEN_MARKET</basket>\n"
            + "</basketlist>\n"
            + "</omnesingleentry>\n"
            + "<omnesingleentry>\n"
            + "<category>OPEN_INTRST_VALUE</category>\n"
            + "<basketlist>\n"
            + "<basket>NSE_FO_OPEN_MARKET</basket>\n"
            + "</basketlist>\n"
            + "</omnesingleentry>\n"
            + "</topnkeys>\n"
            + "</omnereports>";
    TopNKeysResponse response = (TopNKeysResponse) new TopNKeysRequest(null, null).getResponse(xml);
    String expected = "TRADE_VOLUME";
    String actual = response.getKeys()[0].getCategory();
    assertEquals(expected, actual);
    expected = "NSE_FO_OPEN_MARKET";
    actual = response.getKeys()[0].getBaskets()[0];
    assertEquals(expected, actual);
  }
}