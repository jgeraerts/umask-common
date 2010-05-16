package net.umask.common.base.query;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional(readOnly = true)
public class QueryServiceImpl implements QueryService {

    @Autowired
    SessionFactory sessionFactory;

    public <R> R executeQuery(Query<R> query) {
        return query.execute(sessionFactory.getCurrentSession());
    }
}