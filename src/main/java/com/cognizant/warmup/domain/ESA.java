package com.cognizant.warmup.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "esa")
public class ESA {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "esa_id")
	private Integer id;
}
