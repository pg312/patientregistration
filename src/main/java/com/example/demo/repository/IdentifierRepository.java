package com.example.demo.repository;

import com.example.demo.model.Identifier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IdentifierRepository extends CrudRepository<Identifier,Long> {
}
