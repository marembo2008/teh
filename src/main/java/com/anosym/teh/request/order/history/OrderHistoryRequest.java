/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.teh.request.order.history;

import com.anosym.teh.request.PostRequest;
import com.anosym.teh.response.Response;
import com.anosym.teh.response.order.history.OrderHistoryResponse;
import com.anosym.utilities.FormattedCalendar;
import java.util.Calendar;

/**
 *
 * @author marembo
 */
public class OrderHistoryRequest extends PostRequest {

  public OrderHistoryRequest(
          String loginId,
          String accountId,
          Calendar startDate,
          Calendar endDate,
          String sortOn,
          String sortType,
          String token) {
    this("/XMLServlets/servlet/OrderHistory", loginId, accountId, startDate, endDate, sortOn, sortType, token);
  }

  protected OrderHistoryRequest(
          String servletUrl,
          String loginId,
          String accountId,
          Calendar startDate,
          Calendar endDate,
          String sortOn,
          String sortType,
          String token) {
    super(servletUrl);
    addParameter("sLoginId", loginId);
    addParameter("sAccountId", accountId);
    addParameter("ReportDate0", FormattedCalendar.toDateString(startDate, "mm/dd/yyyy"));
    addParameter("ReportDate1", FormattedCalendar.toDateString(endDate, "mm/dd/yyyy"));
    addParameter("SortOn", sortOn);
    addParameter("SortType", sortType);
    addParameter("token", token);
  }

  @Override
  protected Response getResponse(String response) {
    return processResponse(response, OrderHistoryResponse.class);
  }
}
