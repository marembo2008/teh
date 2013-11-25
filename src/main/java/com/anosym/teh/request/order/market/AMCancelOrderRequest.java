/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.teh.request.order.market;

import com.anosym.teh.request.PostRequest;
import com.anosym.teh.response.Response;
import com.anosym.teh.response.order.market.AMModifyOrderResponse;

/**
 *
 * @author marembo
 */
public class AMCancelOrderRequest extends PostRequest {

  public AMCancelOrderRequest(String userId, String token, String orderNumber) {
    super("/XMLServlets/servlet/CancelAMO");
    addParameter("uid", userId);
    addParameter("token", token);
    addParameter("nestordernumber", orderNumber);
  }

  @Override
  protected Response getResponse(String response) {
    return processResponse(response, AMModifyOrderResponse.class);
  }
}
