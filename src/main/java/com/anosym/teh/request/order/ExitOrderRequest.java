/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.teh.request.order;

import com.anosym.teh.response.Response;
import com.anosym.teh.response.order.ExitOrderFailureResponse;
import com.anosym.teh.response.order.ExitOrderResponse;

/**
 *
 * @author marembo
 */
public class ExitOrderRequest extends CancelOrderRequest {

  public ExitOrderRequest(String userId, String token, String orderNumber) {
    super("/XMLServlets/servlet/ExitCoverOrder", userId, token, orderNumber);
  }

  @Override
  protected Response getResponse(String response) {
    if (response.contains("<exitsuccess>")) {
      return processResponse(response, ExitOrderResponse.class);
    } else {
      return processResponse(response, ExitOrderFailureResponse.class);
    }
  }
}
