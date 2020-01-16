package com.test.warmup.domain;

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
@Table(name = "ebs")
public class EBS {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ebs_id")
	private Integer id;
	
	@RestResource
	@OneToOne(optional = false)
	@JoinColumn(name = "member_id")
	private TeamMember teamMember;
	
	@Column(name = "submitted_date")
	private Date submittedDate;
	
	@Column(name = "start_date")
	private Date startDate;
	
	@Column(name = "confirmed_date")
	private Date confirmDate;
	
	private String comments;
	
	@Column(name = "racf_id")
	private Integer racfId;
	
	@Column(name = "has_badge")
	private boolean hasBadge;
	
	@Column(name = "has_laptop")
	private boolean hasLaptop;
	
	@Column(name = "orientation")
	private boolean orientation;

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

	public Date getSubmittedDate() {
		return submittedDate;
	}

	public void setSubmittedDate(Date submittedDate) {
		this.submittedDate = submittedDate;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getConfirmDate() {
		return confirmDate;
	}

	public void setConfirmDate(Date confirmDate) {
		this.confirmDate = confirmDate;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public Integer getRacfId() {
		return racfId;
	}

	public void setRacfId(Integer racfId) {
		this.racfId = racfId;
	}

	public boolean isHasBadge() {
		return hasBadge;
	}

	public void setHasBadge(boolean hasBadge) {
		this.hasBadge = hasBadge;
	}

	public boolean isHasLaptop() {
		return hasLaptop;
	}

	public void setHasLaptop(boolean hasLaptop) {
		this.hasLaptop = hasLaptop;
	}

	public boolean isOrientation() {
		return orientation;
	}

	public void setOrientation(boolean orientation) {
		this.orientation = orientation;
	}
	
	
	

}
