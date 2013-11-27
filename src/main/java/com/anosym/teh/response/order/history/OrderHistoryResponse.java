/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.teh.response.order.history;

import com.anosym.teh.response.Response;
import com.anosym.teh.response.util.PriceConverter;
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
public class OrderHistoryResponse extends Response {

  public static class OrderEntry {

    private String exchange;
    @Markup(name = "nestordernumber")
    private String orderNumber;
    @Markup(name = "transactiontype")
    private String transactionType;
    @Markup(name = "symbolname")
    private String symbolName;
    @Markup(name = "pricetofill")
    @Converter(PriceConverter.class)
    private BigDecimal priceToFill;
    @Markup(name = "averageprice")
    @Converter(PriceConverter.class)
    private BigDecimal averagePrice;
    @Markup(name = "triggerprice")
    @Converter(PriceConverter.class)
    private BigDecimal triggerPrice;
    @Markup(name = "qtytofill")
    private int quantityToFill;
    @Markup(name = "unfilledsize")
    private int unfilledSize;
    @Markup(name = "disclosedqty")
    private int disclosedQuantity;
    @Markup(name = "exchangeorderid")
    private String exchangeOrderId;
    private String status;
    @Markup(name = "rejectionreason")
    private String rejectionReason;
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
    @Markup(name = "exchangetimestamp")
    @Converter(IsoLongMonthDateTimeConverter.class)
    private Calendar exchangeTimestamp;
    @Markup(name = "filldateandtime")
    @Converter(IsoLongMonthDateTimeConverter.class)
    private Calendar fillDateAndTime;
    @Markup(name = "orderentrytime")
    @Converter(IsoLongMonthDateTimeConverter.class)
    private Calendar orderEntryTime;
    @Markup(name = "ordersource")
    private String orderSource;
    @Markup(name = "ordergenerationtype")
    private String orderGenerationType;

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

    public BigDecimal getAveragePrice() {
      return averagePrice;
    }

    public void setAveragePrice(BigDecimal averagePrice) {
      this.averagePrice = averagePrice;
    }

    public BigDecimal getTriggerPrice() {
      return triggerPrice;
    }

    public void setTriggerPrice(BigDecimal triggerPrice) {
      this.triggerPrice = triggerPrice;
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

    public String getRejectionReason() {
      return rejectionReason;
    }

    public void setRejectionReason(String rejectionReason) {
      this.rejectionReason = rejectionReason;
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

    public Calendar getExchangeTimestamp() {
      return exchangeTimestamp;
    }

    public void setExchangeTimestamp(Calendar exchangeTimestamp) {
      this.exchangeTimestamp = exchangeTimestamp;
    }

    public Calendar getFillDateAndTime() {
      return fillDateAndTime;
    }

    public void setFillDateAndTime(Calendar fillDateAndTime) {
      this.fillDateAndTime = fillDateAndTime;
    }

    public Calendar getOrderEntryTime() {
      return orderEntryTime;
    }

    public void setOrderEntryTime(Calendar orderEntryTime) {
      this.orderEntryTime = orderEntryTime;
    }

    public void setOrderSource(String orderSource) {
      this.orderSource = orderSource;
    }

    public String getOrderSource() {
      return orderSource;
    }


    public String getOrderGenerationType() {
      return orderGenerationType;
    }

    public void setOrderGenerationType(String orderGenerationType) {
      this.orderGenerationType = orderGenerationType;
    }

    @Override
    public String toString() {
      return "OrderEntry{" + "exchange=" + exchange + ", orderNumber=" + orderNumber + ", transactionType=" + transactionType + ", symbolName=" + symbolName + ", priceToFill=" + priceToFill + ", averagePrice=" + averagePrice + ", triggerPrice=" + triggerPrice + ", quantityToFill=" + quantityToFill + ", unfilledSize=" + unfilledSize + ", disclosedQuantity=" + disclosedQuantity + ", exchangeOrderId=" + exchangeOrderId + ", status=" + status + ", rejectionReason=" + rejectionReason + ", priceType=" + priceType + ", duration=" + duration + ", productcode=" + productcode + ", tradingSymbol=" + tradingSymbol + ", customerFirm=" + customerFirm + ", filledQuantity=" + filledQuantity + ", exchangeTimestamp=" + exchangeTimestamp + ", fillDateAndTime=" + fillDateAndTime + ", orderEntryTime=" + orderEntryTime + ", ordersource=" + orderSource + ", orderGenerationType=" + orderGenerationType + '}';
    }
  }
  @Markup(name = "omneorderhistory")
  @ArrayParented(componentMarkup = "omnesingleentry")
  private OrderEntry[] orderEntries;

  public OrderEntry[] getOrderEntries() {
    return orderEntries;
  }

  public void setOrderEntries(OrderEntry[] orderEntries) {
    this.orderEntries = orderEntries;
  }

  @Override
  public String toString() {
    return "OrderHistoryResponse{" + "orderEntries=" + Arrays.toString(orderEntries) + '}';
  }
}
