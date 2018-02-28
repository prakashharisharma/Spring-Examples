package com.td.sb.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.td.sb.model.UserRole;

public interface RoleRepository extends JpaRepository<UserRole, Long>{
}
