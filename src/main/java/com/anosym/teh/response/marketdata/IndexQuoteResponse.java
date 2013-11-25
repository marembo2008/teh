/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.teh.response.marketdata;

import com.anosym.teh.response.Response;
import com.anosym.vjax.annotations.Markup;
import com.anosym.vjax.annotations.v3.ArrayParented;
import java.math.BigDecimal;
import java.util.Arrays;

/**
 *
 * @author marembo
 */
public class IndexQuoteResponse extends Response {

  public static class IndexQuote {

    @Markup(name = "openprice")
    private int openPrice;
    @Markup(name = "closeprice")
    private int closePrice;
    @Markup(name = "change")
    private BigDecimal change;
    @Markup(name = "percentchange")
    private BigDecimal percentChange;
    @Markup(name = "showprice")
    private BigDecimal showPrice;

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

    public BigDecimal getChange() {
      return change;
    }

    public void setChange(BigDecimal change) {
      this.change = change;
    }

    public BigDecimal getPercentChange() {
      return percentChange;
    }

    public void setPercentChange(BigDecimal percentChange) {
      this.percentChange = percentChange;
    }

    public BigDecimal getShowPrice() {
      return showPrice;
    }

    public void setShowPrice(BigDecimal showPrice) {
      this.showPrice = showPrice;
    }

    @Override
    public String toString() {
      return "IndexQuote{" + "openPrice=" + openPrice + ", closePrice=" + closePrice + ", change=" + change + ", percentChange=" + percentChange + ", showPrice=" + showPrice + '}';
    }
  }
  @Markup(name = "indexdata")
  @ArrayParented(componentMarkup = "omnesingleentry")
  private IndexQuote[] indexQuotes;

  public IndexQuote[] getIndexQuotes() {
    return indexQuotes;
  }

  public void setIndexQuotes(IndexQuote[] indexQuotes) {
    this.indexQuotes = indexQuotes;
  }

  @Override
  public String toString() {
    return "IndexQuoteResponse{" + "indexQuotes=" + Arrays.toString(indexQuotes) + '}';
  }
}
