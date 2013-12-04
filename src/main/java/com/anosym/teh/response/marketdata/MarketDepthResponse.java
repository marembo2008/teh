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
import com.anosym.vjax.annotations.v3.Listener;
import com.anosym.vjax.annotations.v3.Transient;
import com.anosym.vjax.converter.v3.impl.PropertyListener;
import java.math.BigDecimal;
import java.util.Arrays;

/**
 *
 * @author marembo
 */
public class MarketDepthResponse extends Response {

    public static class BestBuy implements Comparable<BestBuy> {

        @Markup(name = "bestbuysize", useRegex = true, regex = "bestbuysize\\d", indexed = true)
        private int bestBuySize;
        @Markup(name = "bestbuyprice", useRegex = true, regex = "bestbuyprice\\d", indexed = true)
        @Converter(PriceConverter.class)
        private BigDecimal bestBuyPrice;
        @Markup(name = "bestbuyorders", useRegex = true, regex = "bestbuyorders\\d", indexed = true)
        private int bestBuyOrders;
        @Transient
        private int index_;

        public int getIndex() {
            return index_;
        }

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

        @Override
        public int compareTo(BestBuy o) {
            return Integer.valueOf(index_).compareTo(o.index_);
        }
    }

    public static class BestSell implements Comparable<BestSell> {

        @Markup(name = "bestsellsize", useRegex = true, regex = "bestsellsize\\d", indexed = true)
        private int bestSellSize;
        @Markup(name = "bestsellprice", useRegex = true, regex = "bestsellprice\\d", indexed = true)
        @Converter(PriceConverter.class)
        private BigDecimal bestSellPrice;
        @Markup(name = "bestsellorders", useRegex = true, regex = "bestsellorders\\d", indexed = true)
        private int bestSellOrders;
        private int index_;

        public int getIndex() {
            return index_;
        }

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

        @Override
        public int compareTo(BestSell o) {
            return Integer.valueOf(index_).compareTo(o.index_);
        }
    }
    @Markup(name = "mbp")
    private MarketDepth scripDetail;
    @Markup(name = "best5buy")
    @ArrayParented(componentMarkup = "omnesingleentry")
    @Listener(MarketDepthBestBuyListener.class)
    private BestBuy[] bestBuys;
    @Markup(name = "best5sell")
    @ArrayParented(componentMarkup = "omnesingleentry")
    @Listener(MarketDepthBestSellListener.class)
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

    public static class MarketDepthBestBuyListener implements PropertyListener<MarketDepthResponse, BestBuy[]> {

        @Override
        public void onSet(MarketDepthResponse object, BestBuy[] property) {
            Arrays.sort(property);
            object.getScripDetail().setBestBuys(property);
        }

    }

    public static class MarketDepthBestSellListener implements PropertyListener<MarketDepthResponse, BestSell[]> {

        @Override
        public void onSet(MarketDepthResponse object, BestSell[] property) {
            Arrays.sort(property);
            object.getScripDetail().setBestSells(property);
        }

    }
}
