/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.teh.response.marketdata;

import com.anosym.teh.response.Response;
import com.anosym.vjax.annotations.Markup;
import com.anosym.vjax.annotations.v3.ArrayParented;
import java.util.Arrays;

/**
 *
 * @author marembo
 */
public class BannedScripsResponse extends Response {

  @ArrayParented(componentMarkup = "symbolname")
  @Markup(name = "symbols")
  private String[] bannedSymbolNames;

  public String[] getBannedSymbolNames() {
    return bannedSymbolNames;
  }

  public void setBannedSymbolNames(String[] bannedSymbolNames) {
    this.bannedSymbolNames = bannedSymbolNames;
  }

  @Override
  public String toString() {
    return "BannedScripsResponse{" + "bannedSymbolNames=" + Arrays.toString(bannedSymbolNames) + '}';
  }
}
