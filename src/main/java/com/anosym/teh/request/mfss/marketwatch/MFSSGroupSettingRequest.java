/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.teh.request.mfss.marketwatch;

import com.anosym.teh.request.PostRequest;
import com.anosym.teh.response.Response;
import com.anosym.teh.response.mfss.marketwatch.MFSSGroupSettingResponse;

/**
 *
 * @author marembo
 */
public class MFSSGroupSettingRequest extends PostRequest {

  public MFSSGroupSettingRequest(String userId, String token) {
    super("/XMLServlets/servlet/GetGroupSettingsMF", userId, token);
  }

  @Override
  protected Response getResponse(String response) {
    return processResponse(response, MFSSGroupSettingResponse.class);
  }
}
