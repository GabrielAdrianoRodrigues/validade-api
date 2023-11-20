package br.com.thr3team.domain.daos;

import java.util.List;
import java.util.Optional;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Transactional
public abstract class DAO<T, I> {
    @PersistenceContext
    protected EntityManager em;

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

    public Optional<T> findById(Class<T> clazz, I id) {
        return Optional.of(em.find(clazz, id));
    }
}