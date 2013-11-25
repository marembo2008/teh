/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.teh.response.ipo.order;

import com.anosym.teh.response.Response;
import com.anosym.vjax.annotations.Markup;
import com.anosym.vjax.annotations.v3.ArrayParented;
import java.util.Arrays;

/**
 *
 * @author marembo
 */
public class IPOPlaceOrderResponse extends Response {

  public static class IPOOrderStatus {

    @Markup(name = "ipostatusindicator")
    private String statusIndicator;
    @Markup(name = "ipoorderstatus")
    private String orderStatus;
    @Markup(name = "ipoorderid")
    private String orderId;
    @Markup(name = "iponestordernumber")
    private String orderNumber;

    public String getStatusIndicator() {
      return statusIndicator;
    }

    public void setStatusIndicator(String statusIndicator) {
      this.statusIndicator = statusIndicator;
    }

    public String getOrderStatus() {
      return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
      this.orderStatus = orderStatus;
    }

    public String getOrderId() {
      return orderId;
    }

    public void setOrderId(String orderId) {
      this.orderId = orderId;
    }

    public String getOrderNumber() {
      return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
      this.orderNumber = orderNumber;
    }

    @Override
    public String toString() {
      return "IPOOrderStatus{" + "statusIndicator=" + statusIndicator + ", orderStatus=" + orderStatus + ", orderId=" + orderId + ", orderNumber=" + orderNumber + '}';
    }
  }
  @ArrayParented(componentMarkup = "omnesingleentry")
  @Markup(name = "omneipoputorder")
  private IPOOrderStatus[] orderStatus;

  public IPOOrderStatus[] getOrderStatus() {
    return orderStatus;
  }

  public void setOrderStatus(IPOOrderStatus[] orderStatus) {
    this.orderStatus = orderStatus;
  }

  @Override
  public String toString() {
    return "IPOPlaceOrderResponse{" + "orderStatus=" + Arrays.toString(orderStatus) + '}';
  }
}
