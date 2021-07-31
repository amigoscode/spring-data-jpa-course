package com.example.demo;

import com.example.demo.entity.book.Book;
import com.example.demo.entity.course.Course;
import com.example.demo.entity.enrollment.EnrollmentId;
import com.example.demo.entity.enrollment.Enrolment;
import com.example.demo.entity.student.Student;
import com.example.demo.repository.StudentRepository;
import com.example.demo.entity.studentIdCard.StudentIdCard;
import com.example.demo.repository.StudentIdCardRepository;
import com.github.javafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository, StudentIdCardRepository studentIdCardRepository){
        return  args -> {
            //generateStudents(studentIdCardRepository);
            Faker faker = new Faker();
            String firstName = faker.name().firstName();
            String lastName = faker.name().lastName();
            String email = String.format("%s.%s@gmail.com", firstName, lastName);
            Student student = new Student(firstName, lastName, email, faker.number().numberBetween(17, 55));

            student.addBook(new Book("Clean Code", LocalDateTime.now().minusDays(4)));

            student.addBook(new Book("Clean program", LocalDateTime.now()));

            StudentIdCard studentIdCard = new StudentIdCard(student, "12356");

            student.setStudentIdCard(studentIdCard);

            student.addEnrolment(new Enrolment(new EnrollmentId(1L, 1L),
                    student,
                    new Course("Computing", "IT"),
                    LocalDateTime.now()));

            student.addEnrolment(new Enrolment(new EnrollmentId(1L, 2L),
                    student,
                    new Course("Logistics", "Business"),
                    LocalDateTime.now()));

            //student.enrolToCourse(new Course("Computing", "IT"));
            //student.enrolToCourse(new Course("Logistics", "Business"));

            studentRepository.save(student);



            studentRepository.findById(1L).ifPresent(s -> {
                System.out.println("fetch book lazy ...");
                List<Book> books = student.getBooks();
                books.forEach(book ->{
                    System.out.println(
                            s.getFirstName() + " borrowed"  + book.getBookName()
                    );
                });
            });

//            studentIdCardRepository.findById(1L).ifPresent(System.out::println);
//
//            studentRepository.findStudentsAndStudentIdById(1L).ifPresent(System.out::println);



        };

    }

    private void getByPage(StudentRepository studentRepository) {
        PageRequest pageRequest = PageRequest.of(
                0,
                5,
                Sort.by("firstName").ascending()
        );
        Page<Student> page = studentRepository.findAll(pageRequest);
        System.out.println(page);
    }

    private void sorting(StudentRepository studentRepository) {
        Sort sort = Sort.by(Sort.Direction.ASC, "firstName").and(Sort.by("age").descending());
        studentRepository.findAll(sort).forEach(student -> System.out.println(student.getFirstName() + " "+ student.getAge()));
    }

    private void generateStudents(StudentIdCardRepository studentIdCardRepository){
        Faker faker = new Faker();
        for(int i=0; i<4; i++){
            String firstName = faker.name().firstName();
            String lastName = faker.name().lastName();
            String email = String.format("%s.%s@gmail.com", firstName, lastName);
            Student student = new Student(firstName, lastName, email, faker.number().numberBetween(17, 55));
            StudentIdCard studentIdCard = new StudentIdCard(student, "12356"+i);
            studentIdCardRepository.save(studentIdCard);
        }
    }


}
