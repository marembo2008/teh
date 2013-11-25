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
public class IPOBidDetailErrorResponse extends Response {

  public static class IPOStatusIndicator {

    @Markup(name = "ipostatusindicator")
    private String message;

    public String getMessage() {
      return message;
    }

    public void setMessage(String message) {
      this.message = message;
    }

    @Override
    public String toString() {
      return "IPOStatusIndicator{" + "message=" + message + '}';
    }
  }
  @Markup(name = "omneipobiddetails")
  @ArrayParented(componentMarkup = "omnesingleentry")
  private IPOStatusIndicator[] statusIndicator;

  public IPOStatusIndicator[] getStatusIndicator() {
    return statusIndicator;
  }

  public void setStatusIndicator(IPOStatusIndicator[] statusIndicator) {
    this.statusIndicator = statusIndicator;
  }

  @Override
  public String toString() {
    return "IPOBidDetailErrorResponse{" + "statusIndicator=" + Arrays.toString(statusIndicator) + '}';
  }
}
