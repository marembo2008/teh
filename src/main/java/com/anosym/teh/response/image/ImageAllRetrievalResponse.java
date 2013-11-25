/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.teh.response.image;

import com.anosym.teh.response.Response;
import com.anosym.vjax.annotations.Markup;
import com.anosym.vjax.annotations.v3.ArrayParented;
import java.util.Arrays;

/**
 *
 * @author marembo
 */
public class ImageAllRetrievalResponse extends Response {

  @ArrayParented(componentMarkup = "imageIndex")
  @Markup(name = "omneimage")
  private int[] imageIndeces;

  public int[] getImageIndeces() {
    return imageIndeces;
  }

  public void setImageIndeces(int[] imageIndeces) {
    this.imageIndeces = imageIndeces;
  }

  @Override
  public String toString() {
    return "AllImageRetrievalResponse{" + "imageIndeces=" + Arrays.toString(imageIndeces) + '}';
  }

}
