/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.teh.request.ipo.order;

import com.anosym.teh.request.PostRequest;
import com.anosym.teh.response.Response;
import com.anosym.teh.response.ipo.order.IPOListResponse;

/**
 *
 * @author marembo
 */
public class IPOListRequest extends PostRequest {

  public IPOListRequest(String userId, String token, String accountId) {
    super("/XMLServlets/servlet/IPOList", userId, token, accountId);
  }

  @Override
  protected Response getResponse(String response) {
    return processResponse(response, IPOListResponse.class);
  }
}
