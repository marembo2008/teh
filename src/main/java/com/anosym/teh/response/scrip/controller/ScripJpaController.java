/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.teh.response.scrip.controller;

import com.anosym.teh.response.controller.AbstractJpaController;
import com.anosym.teh.response.scrip.Scrip;

/**
 *
 * @author marembo
 */
public class ScripJpaController extends AbstractJpaController<Scrip> {

    public ScripJpaController() {
        super(Scrip.class);
    }
}
