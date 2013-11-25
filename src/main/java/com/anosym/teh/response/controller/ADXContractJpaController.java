/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.teh.response.controller;

import com.anosym.teh.response.ADXContract;
import java.util.Collections;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author marembo
 */
public class ADXContractJpaController extends AbstractJpaController<ADXContract> {

    public ADXContractJpaController() {
        super(ADXContract.class);
    }

    public List<ADXContract> loadRequiredContracts() {
        EntityManager em = null;
        try {
            em = getEntityManager();
            return em
                    .createNamedQuery("ADXContract.load_adxcontracs")
                    .setParameter("flag", 1)
                    .getResultList();
        } catch (Exception e) {
            log(e);
            return Collections.EMPTY_LIST;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
}
