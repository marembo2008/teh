/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.teh.response.marketdata.views;

import com.anosym.teh.response.Response;
import com.anosym.vjax.converter.v3.impl.CalendarConverter;
import com.anosym.vjax.annotations.Markup;
import com.anosym.vjax.annotations.v3.ArrayParented;
import com.anosym.vjax.annotations.v3.Converter;
import com.anosym.vjax.annotations.v3.ConverterParam;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Calendar;

/**
 *
 * @author marembo
 */
public class TopNValuesResponse extends Response {

  public static class Scrip {

    @Markup(name = "exchange")
    private String exchange;
    @Markup(name = "symbolname")
    private String symbolName;
    @Markup(name = "group")
    private String group;
    @Markup(name = "scripname")
    private String scripName;
    @Markup(name = "scripcode")
    private String scripCode;
    @Markup(name = "expirydate")
    @Converter(value = CalendarConverter.class, params = {
      @ConverterParam(key = CalendarConverter.CALENDAR_FORMAT_PARAM, value = {"d MMM, yyyy", "d MMM yyyy"})})
    private Calendar expiryDate;
    @Markup(name = "optiontype")
    private String optionType;
    @Markup(name = "optionprice")
    private BigDecimal optionPrice;
    @Markup(name = "lasttradedprice")
    private BigDecimal lastTradedPrice;
    @Markup(name = "prevclose")
    private BigDecimal previousClose;
    @Markup(name = "percentchange")
    private BigDecimal percentChange;
    @Markup(name = "value")
    private BigDecimal value;

    public String getExchange() {
      return exchange;
    }

    public void setExchange(String exchange) {
      this.exchange = exchange;
    }

    public String getSymbolName() {
      return symbolName;
    }

    public void setSymbolName(String symbolName) {
      this.symbolName = symbolName;
    }

    public String getGroup() {
      return group;
    }

    public void setGroup(String group) {
      this.group = group;
    }

    public String getScripName() {
      return scripName;
    }

    public void setScripName(String scripName) {
      this.scripName = scripName;
    }

    public String getScripCode() {
      return scripCode;
    }

    public void setScripCode(String scripCode) {
      this.scripCode = scripCode;
    }

    public Calendar getExpiryDate() {
      return expiryDate;
    }

    public void setExpiryDate(Calendar expiryDate) {
      this.expiryDate = expiryDate;
    }

    public String getOptionType() {
      return optionType;
    }

    public void setOptionType(String optionType) {
      this.optionType = optionType;
    }

    public BigDecimal getOptionPrice() {
      return optionPrice;
    }

    public void setOptionPrice(BigDecimal optionPrice) {
      this.optionPrice = optionPrice;
    }

    public BigDecimal getLastTradedPrice() {
      return lastTradedPrice;
    }

    public void setLastTradedPrice(BigDecimal lastTradedPrice) {
      this.lastTradedPrice = lastTradedPrice;
    }

    public BigDecimal getPreviousClose() {
      return previousClose;
    }

    public void setPreviousClose(BigDecimal previousClose) {
      this.previousClose = previousClose;
    }

    public BigDecimal getPercentChange() {
      return percentChange;
    }

    public void setPercentChange(BigDecimal percentChange) {
      this.percentChange = percentChange;
    }

    public BigDecimal getValue() {
      return value;
    }

    public void setValue(BigDecimal value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return "Scrip{" + "exchange=" + exchange + ", symbolName=" + symbolName + ", group=" + group + ", scripName=" + scripName + ", scripCode=" + scripCode + ", expiryDate=" + expiryDate + ", optionType=" + optionType + ", optionPrice=" + optionPrice + ", lastTradedPrice=" + lastTradedPrice + ", previousClose=" + previousClose + ", percentChange=" + percentChange + ", value=" + value + '}';
    }
  }

  public static class Values {

    @Markup(name = "topnvalues")
    @ArrayParented
    private Scrip[] topValues;
    @Markup(name = "bottomnvalues")
    @ArrayParented
    private Scrip[] bottomValues;

    public Scrip[] getTopValues() {
      return topValues;
    }

    public void setTopValues(Scrip[] topValues) {
      this.topValues = topValues;
    }

    public Scrip[] getBottomValues() {
      return bottomValues;
    }

    public void setBottomValues(Scrip[] bottomValues) {
      this.bottomValues = bottomValues;
    }

    @Override
    public String toString() {
      return "Values{" + "topValues=" + Arrays.toString(topValues) + ", bottomValues=" + Arrays.toString(bottomValues) + '}';
    }
  }
  @Markup(name = "topandbottomvalues")
  private Values values;

  public Values getValues() {
    return values;
  }

  public void setValues(Values values) {
    this.values = values;
  }

  @Override
  public String toString() {
    return "TopNValuesResponse{" + "values=" + values + '}';
  }
}
