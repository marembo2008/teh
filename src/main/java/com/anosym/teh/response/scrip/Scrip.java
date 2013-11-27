/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.teh.response.scrip;

import com.anosym.vjax.annotations.Markup;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author marembo
 */
@Entity
@Table(name = "Scrips")
public class Scrip implements Serializable {

    private static final long serialVersionUID = 7343434L;
    @Id
    @Markup(name = "symbol")
    private String symbol;
    @Markup(name = "tradingsymbol")
    private String tradingSymbol;
    @Markup(name = "compname")
    private String compName;
    @Markup(name = "isin")
    private String isin;
    @Markup(name = "ticksize")
    private int tickSize;
    @Markup(name = "symbolname")
    private String symbolName;
    @Markup(name = "boardlotquantity")
    private int boardLotQuantity;

    public String getTradingSymbol() {
        return tradingSymbol;
    }

    public void setTradingSymbol(String tradingSymbol) {
        this.tradingSymbol = tradingSymbol;
    }

    public String getCompName() {
        return compName;
    }

    public void setCompName(String compName) {
        this.compName = compName;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getIsin() {
        return isin;
    }

    public void setIsin(String isin) {
        this.isin = isin;
    }

    public int getTickSize() {
        return tickSize;
    }

    public void setTickSize(int tickSize) {
        this.tickSize = tickSize;
    }

    public String getSymbolName() {
        return symbolName;
    }

    public void setSymbolName(String symbolName) {
        this.symbolName = symbolName;
    }

    public int getBoardLotQuantity() {
        return boardLotQuantity;
    }

    public void setBoardLotQuantity(int boardLotQuantity) {
        this.boardLotQuantity = boardLotQuantity;
    }

    @Override
    public String toString() {
        return "ScriptData{" + "tradingSymbol=" + tradingSymbol + ", compName=" + compName + ", symbol=" + symbol + ", isin=" + isin + ", tickSize=" + tickSize + ", symbolName=" + symbolName + ", boardLotQuantity=" + boardLotQuantity + '}';
    }
}
