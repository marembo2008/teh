/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.teh.response.marketdata;

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
public class MarketDepthResponse extends Response {

    public static class BestBuy {

        @Markup(name = "bestbuysize", useRegex = true, regex = "bestbuysize\\d")
        private int bestBuySize;
        @Markup(name = "bestbuyprice", useRegex = true, regex = "bestbuyprice\\d")
        @Converter(PriceConverter.class)
        private BigDecimal bestBuyPrice;
        @Markup(name = "bestbuyorders", useRegex = true, regex = "bestbuyorders\\d")
        private int bestBuyOrders;

        public int getBestBuySize() {
            return bestBuySize;
        }

        public void setBestBuySize(int bestBuySize) {
            this.bestBuySize = bestBuySize;
        }

        public BigDecimal getBestBuyPrice() {
            return bestBuyPrice;
        }

        public void setBestBuyPrice(BigDecimal bestBuyPrice) {
            this.bestBuyPrice = bestBuyPrice;
        }

        public int getBestBuyOrders() {
            return bestBuyOrders;
        }

        public void setBestBuyOrders(int bestBuyOrders) {
            this.bestBuyOrders = bestBuyOrders;
        }

        @Override
        public String toString() {
            return "BestBuy{" + "bestBuySize=" + bestBuySize + ", bestBuyPrice=" + bestBuyPrice + ", bestBuyOrders=" + bestBuyOrders + '}';
        }
    }

    public static class BestSell {

        @Markup(name = "bestsellsize", useRegex = true, regex = "bestsellsize\\d")
        private int bestSellSize;
        @Markup(name = "bestsellprice", useRegex = true, regex = "bestsellprice\\d")
        @Converter(PriceConverter.class)
        private BigDecimal bestSellPrice;
        @Markup(name = "bestsellorders", useRegex = true, regex = "bestsellorders\\d")
        private int bestSellOrders;

        public int getBestSellSize() {
            return bestSellSize;
        }

        public void setBestSellSize(int bestSellSize) {
            this.bestSellSize = bestSellSize;
        }

        public BigDecimal getBestSellPrice() {
            return bestSellPrice;
        }

        public void setBestSellPrice(BigDecimal bestSellPrice) {
            this.bestSellPrice = bestSellPrice;
        }

        public int getBestSellOrders() {
            return bestSellOrders;
        }

        public void setBestSellOrders(int bestSellOrders) {
            this.bestSellOrders = bestSellOrders;
        }

        @Override
        public String toString() {
            return "BestSell{" + "bestSellSize=" + bestSellSize + ", bestSellPrice=" + bestSellPrice + ", bestSellOrders=" + bestSellOrders + '}';
        }
    }
    @Markup(name = "mbp")
    private MarketDepth scripDetail;
    @Markup(name = "best5buy")
    @ArrayParented(componentMarkup = "omnesingleentry")
    private BestBuy[] bestBuys;
    @Markup(name = "best5sell")
    @ArrayParented(componentMarkup = "omnesingleentry")
    private BestSell[] bestSells;

    public MarketDepth getScripDetail() {
        return scripDetail;
    }

    public void setScripDetail(MarketDepth scripDetail) {
        this.scripDetail = scripDetail;
    }

    public BestBuy[] getBestBuys() {
        return bestBuys;
    }

    public void setBestBuys(BestBuy[] bestBuys) {
        this.bestBuys = bestBuys;
    }

    public BestSell[] getBestSells() {
        return bestSells;
    }

    public void setBestSells(BestSell[] bestSells) {
        this.bestSells = bestSells;
    }

    @Override
    public String toString() {
        return "MarketDepthResponse{" + "scripDetail=" + scripDetail + ", bestBuys=" + Arrays.toString(bestBuys) + ", bestSells=" + Arrays.toString(bestSells) + '}';
    }
}
