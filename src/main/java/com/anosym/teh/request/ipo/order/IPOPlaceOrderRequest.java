/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.teh.request.ipo.order;

import com.anosym.teh.request.PostRequest;
import com.anosym.teh.response.Response;
import com.anosym.teh.response.ipo.order.IPOPlaceOrderResponse;
import java.math.BigDecimal;

/**
 *
 * @author marembo
 */
public class IPOPlaceOrderRequest extends PostRequest {

  public static enum CutOff {

    Y, N;
  }

  public static enum Category {

    Retail,
    Non_Institutional;

    @Override
    public String toString() {
      return name().replace("_", "-");
    }
  }

  public IPOPlaceOrderRequest(String userId, String token, String accountId,
          String companyId, String issueId, int quantity1,
          BigDecimal price1, int quantity2, BigDecimal price2,
          int quantity3, BigDecimal price3, Category category, CutOff cutOff,
          String bidNumber, String dpId, String checkNumber) {
    super("/XMLServlets/servlet/IPOPostOrder", userId, token, accountId);
    addParameter("companyid", companyId);
    addParameter("issueid", issueId);
    addParameter("qty1", quantity1);
    addParameter("price1", price1);
    addParameter("qty2", quantity2);
    addParameter("price2", price2);
    addParameter("qty3", quantity3);
    addParameter("price3", price3);
    addParameter("Category", category);
    addParameter("cutoff", cutOff);
    addParameter("bidnum", bidNumber);
    addParameter("dpid", dpId);
    addParameter("checkno", checkNumber);
  }

  @Override
  protected Response getResponse(String response) {
    return processResponse(response, IPOPlaceOrderResponse.class);
  }
}
