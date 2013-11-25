/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.teh.request.marketdata;

import com.anosym.teh.request.PostRequest;
import com.anosym.teh.response.Response;
import com.anosym.teh.response.marketdata.BannedScripsResponse;

/**
 *
 * @author marembo
 */
public class BannedScripsRequest extends PostRequest {

  public BannedScripsRequest(String userId, String token) {
    super("/XMLServlets/servlet/BannedScrips", userId, token);
  }

  @Override
  protected Response getResponse(String response) {
    return processResponse(response, BannedScripsResponse.class);
  }
}
