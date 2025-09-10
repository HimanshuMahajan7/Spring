package com.example.repository;

import com.example.entity.Student;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface StudentJpaRepository extends JpaRepository<Student, Integer> {

    @Modifying
    @Transactional
    @Query("delete from Student where id = :studentId")
    void deleteStudent(Integer studentId);

    @Modifying
    @Transactional
    @Query("update Student set gender = :gender where id = :studentId")
    void updateStudent(Integer studentId, String gender);

    /* Inserting using HQL is not possible in Data JPA */
    /*
    @Modifying
    @Transactional
    @Query("insert into Student(id, name, gender, student_rank) values(:id, :name, :gender, :rank)")
    void insertStudent(Integer id, String name, String gender, Long rank);
    */

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO STUDENT(id, name, gender, student_rank) values(:id, :name, :gender, :rank);", nativeQuery = true)
    void insertStudent(Integer id, String name, String gender, Long rank);
}
