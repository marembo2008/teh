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
public class IsoLongMonthDateTimeConverter implements com.anosym.vjax.converter.v3.Converter<Calendar, String> {

  private static final String[] LONG_MONTHS = {
    "January",
    "February",
    "March",
    "April",
    "May",
    "June",
    "July",
    "August",
    "September",
    "October",
    "November",
    "December"
  };
  private static final String[] SHORT_MONTHS = {
    "Jan",
    "Feb",
    "Mar",
    "Apr",
    "May",
    "Jun",
    "Jul",
    "Aug",
    "Sep",
    "Oct",
    "Nov",
    "Dec"
  };

  public String convertFrom(Calendar value) {
    String date = FormattedCalendar.getISODateString(value);
    String time = FormattedCalendar.toISOTimeString(value);
    String[] dateParts = date.split("-");
    String usDateFormat = dateParts[2] + "/" + SHORT_MONTHS[Integer.parseInt(dateParts[1])] + "/" + dateParts[0];
    return usDateFormat + " " + time;
  }

  public Calendar convertTo(String value) {
    if (value.trim().equals("--")) {
      return FormattedCalendar.createInstance("1970-1-1 00:00:00");
    }
    String dateTimeParts[] = value.split(" ");
    String date = dateTimeParts[0];
    String time = dateTimeParts[1];
    String dateParts[] = date.split("-");
    String isoDateFormat = dateParts[2] + "-" + getMonth(dateParts[1]) + "-" + dateParts[0];
    return FormattedCalendar.parseISODate(isoDateFormat + " " + time);
  }
  //one-based

  private int getMonth(String month) {
    for (int i = 0; i < LONG_MONTHS.length; i++) {
      if (LONG_MONTHS[i].equalsIgnoreCase(month)) {
        return (i + 1);
      }
      if (SHORT_MONTHS[i].equalsIgnoreCase(month)) {
        return (i + 1);
      }
    }
    return -1;
  }
}
