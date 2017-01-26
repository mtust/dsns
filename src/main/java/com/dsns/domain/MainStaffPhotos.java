package com.dsns.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class MainStaffPhotos {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Lob
	private byte[] file;

}
