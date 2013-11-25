/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.teh.response.order;

import com.anosym.teh.response.Response;
import com.anosym.teh.response.order.util.PriceConverter;
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
public class OrderBookResponse extends Response {

  public static class OrderEntry {

    @Markup(name = "userid")
    private String userId;
    @Markup(name = "accountid")
    private String accountId;
    @Markup(name = "exchange")
    private String exchange;
    @Markup(name = "nestordernumber")
    private String nestOrderNumber;
    @Markup(name = "nestorderreqid")
    private String nestOrderRequestId;
    @Markup(name = "transactiontype")
    private String transactiontType;
    @Markup(name = "tradingsymbol")
    private String tradingSymbol;
    @Markup(name = "symbol")
    private String symbol;
    private String series;
    @Markup(name = "companyname")
    private String companyName;
    @Converter(PriceConverter.class)
    private BigDecimal price;
    @Markup(name = "avgprice")
    @Converter(PriceConverter.class)
    private BigDecimal averagePrice;
    @Markup(name = "totalqty")
    private int totalQuantity;
    @Markup(name = "pendingqty")
    private int pendingQuantity;
    @Markup(name = "dislcosedqty")
    private int dislcosedQuantity;
    @Markup(name = "filledqty")
    private int filledQuantity;
    @Markup(name = "triggerprice")
    @Converter(PriceConverter.class)
    private BigDecimal triggerPrice;
    @Markup(name = "exchangeorderno")
    private String exchangeOrderNumber;
    private String status;
    @Markup(name = "rejectionreason")
    private String rejectionReason;
    @Markup(name = "ordertype")
    private String orderType;
    @Markup(name = "orderentrytime")
    @Converter(DateTimeConverter.class)
    private Calendar orderEntryTime;
    @Markup(name = "ordervalidity")
    private String orderValidity;
    @Markup(name = "productcode")
    private String productCode;
    @Markup(name = "exchangetimestamp")
    @Converter(IsoLongMonthDateTimeConverter.class)
    private Calendar exchangeTimestamp;
    @Markup(name = "orderplacedby")
    private String orderPlacedBy;
    @Markup(name = "ordergenerationtype")
    private String orderGenerationType;
    @Markup(name = "pricenumerator")
    private String priceNumerator;
    @Markup(name = "pricedenominator")
    private String priceDenominator;
    @Markup(name = "coverorderindicator")
    private String coverOrderIndicator;
    @Markup(name = "generalnumerator")
    private String generalNumerator;
    @Markup(name = "generaldenominator")
    private String generalDenominator;
    private String remarks;
    @Markup(name = "coverreflimitprice")
    private BigDecimal coverReferenceLimitPrice;
    @Markup(name = "coverorderpercentage")
    private float coverOrderPercentage;
    @Markup(name = "ordersource")
    private String orderSource;

    public String getUserId() {
      return userId;
    }

    public void setUserId(String userId) {
      this.userId = userId;
    }

    public String getAccountId() {
      return accountId;
    }

    public void setAccountId(String accountId) {
      this.accountId = accountId;
    }

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

    public String getNestOrderRequestId() {
      return nestOrderRequestId;
    }

    public void setNestOrderRequestId(String nestOrderRequestId) {
      this.nestOrderRequestId = nestOrderRequestId;
    }

    public String getTransactiontType() {
      return transactiontType;
    }

