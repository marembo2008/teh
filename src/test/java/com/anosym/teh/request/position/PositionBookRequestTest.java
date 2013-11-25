/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.teh.request.position;

import com.anosym.teh.response.position.PositionBookResponse;
import java.math.BigDecimal;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author marembo
 */
public class PositionBookRequestTest {

  public PositionBookRequestTest() {
  }

  @Before
  public void setUp() {
  }

  @After
  public void tearDown() {
  }

  @Test
  public void testGetResponse() {
    String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>"
            + "<omnereports>"
            + "<nestpositions>"
            + "<omnesingleentry>"
            + "<exchange>NSE</exchange>"
            + "<tradingsymbol>ABB-EQ</tradingsymbol>"
            + "<symbol>13</symbol>"
            + "<companyname>ABB LTD.</companyname>"
            + "<buyqty>10</buyqty>"
            + "<avgbuyprice>10.0</avgbuyprice>"
            + "<buyamt>100.00</buyamt>"
            + "<sellqty>10</sellqty>"
            + "<avgsellprice>10.0</avgsellprice>"
            + "<sellamt>100.00</sellamt>"
            + "<netamt>0.00</netamt>"
            + "<netqty>0</netqty>"
            + "<markettomarket>0.0</markettomarket>"
            + "<realisedprofitloss>0.0</realisedprofitloss>"
            + "<unrealisedprofitloss>0.0</unrealisedprofitloss>"
            + "<bep>0</bep>"
            + "<productcode>CNC</productcode>"
            + "<ltp>500.0</ltp>"
            + "<instrumentname>NA</instrumentname>"
            + "<optiontype/>"
            + "<expirydate>NA</expirydate>"
            + "<strikeprice>0.0</strikeprice>"
            + "</omnesingleentry>"
            + "<omnesingleentry>"
            + "<exchange>NSE</exchange>"
            + "<tradingsymbol>ALFALAVAL-EQ</tradingsymbol>"
            + "<symbol>70</symbol>"
            + "<companyname>ALFA LAVAL (INDIA) LTD.</companyname>"
            + "<buyqty>1</buyqty>"
            + "<avgbuyprice>1.0</avgbuyprice>"
            + "<buyamt>1.00</buyamt>"
            + "<sellqty>1</sellqty>"
            + "<avgsellprice>1.90</avgsellprice>"
            + "<sellamt>1.00</sellamt>"
            + "<netamt>0.00</netamt>"
            + "<netqty>0</netqty>"
            + "<markettomarket>0.0</markettomarket>"
            + "<realisedprofitloss>0.0</realisedprofitloss>"
            + "<unrealisedprofitloss>0.0</unrealisedprofitloss>"
            + "<bep>0</bep>"
            + "<productcode>CNC</productcode>"
            + "<ltp>1175.15</ltp>"
            + " <instrumentname>NA</instrumentname>"
            + " <optiontype/>"
            + " <expirydate>NA</expirydate>"
            + " <strikeprice>0.0</strikeprice>"
            + "</omnesingleentry>"
            + "</nestpositions>"
            + "<nestpositions />"
            + "</omnereports>";
    PositionBookResponse response = (PositionBookResponse) new PositionBookRequest(null, null, null, null, null, null, null)
            .getResponse(xml);
    BigDecimal expected = new BigDecimal("1175.15");
    BigDecimal actual = response.getPositions()[1].getLastTradedPrice();
    assertEquals(expected, actual);
    System.out.println(response);
  }
}