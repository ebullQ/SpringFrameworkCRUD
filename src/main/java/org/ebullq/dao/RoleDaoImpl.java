package org.ebullq.dao;

import org.ebullq.model.Role;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class RoleDaoImpl implements RoleDao {

    @PersistenceContext(unitName = "entityManagerFactory")
    private EntityManager entityManager;

    @Override
    public List<Role> getAllRoles() {
        return entityManager.createQuery("from Role", Role.class).getResultList();
    }

    @Override
    public Role getRoleByName(String name) {
        TypedQuery<Role> q = entityManager.createQuery(
                "select r from Role r where r.name = :name",
                Role.class
        );
        q.setParameter("name", name);
        return q.getResultList().stream().findAny().orElse(null);
    }
}
