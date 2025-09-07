package com.example.repository;

import com.example.entity.Student;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StudentRepository extends CrudRepository<Student, Integer> {
    List<Student> findByGender(String gender);
    List<Student> findByGenderIsNull();
    List<Student> findByRankGreaterThanEqual(int rank);
    List<Student> findByRankLessThanEqual(int rank);
    List<Student> findByGenderAndRankGreaterThanEqual(String gender, int rank);
}
