/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.teh.response.mfss.scrip;

import com.anosym.teh.response.Response;
import com.anosym.vjax.annotations.Markup;
import com.anosym.vjax.annotations.v3.ArrayParented;
import java.util.Arrays;

/**
 *
 * @author marembo
 */
public class MFSSScripSeriesResponse extends Response {

  @Markup(name = "mfscrips")
  @ArrayParented(componentMarkup = "series")
  private String[] scripSeries;

  public String[] getScripSeries() {
    return scripSeries;
  }

  public void setScripSeries(String[] scripSeries) {
    this.scripSeries = scripSeries;
  }

  @Override
  public String toString() {
    return "MFSSScripSeriesResponse{" + "scripSeries=" + Arrays.toString(scripSeries) + '}';
  }
}
