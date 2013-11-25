/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.teh.response.mfss.marketwatch;

import com.anosym.teh.response.Response;
import com.anosym.vjax.annotations.Markup;
import com.anosym.vjax.annotations.v3.ArrayParented;

/**
 *
 * @author marembo
 */
public class MFSSGroupSettingResponse extends Response {

  @Markup(name = "logindefaultmwmf")
  private String defaultMarketWatch;
  @Markup(name = "logingroupsmf")
  @ArrayParented(componentMarkup = "groupmf")
  private String[] groups;

  public String getDefaultMarketWatch() {
    return defaultMarketWatch;
  }

  public void setDefaultMarketWatch(String defaultMarketWatch) {
    this.defaultMarketWatch = defaultMarketWatch;
  }

  public String[] getGroups() {
    return groups;
  }

  public void setGroups(String[] groups) {
    this.groups = groups;
  }

  @Override
  public String toString() {
    return "MFSSGroupSettingResponse{" + "defaultMarketWatch=" + defaultMarketWatch + ", groups=" + groups + '}';
  }
}
