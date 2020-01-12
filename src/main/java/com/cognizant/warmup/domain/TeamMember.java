package com.cognizant.warmup.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.data.rest.core.annotation.RestResource;

import com.cognizant.warmup.enums.Level;


@Entity
@Table(name = "team_member")
public class TeamMember {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "member_id")
	private Integer id;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Enumerated(EnumType.ORDINAL)
	private Level level;
	
	@Enumerated(EnumType.ORDINAL)
	@Column(name = "grade_level")
	private Level gradeLevel;
	
	@RestResource
	@OneToOne(optional = false)
	@JoinColumn(name = "role_id")
	private Role role;
	
	@RestResource
	@ManyToOne(optional = false)
	@JoinColumn(name = "skill_id")
	private Skill skill;
	
	private String location;
	
	@Column(name = "member_status")
	private String memberStatus;
	
	@Enumerated(EnumType.ORDINAL)
	@Column(name = "training_stage")
	private Level trainingStage;
	
	private String domain;
	
	private String comments;
	
	@Column(name = "employee_id")
	private Integer employeeId;
	
	@Column(name = "racf_id")
	private Integer racfId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firsName) {
		this.firstName = firsName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
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

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Skill getSkill() {
		return skill;
	}

	public void setSkill(Skill skill) {
		this.skill = skill;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getMemberStatus() {
		return memberStatus;
	}

	public void setMemberStatus(String memberStatus) {
		this.memberStatus = memberStatus;
	}

	public Level getTrainingStage() {
		return trainingStage;
	}

	public void setTrainingStage(Level trainingStage) {
		this.trainingStage = trainingStage;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public Integer getRacfId() {
		return racfId;
	}

	public void setRacfId(Integer racfId) {
		this.racfId = racfId;
	}
	
	
	
	
	
}
