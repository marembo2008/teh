/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.teh.response.logs;

import com.anosym.teh.response.Response;
import com.anosym.vjax.annotations.Markup;
import com.anosym.vjax.annotations.v3.ArrayParented;
import java.util.Arrays;

/**
 *
 * @author marembo
 */
public class AdminLogsResponse extends Response {

  public static class LogMessage {

    @Markup(name = "logmessage")
    private String logMessage;

    public String getLogMessage() {
      return logMessage;
    }

    public void setLogMessage(String logMessage) {
      this.logMessage = logMessage;
    }

    @Override
    public String toString() {
      return "LogMessage{" + "logMessage=" + logMessage + '}';
    }
  }

  public static class AdminLogMessages {
  }
  @Markup(name = "adminlogs")
  @ArrayParented(componentMarkup = "omnesingleentry")
  private LogMessage[] adminLogs;

  public LogMessage[] getAdminLogs() {
    return adminLogs;
  }

  public void setAdminLogs(LogMessage[] adminLogs) {
    this.adminLogs = adminLogs;
  }

  @Override
  public String toString() {
    return "AdminLogsResponse{" + "adminLogs=" + Arrays.toString(adminLogs) + '}';
  }
}
