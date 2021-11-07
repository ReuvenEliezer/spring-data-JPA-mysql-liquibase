package com.liquibase.repositories;

import com.liquibase.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

//@Repository
public interface BookDao extends JpaRepository<Book, Long> {
    @Query("SELECT u FROM Book u WHERE u.name = ?1")
    Book getByName(String bookName);
}
