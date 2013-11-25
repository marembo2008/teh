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
public class IPOModifyOrderResponse extends Response {

  @ArrayParented(componentMarkup = "omnesingleentry")
  @Markup(name = "omneipomodifyorder")
  private IPOOrderStatus[] orderStatus;

  public IPOOrderStatus[] getOrderStatus() {
    return orderStatus;
  }

  public void setOrderStatus(IPOOrderStatus[] orderStatus) {
    this.orderStatus = orderStatus;
  }

  @Override
  public String toString() {
    return "IPOModifyOrderResponse{" + "orderStatus=" + Arrays.toString(orderStatus) + '}';
  }
}
