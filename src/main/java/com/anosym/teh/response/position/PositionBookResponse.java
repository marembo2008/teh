/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.teh.response.position;

import com.anosym.teh.response.Response;
import com.anosym.teh.response.util.PriceConverter;
import com.anosym.vjax.annotations.Markup;
import com.anosym.vjax.annotations.v3.ArrayParented;
import com.anosym.vjax.annotations.v3.Converter;
import java.math.BigDecimal;
import java.util.Arrays;

/**
 *
 * @author marembo
 */
public class PositionBookResponse extends Response {

  public static class PositionEntry {

    private String exchange;
    @Markup(name = "tradingsymbol")
    private String tradingSymbol;
    private String symbol;
    @Markup(name = "companyname")
    private String companyName;
    @Markup(name = "buyqty")
    private int buyQuantity;
    @Markup(name = "avgbuyprice")
    @Converter(PriceConverter.class)
    private BigDecimal averageBuyPrice;
    @Markup(name = "buyamt")
    @Converter(PriceConverter.class)
    private BigDecimal buyAmount;
    @Markup(name = "sellqty")
    private int sellQuantity;
    @Markup(name = "avgsellprice")
    @Converter(PriceConverter.class)
    private BigDecimal averageSellPrice;
    @Markup(name = "sellamt")
    @Converter(PriceConverter.class)
    private BigDecimal sellAmount;
    @Markup(name = "netamt")
    @Converter(PriceConverter.class)
    private BigDecimal netAmount;
    @Markup(name = "netqty")
    private int netQuantity;
    @Markup(name = "markettomarket")
    @Converter(PriceConverter.class)
    private BigDecimal marketToMarket;
    @Markup(name = "realisedprofitloss")
    @Converter(PriceConverter.class)
    private BigDecimal realisedProfitLoss;
    @Markup(name = "unrealisedprofitloss")
    @Converter(PriceConverter.class)
    private BigDecimal unrealisedProfitLoss;
    @Markup(name = "bep")
    private String bep;
    @Markup(name = "productcode")
    private String productCode;
    @Markup(name = "ltp")
    @Converter(PriceConverter.class)
    private BigDecimal lastTradedPrice;
    @Markup(name = "instrumentname")
    private String instrumentName;
    @Markup(name = "optiontype")
    private String optionType;
    @Markup(name = "expirydate")
    private String expiryDate;
    @Markup(name = "strikeprice")
    private BigDecimal strikePrice;

    public String getExchange() {
      return exchange;
    }

    public void setExchange(String exchange) {
      this.exchange = exchange;
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

    public String getCompanyName() {
      return companyName;
    }

    public void setCompanyName(String companyName) {
      this.companyName = companyName;
    }

    public int getBuyQuantity() {
      return buyQuantity;
    }

    public void setBuyQuantity(int buyQuantity) {
      this.buyQuantity = buyQuantity;
    }

    public BigDecimal getAverageBuyPrice() {
      return averageBuyPrice;
    }

    public void setAverageBuyPrice(BigDecimal averageBuyPrice) {
      this.averageBuyPrice = averageBuyPrice;
    }

    public BigDecimal getBuyAmount() {
      return buyAmount;
    }

    public void setBuyAmount(BigDecimal buyAmount) {
      this.buyAmount = buyAmount;
    }

    public int getSellQuantity() {
      return sellQuantity;
    }

    public void setSellQuantity(int sellQuantity) {
      this.sellQuantity = sellQuantity;
    }

    public BigDecimal getAverageSellPrice() {
      return averageSellPrice;
    }

    public void setAverageSellPrice(BigDecimal averageSellPrice) {
      this.averageSellPrice = averageSellPrice;
    }

    public BigDecimal getSellAmount() {
      return sellAmount;
    }

    public void setSellAmount(BigDecimal sellAmount) {
      this.sellAmount = sellAmount;
    }

    public BigDecimal getNetAmount() {
      return netAmount;
    }

    public void setNetAmount(BigDecimal netAmount) {
      this.netAmount = netAmount;
    }

    public int getNetQuantity() {
      return netQuantity;
    }

    public void setNetQuantity(int netQuantity) {
      this.netQuantity = netQuantity;
    }

    public BigDecimal getMarketToMarket() {
      return marketToMarket;
    }

    public void setMarketToMarket(BigDecimal marketToMarket) {
      this.marketToMarket = marketToMarket;
    }

    public BigDecimal getRealisedProfitLoss() {
      return realisedProfitLoss;
    }

    public void setRealisedProfitLoss(BigDecimal realisedProfitLoss) {
      this.realisedProfitLoss = realisedProfitLoss;
    }

    public BigDecimal getUnrealisedProfitLoss() {
      return unrealisedProfitLoss;
    }

    public void setUnrealisedProfitLoss(BigDecimal unrealisedProfitLoss) {
      this.unrealisedProfitLoss = unrealisedProfitLoss;
    }

    public String getBep() {
      return bep;
    }

    public void setBep(String bep) {
      this.bep = bep;
    }

    public String getProductCode() {
      return productCode;
    }

    public void setProductCode(String productCode) {
      this.productCode = productCode;
    }

    public BigDecimal getLastTradedPrice() {
      return lastTradedPrice;
    }

    public void setLastTradedPrice(BigDecimal lastTradedPrice) {
      this.lastTradedPrice = lastTradedPrice;
    }

    public String getInstrumentName() {
      return instrumentName;
    }

    public void setInstrumentName(String instrumentName) {
      this.instrumentName = instrumentName;
    }

    public String getOptionType() {
      return optionType;
    }

    public void setOptionType(String optionType) {
      this.optionType = optionType;
    }

    public String getExpiryDate() {
      return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
      this.expiryDate = expiryDate;
    }

    public BigDecimal getStrikePrice() {
      return strikePrice;
    }

    public void setStrikePrice(BigDecimal strikePrice) {
      this.strikePrice = strikePrice;
    }

    @Override
    public String toString() {
      return "PositionEntry{" + "exchange=" + exchange + ", tradingSymbol=" + tradingSymbol + ", symbol=" + symbol + ", companyName=" + companyName + ", buyQuantity=" + buyQuantity + ", averageBuyPrice=" + averageBuyPrice + ", buyAmount=" + buyAmount + ", sellQuantity=" + sellQuantity + ", averageSellPrice=" + averageSellPrice + ", sellAmount=" + sellAmount + ", netAmount=" + netAmount + ", netQuantity=" + netQuantity + ", marketToMarket=" + marketToMarket + ", realisedProfitLoss=" + realisedProfitLoss + ", unrealisedProfitLoss=" + unrealisedProfitLoss + ", bep=" + bep + ", productCode=" + productCode + ", lastTradedPrice=" + lastTradedPrice + ", instrumentName=" + instrumentName + ", optionType=" + optionType + ", expiryDate=" + expiryDate + ", strikePrice=" + strikePrice + '}';
    }
  }
  @Markup(name = "nestpositions")
  @ArrayParented(componentMarkup = "Omnesingleentry")
  private PositionEntry[] positions;

  public PositionEntry[] getPositions() {
    return positions;
  }

  public void setPositions(PositionEntry[] positions) {
    this.positions = positions;
  }

  @Override
  public String toString() {
    return "PositionBookResponse{" + "positions=" + Arrays.toString(positions) + '}';
  }
}
