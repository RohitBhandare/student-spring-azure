package com.example.demo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RepositoryRestResource(collectionResourceRel = "students", path = "students")
public interface StudentDB extends JpaRepository<Students, Integer> {
    Students findByRoll(int i);
    Students deleteByRoll(int i);
}


