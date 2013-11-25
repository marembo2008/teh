/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.teh.request.scrip;

import com.anosym.teh.response.Response;
import com.anosym.teh.response.scrip.ScripSymbolDetailResponse;
import com.anosym.teh.response.scrip.ScripOptionTypeResponse;
import com.anosym.utilities.FormattedCalendar;
import java.util.Calendar;

/**
 *
 * @author marembo
 */
public class ScripOptionTypeRequest extends ScripExpiryDateRequest {

  /**
   *
   * @param userId
   * @param token
   * @param exchange
   * @param instrumentName
   * @param symbol
   * @param expiryDate should be the ssboetod of the expiry date component
   */
  public ScripOptionTypeRequest(String userId, String token, String exchange, String instrumentName,
          String symbol, Calendar expiryDate) {
    super(userId, token, exchange, instrumentName, symbol);
    addParameter("expdate", FormattedCalendar.toDateString(expiryDate, "dd/mm/yyyy"));
  }

  @Override
  protected Response getResponse(String response) {
    String instrumentName = getParameter("instrname");
    if (instrumentName.equalsIgnoreCase("OPTSTK")
            || instrumentName.equalsIgnoreCase("OPTIDX")
            || instrumentName.equalsIgnoreCase("OPTCUR")) {
      return processResponse(response, ScripOptionTypeResponse.class);
    }
    return processResponse(response, ScripSymbolDetailResponse.class);
  }
}
