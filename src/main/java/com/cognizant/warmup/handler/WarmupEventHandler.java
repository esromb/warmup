package com.cognizant.warmup.handler;

import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.HandleBeforeSave;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;

import com.cognizant.warmup.domain.Role;

import lombok.extern.slf4j.Slf4j;

@RepositoryEventHandler
@Slf4j
public class WarmupEventHandler {
	
	@HandleBeforeCreate
	@HandleBeforeSave
    public void handleRoleBeforeCreate(Role role){
		
		if(role.getSkill() != null) {
			log.info("id {} ", role.getSkill().getId());
		}
    }

}
