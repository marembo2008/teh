/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.teh.response.marketdata;

import com.anosym.vjax.annotations.Markup;
import java.math.BigDecimal;

/**
 *
 * @author marembo
 */
public class OptionCalculatorResponse {

  public static class OptionCalculator {

    @Markup(name = "theoriticaloptionprice")
    private BigDecimal theoriticalOptionPrice;
    @Markup(name = "delta")
    private BigDecimal delta;
    @Markup(name = "gamma")
    private BigDecimal gamma;
    @Markup(name = "thetaperday")
    private BigDecimal thetaPerDay;
    @Markup(name = "veg")
    private BigDecimal veg;
    @Markup(name = "rho")
    private BigDecimal rho;

    public BigDecimal getTheoriticalOptionPrice() {
      return theoriticalOptionPrice;
    }

    public void setTheoriticalOptionPrice(BigDecimal theoriticalOptionPrice) {
      this.theoriticalOptionPrice = theoriticalOptionPrice;
    }

    public BigDecimal getDelta() {
      return delta;
    }

    public void setDelta(BigDecimal delta) {
      this.delta = delta;
    }

    public BigDecimal getGamma() {
      return gamma;
    }

    public void setGamma(BigDecimal gamma) {
      this.gamma = gamma;
    }

    public BigDecimal getThetaPerDay() {
      return thetaPerDay;
    }

    public void setThetaPerDay(BigDecimal thetaPerDay) {
      this.thetaPerDay = thetaPerDay;
    }

    public BigDecimal getVeg() {
      return veg;
    }

    public void setVeg(BigDecimal veg) {
      this.veg = veg;
    }

    public BigDecimal getRho() {
      return rho;
    }

    public void setRho(BigDecimal rho) {
      this.rho = rho;
    }

    @Override
    public String toString() {
      return "OptionCalculator{" + "theoriticalOptionPrice=" + theoriticalOptionPrice + ", delta=" + delta + ", gamma=" + gamma + ", thetaPerDay=" + thetaPerDay + ", veg=" + veg + ", rho=" + rho + '}';
    }
  }
  @Markup(name = "optioncalculator")
  private OptionCalculator optionCalculator;

  public OptionCalculator getOptionCalculator() {
    return optionCalculator;
  }

  public void setOptionCalculator(OptionCalculator optionCalculator) {
    this.optionCalculator = optionCalculator;
  }

  @Override
  public String toString() {
    return "OptionCalculatorResponse{" + "optionCalculator=" + optionCalculator + '}';
  }
}
