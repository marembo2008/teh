/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.teh.request.mfss.order;

import com.anosym.teh.request.PostRequest;
import com.anosym.teh.response.Response;
import com.anosym.teh.response.mfss.order.MFSSSIPDetailResponse;

/**
 *
 * @author marembo
 */
public class MFSSSIPDetailRequest extends PostRequest {

  public MFSSSIPDetailRequest(String symbol, String userId, String token) {
    super("/XMLServlets/servlet/MFSipDetails", userId, token);
    addParameter("symbol", symbol);
  }

  @Override
  protected Response getResponse(String response) {
    return processResponse(response, MFSSSIPDetailResponse.class);
  }
}
