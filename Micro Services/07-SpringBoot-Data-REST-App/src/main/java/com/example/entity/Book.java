package com.example.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="book")
public class Book {

	@Id
	private Integer id;
	private String name;
	private String price;

}
