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
public class ScripOptionTypeResponse extends Response {

  @Markup(name = "nfoscrips")
  @ArrayParented(componentMarkup = "optiontype")
  private String[] optionType;

  public String[] getOptionType() {
    return optionType;
  }

  public void setOptionType(String[] optionType) {
    this.optionType = optionType;
  }

  @Override
  public String toString() {
    return "ScripOptionTypeResponse{" + "optionType=" + Arrays.toString(optionType) + '}';
  }
}
