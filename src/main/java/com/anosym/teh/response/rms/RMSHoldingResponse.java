/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.teh.response.rms;

import com.anosym.teh.response.Response;
import com.anosym.teh.response.util.PriceConverter;
import com.anosym.vjax.annotations.Markup;
import com.anosym.vjax.annotations.v3.ArrayParented;
import com.anosym.vjax.annotations.v3.Converter;
import java.math.BigDecimal;
import java.util.Arrays;

/**
 *
 * @author marembo
 */
public class RMSHoldingResponse extends Response {

  public static class RMSHolding {

    @Markup(name = "scripcode")
    private String scripCode;
    private String series;
    private String symbol;
    @Markup(name = "symbolname")
    private String symbolName;
    @Markup(name = "clientid")
    private String clientId;
    @Markup(name = "productcode")
    private String productCode;
    @Markup(name = "collateraltype")
    private String collateralType;
    private int quantity;
    @Markup(name = "t1holdingqty")
    private int t1HoldingQuantity;
    @Markup(name = "usedqty")
    private int usedQuantity;
    @Converter(PriceConverter.class)
    private BigDecimal price;
    @Markup(name = "haircut")
    @Converter(PriceConverter.class)
    private BigDecimal hairCut;
    @Markup(name = "nseltp")
    @Converter(PriceConverter.class)
    private BigDecimal nseLtp;
    @Markup(name = "bseltp")
    @Converter(PriceConverter.class)
    private BigDecimal bseLtp;
    @Markup(name = "targetproduct")
    private String targetProduct;
    @Markup(name = "holdingupdateqty")
    private int holdingUpdateQuantity;
    @Markup(name = "collateralupdateqty")
    private int collateralUpdateQuantity;
    @Markup(name = "collateralqty")
    private int collateralQuantity;
    @Markup(name = "isin")
    private String isin;

    public String getScripCode() {
      return scripCode;
    }

    public void setScripCode(String scripCode) {
      this.scripCode = scripCode;
    }

    public String getSeries() {
      return series;
    }

    public void setSeries(String series) {
      this.series = series;
    }

    public String getSymbol() {
      return symbol;
    }

    public void setSymbol(String symbol) {
      this.symbol = symbol;
    }

    public String getSymbolName() {
      return symbolName;
    }

    public void setSymbolName(String symbolName) {
      this.symbolName = symbolName;
    }

    public String getClientId() {
      return clientId;
    }

    public void setClientId(String clientId) {
      this.clientId = clientId;
    }

    public String getProductCode() {
      return productCode;
    }

    public void setProductCode(String productCode) {
      this.productCode = productCode;
    }

    public String getCollateralType() {
      return collateralType;
    }

    public void setCollateralType(String collateralType) {
      this.collateralType = collateralType;
    }

    public int getQuantity() {
      return quantity;
    }

    public void setQuantity(int quantity) {
      this.quantity = quantity;
    }

    public int getT1HoldingQuantity() {
      return t1HoldingQuantity;
    }

    public void setT1HoldingQuantity(int t1HoldingQuantity) {
      this.t1HoldingQuantity = t1HoldingQuantity;
    }

    public int getUsedQuantity() {
      return usedQuantity;
    }

    public void setUsedQuantity(int usedQuantity) {
      this.usedQuantity = usedQuantity;
    }

    public BigDecimal getPrice() {
      return price;
    }

    public void setPrice(BigDecimal price) {
      this.price = price;
    }

    public BigDecimal getHairCut() {
      return hairCut;
    }

    public void setHairCut(BigDecimal hairCut) {
      this.hairCut = hairCut;
    }

    public BigDecimal getNseLtp() {
      return nseLtp;
    }

    public void setNseLtp(BigDecimal nseLtp) {
      this.nseLtp = nseLtp;
    }

    public BigDecimal getBseLtp() {
      return bseLtp;
    }

    public void setBseLtp(BigDecimal bseLtp) {
      this.bseLtp = bseLtp;
    }

    public String getTargetProduct() {
      return targetProduct;
    }

    public void setTargetProduct(String targetProduct) {
      this.targetProduct = targetProduct;
    }

    public int getHoldingUpdateQuantity() {
      return holdingUpdateQuantity;
    }

    public void setHoldingUpdateQuantity(int holdingUpdateQuantity) {
      this.holdingUpdateQuantity = holdingUpdateQuantity;
    }

    public int getCollateralUpdateQuantity() {
      return collateralUpdateQuantity;
    }

    public void setCollateralUpdateQuantity(int collateralUpdateQuantity) {
      this.collateralUpdateQuantity = collateralUpdateQuantity;
    }

    public int getCollateralQuantity() {
      return collateralQuantity;
    }

    public void setCollateralQuantity(int collateralQuantity) {
      this.collateralQuantity = collateralQuantity;
    }

    public String getIsin() {
      return isin;
    }

    public void setIsin(String isin) {
      this.isin = isin;
    }

    @Override
    public String toString() {
      return "RMSHolding{" + "scripCode=" + scripCode + ", series=" + series + ", symbol=" + symbol + ", symbolName=" + symbolName + ", clientId=" + clientId + ", productCode=" + productCode + ", collateralType=" + collateralType + ", quantity=" + quantity + ", t1HoldingQuantity=" + t1HoldingQuantity + ", usedQuantity=" + usedQuantity + ", price=" + price + ", hairCut=" + hairCut + ", nseLtp=" + nseLtp + ", bseLtp=" + bseLtp + ", targetProduct=" + targetProduct + ", holdingUpdateQuantity=" + holdingUpdateQuantity + ", collateralUpdateQuantity=" + collateralUpdateQuantity + ", collateralQuantity=" + collateralQuantity + ", isin=" + isin + '}';
    }
  }
  @ArrayParented(componentMarkup = "omnesingleentry")
  private RMSHolding[] holdings;

  public RMSHolding[] getHoldings() {
    return holdings;
  }

  public void setHoldings(RMSHolding[] holdings) {
    this.holdings = holdings;
  }

  @Override
  public String toString() {
    return "RMSHoldingResponse{" + "holdings=" + Arrays.toString(holdings) + '}';
  }
}
