/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.teh.request.marketwatch;

import com.anosym.teh.request.PostRequest;
import com.anosym.teh.response.Response;
import com.anosym.teh.response.marketwatch.MarketWatchDeleteResponse;

/**
 *
 * @author marembo
 */
public class MarketWatchDeleteRequest extends PostRequest {

  public MarketWatchDeleteRequest(String userId, String token, String mwName) {
    super("/XMLServlets/servlet/DeleteMW");
    addParameter("uid", userId);
    addParameter("token", token);
    addParameter("sMWName", mwName);
  }

  @Override
  protected Response getResponse(String response) {
    return processResponse(response, MarketWatchDeleteResponse.class);
  }
}
