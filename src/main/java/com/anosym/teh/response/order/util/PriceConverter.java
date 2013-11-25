/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.teh.response.order.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 *
 * @author marembo
 */
public class PriceConverter implements com.anosym.vjax.converter.v3.Converter<BigDecimal, String> {

  public String convertFrom(BigDecimal value) {
    return value.toString();
  }

  public BigDecimal convertTo(String value) {
    if (value.equalsIgnoreCase("ato")) {
      return BigDecimal.ZERO;
    }
    return new BigDecimal(value).setScale(2, RoundingMode.UP);
  }
}
