/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.teh.request.marketdata.views;

import com.anosym.teh.request.PostRequest;
import com.anosym.teh.response.Response;
import com.anosym.teh.response.marketdata.views.TopNValuesResponse;

/**
 *
 * @author marembo
 */
public class TopNValuesRequest extends PostRequest {

  public TopNValuesRequest(String userId, String token, String topNCriteria, String topNBasket) {
    super("/XMLServlets/servlet/GetTopNValues ", userId, token);
    addParameter("topNCriteria", topNCriteria);
    addParameter("topNBasket", topNBasket);
  }

  @Override
  protected Response getResponse(String response) {
    return processResponse(response, TopNValuesResponse.class);
  }
}
