/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.teh.request.marketdata;

import com.anosym.teh.request.PostRequest;
import com.anosym.teh.response.Response;
import com.anosym.teh.response.marketdata.IndexResponse;

/**
 *
 * @author marembo
 */
public class IndexRequest extends PostRequest {

  public IndexRequest(String userId, String token) {
    super("/XMLServlets/servlet/GetIndexList", userId, token);
  }

  @Override
  protected Response getResponse(String response) {
    return processResponse(response, IndexResponse.class);
  }
}
