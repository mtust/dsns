package com.dsns.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table
public class StuffDocuments {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "name")
	private String name;
	@Lob
	private byte[] file;

}
