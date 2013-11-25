/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.teh.request.order;

import com.anosym.teh.request.PostRequest;
import com.anosym.teh.response.Response;
import com.anosym.teh.response.order.ModifyOrderResponse;

/**
 *
 * @author marembo
 */
public class CancelOrderRequest extends PostRequest {

  public CancelOrderRequest(String userId, String token, String orderNumber) {
    this("/XMLServlets/servlet/CancelOrder", userId, token, orderNumber);
  }

  protected CancelOrderRequest(String servletUrl, String userId, String token, String orderNumber) {
    super(servletUrl);
    addParameter("uid", userId);
    addParameter("token", token);
    addParameter("nestordernumber", orderNumber);
  }

  @Override
  protected Response getResponse(String response) {
    return processResponse(response, ModifyOrderResponse.class);
  }
}
