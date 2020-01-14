package com.cognizant.warmup.projection;

import org.springframework.data.rest.core.config.Projection;

import com.cognizant.warmup.domain.Role;
import com.cognizant.warmup.domain.Skill;
import com.cognizant.warmup.domain.TeamMember;
import com.cognizant.warmup.enums.Level;

@Projection(name = "teamMemberProjection", types = {TeamMember.class})
public interface TeamMemberProjection {
	
	Level getTrainingStage();
	
	Integer getId();
	
	String getFirstName();
	
	String getLastName();
	
	Level getLevel();
	
	Level getGradeLevel();
	
	Role getRole();
	
	Skill getSkill();
	
	String getLocation();

}
