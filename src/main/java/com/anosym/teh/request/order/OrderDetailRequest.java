/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.teh.request.order;

import com.anosym.teh.request.PostRequest;
import com.anosym.teh.response.Response;
import com.anosym.teh.response.order.OrderDetailResponse;

/**
 *
 * @author marembo
 */
public class OrderDetailRequest extends PostRequest {

  public OrderDetailRequest(String userId, String token, String orderNumber) {
    super("/XMLServlets/servlet/GetOrderNumberDetails");
    addParameter("uid", userId);
    addParameter("ordernumber", orderNumber);
    addParameter("token", token);
  }

  @Override
  protected Response getResponse(String response) {
    return processResponse(response, OrderDetailResponse.class);
  }
}
