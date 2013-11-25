/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.teh.response.marketwatch;

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
public class MarketWatchScripResponse extends Response {

  public static class ScripDetail {

    private String exchange;
    @Markup(name = "companyname")
    private String companyName;
    @Markup(name = "tradingsymbol")
    private String tradingSymbol;
    @Markup(name = "symbol")
    private String symbol;
    @Markup(name = "instrumentname")
    private String instrumentName;
    @Markup(name = "symbolname")
    private String symbolName;
    @Markup(name = "expirydate")
    @Converter(value = CalendarConverter.class, params = {
      @ConverterParam(key = CalendarConverter.CALENDAR_FORMAT_PARAM, value = {"d MMM, yyyy", "d MMM yyyy"})})
    private Calendar expiryDate;
    @Markup(name = "optiontype")
    private String optionType;
    @Markup(name = "strikeprice")
    @Converter(PriceConverter.class)
    private BigDecimal strikePrice;
    @Markup(name = "lasttradedprice")
    @Converter(PriceConverter.class)
    private BigDecimal lastTradedPrice;
    @Markup(name = "lasttradedquantity")
    private int lastTradedQuantity;
    @Markup(name = "percentagechange")
    private float percentageChange;
    private int volume;
    @Markup(name = "open")
    @Converter(PriceConverter.class)
    private BigDecimal openPrice;
    @Markup(name = "close")
    @Converter(PriceConverter.class)
    private BigDecimal closePrice;
    @Markup(name = "low")
    @Converter(PriceConverter.class)
    private BigDecimal lowPrice;
    @Markup(name = "high")
    @Converter(PriceConverter.class)
    private BigDecimal highPrice;
    @Markup(name = "spotprice")
    @Converter(PriceConverter.class)
    private BigDecimal spotPrice;
    @Markup(name = "lasttradedtime")
    @Converter(value = CalendarConverter.class, params = {
      @ConverterParam(key = CalendarConverter.CALENDAR_FORMAT_PARAM, value = "dd/mm/yyyy HH:mm:ss")})
    private Calendar lastTradedTime;
    @Markup(name = "openinterest")
    private String openInterest;
    @Markup(name = "bestbuyprice")
    @Converter(PriceConverter.class)
    private BigDecimal bestBuyPrice;
    @Markup(name = "bestbuysize")
    private int bestBuySize;
    @Markup(name = "bestsellprice")
    @Converter(PriceConverter.class)
    private BigDecimal bestSellPrice;
    @Markup(name = "bestsellsize")
    private int bestSellSize;
    @Markup(name = "averageprice")
    @Converter(PriceConverter.class)
    private BigDecimal averagePrice;
    @Markup(name = "totalbuyqty")
    private int totalBuyQuantity;
    @Markup(name = "totalsellqty")
    private int totalSellQuantity;

    public String getExchange() {
      return exchange;
    }

    public void setExchange(String exchange) {
      this.exchange = exchange;
    }

    public String getCompanyName() {
      return companyName;
    }

    public void setCompanyName(String companyName) {
      this.companyName = companyName;
    }

    public String getTradingSymbol() {
      return tradingSymbol;
    }

    public void setTradingSymbol(String tradingSymbol) {
      this.tradingSymbol = tradingSymbol;
    }

    public String getSymbol() {
      return symbol;
    }

    public void setSymbol(String symbol) {
      this.symbol = symbol;
    }

    public String getInstrumentName() {
      return instrumentName;
    }

    public void setInstrumentName(String instrumentName) {
      this.instrumentName = instrumentName;
    }

    public String getSymbolName() {
      return symbolName;
    }

