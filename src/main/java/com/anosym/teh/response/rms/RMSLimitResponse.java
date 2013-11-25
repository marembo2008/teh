/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.teh.response.rms;

import com.anosym.teh.response.Response;
import com.anosym.teh.response.order.util.PriceConverter;
import com.anosym.vjax.annotations.Markup;
import com.anosym.vjax.annotations.v3.Converter;
import java.math.BigDecimal;

/**
 *
 * @author marembo
 */
public class RMSLimitResponse extends Response {

  public static class MarginAvailable {

    @Markup(name = "cashmarginavailable")
    @Converter(PriceConverter.class)
    private BigDecimal cashMarginAvailable;
    @Markup(name = "collateralvalue")
    @Converter(PriceConverter.class)
    private BigDecimal collateralValue;
    @Markup(name = "directcollateralvalue")
    @Converter(PriceConverter.class)
    private BigDecimal directCollateralValue;
    @Markup(name = "adhocmargin")
    @Converter(PriceConverter.class)
    private BigDecimal adhocMargin;
    @Markup(name = "branchadhoc")
    @Converter(PriceConverter.class)
    private BigDecimal branchAdhoc;
    @Markup(name = "payinamount")
    @Converter(PriceConverter.class)
    private BigDecimal payInAmount;
    @Markup(name = "credits")
    @Converter(PriceConverter.class)
    private BigDecimal credits;
    @Markup(name = "notionalcash")
    @Converter(PriceConverter.class)
    private BigDecimal notionalCash;

    public BigDecimal getCashMarginAvailable() {
      return cashMarginAvailable;
    }

    public void setCashMarginAvailable(BigDecimal cashMarginAvailable) {
      this.cashMarginAvailable = cashMarginAvailable;
    }

    public BigDecimal getCollateralValue() {
      return collateralValue;
    }

    public void setCollateralValue(BigDecimal collateralValue) {
      this.collateralValue = collateralValue;
    }

    public BigDecimal getDirectCollateralValue() {
      return directCollateralValue;
    }

    public void setDirectCollateralValue(BigDecimal directCollateralValue) {
      this.directCollateralValue = directCollateralValue;
    }

    public BigDecimal getAdhocMargin() {
      return adhocMargin;
    }

    public void setAdhocMargin(BigDecimal adhocMargin) {
      this.adhocMargin = adhocMargin;
    }

    public BigDecimal getBranchAdhoc() {
      return branchAdhoc;
    }

    public void setBranchAdhoc(BigDecimal branchAdhoc) {
      this.branchAdhoc = branchAdhoc;
    }

    public BigDecimal getPayInAmount() {
      return payInAmount;
    }

    public void setPayInAmount(BigDecimal payInAmount) {
      this.payInAmount = payInAmount;
    }

    public BigDecimal getCredits() {
      return credits;
    }

    public void setCredits(BigDecimal credits) {
      this.credits = credits;
    }

    public BigDecimal getNotionalCash() {
      return notionalCash;
    }

    public void setNotionalCash(BigDecimal notionalCash) {
      this.notionalCash = notionalCash;
    }

    @Override
    public String toString() {
      return "MarginAvailable{" + "cashMarginAvailable=" + cashMarginAvailable + ", collateralValue=" + collateralValue + ", directCollateralValue=" + directCollateralValue + ", adhocMargin=" + adhocMargin + ", branchAdhoc=" + branchAdhoc + ", payInAmount=" + payInAmount + ", credits=" + credits + ", notionalCash=" + notionalCash + '}';
    }
  }

  public static class MarginUtilized {

