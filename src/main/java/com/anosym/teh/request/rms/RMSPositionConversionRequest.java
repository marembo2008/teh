/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.teh.request.rms;

import com.anosym.teh.request.PostRequest;
import com.anosym.teh.response.Response;
import com.anosym.teh.response.rms.RMSPositionConversionResponse;

/**
 *
 * @author marembo
 */
public class RMSPositionConversionRequest extends PostRequest {

  /**
   * The details order number, fill id and product code have to be fetched from GetTrades servlet.
   *
   * @param userId
   * @param token
   * @param orderNumber
   * @param fillId
   * @param productCode
   * @param newProductCode
   */
  public RMSPositionConversionRequest(String userId, String token,
          String orderNumber, String fillId, String productCode, String newProductCode) {
    super("/XMLServlets/servlet/PositionConvertion", userId, token);
    addParameter("nestordnum", orderNumber);
    addParameter("fillid", fillId);
    addParameter("pcode", productCode);
    addParameter("producttochge", newProductCode);
  }

  @Override
  protected Response getResponse(String response) {
    /**
     * The error response will be taken care off automatically.
     */
    return processResponse(response, RMSPositionConversionResponse.class);
  }
}
