/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.teh.response.marketdata;

import com.anosym.teh.response.order.util.PriceConverter;
import com.anosym.utilities.FormattedCalendar;
import com.anosym.vjax.annotations.Markup;
import com.anosym.vjax.annotations.v3.Converter;
import com.anosym.vjax.annotations.v3.ConverterParam;
import com.anosym.vjax.converter.v3.impl.CalendarConverter;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Calendar;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;

/**
 *
 * @author marembo
 */
@Entity
public class SecurityInfo implements Serializable {

    @Id
    private String symbol;
    private String series;
    @Markup(name = "boardlotqty")
    private int boardLotQuantity;
    @Markup(name = "ticksize")
    private BigDecimal tickSize;
    @Markup(name = "instrumenttype")
    private String instrumentType;
    @Markup(name = "exchange")
    private String exchange;
    @Markup(name = "issuestartdate")
    @Converter(value = CalendarConverter.class, params = {
        @ConverterParam(key = CalendarConverter.CALENDAR_FORMAT_PARAM, value = {"d MMM, yyyy", "d MMM yyyy"})})
    @Temporal(javax.persistence.TemporalType.DATE)
    private Calendar issueStartDate;
    @Markup(name = "issuematuritydate")
    @Converter(value = CalendarConverter.class, params = {
        @ConverterParam(key = CalendarConverter.CALENDAR_FORMAT_PARAM, value = {"d MMM, yyyy", "d MMM yyyy"})})
    @Temporal(javax.persistence.TemporalType.DATE)
    private Calendar issueMaturityDate;
    @Markup(name = "issuerate")
    private BigDecimal issueRate;
    @Markup(name = "issuecapital")
    private BigDecimal issueCapital;
    @Markup(name = "listdate")
    @Converter(value = CalendarConverter.class, params = {
        @ConverterParam(key = CalendarConverter.CALENDAR_FORMAT_PARAM, value = {"d MMM, yyyy", "d MMM yyyy"})})
    @Temporal(javax.persistence.TemporalType.DATE)
    private Calendar listDate;
    @Markup(name = "permittedtotrade")
    private String permittedToTrade;
    @Markup(name = "nodelstartdate")
    @Converter(value = CalendarConverter.class, params = {
        @ConverterParam(key = CalendarConverter.CALENDAR_FORMAT_PARAM, value = {"d MMM, yyyy", "d MMM yyyy"})})
    @Temporal(javax.persistence.TemporalType.DATE)
    private Calendar nodelStartDate;
    @Markup(name = "nodelendtime")
    @Converter(value = CalendarConverter.class, params = {
        @ConverterParam(key = CalendarConverter.CALENDAR_FORMAT_PARAM, value = {"d MMM, yyyy", "d MMM yyyy"})})
    @Temporal(javax.persistence.TemporalType.DATE)
    private Calendar nodelEndTime;
    @Markup(name = "bookclsstarttime")
    @Converter(value = CalendarConverter.class, params = {
        @ConverterParam(key = CalendarConverter.CALENDAR_FORMAT_PARAM, value = {"d MMM, yyyy", "d MMM yyyy"})})
    @Temporal(javax.persistence.TemporalType.DATE)
    private Calendar bookClsStartTime;
    @Markup(name = "bookclsendtime")
    @Converter(value = CalendarConverter.class, params = {
        @ConverterParam(key = CalendarConverter.CALENDAR_FORMAT_PARAM, value = {"d MMM, yyyy", "d MMM yyyy"})})
    @Temporal(javax.persistence.TemporalType.DATE)
    private Calendar bookClsEndTime;
    @Markup(name = "recorddate")
    @Converter(value = CalendarConverter.class, params = {
        @ConverterParam(key = CalendarConverter.CALENDAR_FORMAT_PARAM, value = {"d MMM, yyyy", "d MMM yyyy"})})
    @Temporal(javax.persistence.TemporalType.DATE)
    private Calendar recordDate;
    @Markup(name = "remarks")
    private String remarks;
    @Markup(name = "warning")
    private String warning;
    @Markup(name = "freeze")
    private String freeze;
    @Markup(name = "circuitrating")
    private String circuitRating;
    @Markup(name = "readmdate")
    @Converter(value = CalendarConverter.class, params = {
        @ConverterParam(key = CalendarConverter.CALENDAR_FORMAT_PARAM, value = {"d MMM, yyyy", "d MMM yyyy"})})
    @Temporal(javax.persistence.TemporalType.DATE)
    private Calendar reAdmDate;
    @Markup(name = "expulsiondate")
    @Converter(value = CalendarConverter.class, params = {
        @ConverterParam(key = CalendarConverter.CALENDAR_FORMAT_PARAM, value = {"d MMM, yyyy", "d MMM yyyy"})})
    @Temporal(javax.persistence.TemporalType.DATE)
    private Calendar expulsionDate;
    @Markup(name = "intpaydate")
    @Converter(value = CalendarConverter.class, params = {
        @ConverterParam(key = CalendarConverter.CALENDAR_FORMAT_PARAM, value = {"d MMM, yyyy", "d MMM yyyy"})})
    @Temporal(javax.persistence.TemporalType.DATE)
    private Calendar intPayDate;
    @Markup(name = "expirydate")
    @Converter(value = CalendarConverter.class, params = {
        @ConverterParam(key = CalendarConverter.CALENDAR_FORMAT_PARAM, value = {"d MMM, yyyy", "d MMM yyyy"})})
    @Temporal(javax.persistence.TemporalType.DATE)
    private Calendar expiryDate;
    @Markup(name = "localupdatetime")
    @Converter(value = CalendarConverter.class, params = {
        @ConverterParam(key = CalendarConverter.CALENDAR_FORMAT_PARAM, value = {"d MMM, yyyy", "d MMM yyyy"})})
    @Temporal(javax.persistence.TemporalType.DATE)
    private Calendar localUpdateTime;
    @Markup(name = "priceunits")
    private String priceUnits;
    @Markup(name = "pricenumerator")
    private int priceNumerator;
    @Markup(name = "qtyunits")
    private int quantityUnits;
    @Markup(name = "pricedenominator")
    private int priceDenominator;
    @Markup(name = "deliveryunits")
    private int deliveryUnits;
    @Markup(name = "generalnumerator")
    private int generalNumerator;
    @Markup(name = "tenderperiodstartdate")
    @Converter(value = CalendarConverter.class, params = {
        @ConverterParam(key = CalendarConverter.CALENDAR_FORMAT_PARAM, value = {"d MMM, yyyy", "d MMM yyyy"})})
    @Temporal(javax.persistence.TemporalType.DATE)
    private Calendar tenderPeriodStartDate;
    @Markup(name = "generaldenominator")
    private int generalDenominator;
    @Markup(name = "tenderperiodenddate")
    @Converter(value = CalendarConverter.class, params = {
        @ConverterParam(key = CalendarConverter.CALENDAR_FORMAT_PARAM, value = {"d MMM, yyyy", "d MMM yyyy"})})
    @Temporal(javax.persistence.TemporalType.DATE)
    private Calendar tenderPeriodEndDate;
    @Markup(name = "lasttradingdate")
    @Converter(value = CalendarConverter.class, params = {
        @ConverterParam(key = CalendarConverter.CALENDAR_FORMAT_PARAM, value = {"d MMM, yyyy", "d MMM yyyy"})})
    @Temporal(javax.persistence.TemporalType.DATE)
    private Calendar lastTradingDate;
    @Markup(name = "markettype")
    private String marketType;
    @Markup(name = "openinterest")
    private String openInterest;
    @Markup(name = "pricequotation")
    private String priceQuotation;
    @Markup(name = "lowercircuitlimit")
    @Converter(PriceConverter.class)
    private BigDecimal lowerCircuitLimit;
    @Markup(name = "highercircuitlimit")
    @Converter(PriceConverter.class)
    private BigDecimal higherCircuitLimit;
    @Markup(name = "deliverystartdate")
    @Converter(value = CalendarConverter.class, params = {
        @ConverterParam(key = CalendarConverter.CALENDAR_FORMAT_PARAM, value = {"d MMM, yyyy", "d MMM yyyy"})})
    @Temporal(javax.persistence.TemporalType.DATE)
    private Calendar deliveryStartDate;
    @Markup(name = "deliveryenddate")
    @Converter(value = CalendarConverter.class, params = {
        @ConverterParam(key = CalendarConverter.CALENDAR_FORMAT_PARAM, value = {"d MMM, yyyy", "d MMM yyyy"})})
    @Temporal(javax.persistence.TemporalType.DATE)
    private Calendar deliveryEndDate;
    @Markup(name = "sellvarmargin")
    private String sellVarMargin;
    @Markup(name = "buyvarmargin")
    private String buyVarMargin;
    @Markup(name = "valuetradedtoday")
    private String valueTradedToday;
    @Markup(name = "maxordersize")
    private String maxOrderSize;
    @Markup(name = "dpr")
    private String dpr;
    @Markup(name = "imspreadbenifit")
    private String imSpreadBenifit;
    @Markup(name = "otherbuymargin")
    private String otherBuyMargin;
    @Markup(name = "othersellmargin")
    private String otherSellMargin;
    @Markup(name = "exposuremargin")
    private String exposureMargin;

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

