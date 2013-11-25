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
public class LotsWeightPreferenceSettingRequest extends PostRequest {

  public LotsWeightPreferenceSettingRequest(String lotsWeightsPreference, String userId, String token) {
    super("/XMLServlet/servlet/SetLotsPreference", userId, token);
    addParameter("lotsweights", lotsWeightsPreference);
  }

  @Override
  protected Response getResponse(String response) {
    return processResponse(response, LotsWeightPreferenceResponse.class);
  }
}
