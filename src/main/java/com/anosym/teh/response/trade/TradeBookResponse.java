/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.teh.response.trade;

import com.anosym.teh.response.Response;
import com.anosym.teh.response.util.PriceConverter;
import com.anosym.teh.util.DateTimeConverter;
import com.anosym.teh.util.IsoLongMonthDateTimeConverter;
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
public class TradeBookResponse extends Response {

  public static class TradeEntry {

    private String exchange;
    @Markup(name = "nestordernumber")
    private String orderNumber;
    @Markup(name = "nestorderreqid")
    private String orderRequestId;
    @Markup(name = "transactiontype")
    private String transactionType;
    @Markup(name = "symbolname")
    private String symbolName;
    @Markup(name = "companyname")
    private String companyName;
    private String series;
    @Markup(name = "exchangeorderno")
    private String exchangeOrderNumber;
    @Markup(name = "orderentrytime")
    @Converter(DateTimeConverter.class)
    private Calendar orderEntryTime;
    @Markup(name = "fillprice")
    @Converter(PriceConverter.class)
    private BigDecimal fillPrice;
    @Markup(name = "fillqty")
    private int fillQuantity;
    @Markup(name = "tradeid")
    private String tradeId;
    @Markup(name = "tradingsymbol")
    private String tradingSymbol;
    @Markup(name = "symbol")
    private String symbol;
    @Markup(name = "productcode")
    private String productcode;
    @Markup(name = "exchangetimestamp")
    @Converter(IsoLongMonthDateTimeConverter.class)
    private Calendar exchangeTimestamp;
    @Markup(name = "ordergenerationtype")
    private String orderGenerationType;
    @Markup(name = "pricenumerator")
    private String priceNumerator;
    @Markup(name = "pricedenominator")
    private String priceDenominator;
    @Markup(name = "generalnumerator")
    private String generalNumerator;
    @Markup(name = "generaldenominator")
    private String generalDenominator;
    private String remarks;

    public String getExchange() {
      return exchange;
    }

    public void setExchange(String exchange) {
      this.exchange = exchange;
    }

    public String getOrderNumber() {
      return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
      this.orderNumber = orderNumber;
    }

    public String getOrderRequestId() {
      return orderRequestId;
    }

    public void setOrderRequestId(String orderRequestId) {
      this.orderRequestId = orderRequestId;
    }

    public String getTransactionType() {
      return transactionType;
    }

    public void setTransactionType(String transactionType) {
      this.transactionType = transactionType;
    }

    public String getSymbolName() {
      return symbolName;
    }

    public void setSymbolName(String symbolName) {
      this.symbolName = symbolName;
    }

    public String getCompanyName() {
      return companyName;
    }

    public void setCompanyName(String companyName) {
      this.companyName = companyName;
    }

    public String getSeries() {
      return series;
    }

    public void setSeries(String series) {
      this.series = series;
    }

    public String getExchangeOrderNumber() {
      return exchangeOrderNumber;
    }

    public void setExchangeOrderNumber(String exchangeOrderNumber) {
      this.exchangeOrderNumber = exchangeOrderNumber;
    }

    public Calendar getOrderEntryTime() {
      return orderEntryTime;
    }

    public void setOrderEntryTime(Calendar orderEntryTime) {
      this.orderEntryTime = orderEntryTime;
    }

    public BigDecimal getFillPrice() {
      return fillPrice;
    }

    public void setFillPrice(BigDecimal fillPrice) {
      this.fillPrice = fillPrice;
    }

    public int getFillQuantity() {
      return fillQuantity;
    }

    public void setFillQuantity(int fillQuantity) {
      this.fillQuantity = fillQuantity;
    }

    public String getTradeId() {
      return tradeId;
    }

    public void setTradeId(String tradeId) {
      this.tradeId = tradeId;
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

    public String getProductcode() {
      return productcode;
    }

    public void setProductcode(String productcode) {
      this.productcode = productcode;
    }

    public Calendar getExchangeTimestamp() {
      return exchangeTimestamp;
    }

    public void setExchangeTimestamp(Calendar exchangeTimestamp) {
      this.exchangeTimestamp = exchangeTimestamp;
    }

    public String getOrderGenerationType() {
      return orderGenerationType;
    }

    public void setOrderGenerationType(String orderGenerationType) {
      this.orderGenerationType = orderGenerationType;
    }

    public String getPriceNumerator() {
      return priceNumerator;
    }

    public void setPriceNumerator(String priceNumerator) {
      this.priceNumerator = priceNumerator;
    }

    public String getPriceDenominator() {
      return priceDenominator;
    }

    public void setPriceDenominator(String priceDenominator) {
      this.priceDenominator = priceDenominator;
    }

    public String getGeneralNumerator() {
      return generalNumerator;
    }

    public void setGeneralNumerator(String generalNumerator) {
      this.generalNumerator = generalNumerator;
    }

    public String getGeneralDenominator() {
      return generalDenominator;
    }

    public void setGeneralDenominator(String generalDenominator) {
      this.generalDenominator = generalDenominator;
    }

    public String getRemarks() {
      return remarks;
    }

    public void setRemarks(String remarks) {
      this.remarks = remarks;
    }

    @Override
    public String toString() {
      return "TradeEntry{" + "exchange=" + exchange + ", orderNumber=" + orderNumber + ", orderRequestId=" + orderRequestId + ", transactionType=" + transactionType + ", symbolName=" + symbolName + ", companyName=" + companyName + ", series=" + series + ", exchangeOrderNumber=" + exchangeOrderNumber + ", orderEntryTime=" + orderEntryTime + ", fillPrice=" + fillPrice + ", fillQuantity=" + fillQuantity + ", tradeId=" + tradeId + ", tradingSymbol=" + tradingSymbol + ", symbol=" + symbol + ", productcode=" + productcode + ", exchangeTimestamp=" + exchangeTimestamp + ", orderGenerationType=" + orderGenerationType + ", priceNumerator=" + priceNumerator + ", priceDenominator=" + priceDenominator + ", generalNumerator=" + generalNumerator + ", generalDenominator=" + generalDenominator + ", remarks=" + remarks + '}';
    }
  }
  @Markup(name = "omnetradebook")
  @ArrayParented(componentMarkup = "omnesingleentry")
  private TradeEntry[] tradeEntries;

  public TradeEntry[] getTradeEntries() {
    return tradeEntries;
  }

  public void setTradeEntries(TradeEntry[] tradeEntries) {
    this.tradeEntries = tradeEntries;
  }

  @Override
  public String toString() {
    return "TradeBookResponse{" + "tradeEntries=" + Arrays.toString(tradeEntries) + '}';
  }
}
