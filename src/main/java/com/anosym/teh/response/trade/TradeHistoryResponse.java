/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.teh.response.trade;

import com.anosym.teh.response.Response;
import com.anosym.teh.response.order.util.PriceConverter;
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
public class TradeHistoryResponse extends Response {

  public static class TradeEntry {

    private String exchange;
    @Markup(name = "nestordernumber")
    private String orderNumber;
    @Markup(name = "nestreqid")
    private String requestId;
    @Markup(name = "transactiontype")
    private String transactionType;
    @Markup(name = "symbolname")
    private String symbolName;
    @Markup(name = "pricetofill")
    @Converter(PriceConverter.class)
    private BigDecimal priceToFill;
    @Markup(name = "qtytofill")
    private int quantityToFill;
    @Markup(name = "unfilledsize")
    private int unfilledSize;
    @Markup(name = "disclosedqty")
    private int disclosedQuantity;
    @Markup(name = "exchangeorderid")
    private String exchangeOrderId;
    private String status;
    @Markup(name = "pricetype")
    private String priceType;
    private String duration;
    @Markup(name = "productcode")
    private String productcode;
    @Markup(name = "tradingsymbol")
    private String tradingSymbol;
    @Markup(name = "customerfirm")
    private String customerFirm;
    @Markup(name = "filledqty")
    private int filledQuantity;
    @Markup(name = "fillprc")
    @Converter(PriceConverter.class)
    private BigDecimal fillPrice;
    @Markup(name = "ordersource")
    private String orderSource;
    @Markup(name = "filldateandtime")
    @Converter(IsoLongMonthDateTimeConverter.class)
    private Calendar fillDateAndTime;
    @Markup(name = "modifieduser")
    private String modifiedUser;
    @Markup(name = "fillid")
    private String fillId;
    @Markup(name = "fillqty")
    private int fillQuantity;

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

    public String getRequestId() {
      return requestId;
    }

    public void setRequestId(String requestId) {
      this.requestId = requestId;
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

    public BigDecimal getPriceToFill() {
      return priceToFill;
    }

    public void setPriceToFill(BigDecimal priceToFill) {
      this.priceToFill = priceToFill;
    }

    public int getQuantityToFill() {
      return quantityToFill;
    }

    public void setQuantityToFill(int quantityToFill) {
      this.quantityToFill = quantityToFill;
    }

    public int getUnfilledSize() {
      return unfilledSize;
    }

    public void setUnfilledSize(int unfilledSize) {
      this.unfilledSize = unfilledSize;
    }

    public int getDisclosedQuantity() {
      return disclosedQuantity;
    }

    public void setDisclosedQuantity(int disclosedQuantity) {
      this.disclosedQuantity = disclosedQuantity;
    }

    public String getExchangeOrderId() {
      return exchangeOrderId;
    }

    public void setExchangeOrderId(String exchangeOrderId) {
      this.exchangeOrderId = exchangeOrderId;
    }

    public String getStatus() {
      return status;
    }

    public void setStatus(String status) {
      this.status = status;
    }

    public String getPriceType() {
      return priceType;
    }

    public void setPriceType(String priceType) {
      this.priceType = priceType;
    }

    public String getDuration() {
      return duration;
    }

    public void setDuration(String duration) {
      this.duration = duration;
    }

    public String getProductcode() {
      return productcode;
    }

    public void setProductcode(String productcode) {
      this.productcode = productcode;
    }

    public String getTradingSymbol() {
      return tradingSymbol;
    }

    public void setTradingSymbol(String tradingSymbol) {
      this.tradingSymbol = tradingSymbol;
    }

    public String getCustomerFirm() {
      return customerFirm;
    }

    public void setCustomerFirm(String customerFirm) {
      this.customerFirm = customerFirm;
    }

    public int getFilledQuantity() {
      return filledQuantity;
    }

    public void setFilledQuantity(int filledQuantity) {
      this.filledQuantity = filledQuantity;
    }

    public BigDecimal getFillPrice() {
      return fillPrice;
    }

    public void setFillPrice(BigDecimal fillPrice) {
      this.fillPrice = fillPrice;
    }

    public String getOrderSource() {
      return orderSource;
    }

    public void setOrderSource(String orderSource) {
      this.orderSource = orderSource;
    }

    public Calendar getFillDateAndTime() {
      return fillDateAndTime;
    }

    public void setFillDateAndTime(Calendar fillDateAndTime) {
      this.fillDateAndTime = fillDateAndTime;
    }

    public String getModifiedUser() {
      return modifiedUser;
    }

    public void setModifiedUser(String modifiedUser) {
      this.modifiedUser = modifiedUser;
    }

    public String getFillId() {
      return fillId;
    }

    public void setFillId(String fillId) {
      this.fillId = fillId;
    }

    public int getFillQuantity() {
      return fillQuantity;
    }

    public void setFillQuantity(int fillQuantity) {
      this.fillQuantity = fillQuantity;
    }

    @Override
    public String toString() {
      return "TradeEntry{" + "exchange=" + exchange + ", orderNumber=" + orderNumber + ", requestId=" + requestId + ", transactionType=" + transactionType + ", symbolName=" + symbolName + ", priceToFill=" + priceToFill + ", quantityToFill=" + quantityToFill + ", unfilledSize=" + unfilledSize + ", disclosedQuantity=" + disclosedQuantity + ", exchangeOrderId=" + exchangeOrderId + ", status=" + status + ", priceType=" + priceType + ", duration=" + duration + ", productcode=" + productcode + ", tradingSymbol=" + tradingSymbol + ", customerFirm=" + customerFirm + ", filledQuantity=" + filledQuantity + ", fillPrice=" + fillPrice + ", orderSource=" + orderSource + ", fillDateAndTime=" + fillDateAndTime + ", modifiedUser=" + modifiedUser + ", fillId=" + fillId + ", fillQuantity=" + fillQuantity + '}';
    }
  }
  @Markup(name = "omnetradehistory")
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
    return "TradeHistoryResponse{" + "tradeEntries=" + Arrays.toString(tradeEntries) + '}';
  }
}
