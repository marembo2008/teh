/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.teh.request.logs;

import com.anosym.teh.request.PostRequest;
import com.anosym.teh.response.Response;
import com.anosym.teh.response.logs.BrokerLogsResponse;

/**
 *
 * @author marembo
 */
public class BrokerLogsRequest extends PostRequest {

  public BrokerLogsRequest(String userId, String token) {
    super("/XMLServlets/servlet/BrokerLogs", userId, token);
  }

  @Override
  protected Response getResponse(String response) {
    return processResponse(response, BrokerLogsResponse.class);
  }
}
