/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.teh.request.scrip;

import com.anosym.teh.request.Exchange;
import com.anosym.teh.request.PostRequest;
import com.anosym.teh.response.Response;
import com.anosym.teh.response.scrip.ScripDataResponse;

/**
 *
 * @author marembo
 */
public class ScripSearchOnTextAndExchangeRequest extends PostRequest {

    /**
     *
     * @param userId
     * @param token
     * @param searchText
     * @param exchange the values NSE or BSE
     * @param sortOn
     */
    public ScripSearchOnTextAndExchangeRequest(String userId, String token, String searchText, Exchange exchange, String sortOn) {
        super("/XMLServlets/servlet/GetScrips");
        addParameter("uid", userId);
        addParameter("token", token);
        addParameter("searchtext", searchText);
        addParameter("exchange", exchange);
        addParameter("sorton", sortOn);
    }

    @Override
    protected Response getResponse(String response) {
        return processResponse(response, ScripDataResponse.class);
    }
}
