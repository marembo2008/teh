/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.teh.request.mfss.order;

import com.anosym.teh.request.PostRequest;
import com.anosym.teh.response.Response;
import com.anosym.teh.response.mfss.order.MFSSOrderHistoryResponse;

/**
 *
 * @author marembo
 */
public class MFSSOrderHistoryRequest extends PostRequest {

  public MFSSOrderHistoryRequest(String orderNumber, String userId, String token) {
    super("/XMLServlets/servlet/OrderHistoryMF", userId, token);
    addParameter("ordernumbermf", orderNumber);
  }

  @Override
  protected Response getResponse(String response) {
    return processResponse(response, MFSSOrderHistoryResponse.class);
  }
}
