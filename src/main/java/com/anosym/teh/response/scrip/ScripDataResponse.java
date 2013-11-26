/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.teh.response.scrip;

import com.anosym.teh.response.Response;
import com.anosym.vjax.annotations.Markup;
import com.anosym.vjax.annotations.v3.ArrayParented;
import java.util.Arrays;

/**
 *
 * @author marembo
 */
public class ScripDataResponse extends Response {

    @Markup(name = "scrips")
    @ArrayParented(componentMarkup = "scripdata")
    private Scrip[] scrips;

    public Scrip[] getScrips() {
        return scrips;
    }

    public void setScrips(Scrip[] scrips) {
        this.scrips = scrips;
    }

    @Override
    public String toString() {
        return "ScripSearchOnTextAndExchangeResponse{" + "scrips=" + Arrays.toString(scrips) + '}';
    }
}
