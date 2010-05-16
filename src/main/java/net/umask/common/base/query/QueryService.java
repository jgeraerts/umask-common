package net.umask.common.base.query;

public interface QueryService {

    <R> R executeQuery(Query<R> query);

}
