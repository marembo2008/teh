/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.teh.request.order;

import com.anosym.teh.request.PostRequest;
import com.anosym.teh.response.Response;
import com.anosym.teh.response.order.OrderBookResponse;

/**
 *
 * @author marembo
 */
public class OrderBookRequest extends PostRequest {

  public OrderBookRequest(String userId, String token) {
    super("/XMLServlets/servlet/GetOrders");
    addParameter("token", token);
    addParameter("uid", userId);
  }

  @Override
  protected Response getResponse(String response) {
    return processResponse(response, OrderBookResponse.class);
  }
}
