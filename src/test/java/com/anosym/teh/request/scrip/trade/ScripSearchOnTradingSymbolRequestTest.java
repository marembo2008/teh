/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.teh.request.scrip.trade;

import com.anosym.teh.request.Exchange;
import com.anosym.teh.response.Response;
import com.anosym.teh.response.scrip.trade.ScripSearchOnTradingSymbolResponse;
import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author marembo
 */
public class ScripSearchOnTradingSymbolRequestTest {

    public ScripSearchOnTradingSymbolRequestTest() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testGetResponse() {
        String responseXml = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n"
                + "<omnereports>\n"
                + " <scrips>\n"
                + "  <scripdetail>\n"
                + "   <tradingsymbol>BANKNIFTY11JUNFUT</tradingsymbol>\n"
                + "   <symbolname>42254</symbolname>\n"
                + "   <boardlotqty>25</boardlotqty>\n"
                + "   <scripexpirydate>\n"
                + "    <ssboetod>993911400</ssboetod>\n"
                + "   </scripexpirydate>\n"
                + "  </scripdetail>\n"
                + " </scrips>\n"
                + "</omnereports>";
        Response response = new ScripSearchOnTradingSymbolRequest(null, null, null, null).getResponse(responseXml);
        int expectedBoardLotQuantity = 25;
        int actualBoardLotQuantity = ((ScripSearchOnTradingSymbolResponse) response).getTradingDetails()[0].getBoardLotQuantity();
        Assert.assertEquals(expectedBoardLotQuantity, actualBoardLotQuantity);
    }
}
