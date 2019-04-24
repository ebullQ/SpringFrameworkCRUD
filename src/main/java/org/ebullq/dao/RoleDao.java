package org.ebullq.dao;

import org.ebullq.model.Role;

import java.util.List;

public interface RoleDao {
    List<Role> getAllRoles();
    Role getRoleByName(String role);
}
