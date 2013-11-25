/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.teh.request.mfss.order;

import com.anosym.teh.request.PostRequest;
import com.anosym.teh.response.Response;
import com.anosym.teh.response.mfss.order.MFSSDPDetailResponse;

/**
 *
 * @author marembo
 */
public class MFSSDPDetailsRequest extends PostRequest {

  public MFSSDPDetailsRequest(String userId, String token) {
    super("/XMLServlets/servlet/MFDpIds", userId, token);
  }

  @Override
  protected Response getResponse(String response) {
    return processResponse(response, MFSSDPDetailResponse.class);
  }
}
