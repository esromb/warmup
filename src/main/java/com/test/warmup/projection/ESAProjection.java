package com.test.warmup.projection;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

import com.test.warmup.domain.ESA;

@Projection(name = "esaProjection", types = {ESA.class})
public interface ESAProjection {
	
	Integer getId();
	
	@Value("#{target.teamMember}")
	TeamMemberProjection getTeamMember();
	
	String getEsaStatus();
	
	
	Date getAllocationDate();
	
	String getComments();

}
