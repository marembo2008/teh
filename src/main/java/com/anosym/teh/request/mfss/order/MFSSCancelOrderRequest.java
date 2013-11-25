/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.teh.request.mfss.order;

import com.anosym.teh.request.PostRequest;
import com.anosym.teh.response.Response;
import com.anosym.teh.response.mfss.order.MFSSCancelOrderResponse;

/**
 *
 * @author marembo
 */
public class MFSSCancelOrderRequest extends PostRequest {

  public MFSSCancelOrderRequest(String orderNumber, String userId, String token) {
    super("/XMLServlet/servlet/MFCancelOrder", userId, token);
    addParameter("orderno", orderNumber);
  }

  @Override
  protected Response getResponse(String response) {
    return processResponse(response, MFSSCancelOrderResponse.class);
  }
}
