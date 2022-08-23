package com.jpqlandnativesql.repository;

import com.jpqlandnativesql.entity.Student;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {


    @Query("FROM Student")
    List<Student> findAllStudents(Pageable pageable);

    @Query("SELECT st.firstName,st.lastName FROM Student st")
    List<Object[]> finaAllStudentsPartialData();

    @Query("FROM Student WHERE firstName=:firstName")
    List<Student> findAllStudentByFirstName(@Param("firstName") String firstName);


    @Query("FROM Student where score>:minimumScore and score<:maximumScore")
    List<Student>findStudentsForGivenScore(@Param("minimumScore") int minimumScore, @Param("maximumScore") int maximumScore);

    @Modifying
    @Query("DELETE FROM Student  WHERE firstName=:firstName")
    void deleteStudentsByFirstName(@Param("firstName") String firstName);

}
