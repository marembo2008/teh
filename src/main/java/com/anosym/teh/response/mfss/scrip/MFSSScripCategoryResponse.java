/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.teh.response.mfss.scrip;

import com.anosym.teh.response.Response;
import com.anosym.vjax.annotations.Markup;
import com.anosym.vjax.annotations.v3.ArrayParented;
import java.util.Arrays;

/**
 *
 * @author marembo
 */
public class MFSSScripCategoryResponse extends Response {

  @Markup(name = "mfscrips")
  @ArrayParented(componentMarkup = "category")
  private String[] scripCategories;

  public String[] getScripCategories() {
    return scripCategories;
  }

  public void setScripCategories(String[] scripCategories) {
    this.scripCategories = scripCategories;
  }

  @Override
  public String toString() {
    return "MFSSScripCategoriesResponse{" + "scripCategories=" + Arrays.toString(scripCategories) + '}';
  }
}
