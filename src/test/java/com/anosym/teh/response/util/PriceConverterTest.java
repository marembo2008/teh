/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.teh.response.util;

import java.math.BigDecimal;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author marembo
 */
public class PriceConverterTest {

    public PriceConverterTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of convertFrom method, of class PriceConverter.
     */
    @Test
    public void testConvertFrom() {
        System.out.println("convertFrom");
        BigDecimal value = new BigDecimal("45.00");
        PriceConverter instance = new PriceConverter();
        String expResult = "45.00";
        String result = instance.convertFrom(value);
        assertEquals(expResult, result);
    }

    /**
     * Test of convertTo method, of class PriceConverter.
     */
    @Test
    public void testConvertTo() {
        System.out.println("convertTo");
        String value = "6,647.70";
        PriceConverter instance = new PriceConverter();
        BigDecimal expResult = new BigDecimal("6647.70");
        BigDecimal result = instance.convertTo(value);
        assertEquals(expResult, result);
    }

}