    public void setSymbolName(String symbolName) {
      this.symbolName = symbolName;
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

    public BigDecimal getStrikePrice() {
      return strikePrice;
    }

    public void setStrikePrice(BigDecimal strikePrice) {
      this.strikePrice = strikePrice;
    }

    public BigDecimal getLastTradedPrice() {
      return lastTradedPrice;
    }

    public void setLastTradedPrice(BigDecimal lastTradedPrice) {
      this.lastTradedPrice = lastTradedPrice;
    }

    public int getLastTradedQuantity() {
      return lastTradedQuantity;
    }

    public void setLastTradedQuantity(int lastTradedQuantity) {
      this.lastTradedQuantity = lastTradedQuantity;
    }

    public float getPercentageChange() {
      return percentageChange;
    }

    public void setPercentageChange(float percentageChange) {
      this.percentageChange = percentageChange;
    }

    public int getVolume() {
      return volume;
    }

    public void setVolume(int volume) {
      this.volume = volume;
    }

    public BigDecimal getOpenPrice() {
      return openPrice;
    }

    public void setOpenPrice(BigDecimal openPrice) {
      this.openPrice = openPrice;
    }

    public BigDecimal getClosePrice() {
      return closePrice;
    }

    public void setClosePrice(BigDecimal closePrice) {
      this.closePrice = closePrice;
    }

    public BigDecimal getLowPrice() {
      return lowPrice;
    }

    public void setLowPrice(BigDecimal lowPrice) {
      this.lowPrice = lowPrice;
    }

    public BigDecimal getHighPrice() {
      return highPrice;
    }

    public void setHighPrice(BigDecimal highPrice) {
      this.highPrice = highPrice;
    }

    public BigDecimal getSpotPrice() {
      return spotPrice;
    }

    public void setSpotPrice(BigDecimal spotPrice) {
      this.spotPrice = spotPrice;
    }

    public Calendar getLastTradedTime() {
      return lastTradedTime;
    }

    public void setLastTradedTime(Calendar lastTradedTime) {
      this.lastTradedTime = lastTradedTime;
    }

    public String getOpenInterest() {
      return openInterest;
    }

    public void setOpenInterest(String openInterest) {
      this.openInterest = openInterest;
    }

    public BigDecimal getBestBuyPrice() {
      return bestBuyPrice;
    }

    public void setBestBuyPrice(BigDecimal bestBuyPrice) {
      this.bestBuyPrice = bestBuyPrice;
    }

    public int getBestBuySize() {
      return bestBuySize;
    }

    public void setBestBuySize(int bestBuySize) {
      this.bestBuySize = bestBuySize;
    }

    public BigDecimal getBestSellPrice() {
      return bestSellPrice;
    }

    public void setBestSellPrice(BigDecimal bestSellPrice) {
      this.bestSellPrice = bestSellPrice;
    }

    public int getBestSellSize() {
      return bestSellSize;
    }

    public void setBestSellSize(int bestSellSize) {
      this.bestSellSize = bestSellSize;
    }

    public BigDecimal getAveragePrice() {
      return averagePrice;
    }

    public void setAveragePrice(BigDecimal averagePrice) {
      this.averagePrice = averagePrice;
    }

    public int getTotalBuyQuantity() {
      return totalBuyQuantity;
    }

    public void setTotalBuyQuantity(int totalBuyQuantity) {
      this.totalBuyQuantity = totalBuyQuantity;
    }

    public int getTotalSellQuantity() {
      return totalSellQuantity;
    }

    public void setTotalSellQuantity(int totalSellQuantity) {
      this.totalSellQuantity = totalSellQuantity;
    }

    @Override
    public String toString() {
      return "ScripDetail{" + "exchange=" + exchange + ", companyName=" + companyName + ", tradingSymbol=" + tradingSymbol + ", symbol=" + symbol + ", instrumentName=" + instrumentName + ", symbolName=" + symbolName + ", expiryDate=" + expiryDate + ", optionType=" + optionType + ", strikePrice=" + strikePrice + ", lastTradedPrice=" + lastTradedPrice + ", lastTradedQuantity=" + lastTradedQuantity + ", percentageChange=" + percentageChange + ", volume=" + volume + ", openPrice=" + openPrice + ", closePrice=" + closePrice + ", lowPrice=" + lowPrice + ", highPrice=" + highPrice + ", spotPrice=" + spotPrice + ", lastTradedTime=" + lastTradedTime + ", openInterest=" + openInterest + ", bestBuyPrice=" + bestBuyPrice + ", bestBuySize=" + bestBuySize + ", bestSellPrice=" + bestSellPrice + ", bestSellSize=" + bestSellSize + ", averagePrice=" + averagePrice + ", totalBuyQuantity=" + totalBuyQuantity + ", totalSellQuantity=" + totalSellQuantity + '}';
    }
  }
  @ArrayParented(componentMarkup = "omnesingleentry")
  @Markup(name = "omnemarketwatch")
  private ScripDetail[] scripDetails;

  public ScripDetail[] getScripDetails() {
    return scripDetails;
  }

  public void setScripDetails(ScripDetail[] scripDetails) {
    this.scripDetails = scripDetails;
  }

  @Override
  public String toString() {
    return "MarketWatchScripResponse{" + "scripDetails=" + Arrays.toString(scripDetails) + '}';
  }
}
