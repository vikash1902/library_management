package com.example.pyramid.repo;

import com.example.pyramid.entity.RoleDetails;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleDetailsRepo extends JpaRepository<RoleDetails, Integer> {
}
