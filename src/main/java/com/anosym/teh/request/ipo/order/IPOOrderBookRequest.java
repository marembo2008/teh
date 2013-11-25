/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.teh.request.ipo.order;

import com.anosym.teh.request.PostRequest;
import com.anosym.teh.response.Response;
import com.anosym.teh.response.ipo.order.IPOOrderBookResponse;

/**
 *
 * @author marembo
 */
public class IPOOrderBookRequest extends PostRequest {

  public IPOOrderBookRequest(String issueId, String userId, String token, String accountId) {
    super("/XMLServlets/servlet/IPOOrderBook", userId, token, accountId);
    addParameter("issueId", issueId);
  }

  @Override
  protected Response getResponse(String response) {
    return processResponse(response, IPOOrderBookResponse.class);
  }
}
