/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.anosym.teh.response.user.controller;

import com.anosym.teh.response.user.UserProfile;
import com.anosym.teh.response.user.controller.exceptions.NonexistentEntityException;
import com.anosym.teh.response.user.controller.exceptions.PreexistingEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author marembo
 */
public class UserProfileJpaController implements Serializable {

    public UserProfileJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(UserProfile userProfile) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(userProfile);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findUserProfile(userProfile.getLoginAccountId()) != null) {
                throw new PreexistingEntityException("UserProfile " + userProfile + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(UserProfile userProfile) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            userProfile = em.merge(userProfile);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = userProfile.getLoginAccountId();
                if (findUserProfile(id) == null) {
                    throw new NonexistentEntityException("The userProfile with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(String id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            UserProfile userProfile;
            try {
                userProfile = em.getReference(UserProfile.class, id);
                userProfile.getLoginAccountId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The userProfile with id " + id + " no longer exists.", enfe);
            }
            em.remove(userProfile);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<UserProfile> findUserProfileEntities() {
        return findUserProfileEntities(true, -1, -1);
    }

    public List<UserProfile> findUserProfileEntities(int maxResults, int firstResult) {
        return findUserProfileEntities(false, maxResults, firstResult);
    }

    private List<UserProfile> findUserProfileEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(UserProfile.class));
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

    public UserProfile findUserProfile(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(UserProfile.class, id);
        } finally {
            em.close();
        }
    }

    public int getUserProfileCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<UserProfile> rt = cq.from(UserProfile.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
