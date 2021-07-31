package com.example.demo.repository;

import com.example.demo.entity.student.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    @Query("SELECT s FROM Student s WHERE s.email = ?1")
    Optional<Student> findStudentByEmail(String email);
    @Query("SELECT s FROM Student s WHERE s.firstName = ?1 and s.age = ?2")
    List<Student> findStudentsByFirstNameEqualsAndAgeEquals(String firstname, Integer age);
    @Query("SELECT s FROM Student s WHERE s.age>=?1")
    Optional<List<Student>> findAllStudentWithAgeGreaterThanInput(Integer age);
   // @Query("SELECT s FROM Student s join StudentIdCard sic on s.id = ?1")
    Optional<Student> findStudentsAndStudentIdById(Long id);

    //To update or delete
    @Transactional
    @Modifying
    @Query("DELETE FROM Student u WHERE u.id = ?1")
    int deleteStudentById(Long id);


}
