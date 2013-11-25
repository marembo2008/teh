/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.teh.request.rms;

import com.anosym.teh.request.PostRequest;
import com.anosym.teh.response.Response;
import com.anosym.teh.response.rms.RMSHoldingResponse;

/**
 *
 * @author marembo
 */
public class RMSHoldingRequest extends PostRequest {

  public RMSHoldingRequest(String userId, String token, String accountId, String broker) {
    this("/XMLServlets/servlet/RMSHoldings", userId, token, accountId, broker);
  }

  protected RMSHoldingRequest(String servletUrl, String userId, String token, String accountId, String broker) {
    super(servletUrl, userId, token, null);
    addParameter("acctid", accountId);
    addParameter("broker", broker);
  }

  @Override
  protected Response getResponse(String response) {
    return processResponse(response, RMSHoldingResponse.class);
  }
}
