/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.teh.request.ipo.order;

import com.anosym.teh.request.PostRequest;
import com.anosym.teh.response.Response;
import com.anosym.teh.response.ipo.order.IPOBidDetailErrorResponse;
import com.anosym.teh.response.ipo.order.IPOBidDetailsResponse;

/**
 *
 * @author marembo
 */
public class IPOBidDetailsRequest extends PostRequest {

  public IPOBidDetailsRequest(String userId, String token,
          String companyId, String issueId) {
    super("/XMLServlets/servlet/ IPOBidDetails", userId, token);
    addParameter("compid", companyId);
    addParameter("issueid", issueId);
  }

  @Override
  protected Response getResponse(String response) {
    if (response.contains("<ipostatusindicator>")) {
      return processResponse(response, IPOBidDetailErrorResponse.class);
    }
    return processResponse(response, IPOBidDetailsResponse.class);
  }
}
