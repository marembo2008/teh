/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.teh.request.user.preference.lotsweight;

import com.anosym.teh.request.PostRequest;
import com.anosym.teh.response.Response;
import com.anosym.teh.response.user.preferences.lotsweight.LotsWeightPreferenceResponse;

/**
 *
 * @author marembo
 */
public class LotsWeightPreferenceRequest extends PostRequest {

  public LotsWeightPreferenceRequest(String userId, String token) {
    super("/XMLServlets/servlet/GetLotsPreference", userId, token);
  }

  @Override
  protected Response getResponse(String response) {
    return processResponse(response, LotsWeightPreferenceResponse.class);
  }
}
