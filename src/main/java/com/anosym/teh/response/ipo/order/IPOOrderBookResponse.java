/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.teh.response.ipo.order;

import com.anosym.teh.request.ipo.order.IPOPlaceOrderRequest;
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
public class IPOOrderBookResponse extends Response {

  public static class IPOOrder {

    @Markup(name = "loginaccountid")
    private String loginAccountId;
    @Markup(name = "loginaccountname")
    private String loginAccountName;
    @Markup(name = "user")
    private String user;
    @Markup(name = "ipobidno")
    private String ipoBidNumber;
    @Markup(name = "iponestorderno")
    private String ipoOrderNumber;
    @Markup(name = "ipoexchangeuser")
    private String ipoExchangeUserId;
    @Markup(name = "ipoexchangesegment")
    private String exchangeSegmentName;
    @Markup(name = "ipoexchangeorderid")
    private String exchangeOrderId;
    @Markup(name = "ipoissueid")
    private String issueId;
    @Markup(name = "iposymbol")
    private String symbol;
    @Markup(name = "iposymbolname")
    private String symbolName;
    @Markup(name = "ipogroup")
    private String group;
    @Markup(name = "ipobankaccountno")
    private String bankAccountNumber;
    @Markup(name = "ipobankaccountname")
    private String bankAccountName;
    @Markup(name = "ipobankbranch")
    private String bankBranch;
    @Markup(name = "ipobankaddress")
    private String bankAddress;
    @Markup(name = "ipodpid")
    private String dpId;
    @Markup(name = "ipodpname")
    private String dpName;
    @Markup(name = "ipodptype")
    private String dpType;
    @Markup(name = "ipodpno")
    private String dpNumber;
    @Markup(name = "ipobroker")
    private String broker;
    @Markup(name = "ipotransactiontype")
    private String transactionType;
    @Markup(name = "ipobuyqty")
    private int buyQuantity;
    @Markup(name = "ipoprice")
    private BigDecimal price;
    @Markup(name = "ipotransactionamount")
    private BigDecimal transactionAmount;
    @Markup(name = "ipoordertype")
    private String orderType;
    @Markup(name = "ipocutoff")
    private IPOPlaceOrderRequest.CutOff cutOff;
    @Markup(name = "ipomarginrate")
    private BigDecimal marginRate;
    @Markup(name = "ipominimumquantity")
    private int minimumQuantity;
    @Markup(name = "ipomultiplequantity")
    private int multipleQuantity;
    @Markup(name = "ipolowband")
    private BigDecimal lowBand;
    @Markup(name = "ipohighband")
    private BigDecimal highBand;
    @Markup(name = "iporefundtype")
    private String refundType;
    @Markup(name = "ipocustomerfirm")
    private String customerFirm;
    @Markup(name = "ipoorderduration")
    private String orderDuration;
    @Markup(name = "ipocategory")
    private String category;
    @Markup(name = "ipolocationid")
    private String locationId;
    @Markup(name = "iporoutetorms")
    private String routeToRms;
    @Markup(name = "ipostatusindicator")
    private String statusIndicator;
    @Markup(name = "ipotimestamp")
    @Converter(value = CalendarConverter.class, params = {
      @ConverterParam(key = CalendarConverter.CALENDAR_FORMAT_PARAM, value = "dd-mmm-yyyy HH:mm:ss")})
    private Calendar timestamp;
    @Markup(name = "ipoapplicationno")
    private String applicationNumber;
    @Markup(name = "ipotransactiondate")
    @Converter(value = CalendarConverter.class, params = {
      @ConverterParam(key = CalendarConverter.CALENDAR_FORMAT_PARAM, value = "dd/mm/yyyy")})
    private Calendar transactionDate;
    @Markup(name = "ipobeneficiaryid")
    private String beneficiaryId;
    @Markup(name = "ipormsvalidated")
    private String rmsValidation;
    @Markup(name = "iporeportlevel")
    private String reportLevel;
    @Markup(name = "iporeporttype")
    private String reportType;
    @Markup(name = "ipoorderstatus")
    private String orderStatus;
    @Markup(name = "ipotextmessage")
    private String message;
    @Markup(name = "ipobidlot")
    private int bidLot;
    @Markup(name = "ipofinalmodificationdate")
    @Converter(value = CalendarConverter.class, params = {
      @ConverterParam(key = CalendarConverter.CALENDAR_FORMAT_PARAM, value = "dd/mm/yyyy HH:mm:ss")})
    private Calendar finalModificationDate;
    @Markup(name = "ipostartdate")
    @Converter(value = CalendarConverter.class, params = {
      @ConverterParam(key = CalendarConverter.CALENDAR_FORMAT_PARAM, value = "dd/mm/yyyy HH:mm:ss")})
    private Calendar startDate;
    @Markup(name = "ipoenddate")
    @Converter(value = CalendarConverter.class, params = {
      @ConverterParam(key = CalendarConverter.CALENDAR_FORMAT_PARAM, value = "dd/mm/yyyy HH:mm:ss")})
    private Calendar endDate;
    @Markup(name = "ipocompanyname")
    private String companyName;
    @Converter(value = CalendarConverter.class, params = {
      @ConverterParam(key = CalendarConverter.CALENDAR_FORMAT_PARAM, value = "dd/mm/yyyy HH:mm:ss")})
    @Markup(name = "ipofinalconfirmdate")
    private Calendar finalConfirmDate;

