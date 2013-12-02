/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.teh.response.util;

import com.anosym.utilities.Utility;
import com.anosym.vjax.converter.v3.Converter;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author marembo
 */
public class PriceConverter implements Converter<BigDecimal, String> {

    @Override
    public String convertFrom(BigDecimal value) {
        return value.toString();
    }

    @Override
    public BigDecimal convertTo(String value) {
        try {
            if (Utility.isNullOrEmpty(value)
                    || value.equalsIgnoreCase("ato")
                    || value.equalsIgnoreCase("na")) {
                return BigDecimal.ZERO;
            }
            return new BigDecimal(value.replaceAll("[\\W&&[^\\.]]+", "")).setScale(2, RoundingMode.UP);
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, value, e);
            System.out.println(e.getLocalizedMessage() + ": " + value);
            return BigDecimal.ZERO;
        }
    }
}
