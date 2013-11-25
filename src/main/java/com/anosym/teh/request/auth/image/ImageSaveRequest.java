/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.teh.request.auth.image;

import com.anosym.teh.request.PostRequest;
import com.anosym.teh.response.Response;
import com.anosym.teh.response.image.SaveDataResponse;

/**
 *
 * @author marembo
 */
public class ImageSaveRequest extends PostRequest {

  public ImageSaveRequest() {
    super("/XMLServlets/servlet/ModifyUser");
    addParameter("uid", null);
    addParameter("Index", null);
  }

  @Override
  protected Response getResponse(String response) {
    return processResponse(response, SaveDataResponse.class);
  }
}
