/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.teh.response.auth.image;

import com.anosym.teh.response.Response;
import com.anosym.vjax.annotations.Markup;

/**
 *
 * @author marembo
 */
public class ImageAuthenticationResponse extends Response {

  public static class ImageIndex {

    @Markup(name = "omneimage")
    private int index;

    public ImageIndex(int index) {
      this.index = index;
    }

    public ImageIndex() {
    }

    public void setIndex(int index) {
      this.index = index;
    }

    public int getIndex() {
      return index;
    }

    @Override
    public String toString() {
      return "ImageIndex{" + "imageindex=" + index + '}';
    }

  }
  @Markup(name = "omneimagetag")
  private ImageIndex imageindex;

  public ImageAuthenticationResponse() {
  }

  public ImageIndex getImageIndex() {
    return imageindex;
  }

  public void setImageIndex(ImageIndex imageindex) {
    this.imageindex = imageindex;
  }

  @Override
  public String toString() {
    return "ImageAuthenticationResponse{" + "imageindex=" + imageindex + '}';
  }

}
