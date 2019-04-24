package org.ebullq.service;

import org.ebullq.model.Role;

import java.util.List;

public interface RoleService {
    List<Role> getAllRoles();
    Role getRoleByName(String role);
}
