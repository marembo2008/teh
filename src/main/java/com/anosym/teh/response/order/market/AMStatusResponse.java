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
public class AMStatusResponse extends Response {

  @Markup(name = "AMOPlacestatus")
  private String placeStatus;
  @Markup(name = "AMOStorestatus")
  private String storeStatus;

  public String getPlaceStatus() {
    return placeStatus;
  }

  public void setPlaceStatus(String placeStatus) {
    this.placeStatus = placeStatus;
  }

  public String getStoreStatus() {
    return storeStatus;
  }

  public void setStoreStatus(String storeStatus) {
    this.storeStatus = storeStatus;
  }

  @Override
  public String toString() {
    return "AMStatusResponse{" + "placeStatus=" + placeStatus + ", storeStatus=" + storeStatus + '}';
  }
}