    public void setTransactiontType(String transactiontType) {
      this.transactiontType = transactiontType;
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

    public String getSeries() {
      return series;
    }

    public void setSeries(String series) {
      this.series = series;
    }

    public String getCompanyName() {
      return companyName;
    }

    public void setCompanyName(String companyName) {
      this.companyName = companyName;
    }

    public BigDecimal getPrice() {
      return price;
    }

    public void setPrice(BigDecimal price) {
      this.price = price;
    }

    public BigDecimal getAveragePrice() {
      return averagePrice;
    }

    public void setAveragePrice(BigDecimal averagePrice) {
      this.averagePrice = averagePrice;
    }

    public int getTotalQuantity() {
      return totalQuantity;
    }

    public void setTotalQuantity(int totalQuantity) {
      this.totalQuantity = totalQuantity;
    }

    public int getPendingQuantity() {
      return pendingQuantity;
    }

    public void setPendingQuantity(int pendingQuantity) {
      this.pendingQuantity = pendingQuantity;
    }

    public int getDislcosedQuantity() {
      return dislcosedQuantity;
    }

    public void setDislcosedQuantity(int dislcosedQuantity) {
      this.dislcosedQuantity = dislcosedQuantity;
    }

    public int getFilledQuantity() {
      return filledQuantity;
    }

    public void setFilledQuantity(int filledQuantity) {
      this.filledQuantity = filledQuantity;
    }

    public BigDecimal getTriggerPrice() {
      return triggerPrice;
    }

    public void setTriggerPrice(BigDecimal triggerPrice) {
      this.triggerPrice = triggerPrice;
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

    public String getOrderType() {
      return orderType;
    }

    public void setOrderType(String orderType) {
      this.orderType = orderType;
    }

    public Calendar getOrderEntryTime() {
      return orderEntryTime;
    }

    public void setOrderEntryTime(Calendar orderEntryTime) {
      this.orderEntryTime = orderEntryTime;
    }

    public String getOrderValidity() {
      return orderValidity;
    }

    public void setOrderValidity(String orderValidity) {
      this.orderValidity = orderValidity;
    }

    public String getProductCode() {
      return productCode;
    }

    public void setProductCode(String productCode) {
      this.productCode = productCode;
    }

    public void setExchangeTimestamp(Calendar exchangeTimestamp) {
      this.exchangeTimestamp = exchangeTimestamp;
    }

    public Calendar getExchangeTimestamp() {
      return exchangeTimestamp;
    }

    public String getOrderPlacedBy() {
      return orderPlacedBy;
    }

    public void setOrderPlacedBy(String orderPlacedBy) {
      this.orderPlacedBy = orderPlacedBy;
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

    public String getCoverOrderIndicator() {
      return coverOrderIndicator;
    }

    public void setCoverOrderIndicator(String coverOrderIndicator) {
      this.coverOrderIndicator = coverOrderIndicator;
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

    public BigDecimal getCoverReferenceLimitPrice() {
      return coverReferenceLimitPrice;
    }

    public void setCoverReferenceLimitPrice(BigDecimal coverReferenceLimitPrice) {
      this.coverReferenceLimitPrice = coverReferenceLimitPrice;
    }

    public float getCoverOrderPercentage() {
      return coverOrderPercentage;
    }

    public void setCoverOrderPercentage(float coverOrderPercentage) {
      this.coverOrderPercentage = coverOrderPercentage;
    }

    public String getOrderSource() {
      return orderSource;
    }

    public void setOrderSource(String orderSource) {
      this.orderSource = orderSource;
    }

    @Override
    public String toString() {
      return "OrderEntry{" + "userId=" + userId + ",\n accountId=" + accountId + ",\n exchange=" + exchange + ",\n nestOrderNumber=" + nestOrderNumber + ",\n nestOrderRequestId=" + nestOrderRequestId + ",\n transactiontType=" + transactiontType + ",\n tradingSymbol=" + tradingSymbol + ",\n symbol=" + symbol + ",\n series=" + series + ",\n companyName=" + companyName + ",\n price=" + price + ",\n averagePrice=" + averagePrice + ",\n totalQuantity=" + totalQuantity + ",\n pendingQuantity=" + pendingQuantity + ",\n dislcosedQuantity=" + dislcosedQuantity + ",\n filledQuantity=" + filledQuantity + ",\n triggerPrice=" + triggerPrice + ",\n exchangeOrderNumber=" + exchangeOrderNumber + ",\n status=" + status + ",\n rejectionReason=" + rejectionReason + ",\n orderType=" + orderType + ",\n orderEntryTime=" + orderEntryTime + ",\n orderValidity=" + orderValidity + ",\n productCode=" + productCode + ",\n exchangeTimestamp=" + exchangeTimestamp + ",\n orderPlacedBy=" + orderPlacedBy + ",\n orderGenerationType=" + orderGenerationType + ",\n priceNumerator=" + priceNumerator + ",\n priceDenominator=" + priceDenominator + ",\n coverOrderIndicator=" + coverOrderIndicator + ",\n generalNumerator=" + generalNumerator + ",\n generalDenominator=" + generalDenominator + ",\n remarks=" + remarks + ",\n coverReferenceLimitPrice=" + coverReferenceLimitPrice + ",\n coverOrderPercentage=" + coverOrderPercentage + ",\n orderSource=" + orderSource + '}';
    }
  }
  @Markup(name = "omneorderbook")
  @ArrayParented(componentMarkup = "omnesingleentry")
  private OrderEntry[] orders;

  public OrderEntry[] getOrders() {
    return orders;
  }

  public void setOrders(OrderEntry[] orders) {
    this.orders = orders;
  }

  @Override
  public String toString() {
    return "OrderBookResponse{" + "orders=" + Arrays.toString(orders) + '}';
  }
}
