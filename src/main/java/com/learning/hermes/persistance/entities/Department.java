package com.learning.hermes.persistance.entities;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "Departmets")
public class Department {

    @Id
    @GeneratedValue
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
    Collection<User> user;

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public Integer getWeightLimit() {
        return weightLimit;
    }

    public void setWeightLimit(Integer weightLimit) {
        this.weightLimit = weightLimit;
    }

    public Collection<User> getUser() {
        return user;
    }

    public void setUser(Collection<User> user) {
        this.user = user;
    }
}