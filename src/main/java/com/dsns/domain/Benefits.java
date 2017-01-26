package com.dsns.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.util.Date;

@Slf4j
@Data
@Entity
@Table(name = "benefits")
public class Benefits {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "fromDate")
	private Date fromDate;

	@JsonFormat(pattern="yyyy-MM-dd")
	@Column(name = "toDate")
	private Date toDate;

	@Column(name = "benefitOrder")
	private String order;

	@JsonFormat(pattern="yyyy-MM-dd")
	@Column(name = "orderDate")
	private Date orderDate;

	@Column(name = "certification")
	private String certification;

	// пільгова вислуга
	@Column(name = "privilege")
	private String privilege;

	@Column(name = "actsAndComments")//????????????????
	private String actsAndComments;

	@Column(name = "otherInfo")
	private String otherInfo;

}
