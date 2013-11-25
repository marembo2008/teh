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
public class RMSMaxPayoutAmountResponse extends Response {

  @Markup(name = "maxpayoutamount")
  private BigDecimal maxPayoutAmount;

  public BigDecimal getMaxPayoutAmount() {
    return maxPayoutAmount;
  }

  public void setMaxPayoutAmount(BigDecimal maxPayoutAmount) {
    this.maxPayoutAmount = maxPayoutAmount;
  }

  @Override
  public String toString() {
    return "RMSMaxPayoutAmountResponse{" + "maxPayoutAmount=" + maxPayoutAmount + '}';
  }
}
