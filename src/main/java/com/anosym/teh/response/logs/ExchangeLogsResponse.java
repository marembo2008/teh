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
public class ExchangeLogsResponse extends Response {

  public static class LogMessage {

    private String exchange;
    private String ssboe;
    @Markup(name = "exchangenews")
    private String exchangeNews;

    public String getExchange() {
      return exchange;
    }

    public void setExchange(String exchange) {
      this.exchange = exchange;
    }

    public String getSsboe() {
      return ssboe;
    }

    public void setSsboe(String ssboe) {
      this.ssboe = ssboe;
    }

    public String getExchangeNews() {
      return exchangeNews;
    }

    public void setExchangeNews(String exchangeNews) {
      this.exchangeNews = exchangeNews;
    }

    @Override
    public String toString() {
      return "LogMessage{" + "exchange=" + exchange + ", ssboe=" + ssboe + ", exchangeNews=" + exchangeNews + '}';
    }
  }

  public static class ExchangeLog {

    @Markup(name = "logmessage")
    private LogMessage logMessage;

    public LogMessage getLogMessage() {
      return logMessage;
    }

    public void setLogMessage(LogMessage logMessage) {
      this.logMessage = logMessage;
    }

    @Override
    public String toString() {
      return "ExchangeLog{" + "logMessage=" + logMessage + '}';
    }
  }
  @Markup(name = "exchangelogs")
  @ArrayParented(componentMarkup = "omnesingleentry")
  private ExchangeLog[] logs;

  public ExchangeLog[] getLogs() {
    return logs;
  }

  public void setLogs(ExchangeLog[] logs) {
    this.logs = logs;
  }

  @Override
  public String toString() {
    return "ExchangeLogsResponse{" + "logs=" + Arrays.toString(logs) + '}';
  }
}
