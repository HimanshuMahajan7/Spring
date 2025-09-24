package com.example.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.example.entity.Book;

@Repository
@RepositoryRestResource(path = "books")
public interface BookRepo extends JpaRepository<Book, Integer> {

	List<Book> findByNameContaining(String name);
}
