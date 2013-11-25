/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.teh.util;

import com.anosym.utilities.FormattedCalendar;
import java.util.Calendar;

/**
 *
 * @author marembo
 */
public class DateTimeConverter implements com.anosym.vjax.converter.v3.Converter<Calendar, String> {

  public String convertFrom(Calendar value) {
    String date = FormattedCalendar.getISODateString(value);
    String time = FormattedCalendar.toISOTimeString(value);
    String[] dateParts = date.split("-");
    String usDateFormat = dateParts[2] + "/" + dateParts[1] + "/" + dateParts[0];
    return usDateFormat + " " + time;
  }

  public Calendar convertTo(String value) {
    if (value.trim().equals("--")) {
      return FormattedCalendar.createInstance("1970-1-1 00:00:00");
    }
    String dateTimeParts[] = value.split(" ");
    String date = dateTimeParts[0];
    String time = dateTimeParts[1];
    String dateParts[] = date.split("/");
    String isoDateFormat = dateParts[2] + "-" + dateParts[1] + "-" + dateParts[0];
    return FormattedCalendar.parseISODate(isoDateFormat + " " + time);
  }
}
