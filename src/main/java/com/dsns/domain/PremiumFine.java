package com.dsns.domain;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.util.Date;

@Slf4j
@Data
@Entity
@Table(name = "PremiumFine")
public class PremiumFine {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "premiumFineOrder")
	private String order;

	@Column(name = "deadlines")
	private Date orderDate;

	@Column(name = "serialNumber")
	private String serialNumber; // !!!!!!!!!!!!!!!! STRING?

}
