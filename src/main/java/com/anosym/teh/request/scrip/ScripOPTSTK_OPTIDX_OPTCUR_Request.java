/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.teh.request.scrip;

import com.anosym.teh.response.Response;
import com.anosym.teh.response.scrip.ScripSymbolDetailResponse;
import java.math.BigDecimal;
import java.util.Calendar;

/**
 *
 * @author marembo
 */
public class ScripOPTSTK_OPTIDX_OPTCUR_Request extends ScripStrikePriceRequest {

  public ScripOPTSTK_OPTIDX_OPTCUR_Request(String userId, String token, String exchange,
          String instrumentName, String symbol, Calendar expiryDate, String optionType,
          BigDecimal strikePrice) {
    super(userId, token, exchange, instrumentName, symbol, expiryDate, optionType);
    addParameter("strikeprice", strikePrice);
  }

  @Override
  protected Response getResponse(String response) {
    return processResponse(response, ScripSymbolDetailResponse.class);
  }
}
