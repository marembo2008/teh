/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.teh.request.auth.image;

import com.anosym.teh.request.PostRequest;
import com.anosym.teh.response.Response;
import com.anosym.teh.response.image.ImageRetrievalAuthenticationFailureResponse;
import com.anosym.teh.response.image.ImageRetrievalFailureResponse;
import com.anosym.teh.response.auth.image.ImageAuthenticationResponse;

/**
 *
 * @author marembo
 */
public class ImageRetrievalRequest extends PostRequest {

  public ImageRetrievalRequest(ImageAuthenticationResponse authenticationResponse) {
    super("/XMLServlets/servlet/RetieveImageFromMRV");
    addParameter("index", authenticationResponse.getImageIndex().getIndex() + "");
  }

  @Override
  protected Response getResponse(String response) {
    if (response.contains("<message>")) {
      return processResponse(response, ImageRetrievalFailureResponse.class);
    }
    return processResponse(response, ImageRetrievalAuthenticationFailureResponse.class);
  }

}
