package com.test.warmup.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.rest.core.annotation.RestResource;

import com.test.warmup.enums.Level;

@Entity
@Table(name = "role")
public class Role {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "role_id")
	private Integer id;
	
	@RestResource
	@ManyToOne(optional = false)
	@JoinColumn(name = "skill_id")
	private Skill skill;
	
	
	@Enumerated(EnumType.ORDINAL)
	private Level level;
	
	@Enumerated(EnumType.ORDINAL)
	@Column(name = "grade_level")
	private Level gradeLevel;
	
	
	private String location;
	
	@Column(name = "cost_bucket")
	private String costBucket;
	
	@Column(name = "role_status")
	private String roleStatus;
	
	private String geo;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Skill getSkill() {
		return skill;
	}

	public void setSkill(Skill skill) {
		this.skill = skill;
	}

	public Level getLevel() {
		return level;
	}

	public void setLevel(Level level) {
		this.level = level;
	}

	public Level getGradeLevel() {
		return gradeLevel;
	}

	public void setGradeLevel(Level gradeLevel) {
		this.gradeLevel = gradeLevel;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getCostBucket() {
		return costBucket;
	}

	public void setCostBucket(String costBucket) {
		this.costBucket = costBucket;
	}

	public String getRoleStatus() {
		return roleStatus;
	}

	public void setRoleStatus(String roleStatus) {
		this.roleStatus = roleStatus;
	}

	public String getGeo() {
		return geo;
	}

	public void setGeo(String geo) {
		this.geo = geo;
	}
	
	
	
	
	
}
