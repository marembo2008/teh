/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.teh.request.rms;

import com.anosym.teh.request.PostRequest;
import com.anosym.teh.response.Response;
import com.anosym.teh.response.rms.RMSPossibleValuesResponse;
import java.math.BigDecimal;

/**
 *
 * @author marembo
 */
public class RMSPossibleValuesRequest extends PostRequest {

  /**
   * The symbol that should be sent in the request should be the symbol that is got in the <symbol>
   * tag in section 1.7.1.1 for NSE, NSE Scrips, for Contracts the symbol should be the symbol that
   * is got in the
   * <symbolname>
   * The pricetype can take only LIMIT The transtype can take values only BUY and SELL. The product
   * can only take these values CNC, MIS, NRML.
   *
   * @param userId
   * @param token
   * @param accountId
   * @param exchange
   * @param symbol
   * @param product
   * @param quantity
   * @param transactionType
   * @param priceType
   * @param price
   */
  public RMSPossibleValuesRequest(String userId, String token, String accountId,
          String exchange, String symbol, String product, int quantity, String transactionType,
          String priceType, BigDecimal price) {
    super("/XMLServlets/servlet/RMSPossibleValues", userId, token, accountId);
    addParameter("exchange", exchange);
    addParameter("symbol", symbol);
    addParameter("product", product);
    addParameter("qty", quantity);
    addParameter("trans", transactionType);
    addParameter("pricetype", price);
  }

  @Override
  protected Response getResponse(String response) {
    return processResponse(response, RMSPossibleValuesResponse.class);
  }
}
