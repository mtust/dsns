package com.dsns.domain;


import javax.persistence.*;


@Entity
@Table(name = "UserPhoto")
@lombok.Data
public class UserPhoto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Lob
	private byte[] photo;

}
