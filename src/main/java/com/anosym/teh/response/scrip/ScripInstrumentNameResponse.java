/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.teh.response.scrip;

import com.anosym.teh.response.Response;
import com.anosym.vjax.annotations.Markup;
import com.anosym.vjax.annotations.v3.ArrayParented;

/**
 *
 * @author marembo
 */
public class ScripInstrumentNameResponse extends Response {

  @Markup(name = "nfoscrips")
  @ArrayParented(componentMarkup = "instrumentname")
  private String[] instrumentName;

  public String[] getInstrumentName() {
    return instrumentName;
  }

  public void setInstrumentName(String[] instrumentName) {
    this.instrumentName = instrumentName;
  }

  @Override
  public String toString() {
    return "ScripInstrumentNameResponse{" + "instrumentName=" + instrumentName + '}';
  }
}
