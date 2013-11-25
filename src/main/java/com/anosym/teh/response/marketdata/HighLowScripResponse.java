/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.teh.response.marketdata;

import com.anosym.teh.response.Response;
import com.anosym.teh.response.order.util.PriceConverter;
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
public class HighLowScripResponse extends Response {

  public static class HighLowScrip {

    @Markup(name = "exchange")
    private String exchange;
    @Markup(name = "symbol")
    private String symbol;
    @Markup(name = "symbolname")
    private String symbolName;
    @Markup(name = "value")
    private BigDecimal value;
    @Markup(name = "group")
    private String group;
    @Markup(name = "scripname")
    private String scripName;
    @Markup(name = "expirydate")
    @Converter(value = CalendarConverter.class, params = {
      @ConverterParam(key = CalendarConverter.CALENDAR_FORMAT_PARAM, value = {"d MMM, yyyy", "d MMM yyyy"})})
    private Calendar expirydate;
    @Markup(name = "optiontype")
    private String optionType;
    @Markup(name = "optionprice")
    @Converter(PriceConverter.class)
    private BigDecimal optionPrice;
    @Markup(name = "lasttradedprice")
    @Converter(PriceConverter.class)
    private BigDecimal lastTradedPrice;
    @Markup(name = "prevclose")
    @Converter(PriceConverter.class)
    private BigDecimal previousClose;
    @Markup(name = "percentchange")
    private BigDecimal percentChange;

    public String getExchange() {
      return exchange;
    }

    public void setExchange(String exchange) {
      this.exchange = exchange;
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

    public BigDecimal getValue() {
      return value;
    }

    public void setValue(BigDecimal value) {
      this.value = value;
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

    public Calendar getExpirydate() {
      return expirydate;
    }

    public void setExpirydate(Calendar expirydate) {
      this.expirydate = expirydate;
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

    @Override
    public String toString() {
      return "HighLowScrip{" + "exchange=" + exchange + ", symbol=" + symbol + ", symbolName=" + symbolName + ", value=" + value + ", group=" + group + ", scripName=" + scripName + ", expirydate=" + expirydate + ", optionType=" + optionType + ", optionPrice=" + optionPrice + ", lastTradedPrice=" + lastTradedPrice + ", previousClose=" + previousClose + ", percentChange=" + percentChange + '}';
    }
  }
  @Markup(name = "highlowscrips")
  @ArrayParented(componentMarkup = "omnesingleentry")
  private HighLowScrip[] scrips;

  public HighLowScrip[] getScrips() {
    return scrips;
  }

  public void setScrips(HighLowScrip[] scrips) {
    this.scrips = scrips;
  }

  @Override
  public String toString() {
    return "HighLowScripResponse{" + "scrips=" + Arrays.toString(scrips) + '}';
  }
}
