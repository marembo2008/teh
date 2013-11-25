/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.teh.request.marketdata;

import com.anosym.teh.request.PostRequest;
import com.anosym.teh.response.Response;
import com.anosym.utilities.FormattedCalendar;
import java.math.BigDecimal;
import java.util.Calendar;

/**
 *
 * @author marembo
 */
public class OptionCalculatorRequest extends PostRequest {

  public OptionCalculatorRequest(String userId, String token,
          String instrument, String symbol, Calendar expiryDate,
          String optionType, BigDecimal strikePrice, BigDecimal spotPrice,
          String premiumOrVolatility, String premiumOrVolatilityValue,
          BigDecimal interestRate) {
    super("/XMLServlets/servlet/OptionCaclculator", userId, token);
    addParameter("Instrument", instrument);
    addParameter("Symbol", symbol);
    addParameter("ExpiryDate", FormattedCalendar.toDateString(expiryDate, "yyyy-mm-dd"));
    addParameter("OptionType", optionType);
    addParameter("StrikePrice", strikePrice);
    addParameter("SpotPrice", spotPrice);
    addParameter("PorV", premiumOrVolatility);
    addParameter("PorV_Value", premiumOrVolatilityValue);
    addParameter("InterestRate", interestRate);
  }

  @Override
  protected Response getResponse(String response) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }
}
