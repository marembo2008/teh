/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.teh.request.mfss.order;

import com.anosym.teh.request.PostRequest;
import com.anosym.teh.response.Response;
import com.anosym.teh.response.mfss.order.MFSSOrderBookResponse;

/**
 *
 * @author marembo
 */
public class MFSSOrderBookRequest extends PostRequest {

  public MFSSOrderBookRequest(String userId, String token) {
    super("/XMLServlets/servlet/OrderBookMF", userId, token);
  }

  @Override
  protected Response getResponse(String response) {
    return processResponse(response, MFSSOrderBookResponse.class);
  }
}
