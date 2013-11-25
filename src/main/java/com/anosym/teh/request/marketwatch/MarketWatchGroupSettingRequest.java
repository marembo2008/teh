/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.teh.request.marketwatch;

import com.anosym.teh.request.PostRequest;
import com.anosym.teh.response.Response;
import com.anosym.teh.response.marketwatch.MarketWatchGroupSettingResponse;

/**
 *
 * @author marembo
 */
public class MarketWatchGroupSettingRequest extends PostRequest {

  public MarketWatchGroupSettingRequest(String userId, String token) {
    super("/XMLServlets/servlet/GetGroupSettings");
    addParameter("uid", userId);
    addParameter("token", token);
  }

  @Override
  protected Response getResponse(String response) {
    return processResponse(response, MarketWatchGroupSettingResponse.class);
  }
}
