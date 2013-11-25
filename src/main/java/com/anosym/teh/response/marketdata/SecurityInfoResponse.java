/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.teh.response.marketdata;

import com.anosym.teh.response.Response;
import com.anosym.vjax.annotations.Markup;
import com.anosym.vjax.annotations.v3.Define;
import com.anosym.vjax.v3.initializer.Initializer;
import com.anosym.vjax.xml.VElement;

/**
 *
 * @author marembo
 */
public class SecurityInfoResponse extends Response {

  public static class SecurityInfoInitializer implements Initializer<Object> {

    public Class<? extends Object> define(VElement element) {
      if (!element.hasChildren() || element.isContentOnly()) {
        return String.class;
      }
      return SecurityInfo.class;
    }
  }
  @Define(SecurityInfoInitializer.class)
  @Markup(name = "securityinfo")
  private Object securityInfo__;

  private boolean hasData() {
    return securityInfo__ instanceof SecurityInfo;
  }

  public SecurityInfo getSecurityInfo() {
    return (SecurityInfo) (hasData() ? securityInfo__ : null);
  }

  public String getSecurityInfoMessage() {
    return (String) (hasData() ? null : securityInfo__);
  }

  @Override
  public String toString() {
    return "SecurityInfoResponse{" + "securityInfo=" + securityInfo__ + '}';
  }
}
