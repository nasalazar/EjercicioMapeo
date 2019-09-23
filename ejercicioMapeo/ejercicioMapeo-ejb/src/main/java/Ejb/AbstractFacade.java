/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejb;

import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author NATHALY
 */
public abstract class AbstractFacade<T> {
    private Class<T> entityClass;
    /**
     * Metodo ya definido en el mapeo
     * @param entityClass 
     */
    public AbstractFacade(Class<T> entityClass) {
        this.entityClass = entityClass;
    }
    /**
     * Metodo ya definido en el mapeo
     * @return 
     */
    protected abstract EntityManager getEntityManager();

    public void create(T entity) {
        getEntityManager().persist(entity);
    }
    /**
     * Metodo ya definido en el mapeo
     * @param entity 
     */
    public void edit(T entity) {
        getEntityManager().merge(entity);
    }
    /**
     * Metodo ya definido en el mapeo
     * @param entity 
     */
    public void remove(T entity) {
        getEntityManager().remove(getEntityManager().merge(entity));
    }
    /**
     * Metodo ya deifinido en el mapeo
     * @param id
     * @return 
     */
    public T find(Object id) {
        return getEntityManager().find(entityClass, id);
    }
    /**
     * Metodo ya definido en el mapeo
     * @return 
     */
    public List<T> findAll() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        return getEntityManager().createQuery(cq).getResultList();
    }
    /**
     * Metodo ya definido en el mapeo
     * @param range
     * @return 
     */
    public List<T> findRange(int[] range) {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        q.setMaxResults(range[1] - range[0] + 1);
        q.setFirstResult(range[0]);
        return q.getResultList();
    }
    /**
     * Metodo del mapeo ya definido
     * @return 
     */
    public int count() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        javax.persistence.criteria.Root<T> rt = cq.from(entityClass);
        cq.select(getEntityManager().getCriteriaBuilder().count(rt));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }
    
}
