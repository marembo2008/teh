/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.teh.response.logs;

import com.anosym.teh.response.Response;
import com.anosym.vjax.annotations.Markup;

/**
 *
 * @author marembo
 */
public class BrokerLogsResponse extends Response {

  @Markup(name = "brokerlogs")
  private String brokerLogs;

  public String getBrokerLogs() {
    return brokerLogs;
  }

  public void setBrokerLogs(String brokerLogs) {
    this.brokerLogs = brokerLogs;
  }

  @Override
  public String toString() {
    return "BrokerLogsResponse{" + "brokerLogs=" + brokerLogs + '}';
  }
}
