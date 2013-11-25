/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.teh.response.scrip;

import com.anosym.teh.response.Response;
import com.anosym.vjax.annotations.Markup;
import com.anosym.vjax.annotations.v3.ArrayParented;
import java.util.Arrays;

/**
 *
 * @author marembo
 */
public class ScripSymbolDetailResponse extends Response {

  public static class ScripSymbolDetail {

    @Markup(name = "tradingsymbol")
    private String tradingSymbol;
    @Markup(name = "symbolname")
    private String symbolName;
    @Markup(name = "boardlotqty")
    private int boardLotQuantity;

    public String getTradingSymbol() {
      return tradingSymbol;
    }

    public void setTradingSymbol(String tradingSymbol) {
      this.tradingSymbol = tradingSymbol;
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
      return "ScripDetail{" + "tradingSymbol=" + tradingSymbol + ", symbolName=" + symbolName + ", boardLotQuantity=" + boardLotQuantity + '}';
    }
  }
  @Markup(name = "nfoscrips")
  @ArrayParented(componentMarkup = "scripdetail")
  private ScripSymbolDetail[] scripDetail;

  public ScripSymbolDetail[] getScripDetail() {
    return scripDetail;
  }

  public void setScripDetail(ScripSymbolDetail[] scripDetail) {
    this.scripDetail = scripDetail;
  }

  @Override
  public String toString() {
    return "ScripDetailResponse{" + "scripDetail=" + Arrays.toString(scripDetail) + '}';
  }
}
