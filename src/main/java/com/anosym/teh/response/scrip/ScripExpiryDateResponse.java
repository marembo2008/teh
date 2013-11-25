/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.teh.response.scrip;

import com.anosym.teh.response.Response;
import com.anosym.vjax.converter.v3.impl.CalendarConverter;
import com.anosym.utilities.FormattedCalendar;
import com.anosym.vjax.annotations.Markup;
import com.anosym.vjax.annotations.v3.ArrayParented;
import com.anosym.vjax.annotations.v3.Converter;
import com.anosym.vjax.annotations.v3.ConverterParam;
import java.util.Arrays;
import java.util.Calendar;

/**
 *
 * @author marembo
 */
public class ScripExpiryDateResponse extends Response {

  public static class ExpiryDate {

    @Markup(name = "expirydate")
    @Converter(value = CalendarConverter.class, params = {
      @ConverterParam(key = CalendarConverter.CALENDAR_FORMAT_PARAM, value = {"d MMM, yyyy", "d MMM yyyy"})})
    private Calendar expiryDate;
    @Markup(name = "ssboetod")
    private String ssboetod;

    public Calendar getExpiryDate() {
      return expiryDate;
    }

    public void setExpiryDate(Calendar expiryDate) {
      this.expiryDate = expiryDate;
    }

    public String getSsboetod() {
      return ssboetod;
    }

    public void setSsboetod(String ssboetod) {
      this.ssboetod = ssboetod;
    }

    @Override
    public String toString() {
      return "ExpiryDate{" + "expiryDate=" + FormattedCalendar.toISOString(expiryDate) + ", ssboetod=" + ssboetod + '}';
    }
  }
  @Markup(name = "nfoscrips")
  @ArrayParented(componentMarkup = "scripexpirydate")
  private ExpiryDate[] expiryDates;

  public ExpiryDate[] getExpiryDates() {
    return expiryDates;
  }

  public void setExpiryDates(ExpiryDate[] expiryDates) {
    this.expiryDates = expiryDates;
  }

  @Override
  public String toString() {
    return "ScripExpiryDateResponse{" + "expiryDates=" + Arrays.toString(expiryDates) + '}';
  }
}
