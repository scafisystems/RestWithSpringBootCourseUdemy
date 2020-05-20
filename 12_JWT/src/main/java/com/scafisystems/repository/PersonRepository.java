package com.scafisystems.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.scafisystems.data.model.Person;


@Repository
public interface PersonRepository extends JpaRepository<Person, Long>{

}