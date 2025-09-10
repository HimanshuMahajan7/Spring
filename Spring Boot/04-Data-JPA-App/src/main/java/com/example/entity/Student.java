package com.example.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "STUDENT")
public class Student {

    @Id
    private Integer id;
    private String name;

    @Column(name = "student_rank")
    private Long rank;
    private String gender;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdDate;

    @UpdateTimestamp
    @Column(insertable = false)
    private LocalDateTime updatedDate;

    public Student() { }

    public Student(Integer id, String name, Long rank, String gender) {
        this.id = id;
        this.name = name;
        this.rank = rank;
        this.gender = gender;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getRank() {
        return rank;
    }

    public void setRank(Long rank) {
        this.rank = rank;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Student[" + "id=" + id + ", name='" + name + ", rank=" + rank + ", gender='" + gender + ", createdDate=" + createdDate + ", updatedDate=" + updatedDate + ']';
    }
}
