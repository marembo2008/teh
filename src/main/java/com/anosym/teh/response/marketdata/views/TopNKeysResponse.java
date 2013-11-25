/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.teh.response.marketdata.views;

import com.anosym.teh.response.Response;
import com.anosym.vjax.annotations.Markup;
import com.anosym.vjax.annotations.v3.ArrayParented;
import java.util.Arrays;

/**
 *
 * @author marembo
 */
public class TopNKeysResponse extends Response {

  public static class Key {

    private String category;
    @Markup(name = "basketlist")
    @ArrayParented(componentMarkup = "basket")
    private String[] baskets;

    public String getCategory() {
      return category;
    }

    public void setCategory(String category) {
      this.category = category;
    }

    public String[] getBaskets() {
      return baskets;
    }

    public void setBaskets(String[] baskets) {
      this.baskets = baskets;
    }

    @Override
    public String toString() {
      return "Key{" + "category=" + category + ", baskets=" + Arrays.toString(baskets) + '}';
    }
  }
  @Markup(name = "topnkeys")
  @ArrayParented(componentMarkup = "omnesingleentry")
  private Key[] keys;

  public Key[] getKeys() {
    return keys;
  }

  public void setKeys(Key[] keys) {
    this.keys = keys;
  }

  @Override
  public String toString() {
    return "TopNKeysResponse{" + "keys=" + Arrays.toString(keys) + '}';
  }
}
