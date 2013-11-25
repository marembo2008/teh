/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.teh.request.marketdata;

import com.anosym.teh.response.marketdata.SecurityInfo;
import com.anosym.teh.response.marketdata.SecurityInfoResponse;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author marembo
 */
public class SecurityInfoRequestTest {

  public SecurityInfoRequestTest() {
  }

  @Before
  public void setUp() {
  }

  @After
  public void tearDown() {
  }

  @Test
  public void testNoDataResponse() {
    String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n"
            + "<omnereports>\n"
            + "<securityinfo>No data available for selected scrip</securityinfo>\n"
            + "</omnereports>";
    SecurityInfoResponse sir = (SecurityInfoResponse) new SecurityInfoRequest(xml, xml, xml, xml).getResponse(xml);
    String expected = "No data available for selected scrip";
    String actual = sir.getSecurityInfoMessage();
    assertEquals(expected, actual);
  }

  @Test
  public void testDataResponse() {
    String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n"
            + "<omnereports>\n"
            + "<securityinfo>\n"
            + "<symbol>RIIL</symbol>\n"
            + "<series>EQ</series>\n"
            + "<boardlotqty>1</boardlotqty>\n"
            + "<ticksize>0.05</ticksize>\n"
            + "<instrumenttype>-</instrumenttype>\n"
            + "<exchange>NSE</exchange>\n"
            + "<issuestartdate>28 Dec, 1994</issuestartdate>\n"
            + "<issuematuritydate>1 Jan, 1980</issuematuritydate>\n"
            + "<issuerate>0</issuerate>\n"
            + "<issuecapital>1.51</issuecapital>\n"
            + "<listdate>1 Jan, 1980</listdate>\n"
            + "<permittedtotrade>0</permittedtotrade>\n"
            + "<nodelstartdate>1 Jan, 1980</nodelstartdate>\n"
            + "<nodelendtime>1 Jan, 1980</nodelendtime>\n"
            + "<bookclsstarttime>15 Jul 2010</bookclsstarttime>\n"
            + "<bookclsendtime>20 Jul 2010</bookclsendtime>\n"
            + "<recorddate>NA</recorddate>\n"
            + "<remarks>NA</remarks>\n"
            + "<warning>NA</warning>\n"
            + "<freeze>2549.0</freeze>\n"
            + "<circuitrating>519.60-779.35</circuitrating>\n"
            + "<readmdate>NA</readmdate>\n"
            + "<expulsiondate>NA</expulsiondate>\n"
            + "<intpaydate>NA</intpaydate>\n"
            + "<expirydate>4 Jun, 2008</expirydate>\n"
            + "<localupdatetime>10 Mar 2011</localupdatetime>\n"
            + "<priceunits>NA</priceunits>\n"
            + "<pricenumerator>0</pricenumerator>\n"
            + "<qtyunits>NA</qtyunits>\n"
            + "<pricedenominator>0</pricedenominator>\n"
            + "<deliveryunits>NA</deliveryunits>\n"
            + "<generalnumerator>0</generalnumerator>\n"
            + "<tenderperiodstartdate>NA</tenderperiodstartdate>\n"
            + "<generaldenominator>0</generaldenominator>\n"
            + "<remarks>NA</remarks>\n"
            + "<tenderperiodenddate>NA</tenderperiodenddate>\n"
            + "<lasttradingdate>NA</lasttradingdate>\n"
            + "<markettype>NA</markettype>\n"
            + "<openinterest>0</openinterest>\n"
            + "<pricequotation>NA</pricequotation>\n"
            + "<lowercircuitlimit>519.60</lowercircuitlimit>"
            + "<highercircuitlimit>779.35</highercircuitlimit>\n"
            + "<deliverystartdate>NA</deliverystartdate>\n"
            + "<deliveryenddate>NA</deliveryenddate>\n"
            + "<sellvarmargin>NA</sellvarmargin>\n"
            + "<buyvarmargin>NA</buyvarmargin>\n"
            + "<valuetradedtoday>NA</valuetradedtoday>\n"
            + "<maxordersize>NA</maxordersize>\n"
            + "<dpr>779.35-519.60</dpr>\n"
            + "<imspreadbenifit>ON</imspreadbenifit>\n"
            + "<otherbuymargin>NA</otherbuymargin>\n"
            + "<othersellmargin>NA</othersellmargin>\n"
            + "<remarks>DIVIDEND RS 3.5 PER SHARE</remarks>\n"
            + "<exposuremargin>NA</exposuremargin>\n"
            + "</securityinfo>\n"
            + "</omnereports>";
    SecurityInfoResponse sir = (SecurityInfoResponse) new SecurityInfoRequest(xml, xml, xml, xml).getResponse(xml);
    assertNotNull(sir.getSecurityInfo());
    SecurityInfo si = sir.getSecurityInfo();
    String expected = "779.35-519.60";
    String actual = si.getDpr();
    assertEquals(expected, actual);
    System.out.println(si);
  }
}