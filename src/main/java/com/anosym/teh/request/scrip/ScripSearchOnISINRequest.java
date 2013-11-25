/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.teh.request.scrip;

import com.anosym.teh.request.PostRequest;
import com.anosym.teh.response.Response;
import com.anosym.teh.response.scrip.ScripDataResponse;

/**
 *
 * @author marembo
 */
public class ScripSearchOnISINRequest extends PostRequest {

  public ScripSearchOnISINRequest(String userId, String token, String isin) {
    super("/XMLServlets/servlet/ISINSearch");
    addParameter("uid", userId);
    addParameter("token", token);
    addParameter("isin", isin);
  }

  @Override
  protected Response getResponse(String response) {
    return processResponse(response, ScripDataResponse.class);
  }
}
