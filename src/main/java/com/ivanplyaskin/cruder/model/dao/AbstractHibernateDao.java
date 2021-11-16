package com.ivanplyaskin.cruder.model.dao;

import com.google.common.base.Preconditions;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@SuppressWarnings("unchecked")
public abstract class AbstractHibernateDao<T> {

    private Class<T> clazz;
    @Autowired
    protected SessionFactory sessionFactory;

    protected AbstractHibernateDao(Class<T> clazz) {
        setClazz(clazz);
    }

    protected final void setClazz(final Class<T> clazz) {
        this.clazz = Preconditions.checkNotNull(clazz);
    }

    public T findOne(final long id) {
        return getCurrentSession().get(clazz, id);
    }

    public List<T> findAll() {
        return getCurrentSession().createQuery("from " + clazz.getName()).list();
    }

    public T create(final T entity) {
        Preconditions.checkNotNull(entity);
        getCurrentSession().saveOrUpdate(entity);
        return entity;
    }

    public T update(final T entity) {
        Preconditions.checkNotNull(entity);
        return (T) getCurrentSession().merge(entity);
    }

    public void delete(final T entity) {
        Preconditions.checkNotNull(entity);
        getCurrentSession().delete(entity);
    }

    public void deleteById(final long entityId) {
        final T entity = findOne(entityId);
        Preconditions.checkState(entity != null);
        delete(entity);
    }

    protected Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
}