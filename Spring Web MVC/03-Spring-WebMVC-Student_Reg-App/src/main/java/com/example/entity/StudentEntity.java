package com.example.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class StudentEntity {

	@Id
	@GeneratedValue
	private Integer studentId;
	private String name;
	private String email;
	private String gender;
	private String course;
	private String timings;

	public Integer getStudentId() {
		return studentId;
	}
	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public String getTimings() {
		return timings;
	}
	public void setTimings(String timings) {
		this.timings = timings;
	}

	@Override
	public String toString() {
		return "StudentEntity [studentId=" + studentId + ", name=" + name + ", email=" + email + ", gender=" + gender
				+ ", course=" + course + ", timings=" + timings + "]";
	}

}
