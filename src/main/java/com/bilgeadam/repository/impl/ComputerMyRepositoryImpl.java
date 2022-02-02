package com.bilgeadam.repository.impl;

import com.bilgeadam.entity.ComputerEntity;
import com.bilgeadam.repository.IMyRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class ComputerMyRepositoryImpl implements IMyRepository {

    //entityManager
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<ComputerEntity> findComputerPriceMin(double minPrice) {
        String jpql="select c from ComputerEntity c where c.computerPrice >=:key";
        TypedQuery<ComputerEntity> typedQuery=entityManager.createQuery(jpql,ComputerEntity.class);
        typedQuery.setParameter("key",minPrice);
        return typedQuery.getResultList();
    }
}
