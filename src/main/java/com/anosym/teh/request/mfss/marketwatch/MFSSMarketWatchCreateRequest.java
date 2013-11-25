/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.teh.request.mfss.marketwatch;

import com.anosym.teh.request.PostRequest;
import com.anosym.teh.response.Response;
import com.anosym.teh.response.mfss.marketwatch.MFSSMarketWatchCreateResponse;

/**
 *
 * @author marembo
 */
public class MFSSMarketWatchCreateRequest extends PostRequest {

  public static enum Control {

    CREATE;
  }

  /**
   * The mWString parameter should be in the following format.
   * exchange|scripcode,exchange|scripcode, The value of the control parameter can only be CREATE.
   *
   * @param userId
   * @param token
   * @param mwName
   * @param scripData
   * @param control
   */
  public MFSSMarketWatchCreateRequest(String userId, String token, String mwName, String scripData, Control control) {
    super("/XMLServlets/servlet/CreateMarketWatchMF", userId, token);
    addParameter("mwnameMF", mwName);
    addParameter("mWStringMF", scripData);
    addParameter("controlMF", control);
  }

  @Override
  protected Response getResponse(String response) {
    return processResponse(response, MFSSMarketWatchCreateResponse.class);
  }
}
