package rbac.jpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import rbac.jpa.entity.Account;

public interface AccountDao extends JpaRepository<Account,Integer>{
	Account findByUsername(String username);
}
