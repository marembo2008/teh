/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.teh.response.rms;

import com.anosym.teh.response.Response;
import com.anosym.vjax.annotations.Markup;
import java.math.BigDecimal;

/**
 *
 * @author marembo
 */
public class RMSSpanCalculatorResponse extends Response {

  public static class SpanCalculation {

    @Markup(name = "spanrequirement")
    private BigDecimal spanRequirement;
    @Markup(name = "totalrequirement")
    private BigDecimal totalRequirement;

    public BigDecimal getSpanRequirement() {
      return spanRequirement;
    }

    public void setSpanRequirement(BigDecimal spanRequirement) {
      this.spanRequirement = spanRequirement;
    }

    public BigDecimal getTotalRequirement() {
      return totalRequirement;
    }

    public void setTotalRequirement(BigDecimal totalRequirement) {
      this.totalRequirement = totalRequirement;
    }

    @Override
    public String toString() {
      return "SpanCalculation{" + "spanRequirement=" + spanRequirement + ", totalRequirement=" + totalRequirement + '}';
    }
  }
  @Markup(name = "spancalculation")
  private SpanCalculation spanCalculation;

  public SpanCalculation getSpanCalculation() {
    return spanCalculation;
  }

  public void setSpanCalculation(SpanCalculation spanCalculation) {
    this.spanCalculation = spanCalculation;
  }

  @Override
  public String toString() {
    return "RMSSpanCalculatorResponse{" + "spanCalculation=" + spanCalculation + '}';
  }
}
