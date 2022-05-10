package rbac.jpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import rbac.jpa.entity.Authentication;

public interface AuthenticationDao extends JpaRepository<Authentication, Integer> {
}
