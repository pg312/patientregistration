package com.example.demo.repository;

import com.example.demo.model.StaffDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StaffRepository extends JpaRepository<StaffDto, Long> {
}
