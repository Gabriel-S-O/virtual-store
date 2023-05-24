package com.dev.backend.service;

import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.backend.entity.Permission;
import com.dev.backend.repository.PermissionRepository;

@Service
public class PermissionService {

    @Autowired
    private PermissionRepository permissionRepository;

    public List<Permission> findAll() {
        return permissionRepository.findAll();
    }

    public Permission findById(Long id) {
        return permissionRepository.findById(id).get();
    }

    public Permission insert(Permission permission) {
        permission.setCreationDate(new Date());
        Permission newPermission = permissionRepository.saveAndFlush(permission);
        return newPermission;
    }

    public Permission update(Permission permission) {
        permission.setUpdateDate(new Date());
        return permissionRepository.saveAndFlush(permission);
    }

    public void delete(Long id) {
        Permission permission = permissionRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Permission not found."));
        permissionRepository.delete(permission);

    }

}
