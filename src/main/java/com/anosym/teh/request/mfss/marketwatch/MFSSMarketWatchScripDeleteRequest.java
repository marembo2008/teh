/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.teh.request.mfss.marketwatch;

import com.anosym.teh.request.PostRequest;
import com.anosym.teh.response.Response;
import com.anosym.teh.response.mfss.marketwatch.MFSSMarketWatchScripDeleteResponse;

/**
 *
 * @author marembo
 */
public class MFSSMarketWatchScripDeleteRequest extends PostRequest {

  public MFSSMarketWatchScripDeleteRequest(String userId, String token,
          String scripName, String mwName) {
    super("/XMLServlets/servlet/DeleteScripsMWMF", userId, token);
    addParameter("SearchFor", scripName);
    addParameter("mw", mwName);
  }

  @Override
  protected Response getResponse(String response) {
    return processResponse(response, MFSSMarketWatchScripDeleteResponse.class);
  }

}
