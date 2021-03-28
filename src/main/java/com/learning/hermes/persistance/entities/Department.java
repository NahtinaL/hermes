package com.learning.hermes.persistance.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;

@Data
@NoArgsConstructor
@Entity
@Table(name = "departments")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer departmentId;

    @Column
    private String city;

    @Column(nullable = false)
    private Integer number;

    @Column(nullable = false)
    private String adress;

    @Column(nullable = false)
    private Integer weightLimit;

    @OneToMany(mappedBy = "department")
    Collection<UserEntity> user;

}