package com.bilgeadam.repository;

import com.bilgeadam.entity.PersonEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IPersonRepository extends PagingAndSortingRepository<PersonEntity,Long> {
}