    public int getBoardLotQuantity() {
        return boardLotQuantity;
    }

    public void setBoardLotQuantity(int boardLotQuantity) {
        this.boardLotQuantity = boardLotQuantity;
    }

    public BigDecimal getTickSize() {
        return tickSize;
    }

    public void setTickSize(BigDecimal tickSize) {
        this.tickSize = tickSize;
    }

    public String getInstrumentType() {
        return instrumentType;
    }

    public void setInstrumentType(String instrumentType) {
        this.instrumentType = instrumentType;
    }

    public String getExchange() {
        return exchange;
    }

    public void setExchange(String exchange) {
        this.exchange = exchange;
    }

    public Calendar getIssueStartDate() {
        return issueStartDate;
    }

    public void setIssueStartDate(Calendar issueStartDate) {
        this.issueStartDate = issueStartDate;
    }

    public Calendar getIssueMaturityDate() {
        return issueMaturityDate;
    }

    public void setIssueMaturityDate(Calendar issueMaturityDate) {
        this.issueMaturityDate = issueMaturityDate;
    }

    public BigDecimal getIssueRate() {
        return issueRate;
    }

    public void setIssueRate(BigDecimal issueRate) {
        this.issueRate = issueRate;
    }

    public BigDecimal getIssueCapital() {
        return issueCapital;
    }

