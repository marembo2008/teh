/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.teh.request.mfss.scrip;

import com.anosym.teh.request.PostRequest;
import com.anosym.teh.response.Response;
import com.anosym.teh.response.mfss.scrip.MFSSScripSeriesResponse;

/**
 *
 * @author marembo
 */
public class MFSSScripSeriesRequest extends PostRequest {

  public MFSSScripSeriesRequest(String exchange, String userId, String token) {
    super("/XMLServlets/servlet/MFSearchScrip", userId, token);
    addParameter("exchange", exchange);
  }

  @Override
  protected Response getResponse(String response) {
    return processResponse(response, MFSSScripSeriesResponse.class);
  }
}
