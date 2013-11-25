/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.teh.response.order.market;

import com.anosym.teh.response.Response;
import com.anosym.vjax.annotations.Markup;

/**
 *
 * @author marembo
 */
public class AMModifyOrderResponse extends Response {

  @Markup(name = "nestmodifyordernumber")
  private String orderNumber;

  public String getOrderNumber() {
    return orderNumber;
  }

  public void setOrderNumber(String orderNumber) {
    this.orderNumber = orderNumber;
  }

  @Override
  public String toString() {
    return "AMModifyOrderResponse{" + "orderNumber=" + orderNumber + '}';
  }
}
