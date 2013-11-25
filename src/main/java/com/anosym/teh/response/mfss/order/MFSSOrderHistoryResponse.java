/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.teh.response.mfss.order;

import com.anosym.teh.response.Response;
import com.anosym.vjax.converter.v3.impl.CalendarConverter;
import com.anosym.utilities.FormattedCalendar;
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
public class MFSSOrderHistoryResponse extends Response {

  public static class OrderHistory {

    @Markup(name = "orderno")
    private String orderNumber;
    @Markup(name = "requestid")
    private String requestId;
    @Markup(name = "transactiontype")
    private String transactionType;
    @Markup(name = "schemename")
    private String schemeName;
    @Markup(name = "tradingsymbol")
    private String tradingSymbol;
    @Markup(name = "units")
    private int units;
    @Markup(name = "amt")
    private BigDecimal amount;
    @Markup(name = "exchorderno")
    private String exchangeOrderNumber;
    @Markup(name = "status")
    private String status;
    @Markup(name = "rejectionreason")
    private String rejectionReason;
    @Markup(name = "orderentrytime")
    @Converter(value = CalendarConverter.class, params = {
      @ConverterParam(key = CalendarConverter.CALENDAR_FORMAT_PARAM, value = "dd/mm/yyyy HH:mm:ss")})
    private Calendar orderEntryTime;

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

    public String getSchemeName() {
      return schemeName;
    }

    public void setSchemeName(String schemeName) {
      this.schemeName = schemeName;
    }

    public String getTradingSymbol() {
      return tradingSymbol;
    }

    public void setTradingSymbol(String tradingSymbol) {
      this.tradingSymbol = tradingSymbol;
    }

    public int getUnits() {
      return units;
    }

    public void setUnits(int units) {
      this.units = units;
    }

    public BigDecimal getAmount() {
      return amount;
    }

    public void setAmount(BigDecimal amount) {
      this.amount = amount;
    }

    public String getExchangeOrderNumber() {
      return exchangeOrderNumber;
    }

    public void setExchangeOrderNumber(String exchangeOrderNumber) {
      this.exchangeOrderNumber = exchangeOrderNumber;
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

    public Calendar getOrderEntryTime() {
      return orderEntryTime;
    }

    public void setOrderEntryTime(Calendar orderEntryTime) {
      this.orderEntryTime = orderEntryTime;
    }

    @Override
    public String toString() {
      return "OrderHistory{" + "orderNumber=" + orderNumber + ", requestId=" + requestId + ", transactionType=" + transactionType + ", schemeName=" + schemeName + ", tradingSymbol=" + tradingSymbol + ", units=" + units + ", amount=" + amount + ", exchangeOrderNumber=" + exchangeOrderNumber + ", status=" + status + ", rejectionReason=" + rejectionReason + ", orderEntryTime=" + FormattedCalendar.toISOString(orderEntryTime) + '}';
    }
  }
  @Markup(name = "omneindividualhistory")
  @ArrayParented(componentMarkup = "omnesingleentry")
  private OrderHistory[] orders;

  public OrderHistory[] getOrders() {
    return orders;
  }

  public void setOrders(OrderHistory[] orders) {
    this.orders = orders;
  }

  @Override
  public String toString() {
    return "MFSSOrderHistoryResponse{" + "orders=" + Arrays.toString(orders) + '}';
  }
}
