/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.teh.request.order.market;

import com.anosym.teh.request.PostRequest;
import com.anosym.teh.response.Response;
import com.anosym.teh.response.order.market.AMStatusResponse;

/**
 *
 * @author marembo
 */
public class AMStatusRequest extends PostRequest {

  public AMStatusRequest(String userId, String token) {
    super("/XMLServlets/servlet/AMOStatus");
    addParameter("uid", userId);
    addParameter("token", token);
  }

  @Override
  protected Response getResponse(String response) {
    return processResponse(response, AMStatusResponse.class);
  }
}
