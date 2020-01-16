package com.test.warmup.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.test.warmup.domain.EBS;

@RepositoryRestResource(path = "ebses", collectionResourceRel = "ebses")
public interface EBSRepository extends PagingAndSortingRepository<EBS, Integer> {

}
