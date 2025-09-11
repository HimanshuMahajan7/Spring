package com.example.repository;

import com.example.entity.NameGenderView;
import com.example.entity.Student;
import com.example.entity.StudentDTO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StudentRepository extends CrudRepository<Student, Integer> {
    List<Student> findByGender(String gender);
    List<Student> findByGenderIsNull();
    List<Student> findByRankGreaterThanEqual(int rank);
    List<Student> findByRankLessThanEqual(int rank);
    List<Student> findByGenderAndRankGreaterThanEqual(String gender, int rank);

    /* Custom Queries */
    /* HQL */
    @Query(value = "from Student")
    List<Student> getStudents();

    /* SQL */
    @Query(value = "SELECT * FROM student", nativeQuery = true)
    List<Student> getAllStudents();

    /* HQL */
    @Query(value = "FROM Student WHERE gender = :gender")
    List<Student> getStudentByGender(String gender);

    /* HQL */
    @Query(value = "FROM Student WHERE gender is null")
    List<Student> getStudentsWhereGenderIsNull();

    /* HQL */
    @Query(value = "FROM Student WHERE rank >= :rank")
    List<Student> getStudentsWhereRankIsGreaterThan(int rank);

    /* HQL */
    @Query(value = "FROM Student WHERE rank <= :rank")
    List<Student> getStudentsWhereRankIsLessThan(int rank);

    /* HQL */
    @Query(value = "FROM Student WHERE gender = :gender AND rank >= :rank")
    List<Student> getStudentsWhereGenderIsAndRankGreaterThan(String gender, int rank);

    /* SQL */
    @Query(value = "select name, gender from student", nativeQuery = true)
    List<Object[]> getRankAndGender();

    /* HQL */
    @Query(value = "select new com.example.entity.StudentDTO(s.name, s.gender) from Student s")
    List<StudentDTO> getRankAndGenderDTOProjection();

    /* SQL */
    @Query(value = "select name, gender from student", nativeQuery = true)
    List<NameGenderView> getRankAndGenderInterfaceBasedProjection();
}
