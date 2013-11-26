/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.teh.response.marketdata;

import com.anosym.vjax.annotations.Markup;
import com.anosym.vjax.annotations.v3.Converter;
import com.anosym.vjax.annotations.v3.ConverterParam;
import com.anosym.vjax.converter.v3.impl.CalendarConverter;
import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;

/**
 *
 * @author marembo
 */
@Entity
public class IntraDayScripInfo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Markup(name = "ltrate")
    private int lastTradedRate;
    @Markup(name = "time")
    @Temporal(javax.persistence.TemporalType.DATE)
    @Converter(value = CalendarConverter.class, params = {
        @ConverterParam(key = CalendarConverter.CALENDAR_FORMAT_PARAM, value = {"HH:mm:ss"})})
    private Calendar scripTime;
    @Markup(name = "ltqty")
    private int lastTradedQuantity;
    @Markup(name = "cumtrade")
    private int cumulativeTradedVolume;
    @Markup(name = "openprice")
    private int openPrice;
    @Markup(name = "closeprice")
    private int closePrice;
    @Markup(name = "highprice")
    private int highPrice;
    @Markup(name = "lowprice")
    private int lowPrice;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public int getLastTradedRate() {
        return lastTradedRate;
    }

    public void setLastTradedRate(int lastTradedRate) {
        this.lastTradedRate = lastTradedRate;
    }

    public Calendar getTime() {
        return scripTime;
    }

    public void setTime(Calendar time) {
        this.scripTime = time;
    }

    public int getLastTradedQuantity() {
        return lastTradedQuantity;
    }

    public void setLastTradedQuantity(int lastTradedQuantity) {
        this.lastTradedQuantity = lastTradedQuantity;
    }

    public int getCumulativeTradedVolume() {
        return cumulativeTradedVolume;
    }

    public void setCumulativeTradedVolume(int cumulativeTradedVolume) {
        this.cumulativeTradedVolume = cumulativeTradedVolume;
    }

    public int getOpenPrice() {
        return openPrice;
    }

    public void setOpenPrice(int openPrice) {
        this.openPrice = openPrice;
    }

    public int getClosePrice() {
        return closePrice;
    }

    public void setClosePrice(int closePrice) {
        this.closePrice = closePrice;
    }

    public int getHighPrice() {
        return highPrice;
    }

    public void setHighPrice(int highPrice) {
        this.highPrice = highPrice;
    }

    public int getLowPrice() {
        return lowPrice;
    }

    public void setLowPrice(int lowPrice) {
        this.lowPrice = lowPrice;
    }

    @Override
    public String toString() {
        return "IntraDayScripInfo{" + "lastTradedRate=" + lastTradedRate + ", time=" + scripTime + ", lastTradedQuantity=" + lastTradedQuantity + ", cumulativeTradedVolume=" + cumulativeTradedVolume + ", openPrice=" + openPrice + ", closePrice=" + closePrice + ", highPrice=" + highPrice + ", lowPrice=" + lowPrice + '}';
    }
}
