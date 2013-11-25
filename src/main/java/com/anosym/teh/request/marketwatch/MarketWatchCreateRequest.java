/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.teh.request.marketwatch;

import com.anosym.teh.request.PostRequest;
import com.anosym.teh.response.Response;
import com.anosym.teh.response.marketwatch.MarketWatchCreateResponse;

/**
 *
 * @author marembo
 */
public class MarketWatchCreateRequest extends PostRequest {

  public static enum MarketWatchControl {

    CREATE,
    NON_DEFAULT;
  }

  public MarketWatchCreateRequest(String userId, String marketWatchName, String scripData, MarketWatchControl control, String token) {
    super(("/XMLServlets/servlet/CreateMarketWatch"));
    addParameter("uid", userId);
    addParameter("mwname", marketWatchName);
    addParameter("mWString", scripData);
    addParameter("control", control);
    addParameter("token", token);
  }

  @Override
  protected Response getResponse(String response) {
    return processResponse(response, MarketWatchCreateResponse.class);
  }
}
