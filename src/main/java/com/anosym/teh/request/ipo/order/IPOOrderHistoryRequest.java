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
public class IPOOrderHistoryRequest extends PostRequest {

  public IPOOrderHistoryRequest(String userId, String token, String accountId,
          String issueId, String bidNumber, String applicationNumber) {
    super("/XMLServlets/servlet/IPOIndividualOrderHistory", userId, token, accountId);
    addParameter("issueid", issueId);
    addParameter("bidnum", bidNumber);
    addParameter("appnum", applicationNumber);
  }

  @Override
  protected Response getResponse(String response) {
    return processResponse(response, IPOOrderBookResponse.class);
  }
}
