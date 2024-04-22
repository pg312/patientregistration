package com.example.demo.repository;

import com.example.demo.model.Identifier;
import com.example.demo.model.Patient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface IdentifierRepository extends CrudRepository<Identifier,Long> {
}
