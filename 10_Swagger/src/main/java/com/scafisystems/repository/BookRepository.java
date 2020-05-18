package com.scafisystems.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.scafisystems.data.model.Book;


@Repository
public interface BookRepository extends JpaRepository<Book, Long>{

}