/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.teh.response.marketdata;

import com.anosym.vjax.annotations.Markup;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Transient;

/**
 *
 * @author marembo
 */
@Entity
public class Chart implements Serializable {

    private static final long serialVersionUID = 33487343L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Markup(name = "first")
    private int firstPrice;
    @Markup(name = "close")
    private int closePrice;
    @Markup(name = "high")
    private int highPrice;
    @Markup(name = "low")
    private int lowPrice;
    @Markup(name = "low")
    private int lastTradedPrice;
    private int multiplier;
    @Markup(name = "decimalprecision")
    private int decimalPrecision;
    @Markup(name = "intradayscripinfo")
    @Transient
    private IntraDayScripInfo[] intraDayScripInfos;
    @OneToMany(cascade = CascadeType.ALL)
    private List<IntraDayScripInfo> scripInfos;

    @PrePersist
    void setScripInfos() {
        if (this.intraDayScripInfos != null) {
            this.scripInfos = new ArrayList<IntraDayScripInfo>(Arrays.asList(intraDayScripInfos));
        }
    }

    public void setScripInfos(List<IntraDayScripInfo> scripInfos) {
        this.scripInfos = scripInfos;
    }

    public List<IntraDayScripInfo> getScripInfos() {
        return scripInfos;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public int getFirst() {
        return firstPrice;
    }

    public void setFirst(int first) {
        this.firstPrice = first;
    }

    public int getClose() {
        return closePrice;
    }

    public void setClose(int close) {
        this.closePrice = close;
    }

    public int getHigh() {
        return highPrice;
    }

    public void setHigh(int high) {
        this.highPrice = high;
    }

    public int getLow() {
        return lowPrice;
    }

    public void setLow(int low) {
        this.lowPrice = low;
    }

    public int getLast() {
        return lastTradedPrice;
    }

    public void setLast(int last) {
        this.lastTradedPrice = last;
    }

    public int getMultiplier() {
        return multiplier;
    }

    public void setMultiplier(int multiplier) {
        this.multiplier = multiplier;
    }

    public int getDecimalPrecision() {
        return decimalPrecision;
    }

    public void setDecimalPrecision(int decimalPrecision) {
        this.decimalPrecision = decimalPrecision;
    }

    @Override
    public String toString() {
        return "Chart{" + "first=" + firstPrice + ", close=" + closePrice + ", high=" + highPrice + ", low=" + lowPrice + ", last=" + lastTradedPrice + ", multiplier=" + multiplier + ", decimalPrecision=" + decimalPrecision + ", intraDayScripInfos=" + Arrays.toString(intraDayScripInfos) + '}';
    }
}
