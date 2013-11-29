/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.teh.response.marketdata.controller;

import com.anosym.teh.response.controller.AbstractJpaController;
import com.anosym.teh.response.marketdata.MarketDepth;
import java.io.Serializable;

/**
 *
 * @author marembo
 */
public class MarketDepthJpaController extends AbstractJpaController<MarketDepth> implements Serializable {

  private static final long serialVersionUID = 1482948924829L;

  public MarketDepthJpaController() {
    super(MarketDepth.class);
  }
}
