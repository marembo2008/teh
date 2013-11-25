/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.teh.request.order;

import com.anosym.teh.request.PostRequest;
import com.anosym.teh.response.Response;
import java.math.BigDecimal;

/**
 *
 * @author marembo
 */
public class ModifyCoverOrderRequest extends PostRequest {

  public ModifyCoverOrderRequest(String token, String userId, String accountId, String orderNumber, BigDecimal triggerPrice) {
    super("/XMLServlets/servlet/ModifyCoverOrder");
    addParameter("acId", accountId);
    addParameter("token", token);
    addParameter("uid", userId);
    addParameter("nestordernumber", orderNumber);
    addParameter("triggerprice", triggerPrice);
  }

  @Override
  protected Response getResponse(String response) {
    return null;
  }
}
