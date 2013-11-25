/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.teh.request.marketwatch;

import com.anosym.teh.request.PostRequest;
import com.anosym.teh.response.Response;
import com.anosym.teh.response.marketwatch.MarketWatchDeleteScripResponse;

/**
 *
 * @author marembo
 */
public class MarketWatchDeleteScripRequest extends PostRequest {

  public MarketWatchDeleteScripRequest(String userId, String token, String exchange, String scripName, String mwName) {
    super("/XMLServlets/servlet/DeleteScrip");
    addParameter("uid", userId);
    addParameter("token", token);
    addParameter("Exchange", exchange);
    addParameter("SearchFor", scripName);
    addParameter("mw", mwName);
  }

  @Override
  protected Response getResponse(String response) {
    return processResponse(response, MarketWatchDeleteScripResponse.class);
  }
}
