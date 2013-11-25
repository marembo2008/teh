/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.teh.response.marketdata.controller;

import com.anosym.teh.response.controller.AbstractJpaController;
import com.anosym.teh.response.controller.exceptions.NonexistentEntityException;
import com.anosym.teh.response.marketdata.IntraDayScripInfo;
import com.anosym.teh.response.marketdata.IntraDayScripInfo;
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
public class IntraDayGraphJpaController extends AbstractJpaController<IntraDayScripInfo> implements Serializable {

    public IntraDayGraphJpaController() {
        super(IntraDayScripInfo.class);
    }

    public void destroy(String id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            IntraDayScripInfo securityInfo;
            try {
                securityInfo = em.getReference(IntraDayScripInfo.class, id);
                securityInfo.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The IntraDayScripInfo with id " + id + " no longer exists.", enfe);
            }
            em.remove(securityInfo);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<IntraDayScripInfo> findIntraDayScripInfoEntities() {
        return findIntraDayScripInfoEntities(true, -1, -1);
    }

    public List<IntraDayScripInfo> findIntraDayScripInfoEntities(int maxResults, int firstResult) {
        return findIntraDayScripInfoEntities(false, maxResults, firstResult);
    }

    private List<IntraDayScripInfo> findIntraDayScripInfoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(IntraDayScripInfo.class));
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

    public IntraDayScripInfo findIntraDayScripInfo(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(IntraDayScripInfo.class, id);
        } finally {
            em.close();
        }
    }

    public int getIntraDayScripInfoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<IntraDayScripInfo> rt = cq.from(IntraDayScripInfo.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
