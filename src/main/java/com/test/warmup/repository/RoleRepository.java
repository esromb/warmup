package com.test.warmup.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.test.warmup.domain.Role;

@RepositoryRestResource
public interface RoleRepository extends PagingAndSortingRepository<Role, Integer> {

}
