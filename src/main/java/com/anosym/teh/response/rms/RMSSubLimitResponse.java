/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.teh.response.rms;

import com.anosym.teh.response.Response;
import com.anosym.vjax.annotations.Markup;

/**
 *
 * @author marembo
 */
public class RMSSubLimitResponse extends Response {

  @Markup(name = "rmssublimits")
  private RMSLimitResponse.RMSLimit rmsLimit;

  public RMSLimitResponse.RMSLimit getRmsLimit() {
    return rmsLimit;
  }

  public void setRmsLimit(RMSLimitResponse.RMSLimit rmsLimit) {
    this.rmsLimit = rmsLimit;
  }

  @Override
  public String toString() {
    return "RMSSubLimitResponse{" + "rmsLimit=" + rmsLimit + '}';
  }
}
