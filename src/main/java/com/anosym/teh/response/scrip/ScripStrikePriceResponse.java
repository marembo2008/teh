/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.teh.response.scrip;

import com.anosym.teh.response.Response;
import com.anosym.vjax.annotations.Markup;
import com.anosym.vjax.annotations.v3.ArrayParented;
import java.math.BigDecimal;
import java.util.Arrays;

/**
 *
 * @author marembo
 */
public class ScripStrikePriceResponse extends Response {

  @Markup(name = "nfoscrips")
  @ArrayParented(componentMarkup = "strikeprice")
  private BigDecimal[] strikePrice;

  public BigDecimal[] getStrikePrice() {
    return strikePrice;
  }

  public void setStrikePrice(BigDecimal[] strikePrice) {
    this.strikePrice = strikePrice;
  }

  @Override
  public String toString() {
    return "ScripStrikePriceResponse{" + "strikePrice=" + Arrays.toString(strikePrice) + '}';
  }
}