    @Markup(name = "category")
    private String category;
    @Markup(name = "turnover")
    @Converter(PriceConverter.class)
    private BigDecimal turnover;
    @Markup(name = "multiplier")
    @Converter(PriceConverter.class)
    private BigDecimal multiplier;
    @Markup(name = "grossexposurevalue")
    @Converter(PriceConverter.class)
    private BigDecimal grossExposureValue;
    @Markup(name = "elm")
    @Converter(PriceConverter.class)
    private BigDecimal elm;
    @Markup(name = "valueindelivery")
    @Converter(PriceConverter.class)
    private BigDecimal valueInDelivery;
    @Markup(name = "varmargin")
    @Converter(PriceConverter.class)
    private BigDecimal varMargin;
    @Markup(name = "spanmargin")
    @Converter(PriceConverter.class)
    private BigDecimal spanMargin;
    @Markup(name = "adhocscripmargin")
    @Converter(PriceConverter.class)
    private BigDecimal adhocScripMargin;
    @Markup(name = "scripbasketmargin")
    @Converter(PriceConverter.class)
    private BigDecimal scripBasketMargin;
    @Markup(name = "exposuremargin")
    @Converter(PriceConverter.class)
    private BigDecimal exposureMargin;
    @Markup(name = "premiumpresent")
    @Converter(PriceConverter.class)
    private BigDecimal premiumPresentValue;
    @Markup(name = "realisedmtom")
    @Converter(PriceConverter.class)
    private BigDecimal realisedMTMValue;
    @Markup(name = "unrealisedmtom")
    @Converter(PriceConverter.class)
    private BigDecimal unrealisedMTMValue;
    @Markup(name = "ipoamount")
    @Converter(PriceConverter.class)
    private BigDecimal ipoAmount;
    @Markup(name = "mfamount")
    @Converter(PriceConverter.class)
    private BigDecimal mfAmount;
    @Markup(name = "payoutamount")
    @Converter(PriceConverter.class)
    private BigDecimal payoutAmount;
    @Markup(name = "debits")
    @Converter(PriceConverter.class)
    private BigDecimal debits;
    @Markup(name = "subtota")
    @Converter(PriceConverter.class)
    private BigDecimal subTotal;
    @Markup(name = "cncsellcreditpresent")
    @Converter(PriceConverter.class)
    private BigDecimal cncSellCreditPresentValue;
    @Markup(name = "cncmarginused")
    @Converter(PriceConverter.class)
    private BigDecimal cncMarginUtilizedValue;
    @Markup(name = "cncbrokerageprsnt")
    @Converter(PriceConverter.class)
    private BigDecimal cncBrokeragePresentValue;
    @Markup(name = "cncunrealizedmtomprsnt")
    @Converter(PriceConverter.class)
    private BigDecimal cncUnrealizedMTOMPresentValue;
    @Markup(name = "cncrealizedmtomprsnt")
    @Converter(PriceConverter.class)
    private BigDecimal cncRealizedMTOMPresentValue;
    @Markup(name = "coverorderlimitprsnt")
    @Converter(PriceConverter.class)
    private BigDecimal coverOrderLimitPresentValue;
    @Markup(name = "brokerageprsnt")
    @Converter(PriceConverter.class)
    private BigDecimal brokeragePresentValue;

    public String getCategory() {
      return category;
    }

    public void setCategory(String category) {
      this.category = category;
    }

    public BigDecimal getTurnover() {
      return turnover;
    }

    public void setTurnover(BigDecimal turnover) {
      this.turnover = turnover;
    }

    public BigDecimal getMultiplier() {
      return multiplier;
    }

    public void setMultiplier(BigDecimal multiplier) {
      this.multiplier = multiplier;
    }

    public BigDecimal getGrossExposureValue() {
      return grossExposureValue;
    }

    public void setGrossExposureValue(BigDecimal grossExposureValue) {
      this.grossExposureValue = grossExposureValue;
    }

    public BigDecimal getElm() {
      return elm;
    }

    public void setElm(BigDecimal elm) {
      this.elm = elm;
    }

    public BigDecimal getValueInDelivery() {
      return valueInDelivery;
    }

    public void setValueInDelivery(BigDecimal valueInDelivery) {
      this.valueInDelivery = valueInDelivery;
    }

    public BigDecimal getVarMargin() {
      return varMargin;
    }

    public void setVarMargin(BigDecimal varMargin) {
      this.varMargin = varMargin;
    }

    public BigDecimal getSpanMargin() {
      return spanMargin;
    }

    public void setSpanMargin(BigDecimal spanMargin) {
      this.spanMargin = spanMargin;
    }

    public BigDecimal getAdhocScripMargin() {
      return adhocScripMargin;
    }

    public void setAdhocScripMargin(BigDecimal adhocScripMargin) {
      this.adhocScripMargin = adhocScripMargin;
    }

    public BigDecimal getScripBasketMargin() {
      return scripBasketMargin;
    }

    public void setScripBasketMargin(BigDecimal scripBasketMargin) {
      this.scripBasketMargin = scripBasketMargin;
    }

    public BigDecimal getExposureMargin() {
      return exposureMargin;
    }

    public void setExposureMargin(BigDecimal exposureMargin) {
      this.exposureMargin = exposureMargin;
    }

    public BigDecimal getPremiumPresentValue() {
      return premiumPresentValue;
    }

    public void setPremiumPresentValue(BigDecimal premiumPresentValue) {
      this.premiumPresentValue = premiumPresentValue;
    }

    public BigDecimal getRealisedMTMValue() {
      return realisedMTMValue;
    }

    public void setRealisedMTMValue(BigDecimal realisedMTMValue) {
      this.realisedMTMValue = realisedMTMValue;
    }

    public BigDecimal getUnrealisedMTMValue() {
      return unrealisedMTMValue;
    }

    public void setUnrealisedMTMValue(BigDecimal unrealisedMTMValue) {
      this.unrealisedMTMValue = unrealisedMTMValue;
    }

    public BigDecimal getIpoAmount() {
      return ipoAmount;
    }

    public void setIpoAmount(BigDecimal ipoAmount) {
      this.ipoAmount = ipoAmount;
    }

    public BigDecimal getMfAmount() {
      return mfAmount;
    }

    public void setMfAmount(BigDecimal mfAmount) {
      this.mfAmount = mfAmount;
    }

    public BigDecimal getPayoutAmount() {
      return payoutAmount;
    }

    public void setPayoutAmount(BigDecimal payoutAmount) {
      this.payoutAmount = payoutAmount;
    }

    public BigDecimal getDebits() {
      return debits;
    }

    public void setDebits(BigDecimal debits) {
      this.debits = debits;
    }

