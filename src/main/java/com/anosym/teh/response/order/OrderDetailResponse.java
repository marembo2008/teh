/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.teh.response.order;

import com.anosym.teh.response.Response;
import com.anosym.teh.response.util.PriceConverter;
import com.anosym.teh.util.DateTimeConverter;
import com.anosym.utilities.FormattedCalendar;
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
public class OrderDetailResponse extends Response {

  public static class OrderDetail {

    @Markup(name = "exchange")
    private String exchange;
    @Markup(name = "nestordernumber")
    private String nestOrderNumber;
    @Markup(name = "nestreqid")
    private String nestRequestId;
    @Markup(name = "transactiontype")
    private String transactiontType;
    @Markup(name = "symbolname")
    private String symbolName;
    @Markup(name = "exchangeorderid")
    private String exchangeOrderId;
    private String status;
    private String text;
    @Markup(name = "pricetype")
    private String priceType;
    private String duration;
    @Markup(name = "productcode")
    private String productCode;
    @Converter(DateTimeConverter.class)
    private Calendar time;
    @Markup(name = "scripname")
    @Converter(PriceConverter.class)
    private BigDecimal scripName;
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

    public String getExchange() {
      return exchange;
    }

    public void setExchange(String exchange) {
      this.exchange = exchange;
    }

    public String getNestOrderNumber() {
      return nestOrderNumber;
    }

    public void setNestOrderNumber(String nestOrderNumber) {
      this.nestOrderNumber = nestOrderNumber;
    }

    public String getNestRequestId() {
      return nestRequestId;
    }

    public void setNestRequestId(String nestRequestId) {
      this.nestRequestId = nestRequestId;
    }

    public String getTransactiontType() {
      return transactiontType;
    }

    public void setTransactiontType(String transactiontType) {
      this.transactiontType = transactiontType;
    }

    public String getSymbolName() {
      return symbolName;
    }

    public void setSymbolName(String symbolName) {
      this.symbolName = symbolName;
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

    public String getText() {
      return text;
    }

    public void setText(String text) {
      this.text = text;
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

    public String getProductCode() {
      return productCode;
    }

    public void setProductCode(String productCode) {
      this.productCode = productCode;
    }

    public Calendar getTime() {
      return time;
    }

    public void setTime(Calendar time) {
      this.time = time;
    }

    public BigDecimal getScripName() {
      return scripName;
    }

    public void setScripName(BigDecimal scripName) {
      this.scripName = scripName;
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

    @Override
    public String toString() {
      return "OrderDetail{" + "exchange=" + exchange + ", nestOrderNumber=" + nestOrderNumber + ", nestRequestId=" + nestRequestId + ", transactiontType=" + transactiontType + ", symbolName=" + symbolName + ", exchangeOrderId=" + exchangeOrderId + ", status=" + status + ", text=" + text + ", priceType=" + priceType + ", duration=" + duration + ", productCode=" + productCode + ", time=" + FormattedCalendar.toISOString(time) + ", scripName=" + scripName + ", priceToFill=" + priceToFill + ", averagePrice=" + averagePrice + ", triggerPrice=" + triggerPrice + ", quantityToFill=" + quantityToFill + ", unfilledSize=" + unfilledSize + ", disclosedQuantity=" + disclosedQuantity + '}';
    }
  }
  @Markup(name = "omneindividualhistory")
  @ArrayParented(componentMarkup = "omnesingleentry")
  private OrderDetail[] orders;

  public void setOrders(OrderDetail[] orders) {
    this.orders = orders;
  }

  public OrderDetail[] getOrders() {
    return orders;
  }

  @Override
  public String toString() {
    return "OrderDetailResponse{" + "orders=" + Arrays.toString(orders) + '}';
  }
}
