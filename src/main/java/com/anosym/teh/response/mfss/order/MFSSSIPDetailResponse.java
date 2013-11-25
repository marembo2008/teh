/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.teh.response.mfss.order;

import com.anosym.teh.response.Response;
import com.anosym.vjax.annotations.Markup;

/**
 *
 * @author marembo
 */
public class MFSSSIPDetailResponse extends Response {

  /**
   * SIP details can be retrieved for the scrips for which sipindicator is “Y” in the
   * GetMarketWatchInfoMF servlet. sipdate , sipmonth and sipperiod will be in pipe separated format
   * which has to be fetched and displayed.
   */
  public static class SIPDetail {

    @Markup(name = "sipfreq")
    private String sipFrequency;
    @Markup(name = "sipdate")
    private String sipDate;
    @Markup(name = "sipmonth")
    private String sipMonth;
    @Markup(name = "sipperiod")
    private String sipPeriod;

    public String getSipFrequency() {
      return sipFrequency;
    }

    public void setSipFrequency(String sipFrequency) {
      this.sipFrequency = sipFrequency;
    }

    public String getSipDate() {
      return sipDate;
    }

    public void setSipDate(String sipDate) {
      this.sipDate = sipDate;
    }

    public String getSipMonth() {
      return sipMonth;
    }

    public void setSipMonth(String sipMonth) {
      this.sipMonth = sipMonth;
    }

    public String getSipPeriod() {
      return sipPeriod;
    }

    public void setSipPeriod(String sipPeriod) {
      this.sipPeriod = sipPeriod;
    }

    @Override
    public String toString() {
      return "SIPDetail{" + "sipFrequency=" + sipFrequency + ", sipDate=" + sipDate + ", sipMonth=" + sipMonth + ", sipPeriod=" + sipPeriod + '}';
    }
  }
  @Markup(name = "sipdetails")
  private SIPDetail sIPDetail;

  public SIPDetail getsIPDetail() {
    return sIPDetail;
  }

  public void setsIPDetail(SIPDetail sIPDetail) {
    this.sIPDetail = sIPDetail;
  }

  @Override
  public String toString() {
    return "MFSSSIPDetailResponse{" + "sIPDetail=" + sIPDetail + '}';
  }
}
