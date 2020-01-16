package com.test.warmup.projection;

import org.springframework.data.rest.core.config.Projection;

import com.test.warmup.domain.Role;
import com.test.warmup.domain.Skill;
import com.test.warmup.domain.TeamMember;
import com.test.warmup.enums.Level;

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
