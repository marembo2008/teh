/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.teh.request.position;

import com.anosym.teh.request.PostRequest;
import com.anosym.teh.response.Response;
import com.anosym.teh.response.position.PositionBookNoDataResponse;
import com.anosym.teh.response.position.PositionBookResponse;

/**
 *
 * @author marembo
 */
public class PositionBookRequest extends PostRequest {

  public PositionBookRequest(String userId, String token, String accountId, String dayOrNetwise,
          String exchange, String productCode, String sortType) {
    super("/XMLServlets/servlet/GetPositions");
    addParameter("uid", userId);
    addParameter("token", token);
    addParameter("acId", accountId);
    addParameter("dayornetwise", dayOrNetwise);
    addParameter("exchange", exchange);
    addParameter("productcode", productCode);
    addParameter("sortType", sortType);
  }

  @Override
  protected Response getResponse(String response) {
    if (response.contains("<nestpositionnodata>")) {
      return processResponse(response, PositionBookNoDataResponse.class);
    }
    return processResponse(response, PositionBookResponse.class);
  }
}
