package com.example.demo.entity.studentIdCard;

import com.example.demo.entity.student.Student;

import javax.persistence.*;

@Entity(name="StudentIdCard")
@Table(
        name="student_id_card",
        uniqueConstraints = {
                @UniqueConstraint(name="student_id_card_unique", columnNames = "card_number")
        }
)
public class StudentIdCard {
    @Id
    @SequenceGenerator(
            name= "student_card_id_sequence",
            sequenceName = "student_card_id_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_card_id_sequence"
    )

    @Column(
            name="id",
            nullable = false,
            updatable = false
    )

    private Long id;

    //default for one to one relationship
    @OneToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    @JoinColumn(
            name = "student_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey
            (
                    name= "student_id_fk"
            )
    )
    private Student student;

    @Column(
            name="card_number",
            nullable = false,
            length = 15
    )
    private String cardNumber;


    public StudentIdCard(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public StudentIdCard() {
    }

    public StudentIdCard(Student student, String cardNumber) {
        this.student = student;
        this.cardNumber = cardNumber;
    }


    public Long getId() {
        return id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public String toString() {
        return "StudentIdCard{" +
                "id=" + id +
                ", student=" + student +
                ", cardNumber='" + cardNumber + '\'' +
                '}';
    }
}