    public void setIssueCapital(BigDecimal issueCapital) {
        this.issueCapital = issueCapital;
    }

    public Calendar getListDate() {
        return listDate;
    }

    public void setListDate(Calendar listDate) {
        this.listDate = listDate;
    }

    public String getPermittedToTrade() {
        return permittedToTrade;
    }

    public void setPermittedToTrade(String permittedToTrade) {
        this.permittedToTrade = permittedToTrade;
    }

    public Calendar getNodelStartDate() {
        return nodelStartDate;
    }

    public void setNodelStartDate(Calendar nodelStartDate) {
        this.nodelStartDate = nodelStartDate;
    }

    public Calendar getNodelEndTime() {
        return nodelEndTime;
    }

    public void setNodelEndTime(Calendar nodelEndTime) {
        this.nodelEndTime = nodelEndTime;
    }

    public Calendar getBookClsStartTime() {
        return bookClsStartTime;
    }

    public void setBookClsStartTime(Calendar bookClsStartTime) {
        this.bookClsStartTime = bookClsStartTime;
    }

    public Calendar getBookClsEndTime() {
        return bookClsEndTime;
    }

    public void setBookClsEndTime(Calendar bookClsEndTime) {
        this.bookClsEndTime = bookClsEndTime;
    }

    public Calendar getRecordDate() {
        return recordDate;
    }

