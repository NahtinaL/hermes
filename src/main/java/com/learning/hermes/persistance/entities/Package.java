package com.learning.hermes.persistance.entities;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Packages")
public class Package {

    @Id
    @Column(name = "id")
    @GeneratedValue
    private Integer id;

    @Column(nullable = false)
    private String ttn;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer cost;

    @Column(nullable = false)
    private Integer weight;

    @Column
    private String fragility;

    @Column
    private Integer fee;

    @Column(nullable = false)
    private String status;

    @ManyToOne
    @JoinColumn(name = "department_from")
    private Department departmentFrom;

    @ManyToOne
    @JoinColumn(name = "department_to")
    private Department departmentTo;

    @Column(nullable = false)
    private String senderPhone;

    @Column(nullable = false)
    private String receiverPhone;

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @Column
    private String deliverDate;

    @Column
    private String receivedDate;

}
