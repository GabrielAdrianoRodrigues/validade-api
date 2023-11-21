package br.com.thr3r.domain.daos;

import java.util.List;
import java.util.Optional;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Table;
import jakarta.transaction.Transactional;

@Transactional
@SuppressWarnings("unchecked")
public abstract class DAO<T, I> {
    @PersistenceContext
    protected EntityManager em;

    private Class<T> persistenceClass;

    public T save(T entity) {
        em.persist(entity);
        return entity;
    }

    public List<T> saveAll(List<T> entities) {
        entities.forEach(x -> em.persist(x));
        return entities;
    }

    public T update(T entity) {
        return em.merge(entity);        
    }

    public Optional<T> findById(I id) {
        return Optional.of(em.find(persistenceClass, id));
    }

    public void delete(T entity) {
        em.remove(entity);
    }

    public List<T> findAll() {
        return (List<T>) em.createNativeQuery("SELECT * FROM %s".formatted(persistenceClass.getAnnotation(Table.class).name()), persistenceClass).getResultList();
    }
}