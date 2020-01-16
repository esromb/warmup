package com.test.warmup.configuration;

import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import com.test.warmup.domain.EBS;
import com.test.warmup.domain.ESA;
import com.test.warmup.domain.Role;
import com.test.warmup.domain.Skill;
import com.test.warmup.domain.TeamMember;
import com.test.warmup.domain.User;

@Component
public class SpringDataRestConfig implements RepositoryRestConfigurer {

  @Override
  public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
    config.setDefaultMediaType(MediaType.APPLICATION_JSON);
    config
        .exposeIdsFor(Role.class, User.class, Skill.class, TeamMember.class,
            ESA.class, EBS.class);
    config.setReturnBodyOnCreate(true);
    config.setReturnBodyOnUpdate(false);
    
  }
}
