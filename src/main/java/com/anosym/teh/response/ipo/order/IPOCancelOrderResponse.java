/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.teh.response.ipo.order;

import com.anosym.teh.response.Response;
import com.anosym.teh.response.ipo.order.IPOPlaceOrderResponse.IPOOrderStatus;
import com.anosym.vjax.annotations.Markup;
import com.anosym.vjax.annotations.v3.ArrayParented;
import java.util.Arrays;

/**
 *
 * @author marembo
 */
public class IPOCancelOrderResponse extends Response {

  @ArrayParented(componentMarkup = "omnesingleentry")
  @Markup(name = "ipocancelorder")
  private IPOOrderStatus[] orderStatus;

  public IPOOrderStatus[] getOrderStatus() {
    return orderStatus;
  }

  public void setOrderStatus(IPOOrderStatus[] orderStatus) {
    this.orderStatus = orderStatus;
  }

  @Override
  public String toString() {
    return "IPOCancelOrderResponse{" + "orderStatus=" + Arrays.toString(orderStatus) + '}';
  }
}
