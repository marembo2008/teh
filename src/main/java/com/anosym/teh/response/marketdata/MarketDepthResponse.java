/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.teh.response.marketdata;

import com.anosym.teh.response.Response;
import com.anosym.teh.response.logs.UserLogsResponse;
import com.anosym.vjax.annotations.Markup;
import com.anosym.vjax.annotations.v3.ArrayParented;
import com.anosym.vjax.annotations.v3.Converter;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Calendar;

/**
 *
 * @author marembo
 */
public class MarketDepthResponse extends Response {

  public static class ScripDetail {

    @Markup(name = "lasttradedprice")
    private BigDecimal lastTradedPrice;
    @Markup(name = "lasttradedqty")
    private int lastTradedQuantity;
    @Markup(name = "lasttradedtime")
    @Converter(UserLogsResponse.CalendarMillisConverter.class)
    private Calendar lastTradedTime;
    @Markup(name = "percentagechange")
    private int percentageChange;
    @Markup(name = "abschange")
    private int absoluteChange;
    @Markup(name = "symbol")
    private String symbol;
    @Markup(name = "series")
    private String series;
    @Markup(name = "weightedavg")
    private BigDecimal weightedAverage;
    @Markup(name = "openrate")
    private BigDecimal openRate;
    @Markup(name = "triggerpercent")
    private int triggerPercent;
    @Markup(name = "previouscloserate")
    private BigDecimal previousCloseRate;
    @Markup(name = "highrate")
    private BigDecimal highRate;
    @Markup(name = "lowrate")
    private BigDecimal lowRate;
    @Markup(name = "trend")
    private String trend;
    @Markup(name = "volume")
    private int volume;
    @Markup(name = "totalbuyqty")
    private int totalBuyQuantity;
    @Markup(name = "totalsellqty")
    private int totalSellQuantity;
    @Markup(name = "lowercircuitlimit")
    private BigDecimal lowerCircuitLimit;
    @Markup(name = "highercircuitlimit")
    private BigDecimal higherCircuitLimit;
    @Markup(name = "openinterest")
    private int openInterest;
    @Markup(name = "value")
    private BigDecimal value;
    @Markup(name = "yearlyhighprice")
    private BigDecimal yearlyHighPrice;
    @Markup(name = "yearlylowprice")
    private BigDecimal yearlyLowPrice;
    @Markup(name = "tradingsymbol")
    private String tradingSymbol;
    @Markup(name = "companyname")
    private String companyName;

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

    public Calendar getLastTradedTime() {
      return lastTradedTime;
    }

    public void setLastTradedTime(Calendar lastTradedTime) {
      this.lastTradedTime = lastTradedTime;
    }

    public int getPercentageChange() {
      return percentageChange;
    }

    public void setPercentageChange(int percentageChange) {
      this.percentageChange = percentageChange;
    }

    public int getAbsoluteChange() {
      return absoluteChange;
    }

