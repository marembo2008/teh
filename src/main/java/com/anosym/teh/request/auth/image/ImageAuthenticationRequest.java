/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.teh.request.auth.image;

import com.anosym.teh.request.PostRequest;
import com.anosym.teh.response.Response;
import com.anosym.teh.response.auth.image.ImageAuthenticationFailureResponse;
import com.anosym.teh.response.auth.image.ImageAuthenticationResponse;

/**
 *
 * @author marembo
 */
public class ImageAuthenticationRequest extends PostRequest {

  public ImageAuthenticationRequest() {
    this(null);
  }

  public ImageAuthenticationRequest(String userId) {
    super("/XMLServlets/servlet/GetSelectedImage");
    addParameter("uid", userId);
  }

  @Override
  protected Response getResponse(String response) {
    if (response.contains("<message>")) {
      return processResponse(response, ImageAuthenticationFailureResponse.class);
    }
    return processResponse(response, ImageAuthenticationResponse.class);
  }

}
