/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.teh.response.mfss.order;

import com.anosym.teh.response.Response;
import com.anosym.vjax.converter.v3.impl.CalendarConverter;
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
public class MFSSOrderBookResponse extends Response {

  public static class Order {

    @Markup(name = "transactiontype")
    private String transactionType;
    private String symbol;
    private String series;
    @Markup(name = "qty")
    private int quantity;
    private BigDecimal amount;
    @Markup(name = "noworderno")
    private String nowOrderNumber;
    @Markup(name = "nowupdatetime")
    @Converter(CalendarConverter.class)
    private Calendar nowUpdateTime;
    @Markup(name = "exchorderno")
    private String exchangeOrderNumber;
    @Markup(name = "exchtimestamp")
    @Converter(CalendarConverter.class)
    private Calendar exchangeTimestamp;
    @Markup(name = "ordersource")
    private String orderSource;
    private String status;
    @Markup(name = "rejectionreason")
    private String rejectionReason;
    @Markup(name = "sipsecurity")
    private String sipSecurity;
    @Markup(name = "sipfrequency")
    private String sipFrequency;
    @Markup(name = "sipdaydate")
    private String sipDayDate;
    @Markup(name = "sipmonth")
    private String sipMonth;
    @Markup(name = "sipperiod")
    private String sipPeriod;
    @Markup(name = "siptrancheno")
    private String sipTrancehNumber;
    @Markup(name = "sipregistrationno")
    private String sipRegistrationNumber;
    @Markup(name = "orderplacedby")
    private String orderPlacedBy;
    @Markup(name = "ordergeneratintype")
    private String orderGeneratinType;

    public String getTransactionType() {
      return transactionType;
    }

    public void setTransactionType(String transactionType) {
      this.transactionType = transactionType;
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

    public int getQuantity() {
      return quantity;
    }

    public void setQuantity(int quantity) {
      this.quantity = quantity;
    }

    public BigDecimal getAmount() {
      return amount;
    }

    public void setAmount(BigDecimal amount) {
      this.amount = amount;
    }

    public String getNowOrderNumber() {
      return nowOrderNumber;
    }

    public void setNowOrderNumber(String nowOrderNumber) {
      this.nowOrderNumber = nowOrderNumber;
    }

    public Calendar getNowUpdateTime() {
      return nowUpdateTime;
    }

    public void setNowUpdateTime(Calendar nowUpdateTime) {
      this.nowUpdateTime = nowUpdateTime;
    }

    public String getExchangeOrderNumber() {
      return exchangeOrderNumber;
    }

    public void setExchangeOrderNumber(String exchangeOrderNumber) {
      this.exchangeOrderNumber = exchangeOrderNumber;
    }

    public Calendar getExchangeTimestamp() {
      return exchangeTimestamp;
    }

    public void setExchangeTimestamp(Calendar exchangeTimestamp) {
      this.exchangeTimestamp = exchangeTimestamp;
    }

    public String getOrderSource() {
      return orderSource;
    }

    public void setOrderSource(String orderSource) {
      this.orderSource = orderSource;
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

    public String getSipSecurity() {
      return sipSecurity;
    }

    public void setSipSecurity(String sipSecurity) {
      this.sipSecurity = sipSecurity;
    }

    public String getSipFrequency() {
      return sipFrequency;
    }

    public void setSipFrequency(String sipFrequency) {
      this.sipFrequency = sipFrequency;
    }

    public String getSipDayDate() {
      return sipDayDate;
    }

    public void setSipDayDate(String sipDayDate) {
      this.sipDayDate = sipDayDate;
    }

    public String getSipMonth() {
      return sipMonth;
    }

    public void setSipMonth(String sipMonth) {
      this.sipMonth = sipMonth;
    }

    public String getSipPeriod() {
      return sipPeriod;
    }

    public void setSipPeriod(String sipPeriod) {
      this.sipPeriod = sipPeriod;
    }

    public String getSipTrancehNumber() {
      return sipTrancehNumber;
    }

    public void setSipTrancehNumber(String sipTrancehNumber) {
      this.sipTrancehNumber = sipTrancehNumber;
    }

    public String getSipRegistrationNumber() {
      return sipRegistrationNumber;
    }

    public void setSipRegistrationNumber(String sipRegistrationNumber) {
      this.sipRegistrationNumber = sipRegistrationNumber;
    }

    public String getOrderPlacedBy() {
      return orderPlacedBy;
    }

    public void setOrderPlacedBy(String orderPlacedBy) {
      this.orderPlacedBy = orderPlacedBy;
    }

    public String getOrderGeneratinType() {
      return orderGeneratinType;
    }

    public void setOrderGeneratinType(String orderGeneratinType) {
      this.orderGeneratinType = orderGeneratinType;
    }

    @Override
    public String toString() {
      return "Order{" + "transactionType=" + transactionType + ", symbol=" + symbol + ", series=" + series + ", quantity=" + quantity + ", amount=" + amount + ", nowOrderNumber=" + nowOrderNumber + ", nowUpdateTime=" + nowUpdateTime + ", exchangeOrderNumber=" + exchangeOrderNumber + ", exchangeTimestamp=" + exchangeTimestamp + ", orderSource=" + orderSource + ", status=" + status + ", rejectionReason=" + rejectionReason + ", sipSecurity=" + sipSecurity + ", sipFrequency=" + sipFrequency + ", sipDayDate=" + sipDayDate + ", sipMonth=" + sipMonth + ", sipPeriod=" + sipPeriod + ", sipTrancehNumber=" + sipTrancehNumber + ", sipRegistrationNumber=" + sipRegistrationNumber + ", orderPlacedBy=" + orderPlacedBy + ", orderGeneratinType=" + orderGeneratinType + '}';
    }
  }
  @ArrayParented(componentMarkup = "omnesingleentry")
  @Markup(name = "omneorderbookmf")
  private Order[] orders;

  public Order[] getOrders() {
    return orders;
  }

  public void setOrders(Order[] orders) {
    this.orders = orders;
  }

  @Override
  public String toString() {
    return "MFSSOrderBookResponse{" + "orders=" + Arrays.toString(orders) + '}';
  }
}
