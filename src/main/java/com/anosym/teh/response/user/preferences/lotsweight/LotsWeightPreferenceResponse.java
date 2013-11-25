/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.teh.response.user.preferences.lotsweight;

import com.anosym.teh.response.Response;
import com.anosym.vjax.annotations.Markup;

/**
 *
 * @author marembo
 */
public class LotsWeightPreferenceResponse extends Response {

  @Markup(name = "omnepreference")
  private String preferenceStatus;

  public String getPreferenceStatus() {
    return preferenceStatus;
  }

  public void setPreferenceStatus(String preferenceStatus) {
    this.preferenceStatus = preferenceStatus;
  }

  @Override
  public String toString() {
    return "LotsWeightPreferenceSettingResponse{" + "preferenceStatus=" + preferenceStatus + '}';
  }
}
