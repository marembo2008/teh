/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.teh.response.auth.image;

import com.anosym.teh.response.Response;

/**
 *
 * @author marembo
 */
public class ImageAuthenticationFailureResponse extends Response {

  private String message;

  public ImageAuthenticationFailureResponse() {
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  @Override
  public String toString() {
    return "ImageAuthenticationFailureResponse{" + "message=" + message + '}';
  }

}
