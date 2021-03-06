package com.dsns.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.util.Date;

@Slf4j
@Data
@Entity
@Table(name = "holiday")
public class Holiday {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "typeHoliday")
	private String typeHoliday;

	@Column(name = "holidayPlace")
	private String holidayPlace;

	@JsonFormat(pattern="yyyy-MM-dd")
	@Column(name = "fromDate")
	private Date fromDate;

	@JsonFormat(pattern="yyyy-MM-dd")
	@Column(name = "toDate")
	private Date toDate;

	@Column(name = "description")
	private String description;

}
