package com.test.warmup.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.test.warmup.domain.Skill;

@RepositoryRestResource
public interface SkillRepository extends PagingAndSortingRepository<Skill, Integer> {

}
