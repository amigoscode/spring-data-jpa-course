package com.example.demo.repositories;

import com.example.demo.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    public List<Student> findAllByFirstName(String firstName);
    public Student findByEmail(String email);

    @Query(value="select s.first_name, s.email, c.country_name from student_table s " +
            "inner join countries c on s.country_id = c.country_id", nativeQuery = true)
    public List<Object> getStudentWithCountry();
}
