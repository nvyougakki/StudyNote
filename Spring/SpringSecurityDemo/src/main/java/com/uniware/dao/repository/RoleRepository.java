package com.uniware.dao.repository;

import com.uniware.bean.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface RoleRepository extends JpaRepository<Role, Long> {
}
