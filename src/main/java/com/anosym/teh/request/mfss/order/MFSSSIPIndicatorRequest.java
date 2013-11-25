/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.teh.request.mfss.order;

import com.anosym.teh.request.PostRequest;
import com.anosym.teh.response.Response;
import com.anosym.teh.response.mfss.order.MFSSSIPIndicatorResponse;

/**
 *
 * @author marembo
 */
public class MFSSSIPIndicatorRequest extends PostRequest {

  public MFSSSIPIndicatorRequest(String exchange, String symbol, String userId, String token) {
    super("/XMLServlets/servlet/GetSipIndicator", userId, token);
    addParameter("s_ExchSeg", exchange);
    addParameter("s_Symbol", symbol);
  }

  @Override
  protected Response getResponse(String response) {
    return processResponse(response, MFSSSIPIndicatorResponse.class);
  }
}
