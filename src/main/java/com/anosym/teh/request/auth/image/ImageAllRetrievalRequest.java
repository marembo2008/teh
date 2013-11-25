/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.teh.request.auth.image;

import com.anosym.teh.request.PostRequest;
import com.anosym.teh.response.Response;
import com.anosym.teh.response.image.ImageAllRetrievalFailureResponse;
import com.anosym.teh.response.image.ImageAllRetrievalResponse;

/**
 *
 * @author marembo
 */
public class ImageAllRetrievalRequest extends PostRequest {

  public ImageAllRetrievalRequest() {
    super("/XMLServlets/servlet/GetAllImages");
  }

  @Override
  protected Response getResponse(String response) {
    if (response.contains("<omneimage>")) {
      return processResponse(response, ImageAllRetrievalResponse.class);
    } else {
      return processResponse(response, ImageAllRetrievalFailureResponse.class);
    }
  }

}
