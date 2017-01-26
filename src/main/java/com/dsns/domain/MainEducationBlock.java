package com.dsns.domain;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Slf4j
@Entity
@Table(name = "mainEducationBlock")
public class MainEducationBlock implements Serializable{
	
	@Column
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "educationalLevel")
    private String educationalLevel;// Освітний рівень??

    @Column(name = "school")
    private String school;

    @Column(name = "educationLevel")
    private String educationQualificationLevel;// Освітньо-кваліфікаційний рівень??

    @Column(name = "qualification")
    private String qualification;

    @Column(name = "specialty")
    private String specialty;

    @Column(name = "SeriesAndNumberOfDiploma")
    private String seriesAndNumberOfDiploma;


}
