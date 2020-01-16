package com.test.warmup.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMethod;

import com.test.warmup.domain.TeamMember;

@RepositoryRestResource
@CrossOrigin(origins = "http://localhost:3000",
methods = { RequestMethod.GET,  RequestMethod.OPTIONS, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE },
maxAge = 3600)
public interface TeamMemberRepository extends PagingAndSortingRepository<TeamMember, Integer> {

}
