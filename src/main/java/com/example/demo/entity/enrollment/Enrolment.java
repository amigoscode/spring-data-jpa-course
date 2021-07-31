package com.example.demo.entity.enrollment;

import com.example.demo.entity.course.Course;
import com.example.demo.entity.student.Student;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name="Enrolment")
@Table(name ="enrolment")
public class Enrolment {

    @EmbeddedId
    private EnrollmentId enrollmentId;

    @ManyToOne
    @MapsId("studentId")
    @JoinColumn(name = "student_id",
    foreignKey = @ForeignKey(name = "enrolment_student_fk")
    )
    private Student student;

    @ManyToOne
    @MapsId("courseId")
    @JoinColumn(name = "course_id",
            foreignKey = @ForeignKey(name = "enrolment_course_fk")
    )
    private Course course;


    @Column(
            name = "created_at",
            nullable = false,
            columnDefinition = "TIMESTAMP WITHOUT TIME ZONE"
    )
    private LocalDateTime createdAt;

    public Enrolment(Student student, Course course, LocalDateTime createdAt) {
        this.student = student;
        this.course = course;
        this.createdAt=createdAt;
    }

    public Enrolment() {
    }

    public Enrolment(EnrollmentId enrollmentId, Student student, Course course, LocalDateTime createdAt) {
        this.enrollmentId = enrollmentId;
        this.student = student;
        this.course = course;
        this.createdAt=createdAt;
    }

    public EnrollmentId getEnrollmentId() {
        return enrollmentId;
    }

    public void setEnrollmentId(EnrollmentId enrollmentId) {
        this.enrollmentId = enrollmentId;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