    public String getLoginAccountId() {
      return loginAccountId;
    }

    public void setLoginAccountId(String loginAccountId) {
      this.loginAccountId = loginAccountId;
    }

    public String getLoginAccountName() {
      return loginAccountName;
    }

    public void setLoginAccountName(String loginAccountName) {
      this.loginAccountName = loginAccountName;
    }

    public String getUser() {
      return user;
    }

    public void setUser(String user) {
      this.user = user;
    }

    public String getIpoBidNumber() {
      return ipoBidNumber;
    }

    public void setIpoBidNumber(String ipoBidNumber) {
      this.ipoBidNumber = ipoBidNumber;
    }

    public String getIpoOrderNumber() {
      return ipoOrderNumber;
    }

    public void setIpoOrderNumber(String ipoOrderNumber) {
      this.ipoOrderNumber = ipoOrderNumber;
    }

    public String getIpoExchangeUserId() {
      return ipoExchangeUserId;
    }

    public void setIpoExchangeUserId(String ipoExchangeUserId) {
      this.ipoExchangeUserId = ipoExchangeUserId;
    }

    public String getExchangeSegmentName() {
      return exchangeSegmentName;
    }

    public void setExchangeSegmentName(String exchangeSegmentName) {
      this.exchangeSegmentName = exchangeSegmentName;
    }

    public String getExchangeOrderId() {
      return exchangeOrderId;
    }

    public void setExchangeOrderId(String exchangeOrderId) {
      this.exchangeOrderId = exchangeOrderId;
    }

    public String getIssueId() {
      return issueId;
    }

