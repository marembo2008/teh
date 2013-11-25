/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.teh.request.order;

import com.anosym.teh.response.order.OrderBookResponse;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author marembo
 */
public class OrderBookRequestTest {

  public OrderBookRequestTest() {
  }

  @Before
  public void setUp() {
  }

  @After
  public void tearDown() {
  }

  @Test
  public void testGetResponse() {
    String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?> "
            + "<omnereports>"
            + "<omneorderbook>"
            + "<omnesingleentry>"
            + " <userid>USER0002</userid> "
            + " <accountid>USER0002</accountid> "
            + " <exchange>NSE</exchange> "
            + " <nestordernumber>120515000000631</nestordernumber> "
            + " <nestorderreqid>1</nestorderreqid> "
            + " <transactiontype>BUY</transactiontype> "
            + " <tradingsymbol>ZEENEWS-EQ</tradingsymbol> "
            + " <symbol>14003</symbol> "
            + " <series>EQ</series> "
            + " <companyname>ZEE NEWS LIMITED</companyname> "
            + " <price>9</price> "
            + " <avgprice>0</avgprice> "
            + " <totalqty>10</totalqty> "
            + " <pendingqty>10</pendingqty> "
            + " <dislcosedqty>0</dislcosedqty> "
            + " <filledqty>0</filledqty> "
            + " <triggerprice>0</triggerprice> "
            + " <exchangeorderno>2012051521545118</exchangeorderno> "
            + " <status>open</status> "
            + " <rejectionreason /> "
            + " <ordertype>LIMIT</ordertype> "
            + " <orderentrytime>15/05/2012 12:49:25</orderentrytime> "
            + " <productcode>NRML</productcode> "
            + " <exchangetimestamp>15-May-2012 12:49:25</exchangetimestamp> "
            + " <ordersource>XMLAPI</ordersource> "
            + " <ordergenerationtype>--</ordergenerationtype> "
            + " <ordervalidity>DAY</ordervalidity> "
            + " <coverorderindicator /> "
            + " <coverorderpercentage>0</coverorderpercentage>  <coverreflimitprice>0</coverreflimitprice> "
            + " <pricenumerator>1</pricenumerator> "
            + " <pricedenominator>1</pricedenominator> "
            + " <generalnumerator>1</generalnumerator> "
            + " <generaldenominator>1</generaldenominator> "
            + " <remarks>Remarksfield</remarks> "
            + " </omnesingleentry>"
            + " </omneorderbook>"
            + " </omnereports>";
    OrderBookResponse response = (OrderBookResponse) new OrderBookRequest("", "").getResponse(xml);
    String expectedExchangeOrderNumber = "2012051521545118";
    String actualExchangeOrderNumber = response.getOrders()[0].getExchangeOrderNumber();
    assertEquals(expectedExchangeOrderNumber, actualExchangeOrderNumber);
  }
}