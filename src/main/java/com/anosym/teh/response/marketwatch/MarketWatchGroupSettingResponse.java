/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.teh.response.marketwatch;

import com.anosym.teh.response.Response;
import com.anosym.vjax.annotations.Markup;
import com.anosym.vjax.annotations.v3.ArrayParented;
import java.util.Arrays;

/**
 *
 * @author marembo
 */
public class MarketWatchGroupSettingResponse extends Response {

  @Markup(name = "logindefaultmw")
  private String defaultUserMarketWatch;
  @Markup(name = "logingroups")
  @ArrayParented(componentMarkup = "group")
  private String[] userCreatedGroups;

  public String getDefaultUserMarketWatch() {
    return defaultUserMarketWatch;
  }

  public void setDefaultUserMarketWatch(String defaultUserMarketWatch) {
    this.defaultUserMarketWatch = defaultUserMarketWatch;
  }

  public String[] getUserCreatedGroups() {
    return userCreatedGroups;
  }

  public void setUserCreatedGroups(String[] userCreatedGroups) {
    this.userCreatedGroups = userCreatedGroups;
  }

  @Override
  public String toString() {
    return "MarketWatchGroupSettingResponse{" + "defaultUserMarketWatch=" + defaultUserMarketWatch + ", userCreatedGroups=" + Arrays.toString(userCreatedGroups) + '}';
  }
}
