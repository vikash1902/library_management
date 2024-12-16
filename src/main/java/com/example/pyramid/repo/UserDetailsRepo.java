package com.example.pyramid.repo;

import com.example.pyramid.entity.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDetailsRepo extends JpaRepository<UserDetails,String> {
}
