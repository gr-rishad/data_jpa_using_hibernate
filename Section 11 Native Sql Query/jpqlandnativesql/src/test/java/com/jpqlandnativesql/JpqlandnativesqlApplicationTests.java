package com.jpqlandnativesql;

import com.jpqlandnativesql.entity.Student;
import com.jpqlandnativesql.repository.StudentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.Rollback;

import javax.transaction.Transactional;
import java.util.List;

@SpringBootTest
class JpqlandnativesqlApplicationTests {

    private StudentRepository studentRepository;

    @Autowired
    public JpqlandnativesqlApplicationTests(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Test
    void contextLoads() {
    }

    @Test
    public void createStudent() {
        Student student = new Student();
        student.setFirstName("John");
        student.setLastName("Ferguson");
        student.setScore(88);

        Student student1 = new Student();
        student1.setFirstName("Bill");
        student1.setLastName("Gates");
        student1.setScore(75);

        studentRepository.save(student);
        studentRepository.save(student1);
    }

    @Test
    public void testFindAllStudents() {
        Pageable pageable = PageRequest.of(0, 2, Sort.Direction.ASC, "id");
        studentRepository.findAllStudents(pageable).forEach(s -> System.out.println(s.getFirstName()));
    }

    @Test
    public void testFindAllStudentsPartial() {
        List<Object[]> partialData = studentRepository.finaAllStudentsPartialData();
        for (Object[] objects : partialData) {
            System.out.println(objects[0]);
            System.out.println(objects[1]);
        }
    }

    @Test
    public void testFirstAllStudentsByFirstName() {
        studentRepository.findAllStudentByFirstName("Bill").forEach(student -> System.out.println(student.getFirstName()));
    }

    @Test
    public void testFindAllStudentsByScores() {
        studentRepository.findStudentsForGivenScore(70, 80).forEach(student -> System.out.println(student.getFirstName()));
    }


    @Test
    @Transactional
    @Rollback(value = false)
    public void testDeleteStudentsByFirstName() {
        studentRepository.deleteStudentsByFirstName("Bill");
    }

    @Test
    public void findAllStudentNQ() {
        studentRepository.findAllStudentNQ();
    }

    @Test
    public void testFindByFirstNameNQ(){
        studentRepository.findAllStudentByFirstName("Bill");
    }

}