    public void setIssueId(String issueId) {
      this.issueId = issueId;
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

    public String getGroup() {
      return group;
    }

    public void setGroup(String group) {
      this.group = group;
    }

    public String getBankAccountNumber() {
      return bankAccountNumber;
    }

    public void setBankAccountNumber(String bankAccountNumber) {
      this.bankAccountNumber = bankAccountNumber;
    }

    public String getBankAccountName() {
      return bankAccountName;
    }

    public void setBankAccountName(String bankAccountName) {
      this.bankAccountName = bankAccountName;
    }

    public String getBankBranch() {
      return bankBranch;
    }

    public void setBankBranch(String bankBranch) {
      this.bankBranch = bankBranch;
    }

    public String getBankAddress() {
      return bankAddress;
    }

    public void setBankAddress(String bankAddress) {
      this.bankAddress = bankAddress;
    }

    public String getDpId() {
      return dpId;
    }

    public void setDpId(String dpId) {
      this.dpId = dpId;
    }

    public String getDpName() {
      return dpName;
    }

    public void setDpName(String dpName) {
      this.dpName = dpName;
    }

    public String getDpType() {
      return dpType;
    }

    public void setDpType(String dpType) {
      this.dpType = dpType;
    }

    public String getDpNumber() {
      return dpNumber;
    }

    public void setDpNumber(String dpNumber) {
      this.dpNumber = dpNumber;
    }

    public String getBroker() {
      return broker;
    }

    public void setBroker(String broker) {
      this.broker = broker;
    }

    public String getTransactionType() {
      return transactionType;
    }

    public void setTransactionType(String transactionType) {
      this.transactionType = transactionType;
    }

    public int getBuyQuantity() {
      return buyQuantity;
    }

    public void setBuyQuantity(int buyQuantity) {
      this.buyQuantity = buyQuantity;
    }

    public BigDecimal getPrice() {
      return price;
    }

    public void setPrice(BigDecimal price) {
      this.price = price;
    }

    public BigDecimal getTransactionAmount() {
      return transactionAmount;
    }

    public void setTransactionAmount(BigDecimal transactionAmount) {
      this.transactionAmount = transactionAmount;
    }

    public String getOrderType() {
      return orderType;
    }

    public void setOrderType(String orderType) {
      this.orderType = orderType;
    }

    public IPOPlaceOrderRequest.CutOff getCutOff() {
      return cutOff;
    }

    public void setCutOff(IPOPlaceOrderRequest.CutOff cutOff) {
      this.cutOff = cutOff;
    }

    public BigDecimal getMarginRate() {
      return marginRate;
    }

    public void setMarginRate(BigDecimal marginRate) {
      this.marginRate = marginRate;
    }

    public int getMinimumQuantity() {
      return minimumQuantity;
    }

    public void setMinimumQuantity(int minimumQuantity) {
      this.minimumQuantity = minimumQuantity;
    }

    public int getMultipleQuantity() {
      return multipleQuantity;
    }

    public void setMultipleQuantity(int multipleQuantity) {
      this.multipleQuantity = multipleQuantity;
    }

    public BigDecimal getLowBand() {
      return lowBand;
    }

    public void setLowBand(BigDecimal lowBand) {
      this.lowBand = lowBand;
    }

    public BigDecimal getHighBand() {
      return highBand;
    }

    public void setHighBand(BigDecimal highBand) {
      this.highBand = highBand;
    }

    public String getRefundType() {
      return refundType;
    }

    public void setRefundType(String refundType) {
      this.refundType = refundType;
    }

    public String getCustomerFirm() {
      return customerFirm;
    }

    public void setCustomerFirm(String customerFirm) {
      this.customerFirm = customerFirm;
    }

    public String getOrderDuration() {
      return orderDuration;
    }

    public void setOrderDuration(String orderDuration) {
      this.orderDuration = orderDuration;
    }

    public String getCategory() {
      return category;
    }

    public void setCategory(String category) {
      this.category = category;
    }

    public String getLocationId() {
      return locationId;
    }

    public void setLocationId(String locationId) {
      this.locationId = locationId;
    }

    public String getRouteToRms() {
      return routeToRms;
    }

    public void setRouteToRms(String routeToRms) {
      this.routeToRms = routeToRms;
    }

    public String getStatusIndicator() {
      return statusIndicator;
    }

    public void setStatusIndicator(String statusIndicator) {
      this.statusIndicator = statusIndicator;
    }

    public Calendar getTimestamp() {
      return timestamp;
    }

    public void setTimestamp(Calendar timestamp) {
      this.timestamp = timestamp;
    }

    public String getApplicationNumber() {
      return applicationNumber;
    }

    public void setApplicationNumber(String applicationNumber) {
      this.applicationNumber = applicationNumber;
    }

    public Calendar getTransactionDate() {
      return transactionDate;
    }

    public void setTransactionDate(Calendar transactionDate) {
      this.transactionDate = transactionDate;
    }

    public String getBeneficiaryId() {
      return beneficiaryId;
    }

    public void setBeneficiaryId(String beneficiaryId) {
      this.beneficiaryId = beneficiaryId;
    }

    public String getRmsValidation() {
      return rmsValidation;
    }

    public void setRmsValidation(String rmsValidation) {
      this.rmsValidation = rmsValidation;
    }

    public String getReportLevel() {
      return reportLevel;
    }

    public void setReportLevel(String reportLevel) {
      this.reportLevel = reportLevel;
    }

    public String getReportType() {
      return reportType;
    }

    public void setReportType(String reportType) {
      this.reportType = reportType;
    }

    public String getOrderStatus() {
      return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
      this.orderStatus = orderStatus;
    }

    public String getMessage() {
      return message;
    }

    public void setMessage(String message) {
      this.message = message;
    }

    public int getBidLot() {
      return bidLot;
    }

    public void setBidLot(int bidLot) {
      this.bidLot = bidLot;
    }

    public Calendar getFinalModificationDate() {
      return finalModificationDate;
    }

    public void setFinalModificationDate(Calendar finalModificationDate) {
      this.finalModificationDate = finalModificationDate;
    }

    public Calendar getStartDate() {
      return startDate;
    }

    public void setStartDate(Calendar startDate) {
      this.startDate = startDate;
    }

    public Calendar getEndDate() {
      return endDate;
    }

    public void setEndDate(Calendar endDate) {
      this.endDate = endDate;
    }

    public String getCompanyName() {
      return companyName;
    }

    public void setCompanyName(String companyName) {
      this.companyName = companyName;
    }

    public Calendar getFinalConfirmDate() {
      return finalConfirmDate;
    }

    public void setFinalConfirmDate(Calendar finalConfirmDate) {
      this.finalConfirmDate = finalConfirmDate;
    }

    @Override
    public String toString() {
      return "IPOOrder{" + "loginAccountId=" + loginAccountId + ", \nloginAccountName=" + loginAccountName + ", \nuser=" + user + ", \nipoBidNumber=" + ipoBidNumber + ", \nipoOrderNumber=" + ipoOrderNumber + ", \nipoExchangeUserId=" + ipoExchangeUserId + ", \nexchangeSegmentName=" + exchangeSegmentName + ", \nexchangeOrderId=" + exchangeOrderId + ", \nissueId=" + issueId + ", \nsymbol=" + symbol + ", \nsymbolName=" + symbolName + ", \ngroup=" + group + ", \nbankAccountNumber=" + bankAccountNumber + ", \nbankAccountName=" + bankAccountName + ", \nbankBranch=" + bankBranch + ", \nbankAddress=" + bankAddress + ", \ndpId=" + dpId + ", \ndpName=" + dpName + ", \ndpType=" + dpType + ", \ndpNumber=" + dpNumber + ", \nbroker=" + broker + ", \ntransactionType=" + transactionType + ", \nbuyQuantity=" + buyQuantity + ", \nprice=" + price + ", \ntransactionAmount=" + transactionAmount + ", \norderType=" + orderType + ", \ncutOff=" + cutOff + ", \nmarginRate=" + marginRate + ", \nminimumQuantity=" + minimumQuantity + ", \nmultipleQuantity=" + multipleQuantity + ", \nlowBand=" + lowBand + ", \nhighBand=" + highBand + ", \nrefundType=" + refundType + ", \ncustomerFirm=" + customerFirm + ", \norderDuration=" + orderDuration + ", \ncategory=" + category + ", \nlocationId=" + locationId + ", \nrouteToRms=" + routeToRms + ", \nstatusIndicator=" + statusIndicator + ", \ntimestamp=" + FormattedCalendar.toISOString(timestamp) + ", \napplicationNumber=" + applicationNumber + ", \ntransactionDate=" + FormattedCalendar.toISOString(transactionDate) + ", \nbeneficiaryId=" + beneficiaryId + ", \nrmsValidation=" + rmsValidation + ", \nreportLevel=" + reportLevel + ", \nreportType=" + reportType + ", \norderStatus=" + orderStatus + ", \nmessage=" + message + ", \nbidLot=" + bidLot + ", \nfinalModificationDate=" + finalModificationDate + ", \nstartDate=" + FormattedCalendar.toISOString(startDate) + ", \nendDate=" + FormattedCalendar.toISOString(endDate) + ", \ncompanyName=" + companyName + ", \nfinalConfirmDate=" + FormattedCalendar.toISOString(finalConfirmDate) + '}';
    }
  }
  @Markup(name = "omneipoorderbook")
  @ArrayParented(componentMarkup = "omnesingleentry")
  private IPOOrder[] orders;

  public IPOOrder[] getOrders() {
    return orders;
  }

  public void setOrders(IPOOrder[] orders) {
    this.orders = orders;
  }

  @Override
  public String toString() {
    return "IPOOrderBookResponse{" + "orders=" + Arrays.toString(orders) + '}';
  }
}
