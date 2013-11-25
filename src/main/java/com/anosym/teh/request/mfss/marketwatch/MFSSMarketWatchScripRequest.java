/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.teh.request.mfss.marketwatch;

import com.anosym.teh.request.PostRequest;
import com.anosym.teh.response.Response;
import com.anosym.teh.response.mfss.marketwatch.MFSSMarketWatchScripResponse;

/**
 *
 * @author marembo
 */
public class MFSSMarketWatchScripRequest extends PostRequest {

  public static enum SetDefaultOption {

    YES,
    NO;
  }

  public MFSSMarketWatchScripRequest(String userId, String token,
          String mwName, SetDefaultOption setDefaultOption) {
    super("/XMLServlets/servlet/GetMarketWatchInfoMF", userId, token);
    addParameter("sMWNameMF", mwName);
    addParameter("setDefaultMF", setDefaultOption);
  }

  @Override
  protected Response getResponse(String response) {
    return processResponse(response, MFSSMarketWatchScripResponse.class);
  }
}
