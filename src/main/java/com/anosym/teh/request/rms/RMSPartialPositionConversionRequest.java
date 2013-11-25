/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.teh.request.rms;

import com.anosym.teh.request.PostRequest;
import com.anosym.teh.response.Response;
import com.anosym.teh.response.rms.RMSPartialPositionConversionBadInputResponse;
import com.anosym.teh.response.rms.RMSPartialPositionConversionResponse;

/**
 *
 * @author marembo
 */
public class RMSPartialPositionConversionRequest extends PostRequest {

  public RMSPartialPositionConversionRequest(String userId, String token, String accountId,
          String tradingSymbol, String symbol, int quantity, String exchange, String transactionType,
          String productCode, String productToChange, String brokerName, String branchId) {
    super("/XMLServlets/servlet/PartialPositionConversion", userId, token, accountId);
    addParameter("tradingsymbol", tradingSymbol);
    addParameter("symbol", symbol);
    addParameter("quantity", quantity);
    addParameter("exchange", exchange);
    addParameter("transactiontype", transactionType);
    addParameter("productcode", productCode);
    addParameter("producttochange", productCode);
    addParameter("BrokerName", brokerName);
    addParameter("BranchId", branchId);
  }

  @Override
  protected Response getResponse(String response) {
    if (response.contains("<partialpositiontext>")) {
      return processResponse(response, RMSPartialPositionConversionBadInputResponse.class);
    }
    return processResponse(response, RMSPartialPositionConversionResponse.class);
  }
}
