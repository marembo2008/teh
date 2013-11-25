/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.teh.request.logs;

import com.anosym.teh.response.logs.AdminLogsResponse;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author marembo
 */
public class AdminLogsRequestTest {

  public AdminLogsRequestTest() {
  }

  @Before
  public void setUp() {
  }

  @After
  public void tearDown() {
  }

  @Test
  public void testGetResponse() {
    String responseXml = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>"
            + "<omnereports>"
            + "<adminlogs>"
            + "<omnesingleentry>"
            + "<logmessage>"
            + "MARGIN Warning percentage Reached 112.83 for Entity account-Z1 Across Exchange Across"
            + "SEGMENT Across product "
            + "</logmessage>"
            + "</omnesingleentry>"
            + "<omnesingleentry>"
            + "<logmessage>"
            + "MARGIN Warning percentage Reached 112.83 for Entity account-Z1 Across Exchange Across"
            + "SEGMENT Across product "
            + "</logmessage>"
            + "</omnesingleentry>"
            + "<omnesingleentry>"
            + "<logmessage>"
            + "MARGIN Warning percentage Reached 69.35 for Entity account-Z1 Across Exchange Across"
            + "SEGMENT Across product "
            + "</logmessage>"
            + "</omnesingleentry>"
            + "<omnesingleentry>"
            + "<logmessage>"
            + "MARGIN Warning percentage Reached 69.35 for Entity account-Z1 Across Exchange Across SEGMENT Across product "
            + "</logmessage>"
            + "</omnesingleentry>"
            + "</adminlogs>"
            + "</omnereports>";
    AdminLogsResponse alr = (AdminLogsResponse) new AdminLogsRequest(null, null).getResponse(responseXml);
    String expected = "MARGIN Warning percentage Reached 69.35 for Entity account-Z1 Across Exchange Across SEGMENT Across product".trim();
    String actual = alr.getAdminLogs()[3].getLogMessage().trim();
    assertEquals(expected, actual);
  }
}