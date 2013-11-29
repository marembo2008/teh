/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.teh.response.marketdata;

import com.anosym.teh.response.logs.UserLogsResponse;
import com.anosym.teh.response.marketdata.MarketDepthResponse.BestBuy;
import com.anosym.teh.response.marketdata.MarketDepthResponse.BestSell;
import com.anosym.vjax.annotations.Markup;
import com.anosym.vjax.annotations.v3.Converter;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author marembo
 */
@Entity
@Table(name = "MarketDepth")
public class MarketDepth implements Serializable {

    private static final long serialVersionUID = 18472842296L;
    @Id
    @Markup(name = "symbol")
    private String symbol;
    @Markup(name = "lasttradedprice")
    private BigDecimal lastTradedPrice;
    @Markup(name = "lasttradedqty")
    private int lastTradedQuantity;
    @Markup(name = "lasttradedtime")
    @Converter(UserLogsResponse.CalendarMillisConverter.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Calendar lastTradedTime;
    @Markup(name = "percentagechange")
    private int percentageChange;
    @Markup(name = "abschange")
    private int absoluteChange;
    @Markup(name = "series")
    private String series;
    @Markup(name = "weightedavg")
    private BigDecimal weightedAverage;
    @Markup(name = "openrate")
    private BigDecimal openRate;
    @Markup(name = "triggerpercent")
    private int triggerPercent;
    @Markup(name = "previouscloserate")
    private BigDecimal previousCloseRate;
    @Markup(name = "highrate")
    private BigDecimal highRate;
    @Markup(name = "lowrate")
    private BigDecimal lowRate;
    @Markup(name = "trend")
    private String trend;
    @Markup(name = "volume")
    private int volume;
    @Markup(name = "totalbuyqty")
    private int totalBuyQuantity;
    @Markup(name = "totalsellqty")
    private int totalSellQuantity;
    @Markup(name = "lowercircuitlimit")
    private BigDecimal lowerCircuitLimit;
    @Markup(name = "highercircuitlimit")
    private BigDecimal higherCircuitLimit;
    @Markup(name = "openinterest")
    private int openInterest;
    @Markup(name = "value")
    @Column(name = "quote_value")
    private BigDecimal value;
    @Markup(name = "yearlyhighprice")
    private BigDecimal yearlyHighPrice;
    @Markup(name = "yearlylowprice")
    private BigDecimal yearlyLowPrice;
    @Markup(name = "tradingsymbol")
    private String tradingSymbol;
    @Markup(name = "companyname")
    private String companyName;

    //best buy
    @Markup(name = "bestbuysize1")
    private int bestBuySize1;
    @Markup(name = "bestbuyprice1")
    private BigDecimal bestBuyPrice1;
    @Markup(name = "bestbuyorders1")
    private int bestBuyOrders1;
    @Markup(name = "bestbuysize2")
    private int bestBuySize2;
    @Markup(name = "bestbuyprice2")
    private BigDecimal bestBuyPrice2;
    @Markup(name = "bestbuyorders2")
    private int bestBuyOrders2;
    @Markup(name = "bestbuysize3")
    private int bestBuySize3;
    @Markup(name = "bestbuyprice3")
    private BigDecimal bestBuyPrice3;
    @Markup(name = "bestbuyorders3")
    private int bestBuyOrders3;
    @Markup(name = "bestbuysize4")
    private int bestBuySize4;
    @Markup(name = "bestbuyprice4")
    private BigDecimal bestBuyPrice4;
    @Markup(name = "bestbuyorders4")
    private int bestBuyOrders4;
    @Markup(name = "bestbuysize5")
    private int bestBuySize5;
    @Markup(name = "bestbuyprice5")
    private BigDecimal bestBuyPrice5;
    @Markup(name = "bestbuyorders5")
    private int bestBuyOrders5;
    //best sell
    @Markup(name = "bestsellsize1")
    private int bestSellSize1;
    @Markup(name = "bestsellprice1")
    private BigDecimal bestSellPrice1;
    @Markup(name = "bestsellorders1")
    private int bestSellOrders1;
    @Markup(name = "bestsellsize2")
    private int bestSellSize2;
    @Markup(name = "bestsellprice2")
    private BigDecimal bestSellPrice2;
    @Markup(name = "bestsellorders2")
    private int bestSellOrders2;
    @Markup(name = "bestsellsize3")
    private int bestSellSize3;
    @Markup(name = "bestsellprice3")
    private BigDecimal bestSellPrice3;
    @Markup(name = "bestsellorders3")
    private int bestSellOrders3;
    @Markup(name = "bestsellsize4")
    private int bestSellSize4;
    @Markup(name = "bestsellprice4")
    private BigDecimal bestSellPrice4;
    @Markup(name = "bestsellorders4")
    private int bestSellOrders4;
    @Markup(name = "bestsellsize5")
    private int bestSellSize5;
    @Markup(name = "bestsellprice5")
    private BigDecimal bestSellPrice5;
    @Markup(name = "bestsellorders5")
    private int bestSellOrders5;

    public void setBestBuys(BestBuy[] bestBuys) {
        for (int i = 0; i < bestBuys.length; i++) {
            try {
                int ix = (i + 1);
                BestBuy bb = bestBuys[i];
                String bestBuySize = "bestBuySize" + ix;
                String bestBuyPrice = "bestBuyPrice" + ix;
                String bestBuyOrders = "bestBuyOrders" + ix;
                Field f = getClass().getDeclaredField(bestBuySize);
                f.setAccessible(true);
                f.set(this, bb.getBestBuySize());
                f = getClass().getDeclaredField(bestBuyPrice);
                f.setAccessible(true);
                f.set(this, bb.getBestBuyPrice());
                f = getClass().getDeclaredField(bestBuyOrders);
                f.setAccessible(true);
                f.set(this, bb.getBestBuyOrders());
            } catch (NoSuchFieldException ex) {
                Logger.getLogger(MarketDepth.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                Logger.getLogger(MarketDepth.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void setBestSells(BestSell[] bestbSells) {
        for (int i = 0; i < bestbSells.length; i++) {
            try {
                int ix = (i + 1);
                BestSell bb = bestbSells[i];
                String bestSellSize = "bestSellSize" + ix;
                String bestSellPrice = "bestSellPrice" + ix;
                String bestSellOrders = "bestSellOrders" + ix;
                Field f = getClass().getDeclaredField(bestSellSize);
                f.setAccessible(true);
                f.set(this, bb.getBestSellSize());
                f = getClass().getDeclaredField(bestSellPrice);
                f.setAccessible(true);
                f.set(this, bb.getBestSellPrice());
                f = getClass().getDeclaredField(bestSellOrders);
                f.setAccessible(true);
                f.set(this, bb.getBestSellOrders());
            } catch (NoSuchFieldException ex) {
                Logger.getLogger(MarketDepth.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                Logger.getLogger(MarketDepth.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public int getBestBuySize1() {
        return bestBuySize1;
    }

    public void setBestBuySize1(int bestBuySize1) {
        this.bestBuySize1 = bestBuySize1;
    }

    public BigDecimal getBestBuyPrice1() {
        return bestBuyPrice1;
    }

    public void setBestBuyPrice1(BigDecimal bestBuyPrice1) {
        this.bestBuyPrice1 = bestBuyPrice1;
    }

    public int getBestBuyOrders1() {
        return bestBuyOrders1;
    }

    public void setBestBuyOrders1(int bestBuyOrders1) {
        this.bestBuyOrders1 = bestBuyOrders1;
    }

    public int getBestBuySize2() {
        return bestBuySize2;
    }

    public void setBestBuySize2(int bestBuySize2) {
        this.bestBuySize2 = bestBuySize2;
    }

    public BigDecimal getBestBuyPrice2() {
        return bestBuyPrice2;
    }

    public void setBestBuyPrice2(BigDecimal bestBuyPrice2) {
        this.bestBuyPrice2 = bestBuyPrice2;
    }

    public int getBestBuyOrders2() {
        return bestBuyOrders2;
    }

    public void setBestBuyOrders2(int bestBuyOrders2) {
        this.bestBuyOrders2 = bestBuyOrders2;
    }

    public int getBestBuySize3() {
        return bestBuySize3;
    }

    public void setBestBuySize3(int bestBuySize3) {
        this.bestBuySize3 = bestBuySize3;
    }

    public BigDecimal getBestBuyPrice3() {
        return bestBuyPrice3;
    }

    public void setBestBuyPrice3(BigDecimal bestBuyPrice3) {
        this.bestBuyPrice3 = bestBuyPrice3;
    }

    public int getBestBuyOrders3() {
        return bestBuyOrders3;
    }

    public void setBestBuyOrders3(int bestBuyOrders3) {
        this.bestBuyOrders3 = bestBuyOrders3;
    }

    public int getBestBuySize4() {
        return bestBuySize4;
    }

    public void setBestBuySize4(int bestBuySize4) {
        this.bestBuySize4 = bestBuySize4;
    }

    public BigDecimal getBestBuyPrice4() {
        return bestBuyPrice4;
    }

    public void setBestBuyPrice4(BigDecimal bestBuyPrice4) {
        this.bestBuyPrice4 = bestBuyPrice4;
    }

    public int getBestBuyOrders4() {
        return bestBuyOrders4;
    }

    public void setBestBuyOrders4(int bestBuyOrders4) {
        this.bestBuyOrders4 = bestBuyOrders4;
    }

    public int getBestBuySize5() {
        return bestBuySize5;
    }

    public void setBestBuySize5(int bestBuySize5) {
        this.bestBuySize5 = bestBuySize5;
    }

    public BigDecimal getBestBuyPrice5() {
        return bestBuyPrice5;
    }

    public void setBestBuyPrice5(BigDecimal bestBuyPrice5) {
        this.bestBuyPrice5 = bestBuyPrice5;
    }

    public int getBestBuyOrders5() {
        return bestBuyOrders5;
    }

    public void setBestBuyOrders5(int bestBuyOrders5) {
        this.bestBuyOrders5 = bestBuyOrders5;
    }

    public int getBestsellSize1() {
        return bestSellSize1;
    }

    public void setBestsellSize1(int bestSellSize1) {
        this.bestSellSize1 = bestSellSize1;
    }

    public BigDecimal getBestsellPrice1() {
        return bestSellPrice1;
    }

    public void setBestsellPrice1(BigDecimal bestSellPrice1) {
        this.bestSellPrice1 = bestSellPrice1;
    }

    public int getBestsellOrders1() {
        return bestSellOrders1;
    }

    public void setBestsellOrders1(int bestSellOrders1) {
        this.bestSellOrders1 = bestSellOrders1;
    }

    public int getBestsellSize2() {
        return bestSellSize2;
    }

    public void setBestsellSize2(int bestSellSize2) {
        this.bestSellSize2 = bestSellSize2;
    }

    public BigDecimal getBestsellPrice2() {
        return bestSellPrice2;
    }

    public void setBestsellPrice2(BigDecimal bestSellPrice2) {
        this.bestSellPrice2 = bestSellPrice2;
    }

    public int getBestsellOrders2() {
        return bestSellOrders2;
    }

    public void setBestsellOrders2(int bestSellOrders2) {
        this.bestSellOrders2 = bestSellOrders2;
    }

    public int getBestsellSize3() {
        return bestSellSize3;
    }

    public void setBestsellSize3(int bestSellSize3) {
        this.bestSellSize3 = bestSellSize3;
    }

    public BigDecimal getBestsellPrice3() {
        return bestSellPrice3;
    }

    public void setBestsellPrice3(BigDecimal bestSellPrice3) {
        this.bestSellPrice3 = bestSellPrice3;
    }

    public int getBestsellOrders3() {
        return bestSellOrders3;
    }

    public void setBestsellOrders3(int bestSellOrders3) {
        this.bestSellOrders3 = bestSellOrders3;
    }

    public int getBestsellSize4() {
        return bestSellSize4;
    }

    public void setBestsellSize4(int bestSellSize4) {
        this.bestSellSize4 = bestSellSize4;
    }

    public BigDecimal getBestsellPrice4() {
        return bestSellPrice4;
    }

    public void setBestsellPrice4(BigDecimal bestSellPrice4) {
        this.bestSellPrice4 = bestSellPrice4;
    }

    public int getBestsellOrders4() {
        return bestSellOrders4;
    }

    public void setBestsellOrders4(int bestSellOrders4) {
        this.bestSellOrders4 = bestSellOrders4;
    }

    public int getBestsellSize5() {
        return bestSellSize5;
    }

    public void setBestsellSize5(int bestSellSize5) {
        this.bestSellSize5 = bestSellSize5;
    }

    public BigDecimal getBestsellPrice5() {
        return bestSellPrice5;
    }

    public void setBestsellPrice5(BigDecimal bestSellPrice5) {
        this.bestSellPrice5 = bestSellPrice5;
    }

    public int getBestsellOrders5() {
        return bestSellOrders5;
    }

    public void setBestsellOrders5(int bestSellOrders5) {
        this.bestSellOrders5 = bestSellOrders5;
    }

    public BigDecimal getLastTradedPrice() {
        return lastTradedPrice;
    }

    public void setLastTradedPrice(BigDecimal lastTradedPrice) {
        this.lastTradedPrice = lastTradedPrice;
    }

    public int getLastTradedQuantity() {
        return lastTradedQuantity;
    }

    public void setLastTradedQuantity(int lastTradedQuantity) {
        this.lastTradedQuantity = lastTradedQuantity;
    }

    public Calendar getLastTradedTime() {
        return lastTradedTime;
    }

    public void setLastTradedTime(Calendar lastTradedTime) {
        this.lastTradedTime = lastTradedTime;
    }

    public int getPercentageChange() {
        return percentageChange;
    }

    public void setPercentageChange(int percentageChange) {
        this.percentageChange = percentageChange;
    }

    public int getAbsoluteChange() {
        return absoluteChange;
    }

    public void setAbsoluteChange(int absoluteChange) {
        this.absoluteChange = absoluteChange;
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

    public BigDecimal getWeightedAverage() {
        return weightedAverage;
    }

    public void setWeightedAverage(BigDecimal weightedAverage) {
        this.weightedAverage = weightedAverage;
    }

    public BigDecimal getOpenRate() {
        return openRate;
    }

    public void setOpenRate(BigDecimal openRate) {
        this.openRate = openRate;
    }

    public int getTriggerPercent() {
        return triggerPercent;
    }

    public void setTriggerPercent(int triggerPercent) {
        this.triggerPercent = triggerPercent;
    }

    public BigDecimal getPreviousCloseRate() {
        return previousCloseRate;
    }

    public void setPreviousCloseRate(BigDecimal previousCloseRate) {
        this.previousCloseRate = previousCloseRate;
    }

    public BigDecimal getHighRate() {
        return highRate;
    }

    public void setHighRate(BigDecimal highRate) {
        this.highRate = highRate;
    }

    public BigDecimal getLowRate() {
        return lowRate;
    }

    public void setLowRate(BigDecimal lowRate) {
        this.lowRate = lowRate;
    }

    public String getTrend() {
        return trend;
    }

    public void setTrend(String trend) {
        this.trend = trend;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public int getTotalBuyQuantity() {
        return totalBuyQuantity;
    }

    public void setTotalBuyQuantity(int totalBuyQuantity) {
        this.totalBuyQuantity = totalBuyQuantity;
    }

    public int getTotalSellQuantity() {
        return totalSellQuantity;
    }

    public void setTotalSellQuantity(int totalSellQuantity) {
        this.totalSellQuantity = totalSellQuantity;
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

    public int getOpenInterest() {
        return openInterest;
    }

    public void setOpenInterest(int openInterest) {
        this.openInterest = openInterest;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public BigDecimal getYearlyHighPrice() {
        return yearlyHighPrice;
    }

    public void setYearlyHighPrice(BigDecimal yearlyHighPrice) {
        this.yearlyHighPrice = yearlyHighPrice;
    }

    public BigDecimal getYearlyLowPrice() {
        return yearlyLowPrice;
    }

    public void setYearlyLowPrice(BigDecimal yearlyLowPrice) {
        this.yearlyLowPrice = yearlyLowPrice;
    }

    public String getTradingSymbol() {
        return tradingSymbol;
    }

    public void setTradingSymbol(String tradingSymbol) {
        this.tradingSymbol = tradingSymbol;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Override
    public String toString() {
        return "ScripDetail{" + "lastTradedPrice=" + lastTradedPrice + ", lastTradedQuantity=" + lastTradedQuantity + ", lastTradedTime=" + lastTradedTime + ", percentageChange=" + percentageChange + ", absoluteChange=" + absoluteChange + ", symbol=" + symbol + ", series=" + series + ", weightedAverage=" + weightedAverage + ", openRate=" + openRate + ", triggerPercent=" + triggerPercent + ", previousCloseRate=" + previousCloseRate + ", highRate=" + highRate + ", lowRate=" + lowRate + ", trend=" + trend + ", volume=" + volume + ", totalBuyQuantity=" + totalBuyQuantity + ", totalSellQuantity=" + totalSellQuantity + ", lowerCircuitLimit=" + lowerCircuitLimit + ", higherCircuitLimit=" + higherCircuitLimit + ", openInterest=" + openInterest + ", value=" + value + ", yearlyHighPrice=" + yearlyHighPrice + ", yearlyLowPrice=" + yearlyLowPrice + ", tradingSymbol=" + tradingSymbol + ", companyName=" + companyName + '}';
    }
}
