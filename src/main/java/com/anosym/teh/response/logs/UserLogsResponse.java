/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.teh.response.logs;

import com.anosym.teh.response.Response;
import com.anosym.teh.response.util.PriceConverter;
import com.anosym.vjax.converter.v3.impl.CalendarConverter;
import com.anosym.utilities.FormattedCalendar;
import com.anosym.utilities.Utility;
import com.anosym.vjax.annotations.Markup;
import com.anosym.vjax.annotations.v3.ArrayParented;
import com.anosym.vjax.annotations.v3.ConverterParam;
import com.anosym.vjax.annotations.v3.Define;
import com.anosym.vjax.converter.v3.Converter;
import com.anosym.vjax.v3.initializer.Initializer;
import com.anosym.vjax.xml.VElement;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Calendar;

/**
 *
 * @author marembo
 */
public class UserLogsResponse extends Response {

    public static interface UserMessage {
    }

    public static class CalendarMillisConverter implements Converter<Calendar, String> {

        @Override
        public String convertFrom(Calendar value) {
            return (value.getTimeInMillis() / 1000) + "";
        }

        @Override
        public Calendar convertTo(String value) {
            if (Utility.isNullOrEmpty(value) || !Utility.isNumber(value)) {
                return null;
            }
            Calendar c = Calendar.getInstance();
            c.setTimeInMillis(Long.parseLong(value) * 1000);
            return c;
        }
    }

    public static class UserLoginMessage implements UserMessage {

        @Markup(name = "messageid")
        private String messageId;
        @Markup(name = "userid")
        private String userId;
        @com.anosym.vjax.annotations.v3.Converter(CalendarMillisConverter.class)
        private Calendar time;

        public String getMessageId() {
            return messageId;
        }

        public void setMessageId(String messageId) {
            this.messageId = messageId;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public Calendar getTime() {
            return time;
        }

        public void setTime(Calendar time) {
            this.time = time;
        }

        @Override
        public String toString() {
            return "UserMessageLog{" + "messageId=" + messageId + ", \nuserId=" + userId + ", \ntime=" + FormattedCalendar.toISOString(time) + '}';
        }
    }

    public static class UserOrderMessage implements UserMessage {

        @Markup(name = "messageid")
        private String messageId;
        @Markup(name = "clientid")
        private String clientId;
        @Markup(name = "pendingqty")
        private int pendingQuantity;
        @Markup(name = "exchange")
        private String exchange;
        @Markup(name = "productcode")
        private String productCode;
        @Markup(name = "tradingsymbol")
        private String tradingSymbol;
        @Markup(name = "nestorderreqid")
        private String orderRequestId;
        @Markup(name = "ordervalidity")
        private String orderValidity;
        @Markup(name = "price")
        private BigDecimal price;
        @Markup(name = "status")
        private String status;
        @Markup(name = "transactiontype")
        private String transactionType;
        @Markup(name = "nestordernumber")
        private String orderNumber;
        @Markup(name = "exchangeorderno")
        private String exchangeOrderNumber;
        @Markup(name = "triggerprice")
        @com.anosym.vjax.annotations.v3.Converter(PriceConverter.class)
        private BigDecimal triggerPrice;
        @Markup(name = "customerfirm")
        private String customerFirm;
        @Markup(name = "filledqty")
        private int filledQuantity;
        @Markup(name = "dislcosedqty")
        private int dislcosedQuantity;
        @Markup(name = "totalqty")
        private int totalQuantity;
        @Markup(name = "orderentrytime")
        @com.anosym.vjax.annotations.v3.Converter(value = CalendarConverter.class, params = {
            @ConverterParam(key = CalendarConverter.CALENDAR_FORMAT_PARAM, value = "dd/mm/yyyy HH:mm:ss")})
        private Calendar orderEntryTime;
        @Markup(name = "text")
        private String message;
        @Markup(name = "fillid")
        private String fillId;
        @Markup(name = "clientcode")
        private String clientCode;
        @Markup(name = "pricetype")
        private String priceType;

        public String getMessageId() {
            return messageId;
        }

        public void setMessageId(String messageId) {
            this.messageId = messageId;
        }

        public String getClientId() {
            return clientId;
        }

        public void setClientId(String clientId) {
            this.clientId = clientId;
        }

        public int getPendingQuantity() {
            return pendingQuantity;
        }

        public void setPendingQuantity(int pendingQuantity) {
            this.pendingQuantity = pendingQuantity;
        }

        public String getExchange() {
            return exchange;
        }

        public void setExchange(String exchange) {
            this.exchange = exchange;
        }

        public String getProductCode() {
            return productCode;
        }

        public void setProductCode(String productCode) {
            this.productCode = productCode;
        }

        public String getTradingSymbol() {
            return tradingSymbol;
        }

