/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.teh.request.mfss.marketwatch;

import com.anosym.teh.request.PostRequest;
import com.anosym.teh.response.Response;
import com.anosym.teh.response.mfss.marketwatch.MFSSMarketWatchDeleteDefaultResponse;
import com.anosym.teh.response.mfss.marketwatch.MFSSMarketWatchDeleteResponse;

/**
 *
 * @author marembo
 */
public class MFSSMarketWatchDeleteRequest extends PostRequest {

  public MFSSMarketWatchDeleteRequest(String mwName, String userId, String token) {
    super("/XMLServlets/servlet/DeleteMWMF", userId, token);
    addParameter("sMWNamemf", mwName);
  }

  @Override
  protected Response getResponse(String response) {
    if (response.contains("<omnedeletemw>")) {
      return processResponse(response, MFSSMarketWatchDeleteResponse.class);
    }
    return processResponse(response, MFSSMarketWatchDeleteDefaultResponse.class);
  }
}
