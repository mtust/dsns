package com.dsns.domain;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;

@Data
@Slf4j
@Entity
@Table(name = "Reports")
public class Reports {

	@Column
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name")
	private String name;
	
	@Lob
	private byte[] file;
	
	@Column(name = "text")
	private String text;
	

}
