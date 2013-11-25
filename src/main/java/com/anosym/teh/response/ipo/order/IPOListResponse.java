/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.teh.response.ipo.order;

import com.anosym.teh.response.Response;
import com.anosym.vjax.converter.v3.impl.CalendarConverter;
import com.anosym.vjax.annotations.Markup;
import com.anosym.vjax.annotations.v3.ArrayParented;
import com.anosym.vjax.annotations.v3.Converter;
import com.anosym.vjax.annotations.v3.ConverterParam;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Calendar;

/**
 *
 * @author marembo
 */
public class IPOListResponse extends Response {

  public static class BidDetail extends IPOBidDetailsResponse.BidDetail {

    @Markup(name = "ipocutoffprice")
    private BigDecimal cutOffPrice;
    @Markup(name = "ipocutofflot")
    private int cutOffLot;
    @Markup(name = "ipofacevalue")
    private BigDecimal faceValue;
    @Markup(name = "ipobid1quantity")
    private int bid1Quantity;
    @Markup(name = "ipobid1price")
    private BigDecimal bid1Price;
    @Markup(name = "ipocutofftime")
    @Converter(value = CalendarConverter.class, params = {
      @ConverterParam(key = CalendarConverter.CALENDAR_FORMAT_PARAM, value = "HH:mm:ss")})
    private Calendar cutOffTime;

    public BigDecimal getCutOffPrice() {
      return cutOffPrice;
    }

    public void setCutOffPrice(BigDecimal cutOffPrice) {
      this.cutOffPrice = cutOffPrice;
    }

    public int getCutOffLot() {
      return cutOffLot;
    }

    public void setCutOffLot(int cutOffLot) {
      this.cutOffLot = cutOffLot;
    }

    public BigDecimal getFaceValue() {
      return faceValue;
    }

    public void setFaceValue(BigDecimal faceValue) {
      this.faceValue = faceValue;
    }

    public int getBid1Quantity() {
      return bid1Quantity;
    }

    public void setBid1Quantity(int bid1Quantity) {
      this.bid1Quantity = bid1Quantity;
    }

    public BigDecimal getBid1Price() {
      return bid1Price;
    }

    public void setBid1Price(BigDecimal bid1Price) {
      this.bid1Price = bid1Price;
    }

    public Calendar getCutOffTime() {
      return cutOffTime;
    }

    public void setCutOffTime(Calendar cutOffTime) {
      this.cutOffTime = cutOffTime;
    }

    @Override
    public String toString() {
      return "BidDetail{" + "cutOffPrice=" + cutOffPrice + ", cutOffLot=" + cutOffLot + ", faceValue=" + faceValue + ", bid1Quantity=" + bid1Quantity + ", bid1Price=" + bid1Price + ", cutOffTime=" + cutOffTime + '}' + super.toString();
    }
  }
  @ArrayParented(componentMarkup = "omnesingleentry")
  @Markup(name = "omneipolist")
  private BidDetail[] bidDetails;

  public BidDetail[] getBidDetails() {
    return bidDetails;
  }

  public void setBidDetails(BidDetail[] bidDetails) {
    this.bidDetails = bidDetails;
  }

  @Override
  public String toString() {
    return "IPOListResponse{" + "bidDetails=" + Arrays.toString(bidDetails) + '}';
  }
}
