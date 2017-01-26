package com.dsns.domain.nominallyJobBooks;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by mtustanovskyy on 1/15/17.
 */

@Data
@Entity
public class Worker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "stateNumber")
    private String stateNumber;

    @Column(name = "position")
    private String position;

    @Column
    private String SPK;

    @Column
    private String specialRank;

    @Column
    private String firstName;
    @Column
    private String lastName;
    @Column
    private String fatherName;
    @Column
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date orderDate;
    @Column
    private String orderNumber;


}
