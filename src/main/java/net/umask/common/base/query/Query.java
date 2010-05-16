package net.umask.common.base.query;

import org.hibernate.Session;


public interface Query<R> {

    R execute(Session session);

}
