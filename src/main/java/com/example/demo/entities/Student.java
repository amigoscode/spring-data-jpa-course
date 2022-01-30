package com.example.demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity(name = "student_table")
@Table(
        name = "student_table",
        uniqueConstraints = {
                @UniqueConstraint(name = "student_email_unique", columnNames = "email")
        }
)
public class Student {

    @Id
    @SequenceGenerator(
            name = "student_generator",
            sequenceName =  "student_generator",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "student_generator"
    )
    @JsonIgnore
    @Column(
            name = "id",
            updatable = false
    )
    Long id;

    @Column(
           name = "first_name",
           nullable = false,
           columnDefinition = "TEXT"
    )
    private String firstName;

    @Column(
            name = "last_name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String lastName;

    @Column(
            name = "age",
            nullable = false
    )
    private Integer age;

    @Column(
            name = "email",
            nullable = false,
//            unique = true,
            columnDefinition = "TEXT"
    )
    private String email;

    @Transient
    private String ignore;
//    this field is completely ignored

//    the child is on the left and the parent is on the right
//    many students can have one country
    @ManyToOne
    @JoinColumn(name = "country_id", insertable = false, updatable = false)
    private Country country;

    @Column(name = "country_id")
    private Long countryId;

    @Column(
            name = "field",
            nullable = false,
            columnDefinition = "character varying(10) not null default 'NA'"
    )
    private String field;
//    -> this field is added from the class, and because of ddl-auto=update, has been
//    added to the table.
//    sql - alter table student_table
//       add column field varchar(255)
//    -> column definition is the SQL that will be executed when this col is created
//    alter table student_table
//       add column field character varying(10) not null default 'NA' not null

    public Student(String firstName, String lastName, Integer age, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.email = email;
    }

    public Student(String firstName, String lastName, Integer age, String email, String field, Country country) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.email = email;
        this.field = field;
        this.country = country;
    }

    public Student() {
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Integer getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Long getCountryId() {
        return countryId;
    }

    public void setCountryId(Long countryId) {
        this.countryId = countryId;
    }
}
