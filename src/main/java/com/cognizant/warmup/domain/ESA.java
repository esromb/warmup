package com.cognizant.warmup.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.data.rest.core.annotation.RestResource;

@Entity
@Table(name = "esa")
public class ESA {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "esa_id")
	private Integer id;
	
	
	@RestResource
	@OneToOne(optional = false)
	@JoinColumn(name = "member_id")
	private TeamMember teamMember;
	
	
	@Column(name = "esa_status")
	private String esaStatus;
	
	@Column(name = "allocation_date")
	private Date allocationDate;
	
	private String comments;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public TeamMember getTeamMember() {
		return teamMember;
	}

	public void setTeamMember(TeamMember teamMember) {
		this.teamMember = teamMember;
	}

	public String getEsaStatus() {
		return esaStatus;
	}

	public void setEsaStatus(String esaStatus) {
		this.esaStatus = esaStatus;
	}

	public Date getAllocationDate() {
		return allocationDate;
	}

	public void setAllocationDate(Date allocationDate) {
		this.allocationDate = allocationDate;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}
	
	
	
}
