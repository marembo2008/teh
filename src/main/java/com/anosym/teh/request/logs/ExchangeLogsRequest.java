/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.teh.request.logs;

import com.anosym.teh.request.PostRequest;
import com.anosym.teh.response.Response;

/**
 *
 * @author marembo
 */
public class ExchangeLogsRequest extends PostRequest {

  public ExchangeLogsRequest(String userId, String token) {
    super("/XMLServlets/servlet/ExchangeLogs", userId, token);
  }

  @Override
  protected Response getResponse(String response) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }
}
