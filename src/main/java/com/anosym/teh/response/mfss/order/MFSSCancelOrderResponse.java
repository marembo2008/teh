/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.teh.response.mfss.order;

import com.anosym.teh.response.Response;
import com.anosym.vjax.annotations.Markup;

/**
 *
 * @author marembo
 */
public class MFSSCancelOrderResponse extends Response {

  @Markup(name = "modifyordermfordernum")
  private String orderNumber;

  public String getOrderNumber() {
    return orderNumber;
  }

  public void setOrderNumber(String orderNumber) {
    this.orderNumber = orderNumber;
  }

  @Override
  public String toString() {
    return "MFSSCancelOrderResponse{" + "orderNumber=" + orderNumber + '}';
  }
}
