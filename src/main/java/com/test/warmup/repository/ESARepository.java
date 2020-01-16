package com.test.warmup.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.test.warmup.domain.ESA;
import com.test.warmup.projection.ESAProjection;

@RepositoryRestResource(excerptProjection = ESAProjection.class, path = "esas", collectionResourceRel ="esas")
public interface ESARepository extends PagingAndSortingRepository<ESA, Integer> {

}
