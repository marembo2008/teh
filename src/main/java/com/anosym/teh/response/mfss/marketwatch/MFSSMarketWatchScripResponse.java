/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.teh.response.mfss.marketwatch;

import com.anosym.teh.response.Response;
import com.anosym.utilities.Utility;
import com.anosym.vjax.annotations.Markup;
import com.anosym.vjax.annotations.v3.ArrayParented;
import com.anosym.vjax.converter.v3.Converter;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Calendar;

/**
 *
 * @author marembo
 */
public class MFSSMarketWatchScripResponse extends Response {

  public static class IntegerConverter implements Converter<String, Integer> {

    public Integer convertFrom(String value) {
      return !Utility.isNullOrEmpty(value) && Utility.isNumber(value) ? Integer.parseInt(value) : 0;
    }

    public String convertTo(Integer value) {
      return value.toString();
    }
  }

  public static class BigDecimalConverter implements Converter<BigDecimal, String> {

    public String convertFrom(BigDecimal value) {
      return value.toString();
    }

    public BigDecimal convertTo(String value) {
      try {
        return new BigDecimal(value);
      } catch (Exception e) {
        return BigDecimal.ZERO;
      }
    }
  }

  public static class MFSSScripDetail {

    private String amc;
    private String symbol;
    private String series;
    @Markup(name = "schemaname")
    private String schemaName;
    @com.anosym.vjax.annotations.v3.Converter(BigDecimalConverter.class)
    private BigDecimal nav;
    @Markup(name = "navdate")
    private Calendar navDate;
    private String category;
    @Markup(name = "totalamt")
    @com.anosym.vjax.annotations.v3.Converter(BigDecimalConverter.class)
    private BigDecimal totalAmount;
    @Markup(name = "isincode")
    private String isinCode;
    @Markup(name = "sipindicator")
    private String sipIndicator;
    @Markup(name = "minredemptionqty")
    @com.anosym.vjax.annotations.v3.Converter(IntegerConverter.class)
    private int minRedemtpionQuantity;

    public String getAmc() {
      return amc;
    }

    public void setAmc(String amc) {
      this.amc = amc;
    }

    public String getSymbol() {
      return symbol;
    }

    public void setSymbol(String symbol) {
      this.symbol = symbol;
    }

    public String getSeries() {
      return series;
    }

    public void setSeries(String series) {
      this.series = series;
    }

    public String getSchemaName() {
      return schemaName;
    }

    public void setSchemaName(String schemaName) {
      this.schemaName = schemaName;
    }

    public BigDecimal getNav() {
      return nav;
    }

    public void setNav(BigDecimal nav) {
      this.nav = nav;
    }

    public Calendar getNavDate() {
      return navDate;
    }

    public void setNavDate(Calendar navDate) {
      this.navDate = navDate;
    }

    public String getCategory() {
      return category;
    }

    public void setCategory(String category) {
      this.category = category;
    }

    public BigDecimal getTotalAmount() {
      return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
      this.totalAmount = totalAmount;
    }

    public String getIsinCode() {
      return isinCode;
    }

    public void setIsinCode(String isinCode) {
      this.isinCode = isinCode;
    }

    public String getSipIndicator() {
      return sipIndicator;
    }

    public void setSipIndicator(String sipIndicator) {
      this.sipIndicator = sipIndicator;
    }

    public int getMinRedemtpionQuantity() {
      return minRedemtpionQuantity;
    }

    public void setMinRedemtpionQuantity(int minRedemtpionQuantity) {
      this.minRedemtpionQuantity = minRedemtpionQuantity;
    }

    @Override
    public String toString() {
      return "MFSSScripDetail{" + "amc=" + amc + ", symbol=" + symbol + ", series=" + series + ", schemaName=" + schemaName + ", nav=" + nav + ", navDate=" + navDate + ", category=" + category + ", totalAmount=" + totalAmount + ", isinCode=" + isinCode + ", sipIndicator=" + sipIndicator + ", minRedemtpionQuantity=" + minRedemtpionQuantity + '}';
    }
  }
  @ArrayParented(componentMarkup = "omnesingleentry")
  @Markup(name = "omnemarketwatchmf")
  private MFSSScripDetail[] scripDetails;

  public MFSSScripDetail[] getScripDetails() {
    return scripDetails;
  }

  public void setScripDetails(MFSSScripDetail[] scripDetails) {
    this.scripDetails = scripDetails;
  }

  @Override
  public String toString() {
    return "MFSSMarketWatchScripResponse{" + "scripDetails=" + Arrays.toString(scripDetails) + '}';
  }
}