    public void setAbsoluteChange(int absoluteChange) {
      this.absoluteChange = absoluteChange;
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

    public BigDecimal getWeightedAverage() {
      return weightedAverage;
    }

    public void setWeightedAverage(BigDecimal weightedAverage) {
      this.weightedAverage = weightedAverage;
    }

    public BigDecimal getOpenRate() {
      return openRate;
    }

    public void setOpenRate(BigDecimal openRate) {
      this.openRate = openRate;
    }

    public int getTriggerPercent() {
      return triggerPercent;
    }

    public void setTriggerPercent(int triggerPercent) {
      this.triggerPercent = triggerPercent;
    }

    public BigDecimal getPreviousCloseRate() {
      return previousCloseRate;
    }

    public void setPreviousCloseRate(BigDecimal previousCloseRate) {
      this.previousCloseRate = previousCloseRate;
    }

    public BigDecimal getHighRate() {
      return highRate;
    }

    public void setHighRate(BigDecimal highRate) {
      this.highRate = highRate;
    }

    public BigDecimal getLowRate() {
      return lowRate;
    }

    public void setLowRate(BigDecimal lowRate) {
      this.lowRate = lowRate;
    }

    public String getTrend() {
      return trend;
    }

    public void setTrend(String trend) {
      this.trend = trend;
    }

    public int getVolume() {
      return volume;
    }

    public void setVolume(int volume) {
      this.volume = volume;
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

    public BigDecimal getLowerCircuitLimit() {
      return lowerCircuitLimit;
    }

    public void setLowerCircuitLimit(BigDecimal lowerCircuitLimit) {
      this.lowerCircuitLimit = lowerCircuitLimit;
    }

    public BigDecimal getHigherCircuitLimit() {
      return higherCircuitLimit;
    }

    public void setHigherCircuitLimit(BigDecimal higherCircuitLimit) {
      this.higherCircuitLimit = higherCircuitLimit;
    }

    public int getOpenInterest() {
      return openInterest;
    }

    public void setOpenInterest(int openInterest) {
      this.openInterest = openInterest;
    }

    public BigDecimal getValue() {
      return value;
    }

    public void setValue(BigDecimal value) {
      this.value = value;
    }

    public BigDecimal getYearlyHighPrice() {
      return yearlyHighPrice;
    }

    public void setYearlyHighPrice(BigDecimal yearlyHighPrice) {
      this.yearlyHighPrice = yearlyHighPrice;
    }

    public BigDecimal getYearlyLowPrice() {
      return yearlyLowPrice;
    }

    public void setYearlyLowPrice(BigDecimal yearlyLowPrice) {
      this.yearlyLowPrice = yearlyLowPrice;
    }

    public String getTradingSymbol() {
      return tradingSymbol;
    }

    public void setTradingSymbol(String tradingSymbol) {
      this.tradingSymbol = tradingSymbol;
    }

    public String getCompanyName() {
      return companyName;
    }

    public void setCompanyName(String companyName) {
      this.companyName = companyName;
    }

    @Override
    public String toString() {
      return "ScripDetail{" + "lastTradedPrice=" + lastTradedPrice + ", lastTradedQuantity=" + lastTradedQuantity + ", lastTradedTime=" + lastTradedTime + ", percentageChange=" + percentageChange + ", absoluteChange=" + absoluteChange + ", symbol=" + symbol + ", series=" + series + ", weightedAverage=" + weightedAverage + ", openRate=" + openRate + ", triggerPercent=" + triggerPercent + ", previousCloseRate=" + previousCloseRate + ", highRate=" + highRate + ", lowRate=" + lowRate + ", trend=" + trend + ", volume=" + volume + ", totalBuyQuantity=" + totalBuyQuantity + ", totalSellQuantity=" + totalSellQuantity + ", lowerCircuitLimit=" + lowerCircuitLimit + ", higherCircuitLimit=" + higherCircuitLimit + ", openInterest=" + openInterest + ", value=" + value + ", yearlyHighPrice=" + yearlyHighPrice + ", yearlyLowPrice=" + yearlyLowPrice + ", tradingSymbol=" + tradingSymbol + ", companyName=" + companyName + '}';
    }
  }

  public static class BestBuy {

    @Markup(name = "bestbuysize", useRegex = true, regex = "bestbuysize\\d")
    private int bestBuySize;
    @Markup(name = "bestbuyprice", useRegex = true, regex = "bestbuyprice\\d")
    private BigDecimal bestBuyPrice;
    @Markup(name = "bestbuyorders", useRegex = true, regex = "bestbuyorders\\d")
    private int bestBuyOrders;

    public int getBestBuySize() {
      return bestBuySize;
    }

    public void setBestBuySize(int bestBuySize) {
      this.bestBuySize = bestBuySize;
    }

    public BigDecimal getBestBuyPrice() {
      return bestBuyPrice;
    }

    public void setBestBuyPrice(BigDecimal bestBuyPrice) {
      this.bestBuyPrice = bestBuyPrice;
    }

    public int getBestBuyOrders() {
      return bestBuyOrders;
    }

    public void setBestBuyOrders(int bestBuyOrders) {
      this.bestBuyOrders = bestBuyOrders;
    }

    @Override
    public String toString() {
      return "BestBuy{" + "bestBuySize=" + bestBuySize + ", bestBuyPrice=" + bestBuyPrice + ", bestBuyOrders=" + bestBuyOrders + '}';
    }
  }

  public static class BestSell {

    @Markup(name = "bestsellsize", useRegex = true, regex = "bestsellsize\\d")
    private int bestSellSize;
    @Markup(name = "bestsellprice", useRegex = true, regex = "bestsellprice\\d")
    private BigDecimal bestSellPrice;
    @Markup(name = "bestsellorders", useRegex = true, regex = "bestsellorders\\d")
    private int bestSellOrders;

    public int getBestSellSize() {
      return bestSellSize;
    }

    public void setBestSellSize(int bestSellSize) {
      this.bestSellSize = bestSellSize;
    }

    public BigDecimal getBestSellPrice() {
      return bestSellPrice;
    }

    public void setBestSellPrice(BigDecimal bestSellPrice) {
      this.bestSellPrice = bestSellPrice;
    }

    public int getBestSellOrders() {
      return bestSellOrders;
    }

    public void setBestSellOrders(int bestSellOrders) {
      this.bestSellOrders = bestSellOrders;
    }

    @Override
    public String toString() {
      return "BestSell{" + "bestSellSize=" + bestSellSize + ", bestSellPrice=" + bestSellPrice + ", bestSellOrders=" + bestSellOrders + '}';
    }
  }
  @Markup(name = "mbp")
  private ScripDetail scripDetail;
  @Markup(name = "best5buy")
  @ArrayParented(componentMarkup = "omnesingleentry")
  private BestBuy[] bestBuys;
  @Markup(name = "best5sell")
  @ArrayParented(componentMarkup = "omnesingleentry")
  private BestSell[] bestSells;

  public ScripDetail getScripDetail() {
    return scripDetail;
  }

  public void setScripDetail(ScripDetail scripDetail) {
    this.scripDetail = scripDetail;
  }

  public BestBuy[] getBestBuys() {
    return bestBuys;
  }

  public void setBestBuys(BestBuy[] bestBuys) {
    this.bestBuys = bestBuys;
  }

  public BestSell[] getBestSells() {
    return bestSells;
  }

  public void setBestSells(BestSell[] bestSells) {
    this.bestSells = bestSells;
  }

  @Override
  public String toString() {
    return "MarketDepthResponse{" + "scripDetail=" + scripDetail + ", bestBuys=" + Arrays.toString(bestBuys) + ", bestSells=" + Arrays.toString(bestSells) + '}';
  }
}
