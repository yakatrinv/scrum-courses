package dao;

import java.util.List;

/**
 * The Dao interface with crud operations
 * @param <T> entity type
 */
public interface DAO <T>{

    T save(T object);

    T update(T object);

    T findById(T object);

    void delete(T object);

    List<T> findAll(T object);
}
