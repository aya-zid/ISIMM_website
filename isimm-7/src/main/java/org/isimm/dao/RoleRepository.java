package org.isimm.dao;

import org.isimm.entities.Role;
import org.isimm.entities.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {

	void deleteByUsername(String username);
  //  Role findByRole(UserRole role);
}