package com.cognizant.warmup.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.cognizant.warmup.domain.ESA;
import com.cognizant.warmup.projection.ESAProjection;

@RepositoryRestResource(excerptProjection = ESAProjection.class, path = "esas", collectionResourceRel ="esas")
public interface ESARepository extends PagingAndSortingRepository<ESA, Integer> {

}
