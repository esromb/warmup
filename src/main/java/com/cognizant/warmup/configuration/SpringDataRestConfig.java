package com.cognizant.warmup.configuration;

import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import com.cognizant.warmup.domain.EBS;
import com.cognizant.warmup.domain.ESA;
import com.cognizant.warmup.domain.Role;
import com.cognizant.warmup.domain.Skill;
import com.cognizant.warmup.domain.TeamMember;
import com.cognizant.warmup.domain.User;

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
