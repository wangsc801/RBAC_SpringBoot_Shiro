package rbac.jpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import rbac.jpa.entity.Authorization;

public interface AuthorizationDao extends JpaRepository<Authorization,Integer>{
}
