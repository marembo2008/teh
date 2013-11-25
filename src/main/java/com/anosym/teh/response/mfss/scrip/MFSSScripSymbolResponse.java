/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.teh.response.mfss.scrip;

import com.anosym.teh.response.Response;
import com.anosym.vjax.annotations.Markup;
import com.anosym.vjax.annotations.v3.ArrayParented;
import java.util.Arrays;

/**
 *
 * @author marembo
 */
public class MFSSScripSymbolResponse extends Response {

  public static class MFSSScripDetail {

    private String symbol;
    @Markup(name = "symbolname")
    private String symbolName;
    @Markup(name = "schemaname")
    private String schemaName;
    @Markup(name = "sipindicator")
    private String sipIndicator;

    public String getSymbol() {
      return symbol;
    }

    public void setSymbol(String symbol) {
      this.symbol = symbol;
    }

    public String getSymbolName() {
      return symbolName;
    }

    public void setSymbolName(String symbolName) {
      this.symbolName = symbolName;
    }

    public String getSchemaName() {
      return schemaName;
    }

    public void setSchemaName(String schemaName) {
      this.schemaName = schemaName;
    }

    public String getSipIndicator() {
      return sipIndicator;
    }

    public void setSipIndicator(String sipIndicator) {
      this.sipIndicator = sipIndicator;
    }

    @Override
    public String toString() {
      return "MFSSScripDetail{" + "symbol=" + symbol + ", symbolName=" + symbolName + ", schemaName=" + schemaName + ", sipIndicator=" + sipIndicator + '}';
    }
  }
  @Markup(name = "mfscrips")
  @ArrayParented(componentMarkup = "scripdetail")
  private MFSSScripDetail[] scripDetails;

  public MFSSScripDetail[] getScripDetails() {
    return scripDetails;
  }

  public void setScripDetails(MFSSScripDetail[] scripDetails) {
    this.scripDetails = scripDetails;
  }

  @Override
  public String toString() {
    return "MFSSScripSymbolResponse{" + "scripDetails=" + Arrays.toString(scripDetails) + '}';
  }
}