    public void setRecordDate(Calendar recordDate) {
        this.recordDate = recordDate;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getWarning() {
        return warning;
    }

    public void setWarning(String warning) {
        this.warning = warning;
    }

    public String getFreeze() {
        return freeze;
    }

    public void setFreeze(String freeze) {
        this.freeze = freeze;
    }

    public String getCircuitRating() {
        return circuitRating;
    }

    public void setCircuitRating(String circuitRating) {
        this.circuitRating = circuitRating;
    }

    public Calendar getReAdmDate() {
        return reAdmDate;
    }

    public void setReAdmDate(Calendar reAdmDate) {
        this.reAdmDate = reAdmDate;
    }

    public Calendar getExpulsionDate() {
        return expulsionDate;
    }

    public void setExpulsionDate(Calendar expulsionDate) {
        this.expulsionDate = expulsionDate;
    }

    public Calendar getIntPayDate() {
        return intPayDate;
    }

    public void setIntPayDate(Calendar intPayDate) {
        this.intPayDate = intPayDate;
    }

    public Calendar getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Calendar expiryDate) {
        this.expiryDate = expiryDate;
    }

    public Calendar getLocalUpdateTime() {
        return localUpdateTime;
    }

    public void setLocalUpdateTime(Calendar localUpdateTime) {
        this.localUpdateTime = localUpdateTime;
    }

    public String getPriceUnits() {
        return priceUnits;
    }

    public void setPriceUnits(String priceUnits) {
        this.priceUnits = priceUnits;
    }

    public int getPriceNumerator() {
        return priceNumerator;
    }

    public void setPriceNumerator(int priceNumerator) {
        this.priceNumerator = priceNumerator;
    }

    public int getQuantityUnits() {
        return quantityUnits;
    }

    public void setQuantityUnits(int quantityUnits) {
        this.quantityUnits = quantityUnits;
    }

    public int getPriceDenominator() {
        return priceDenominator;
    }

    public void setPriceDenominator(int priceDenominator) {
        this.priceDenominator = priceDenominator;
    }

    public int getDeliveryUnits() {
        return deliveryUnits;
    }

    public void setDeliveryUnits(int deliveryUnits) {
        this.deliveryUnits = deliveryUnits;
    }

    public int getGeneralNumerator() {
        return generalNumerator;
    }

    public void setGeneralNumerator(int generalNumerator) {
        this.generalNumerator = generalNumerator;
    }

    public Calendar getTenderPeriodStartDate() {
        return tenderPeriodStartDate;
    }

    public void setTenderPeriodStartDate(Calendar tenderPeriodStartDate) {
        this.tenderPeriodStartDate = tenderPeriodStartDate;
    }

    public int getGeneralDenominator() {
        return generalDenominator;
    }

    public void setGeneralDenominator(int generalDenominator) {
        this.generalDenominator = generalDenominator;
    }

    public Calendar getTenderPeriodEndDate() {
        return tenderPeriodEndDate;
    }

    public void setTenderPeriodEndDate(Calendar tenderPeriodEndDate) {
        this.tenderPeriodEndDate = tenderPeriodEndDate;
    }

    public Calendar getLastTradingDate() {
        return lastTradingDate;
    }

    public void setLastTradingDate(Calendar lastTradingDate) {
        this.lastTradingDate = lastTradingDate;
    }

    public String getMarketType() {
        return marketType;
    }

    public void setMarketType(String marketType) {
        this.marketType = marketType;
    }

    public String getOpenInterest() {
        return openInterest;
    }

    public void setOpenInterest(String openInterest) {
        this.openInterest = openInterest;
    }

    public String getPriceQuotation() {
        return priceQuotation;
    }

