/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.teh.request.scrip;

import com.anosym.teh.response.Response;
import com.anosym.teh.response.scrip.ScripStrikePriceResponse;
import java.util.Calendar;

/**
 *
 * @author marembo
 */
public class ScripStrikePriceRequest extends ScripOptionTypeRequest {

  public ScripStrikePriceRequest(String userId, String token, String exchange,
          String instrumentName, String symbol, Calendar expiryDate,
          String optionType) {
    super(userId, token, exchange, instrumentName, symbol, expiryDate);
    addParameter("optiontype", expiryDate);
  }

  @Override
  protected Response getResponse(String response) {
    if (response.contains("<strikeprice>")) {
      return processResponse(response, ScripStrikePriceResponse.class);
    }
    return super.getResponse(response);
  }
}
