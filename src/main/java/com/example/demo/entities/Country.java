package com.example.demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "countries")
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "country_id", nullable = false)
    private Long countryId;

    @Column(name="country_name", nullable = false)
    private String countryName;

//    ignored to avoid a continuous loop where student tries to print country and country tries to print
//    students
    @JsonIgnore
    @OneToMany
    @JoinColumn(name = "country_id")
    private List<Student> students;

    public Country(Long countryId, String countryName) {
        this.countryId = countryId;
        this.countryName = countryName;
    }

    public Country() {
    }

    public Long getCountryId() {
        return countryId;
    }

    public void setCountryId(Long countryId) {
        this.countryId = countryId;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
