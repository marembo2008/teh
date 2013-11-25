/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.teh.response.rms;

import com.anosym.teh.response.Response;
import com.anosym.vjax.annotations.Markup;
import com.anosym.vjax.annotations.v3.ArrayParented;
import java.util.Arrays;

/**
 *
 * @author marembo
 */
public class RMST1HoldingResponse extends Response {

  public static class RMST1Holding {

    private String series;
    private String symbol;
    @Markup(name = "symbolname")
    private String symbolName;
    @Markup(name = "clientid")
    private String clientId;
    @Markup(name = "productcode")
    private String productCode;
    @Markup(name = "qty")
    private int quantity;

    @Override
    public String toString() {
      return "RMST1Holding{" + "series=" + series + ", symbol=" + symbol + ", symbolName=" + symbolName + ", clientId=" + clientId + ", productCode=" + productCode + ", quantity=" + quantity + '}';
    }

    public String getSeries() {
      return series;
    }

    public void setSeries(String series) {
      this.series = series;
    }

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

    public String getClientId() {
      return clientId;
    }

    public void setClientId(String clientId) {
      this.clientId = clientId;
    }

    public String getProductCode() {
      return productCode;
    }

    public void setProductCode(String productCode) {
      this.productCode = productCode;
    }

    public int getQuantity() {
      return quantity;
    }

    public void setQuantity(int quantity) {
      this.quantity = quantity;
    }
  }
  @ArrayParented(componentMarkup = "omnesingleentry")
  @Markup(name = "t1holdings")
  private RMST1Holding[] t1Holdings;

  public void setT1Holdings(RMST1Holding[] t1Holdings) {
    this.t1Holdings = t1Holdings;
  }

  public RMST1Holding[] getT1Holdings() {
    return t1Holdings;
  }

  @Override
  public String toString() {
    return "RMST1HoldingResponse{" + "holdings=" + Arrays.toString(t1Holdings) + '}';
  }
}
