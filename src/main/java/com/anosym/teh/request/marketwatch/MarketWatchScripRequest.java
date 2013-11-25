/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.teh.request.marketwatch;

import com.anosym.teh.request.PostRequest;
import com.anosym.teh.response.Response;
import com.anosym.teh.response.marketwatch.MarketWatchScripResponse;

/**
 *
 * @author marembo
 */
public class MarketWatchScripRequest extends PostRequest {

  public static enum MarketWatchDefaultOption {

    YES,
    NO;
  }

  public MarketWatchScripRequest(String userId, String mwName, MarketWatchDefaultOption defaultOption, String token) {
    super("/XMLServlets/servlet/GetMarketWatchScrips");
    addParameter("uid", userId);
    addParameter("sMWName", mwName);
    addParameter("setDefault", defaultOption);
    addParameter("token", token);
  }

  @Override
  protected Response getResponse(String response) {
    return processResponse(response, MarketWatchScripResponse.class);
  }
}