    public void setPriceQuotation(String priceQuotation) {
        this.priceQuotation = priceQuotation;
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

    public Calendar getDeliveryStartDate() {
        return deliveryStartDate;
    }

    public void setDeliveryStartDate(Calendar deliveryStartDate) {
        this.deliveryStartDate = deliveryStartDate;
    }

    public Calendar getDeliveryEndDate() {
        return deliveryEndDate;
    }

    public void setDeliveryEndDate(Calendar deliveryEndDate) {
        this.deliveryEndDate = deliveryEndDate;
    }

    public String getSellVarMargin() {
        return sellVarMargin;
    }

    public void setSellVarMargin(String sellVarMargin) {
        this.sellVarMargin = sellVarMargin;
    }

    public String getBuyVarMargin() {
        return buyVarMargin;
    }

    public void setBuyVarMargin(String buyVarMargin) {
        this.buyVarMargin = buyVarMargin;
    }

    public String getValueTradedToday() {
        return valueTradedToday;
    }

    public void setValueTradedToday(String valueTradedToday) {
        this.valueTradedToday = valueTradedToday;
    }

    public String getMaxOrderSize() {
        return maxOrderSize;
    }

    public void setMaxOrderSize(String maxOrderSize) {
        this.maxOrderSize = maxOrderSize;
    }

    public String getDpr() {
        return dpr;
    }

    public void setDpr(String dpr) {
        this.dpr = dpr;
    }

    public String getImSpreadBenifit() {
        return imSpreadBenifit;
    }

    public void setImSpreadBenifit(String imSpreadBenifit) {
        this.imSpreadBenifit = imSpreadBenifit;
    }

    public String getOtherBuyMargin() {
        return otherBuyMargin;
    }

    public void setOtherBuyMargin(String otherBuyMargin) {
        this.otherBuyMargin = otherBuyMargin;
    }

    public String getOtherSellMargin() {
        return otherSellMargin;
    }

    public void setOtherSellMargin(String otherSellMargin) {
        this.otherSellMargin = otherSellMargin;
    }

    public String getExposureMargin() {
        return exposureMargin;
    }

    public void setExposureMargin(String exposureMargin) {
        this.exposureMargin = exposureMargin;
    }

    @Override
    public String toString() {
        return "SecurityInfo{" + "symbol=" + symbol + ", series=" + series + ", boardLotQuantity=" + boardLotQuantity + ", tickSize=" + tickSize + ", instrumentType=" + instrumentType + ", exchange=" + exchange + ", issueStartDate=" + issueStartDate + ", issueMaturityDate=" + issueMaturityDate + ", issueRate=" + issueRate + ", issueCapital=" + issueCapital + ", listDate=" + listDate + ", permittedToTrade=" + permittedToTrade + ", nodelStartDate=" + nodelStartDate + ", nodelEndTime=" + nodelEndTime + ", bookClsStartTime=" + FormattedCalendar.toISOString(bookClsStartTime) + ", bookClsEndTime=" + bookClsEndTime + ", recordDate=" + recordDate + ", remarks=" + remarks + ", warning=" + warning + ", freeze=" + freeze + ", circuitRating=" + circuitRating + ", reAdmDate=" + reAdmDate + ", expulsionDate=" + expulsionDate + ", intPayDate=" + intPayDate + ", expiryDate=" + FormattedCalendar.toISOString(expiryDate) + ", localUpdateTime=" + localUpdateTime + ", priceUnits=" + priceUnits + ", priceNumerator=" + priceNumerator + ", quantityUnits=" + quantityUnits + ", priceDenominator=" + priceDenominator + ", deliveryUnits=" + deliveryUnits + ", generalNumerator=" + generalNumerator + ", tenderPeriodStartDate=" + tenderPeriodStartDate + ", generalDenominator=" + generalDenominator + ", tenderPeriodEndDate=" + tenderPeriodEndDate + ", lastTradingDate=" + lastTradingDate + ", marketType=" + marketType + ", openInterest=" + openInterest + ", priceQuotation=" + priceQuotation + ", lowerCircuitLimit=" + lowerCircuitLimit + ", higherCircuitLimit=" + higherCircuitLimit + ", deliveryStartDate=" + deliveryStartDate + ", deliveryEndDate=" + deliveryEndDate + ", sellVarMargin=" + sellVarMargin + ", buyVarMargin=" + buyVarMargin + ", valueTradedToday=" + valueTradedToday + ", maxOrderSize=" + maxOrderSize + ", dpr=" + dpr + ", imSpreadBenifit=" + imSpreadBenifit + ", otherBuyMargin=" + otherBuyMargin + ", otherSellMargin=" + otherSellMargin + ", exposureMargin=" + exposureMargin + '}';
    }
}
