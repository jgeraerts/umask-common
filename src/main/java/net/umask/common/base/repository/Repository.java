package net.umask.common.base.repository;

import java.io.Serializable;

public interface Repository {

    <T, PK extends Serializable> T get(Class<T> clazz, PK id);

    void save(Object o);

    void remove(Object o);

}
