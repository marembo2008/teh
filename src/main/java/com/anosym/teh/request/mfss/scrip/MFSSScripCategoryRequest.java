/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.teh.request.mfss.scrip;

import com.anosym.teh.request.PostRequest;
import com.anosym.teh.response.Response;
import com.anosym.teh.response.mfss.scrip.MFSSScripCategoryResponse;

/**
 *
 * @author marembo
 */
public class MFSSScripCategoryRequest extends PostRequest {

  public MFSSScripCategoryRequest(String series, String exchange, String userId, String token) {
    super("/XMLServlets/servlet/MFSearchScrip", userId, token);
    addParameter("exchange", exchange);
    addParameter("series", series);
  }

  @Override
  protected Response getResponse(String response) {
    return processResponse(response, MFSSScripCategoryResponse.class);
  }
}
