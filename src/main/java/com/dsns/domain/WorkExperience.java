package com.dsns.domain;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.util.Date;

@Slf4j
@Data
@Entity
@Table(name = "WorkExperience")
public class WorkExperience {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "name")
    private String name;
	
	@Column(name = "fromDate")
	private Date fromDate;
	
	@Column(name = "toDate")
	private Date toDate;
	
}
