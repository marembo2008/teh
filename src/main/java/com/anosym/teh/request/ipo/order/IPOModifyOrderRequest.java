/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.teh.request.ipo.order;

import com.anosym.teh.request.PostRequest;
import com.anosym.teh.response.Response;
import com.anosym.teh.response.ipo.order.IPOModifyOrderResponse;
import java.math.BigDecimal;

/**
 *
 * @author marembo
 */
public class IPOModifyOrderRequest extends PostRequest {

  public IPOModifyOrderRequest(String userId, String token, String accountId,
          String issueId, int newQuantity, BigDecimal newPrice,
          String bidNumber, String applicationNumber) {
    super("/XMLServlets/servlet/IPOModifyOrder", userId, token, null);
    addParameter("accId", accountId);
    addParameter("issueid", issueId);
    addParameter("bidno", bidNumber);
    addParameter("newqty", newQuantity);
    addParameter("newprc", newPrice);
    addParameter("appno", applicationNumber);

  }

  @Override
  protected Response getResponse(String response) {
    return processResponse(response, IPOModifyOrderResponse.class);
  }
}
