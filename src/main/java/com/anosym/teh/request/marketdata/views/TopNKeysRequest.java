/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.teh.request.marketdata.views;

import com.anosym.teh.request.PostRequest;
import com.anosym.teh.response.Response;
import com.anosym.teh.response.marketdata.views.TopNKeysResponse;

/**
 *
 * @author marembo
 */
public class TopNKeysRequest extends PostRequest {

  public TopNKeysRequest(String userId, String token) {
    super("/XMLServlets/servlet/GetTopNKeys", userId, token);
  }

  @Override
  protected Response getResponse(String response) {
    return processResponse(response, TopNKeysResponse.class);
  }
}
