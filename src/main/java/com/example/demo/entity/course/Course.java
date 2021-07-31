package com.example.demo.entity.course;

import com.example.demo.entity.enrollment.Enrolment;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name="Course")
@Table(name="course")
public class Course {
    @Id
    @SequenceGenerator(
            name= "course_sequence",
            sequenceName = "course_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "course_sequence"
    )

    @Column(
            name="id",
            nullable = false,
            updatable = false
    )

    private Long id;

    @Column(
            name="course_name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String courseName;

    @Column(
            name="department",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String department;


    @OneToMany(
            mappedBy = "course",
            cascade = CascadeType.ALL
    )
    private List<Enrolment> enrolments = new ArrayList<>();


    public Course(String courseName, String department) {
        this.courseName = courseName;
        this.department = department;
    }

    public Course() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }


    public List<Enrolment> getEnrolments() {
        return enrolments;
    }

    public void setEnrolments(List<Enrolment> enrolments) {
        this.enrolments = enrolments;
    }

    public void addEnrolment (Enrolment enrolment){
        if(!enrolments.contains(enrolment)){
            enrolments.add(enrolment);
            //enrolment.setStudent(this);
        }

    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", courseName='" + courseName + '\'' +
                ", department='" + department + '\'' +
                '}';
    }
}
