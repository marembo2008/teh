/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.teh.request.marketdata;

import com.anosym.teh.request.PostRequest;
import com.anosym.teh.response.Response;
import com.anosym.teh.response.marketdata.IndexQuoteResponse;
import com.anosym.teh.response.marketdata.IndexResponse.Index;

/**
 *
 * @author marembo
 */
public class IndexQuoteRequest extends PostRequest {

  public IndexQuoteRequest(String userId, String token, Index index) {
    super("/XMLServlets/servlet/GetIndexQuote", userId, token);
    addParameter("symbol", index.getSymbol());
    addParameter("exchange", index.getExchange());
  }

  @Override
  protected Response getResponse(String response) {
    return processResponse(response, IndexQuoteResponse.class);
  }
}
