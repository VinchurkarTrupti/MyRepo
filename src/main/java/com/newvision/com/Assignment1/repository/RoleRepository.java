package com.newvision.com.Assignment1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.newvision.com.Assignment1.persistence.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

}
