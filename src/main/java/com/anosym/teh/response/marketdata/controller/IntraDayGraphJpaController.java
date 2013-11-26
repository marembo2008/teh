/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.teh.response.marketdata.controller;

import com.anosym.teh.response.controller.AbstractJpaController;
import com.anosym.teh.response.controller.exceptions.NonexistentEntityException;
import com.anosym.teh.response.marketdata.Chart;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author marembo
 */
public class IntraDayGraphJpaController extends AbstractJpaController<Chart> implements Serializable {

    public IntraDayGraphJpaController() {
        super(Chart.class);
    }

    public void destroy(String id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Chart securityInfo;
            try {
                securityInfo = em.getReference(Chart.class, id);
                securityInfo.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The Chart with id " + id + " no longer exists.", enfe);
            }
            em.remove(securityInfo);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Chart> findChartEntities() {
        return findChartEntities(true, -1, -1);
    }

    public List<Chart> findChartEntities(int maxResults, int firstResult) {
        return findChartEntities(false, maxResults, firstResult);
    }

    private List<Chart> findChartEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Chart.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Chart findChart(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Chart.class, id);
        } finally {
            em.close();
        }
    }

    public int getChartCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Chart> rt = cq.from(Chart.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
