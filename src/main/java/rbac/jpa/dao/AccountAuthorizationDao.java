package rbac.jpa.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import rbac.jpa.entity.AccountAuthorization;

public interface AccountAuthorizationDao extends JpaRepository<AccountAuthorization, Integer> {
	List<AccountAuthorization> findByAccountId(Integer accountId);
}
