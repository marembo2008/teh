/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.teh.response.ipo.order;

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
public class IPOBidDetailsResponse extends Response {

  public static class BidDetail {

    @Markup(name = "ipocompanyid")
    private String comapnyId;
    @Markup(name = "ipoissueid")
    private String issueId;
    @Markup(name = "ipohighband")
    private int highBand;
    @Markup(name = "ipolowband")
    private int lowBand;
    @Markup(name = "ipoopendate")
    @Converter(value = CalendarConverter.class, params = {
      @ConverterParam(key = CalendarConverter.CALENDAR_FORMAT_PARAM, value = "dd/mm/yyyy")})
    private Calendar ipoOpenDate;
    @Markup(name = "ipoclosedate")
    @Converter(value = CalendarConverter.class, params = {
      @ConverterParam(key = CalendarConverter.CALENDAR_FORMAT_PARAM, value = "dd/mm/yyyy")})
    private Calendar ipoCloseDate;
    @Markup(name = "ipobidlot")
    private int bidLot;
    @Markup(name = "ipomultiplequantity")
    private int multipleQuantity;
    @Markup(name = "ipoissuetype")
    private String issueType;

    public String getComapnyId() {
      return comapnyId;
    }

    public void setComapnyId(String comapnyId) {
      this.comapnyId = comapnyId;
    }

    public String getIssueId() {
      return issueId;
    }

    public void setIssueId(String issueId) {
      this.issueId = issueId;
    }

    public int getHighBand() {
      return highBand;
    }

    public void setHighBand(int highBand) {
      this.highBand = highBand;
    }

    public int getLowBand() {
      return lowBand;
    }

    public void setLowBand(int lowBand) {
      this.lowBand = lowBand;
    }

    public Calendar getIpoOpenDate() {
      return ipoOpenDate;
    }

    public void setIpoOpenDate(Calendar ipoOpenDate) {
      this.ipoOpenDate = ipoOpenDate;
    }

    public Calendar getIpoCloseDate() {
      return ipoCloseDate;
    }

    public void setIpoCloseDate(Calendar ipoCloseDate) {
      this.ipoCloseDate = ipoCloseDate;
    }

    public int getBidLot() {
      return bidLot;
    }

    public void setBidLot(int bidLot) {
      this.bidLot = bidLot;
    }

    public int getMultipleQuantity() {
      return multipleQuantity;
    }

    public void setMultipleQuantity(int multipleQuantity) {
      this.multipleQuantity = multipleQuantity;
    }

    public String getIssueType() {
      return issueType;
    }

    public void setIssueType(String issueType) {
      this.issueType = issueType;
    }

    @Override
    public String toString() {
      return "BidDetail{" + "comapnyId=" + comapnyId + ", issueId=" + issueId + ", highBand=" + highBand + ", lowBand=" + lowBand + ", ipoOpenDate=" + FormattedCalendar.getISODateString(ipoOpenDate) + ", ipoCloseDate=" + FormattedCalendar.getISODateString(ipoCloseDate) + ", bidLot=" + bidLot + ", multipleQuantity=" + multipleQuantity + ", issueType=" + issueType + '}';
    }
  }
  @Markup(name = "omneipobiddetails")
  @ArrayParented(componentMarkup = "omnesingleentry")
  private BidDetail[] bidDetails;

  public BidDetail[] getBidDetails() {
    return bidDetails;
  }

  public void setBidDetails(BidDetail[] bidDetails) {
    this.bidDetails = bidDetails;
  }

  @Override
  public String toString() {
    return "IPOBidDetailsResponse{" + "bidDetails=" + Arrays.toString(bidDetails) + '}';
  }
}
