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
public class ScripSymbolResponse extends Response {

  @Markup(name = "nfoscrips")
  @ArrayParented(componentMarkup = "symbol")
  private String[] symbol;

  public String[] getSymbol() {
    return symbol;
  }

  public void setSymbol(String[] symbol) {
    this.symbol = symbol;
  }

  @Override
  public String toString() {
    return "ScripSymbolResponse{" + "symbol=" + symbol + '}';
  }
}
