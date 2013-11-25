/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.teh.response.marketdata.controller;

import com.anosym.teh.response.controller.AbstractJpaController;
import com.anosym.teh.response.controller.exceptions.NonexistentEntityException;
import com.anosym.teh.response.marketdata.SecurityInfo;
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
public class SecurityInfoJpaController extends AbstractJpaController implements Serializable {

    public SecurityInfoJpaController() {
        super(SecurityInfo.class);
    }

    public void destroy(String id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            SecurityInfo securityInfo;
            try {
                securityInfo = em.getReference(SecurityInfo.class, id);
                securityInfo.getSymbol();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The securityInfo with id " + id + " no longer exists.", enfe);
            }
            em.remove(securityInfo);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<SecurityInfo> findSecurityInfoEntities() {
        return findSecurityInfoEntities(true, -1, -1);
    }

    public List<SecurityInfo> findSecurityInfoEntities(int maxResults, int firstResult) {
        return findSecurityInfoEntities(false, maxResults, firstResult);
    }

    private List<SecurityInfo> findSecurityInfoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(SecurityInfo.class));
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

    public SecurityInfo findSecurityInfo(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(SecurityInfo.class, id);
        } finally {
            em.close();
        }
    }

    public int getSecurityInfoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<SecurityInfo> rt = cq.from(SecurityInfo.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
