package com.test.warmup.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.test.warmup.domain.User;

@RepositoryRestResource
public interface UserRepository extends PagingAndSortingRepository<User, Integer> {
	
	public User findByUsernameAndPassword(String username, String password);

}
