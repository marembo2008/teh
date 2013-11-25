/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.teh.response.scrip.trade;

import com.anosym.teh.response.Response;
import com.anosym.teh.response.scrip.ScripExpiryDateResponse;
import com.anosym.teh.response.scrip.ScripSymbolDetailResponse;
import com.anosym.vjax.annotations.Markup;
import com.anosym.vjax.annotations.v3.ArrayParented;
import java.util.Arrays;

/**
 *
 * @author marembo
 */
public class ScripSearchOnTradingSymbolResponse extends Response {

  public static class ScripTradingDetail extends ScripSymbolDetailResponse.ScripSymbolDetail {

    @Markup(name = "scripexpirydate")
    private ScripExpiryDateResponse.ExpiryDate expiryDate;

    public ScripExpiryDateResponse.ExpiryDate getExpiryDate() {
      return expiryDate;
    }

    public void setExpiryDate(ScripExpiryDateResponse.ExpiryDate expiryDate) {
      this.expiryDate = expiryDate;
    }

    @Override
    public String toString() {
      return "ScripTradingDetail{" + super.toString() + "expiryDate=" + expiryDate + '}';
    }
  }
  @Markup(name = "scrips")
  @ArrayParented(componentMarkup = "scripdetail")
  private ScripTradingDetail[] tradingDetails;

  public ScripTradingDetail[] getTradingDetails() {
    return tradingDetails;
  }

  public void setTradingDetails(ScripTradingDetail[] tradingDetails) {
    this.tradingDetails = tradingDetails;
  }

  @Override
  public String toString() {
    return "ScripSearchOnTradingSymbolResponse{" + "tradingDetails=" + Arrays.toString(tradingDetails) + '}';
  }
}