        public void setTradingSymbol(String tradingSymbol) {
            this.tradingSymbol = tradingSymbol;
        }

        public String getOrderRequestId() {
            return orderRequestId;
        }

        public void setOrderRequestId(String orderRequestId) {
            this.orderRequestId = orderRequestId;
        }

        public String getOrderValidity() {
            return orderValidity;
        }

        public void setOrderValidity(String orderValidity) {
            this.orderValidity = orderValidity;
        }

        public BigDecimal getPrice() {
            return price;
        }

        public void setPrice(BigDecimal price) {
            this.price = price;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getTransactionType() {
            return transactionType;
        }

        public void setTransactionType(String transactionType) {
            this.transactionType = transactionType;
        }

        public String getOrderNumber() {
            return orderNumber;
        }

        public void setOrderNumber(String orderNumber) {
            this.orderNumber = orderNumber;
        }

        public String getExchangeOrderNumber() {
            return exchangeOrderNumber;
        }

        public void setExchangeOrderNumber(String exchangeOrderNumber) {
            this.exchangeOrderNumber = exchangeOrderNumber;
        }

        public BigDecimal getTriggerPrice() {
            return triggerPrice;
        }

        public void setTriggerPrice(BigDecimal triggerPrice) {
            this.triggerPrice = triggerPrice;
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

        public int getDislcosedQuantity() {
            return dislcosedQuantity;
        }

        public void setDislcosedQuantity(int dislcosedQuantity) {
            this.dislcosedQuantity = dislcosedQuantity;
        }

        public int getTotalQuantity() {
            return totalQuantity;
        }

        public void setTotalQuantity(int totalQuantity) {
            this.totalQuantity = totalQuantity;
        }

        public Calendar getOrderEntryTime() {
            return orderEntryTime;
        }

        public void setOrderEntryTime(Calendar orderEntryTime) {
            this.orderEntryTime = orderEntryTime;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public String getFillId() {
            return fillId;
        }

        public void setFillId(String fillId) {
            this.fillId = fillId;
        }

        public String getClientCode() {
            return clientCode;
        }

        public void setClientCode(String clientCode) {
            this.clientCode = clientCode;
        }

        public String getPriceType() {
            return priceType;
        }

        public void setPriceType(String priceType) {
            this.priceType = priceType;
        }

        @Override
        public String toString() {
            return "UserOrderMessage{" + "messageId=" + messageId + ", \nclientId=" + clientId + ", \npendingQuantity=" + pendingQuantity + ", \nexchange=" + exchange + ", \nproductCode=" + productCode + ", \ntradingSymbol=" + tradingSymbol + ", \norderRequestId=" + orderRequestId + ", \norderValidity=" + orderValidity + ", \nprice=" + price + ", \nstatus=" + status + ", \ntransactionType=" + transactionType + ", \norderNumber=" + orderNumber + ", \nexchangeOrderNumber=" + exchangeOrderNumber + ", \ntriggerPrice=" + triggerPrice + ", \ncustomerFirm=" + customerFirm + ", \nfilledQuantity=" + filledQuantity + ", \ndislcosedQuantity=" + dislcosedQuantity + ", \ntotalQuantity=" + totalQuantity + ", \norderEntryTime=" + FormattedCalendar.toISOString(orderEntryTime) + ", \nmessage=" + message + ", \nfillId=" + fillId + ", \nclientCode=" + clientCode + ", \npriceType=" + priceType + '}';
        }
    }

    public static class UserLogMessage {

        @Markup(name = "logmessage")
        @Define(UserMessageInitializer.class)
        private UserMessage logMessage;

        public void setLogMessage(UserMessage logMessage) {
            this.logMessage = logMessage;
        }

        public UserMessage getLogMessage() {
            return logMessage;
        }

        @Override
        public String toString() {
            return "UserLogMessage{" + "logMessage=" + logMessage + '}';
        }
    }
    @Markup(name = "userlogs")
    @ArrayParented(componentMarkup = "omnesingleentry")
    private UserLogMessage[] userLogMessages;

    public UserLogMessage[] getUserLogMessages() {
        return userLogMessages;
    }

    public void setUserLogMessages(UserLogMessage[] userLogMessages) {
        this.userLogMessages = userLogMessages;
    }

    @Override
    public String toString() {
        return "UserLogsResponse{" + "userLogMessages=" + Arrays.toString(userLogMessages) + '}';
    }

    public static class UserMessageInitializer implements Initializer<UserMessage> {

        public Class<? extends UserMessage> define(VElement componentElement) {
            if (componentElement.hasChild("userid")) {
                return UserLoginMessage.class;
            } else if (componentElement.hasChild("clientcode")) {
                return UserOrderMessage.class;
            }
            return null;
        }
    }
}
