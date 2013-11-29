/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.teh.response.controller;

import com.anosym.teh.response.controller.exceptions.NonexistentEntityException;
import com.anosym.teh.response.controller.exceptions.PreexistingEntityException;
import com.anosym.utilities.ClassUtils;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Id;
import javax.persistence.Persistence;

/**
 *
 * @author marembo
 */
public abstract class AbstractJpaController<T> {

    private EntityManagerFactory emf;
    private final Class<T> entityClass;
    private int reloadTime;

    protected AbstractJpaController(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    public final EntityManager getEntityManager() {
        if (emf == null || reloadTime % 50 == 0) {
            if (emf != null) {
                emf.close();
                emf = null;
            }
            reloadTime = 0;
            emf = Persistence.createEntityManagerFactory("com.anosym.teh_teh_jar_1.0-SNAPSHOTPU");
        }
        reloadTime++;
        return emf.createEntityManager();
    }

    public T find(Object id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(entityClass, id);
        } finally {
            em.close();
        }
    }

    public void createOrUpdate(T entity) throws Exception {
        Object id = ClassUtils.getFieldValue(entity, Id.class);
        if (id == null || find(id) == null) {
            System.err.println("Creating......................");
            create(entity);
        } else {
            System.err.println("Updating......................");
            edit(entity);
        }
    }

    public void createOrUpdate(List<T> entities) throws Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            for (T entity : entities) {
                Object id = ClassUtils.getFieldValue(entity, Id.class);
                if (id != null) {
                    if (find(id) == null) {
                        System.err.println("Creating......................");
                        em.persist(entity);
                    } else {
                        System.err.println("Updating......................");
                        em.merge(entity);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void create(T entity) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(entity);
            em.getTransaction().commit();
        } catch (Exception ex) {
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(T entity) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.merge(entity);
            em.getTransaction().commit();
        } catch (Exception ex) {
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    protected void log(Throwable e) {
        Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, e);
    }
}
