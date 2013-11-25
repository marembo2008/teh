/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.teh.request.scrip.trade;

import com.anosym.teh.request.Exchange;
import com.anosym.teh.request.scrip.ScripSearchOnTextAndExchangeRequest;
import com.anosym.teh.response.Response;
import com.anosym.teh.response.scrip.trade.ScripSearchOnTradingSymbolResponse;

/**
 *
 * @author marembo
 */
public class ScripSearchOnTradingSymbolRequest extends ScripSearchOnTextAndExchangeRequest {

    public ScripSearchOnTradingSymbolRequest(String userId, String token, String searchText, Exchange exchange) {
        super(userId, token, searchText, exchange, null);
    }

    @Override
    protected Response getResponse(String response) {
        return processResponse(response, ScripSearchOnTradingSymbolResponse.class);
    }
}
