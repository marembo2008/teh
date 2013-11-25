/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.teh.response.marketdata;

import com.anosym.teh.response.Response;
import com.anosym.vjax.annotations.Markup;
import com.anosym.vjax.annotations.v3.ArrayParented;
import java.util.Arrays;

/**
 *
 * @author marembo
 */
public class IndexResponse extends Response {

  public static class Index {

    private String exchange;
    private String symbol;

    public String getExchange() {
      return exchange;
    }

    public void setExchange(String exchange) {
      this.exchange = exchange;
    }

    public String getSymbol() {
      return symbol;
    }

    public void setSymbol(String symbol) {
      this.symbol = symbol;
    }

    @Override
    public String toString() {
      return "Index{" + "exchange=" + exchange + ", symbol=" + symbol + '}';
    }
  }
  @ArrayParented(componentMarkup = "omnesingleentry")
  @Markup(name = "indexlist")
  private Index[] indeces;

  public Index[] getIndeces() {
    return indeces;
  }

  public void setIndeces(Index[] indeces) {
    this.indeces = indeces;
  }

  @Override
  public String toString() {
    return "IndexResponse{" + "indeces=" + Arrays.toString(indeces) + '}';
  }
}
