/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.teh.request.ipo.order;

import com.anosym.teh.request.PostRequest;
import com.anosym.teh.response.Response;
import com.anosym.teh.response.ipo.order.IPOCancelOrderResponse;

/**
 *
 * @author marembo
 */
public class IPOCancelOrderRequest extends PostRequest {

  public IPOCancelOrderRequest(String userId, String token, String accountId,
          String issueId, String bidNumber, String applicationNumber) {
    super("/XMLServlets/servlet/IPOCancelOrder", userId, token, null);
    addParameter("accId", accountId);
    addParameter("issueid", issueId);
    addParameter("bidno", bidNumber);
    addParameter("appno", applicationNumber);

  }

  @Override
  protected Response getResponse(String response) {
    return processResponse(response, IPOCancelOrderResponse.class);
  }
}
