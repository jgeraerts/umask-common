package net.umask.common.base.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.hibernate.SessionFactory;

import java.io.Serializable;

@org.springframework.stereotype.Repository
public class RepositoryHibernate implements Repository {

    @Autowired
    private SessionFactory sessionFactory;

    @SuppressWarnings({"unchecked"})
    public <T, PK extends Serializable> T get(Class<T> clazz, PK id) {
        return (T) sessionFactory.getCurrentSession().get(clazz, id);
    }

    public void save(Object o) {
        sessionFactory.getCurrentSession().save(o);
    }

    public void remove(Object o) {
        sessionFactory.getCurrentSession().delete(o);
    }
}
