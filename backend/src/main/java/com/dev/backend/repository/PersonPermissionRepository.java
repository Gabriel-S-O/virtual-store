package com.dev.backend.repository;

import com.dev.backend.entity.PersonPermission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonPermissionRepository extends JpaRepository<PersonPermission, Long> {
}
