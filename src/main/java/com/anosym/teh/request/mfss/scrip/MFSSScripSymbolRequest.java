/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.teh.request.mfss.scrip;

import com.anosym.teh.request.PostRequest;
import com.anosym.teh.response.Response;
import com.anosym.teh.response.mfss.scrip.MFSSScripSymbolResponse;

/**
 *
 * @author marembo
 */
public class MFSSScripSymbolRequest extends PostRequest {

  public MFSSScripSymbolRequest(String category, String series, String exchange, String userId, String token) {
    super("/XMLServlets/servlet/MFSearchScrip", userId, token);
    addParameter("exchange", exchange);
    addParameter("series", series);
    addParameter("category", category);
  }

  @Override
  protected Response getResponse(String response) {
    return processResponse(response, MFSSScripSymbolResponse.class);
  }
}