    public BigDecimal getSubTotal() {
      return subTotal;
    }

    public void setSubTotal(BigDecimal subTotal) {
      this.subTotal = subTotal;
    }

    public BigDecimal getCncSellCreditPresentValue() {
      return cncSellCreditPresentValue;
    }

    public void setCncSellCreditPresentValue(BigDecimal cncSellCreditPresentValue) {
      this.cncSellCreditPresentValue = cncSellCreditPresentValue;
    }

    public BigDecimal getCncMarginUtilizedValue() {
      return cncMarginUtilizedValue;
    }

    public void setCncMarginUtilizedValue(BigDecimal cncMarginUtilizedValue) {
      this.cncMarginUtilizedValue = cncMarginUtilizedValue;
    }

    public BigDecimal getCncBrokeragePresentValue() {
      return cncBrokeragePresentValue;
    }

    public void setCncBrokeragePresentValue(BigDecimal cncBrokeragePresentValue) {
      this.cncBrokeragePresentValue = cncBrokeragePresentValue;
    }

    public BigDecimal getCncUnrealizedMTOMPresentValue() {
      return cncUnrealizedMTOMPresentValue;
    }

    public void setCncUnrealizedMTOMPresentValue(BigDecimal cncUnrealizedMTOMPresentValue) {
      this.cncUnrealizedMTOMPresentValue = cncUnrealizedMTOMPresentValue;
    }

    public BigDecimal getCncRealizedMTOMPresentValue() {
      return cncRealizedMTOMPresentValue;
    }

    public void setCncRealizedMTOMPresentValue(BigDecimal cncRealizedMTOMPresentValue) {
      this.cncRealizedMTOMPresentValue = cncRealizedMTOMPresentValue;
    }

    public BigDecimal getCoverOrderLimitPresentValue() {
      return coverOrderLimitPresentValue;
    }

    public void setCoverOrderLimitPresentValue(BigDecimal coverOrderLimitPresentValue) {
      this.coverOrderLimitPresentValue = coverOrderLimitPresentValue;
    }

    public BigDecimal getBrokeragePresentValue() {
      return brokeragePresentValue;
    }

    public void setBrokeragePresentValue(BigDecimal brokeragePresentValue) {
      this.brokeragePresentValue = brokeragePresentValue;
    }

    @Override
    public String toString() {
      return "MarginUtilized{" + "category=" + category + ", turnover=" + turnover + ", multiplier=" + multiplier + ", grossExposureValue=" + grossExposureValue + ", elm=" + elm + ", valueInDelivery=" + valueInDelivery + ", varMargin=" + varMargin + ", spanMargin=" + spanMargin + ", adhocScripMargin=" + adhocScripMargin + ", scripBasketMargin=" + scripBasketMargin + ", exposureMargin=" + exposureMargin + ", premiumPresentValue=" + premiumPresentValue + ", realisedMTMValue=" + realisedMTMValue + ", unrealisedMTMValue=" + unrealisedMTMValue + ", ipoAmount=" + ipoAmount + ", mfAmount=" + mfAmount + ", payoutAmount=" + payoutAmount + ", debits=" + debits + ", subTotal=" + subTotal + ", cncSellCreditPresentValue=" + cncSellCreditPresentValue + ", cncMarginUtilizedValue=" + cncMarginUtilizedValue + ", cncBrokeragePresentValue=" + cncBrokeragePresentValue + ", cncUnrealizedMTOMPresentValue=" + cncUnrealizedMTOMPresentValue + ", cncRealizedMTOMPresentValue=" + cncRealizedMTOMPresentValue + ", coverOrderLimitPresentValue=" + coverOrderLimitPresentValue + ", brokeragePresentValue=" + brokeragePresentValue + '}';
    }
  }

  public static class RMSLimit {

    @Markup(name = "marginavailable")
    private MarginAvailable marginAvailable;
    @Markup(name = "marginutilized")
    private MarginUtilized marginUtilized;
    @Converter(PriceConverter.class)
    private BigDecimal net;

    public MarginAvailable getMarginAvailable() {
      return marginAvailable;
    }

    public void setMarginAvailable(MarginAvailable marginAvailable) {
      this.marginAvailable = marginAvailable;
    }

    public MarginUtilized getMarginUtilized() {
      return marginUtilized;
    }

    public void setMarginUtilized(MarginUtilized marginUtilized) {
      this.marginUtilized = marginUtilized;
    }

    public BigDecimal getNet() {
      return net;
    }

    public void setNet(BigDecimal net) {
      this.net = net;
    }

    @Override
    public String toString() {
      return "RMSLimit{" + "marginAvailable=" + marginAvailable + ", marginUtilized=" + marginUtilized + ", net=" + net + '}';
    }
  }
  @Markup(name = "nestrmslimits")
  private RMSLimit rmsLimit;

  public RMSLimit getRmsLimit() {
    return rmsLimit;
  }

  public void setRmsLimit(RMSLimit rmsLimit) {
    this.rmsLimit = rmsLimit;
  }

  @Override
  public String toString() {
    return "RMSLimitResponse{" + "rmsLimit=" + rmsLimit + '}';
  }
}
