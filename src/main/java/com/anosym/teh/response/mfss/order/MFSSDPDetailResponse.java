/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.teh.response.mfss.order;

import com.anosym.teh.response.Response;
import com.anosym.vjax.annotations.Markup;
import com.anosym.vjax.annotations.v3.ArrayParented;

/**
 *
 * @author marembo
 */
public class MFSSDPDetailResponse extends Response {

  public static class DPS {

    @Markup(name = "dpid1")
    private String dpId1;
    @Markup(name = "dpid2")
    private String dpId2;
    @Markup(name = "dpid3")
    private String dpId3;

    public String getDpId1() {
      return dpId1;
    }

    public void setDpId1(String dpId1) {
      this.dpId1 = dpId1;
    }

    public String getDpId2() {
      return dpId2;
    }

    public void setDpId2(String dpId2) {
      this.dpId2 = dpId2;
    }

    public String getDpId3() {
      return dpId3;
    }

    public void setDpId3(String dpId3) {
      this.dpId3 = dpId3;
    }

    @Override
    public String toString() {
      return "DPS{" + "dpId1=" + dpId1 + ", dpId2=" + dpId2 + ", dpId3=" + dpId3 + '}';
    }
  }
  @Markup(name = "getdps")
  private DPS dps;

  public DPS getDps() {
    return dps;
  }

  public void setDps(DPS dps) {
    this.dps = dps;
  }

  @Override
  public String toString() {
    return "MFSSDPDetailResponse{" + "dps=" + dps + '}';
  }
}
