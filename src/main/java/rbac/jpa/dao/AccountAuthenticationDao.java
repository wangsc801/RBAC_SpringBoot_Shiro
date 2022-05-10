package rbac.jpa.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import rbac.jpa.entity.AccountAuthentication;

public interface AccountAuthenticationDao extends JpaRepository<AccountAuthentication, Integer> {
	List<AccountAuthentication> findByAccountId(Integer id);
}
