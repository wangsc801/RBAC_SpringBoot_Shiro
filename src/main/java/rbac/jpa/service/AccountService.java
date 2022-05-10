package rbac.jpa.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rbac.jpa.dao.AccountAuthenticationDao;
import rbac.jpa.dao.AccountAuthorizationDao;
import rbac.jpa.dao.AccountDao;
import rbac.jpa.dao.AuthenticationDao;
import rbac.jpa.dao.AuthorizationDao;
import rbac.jpa.entity.Account;

@Service
public class AccountService {
	@Autowired
	AccountDao accountDao;
	@Autowired
	AccountAuthorizationDao accountAuthorizationDao;
	@Autowired
	AccountAuthenticationDao accountAuthenticationDao;
	@Autowired
	AuthenticationDao authenticationDao;
	@Autowired
	AuthorizationDao authorizationDao;

	public void createExamples() {
		// Alice
		Account account_1 = new Account();
		account_1.setUsername("Alice");
		account_1.setNickname("super_Alice");
		account_1.setPassword("alice123");
		// Ben
		Account account_2 = new Account();
		account_2.setUsername("Ben");
		account_2.setNickname("strong_Ben");
		account_2.setPassword("ben123");
		// Chris
		Account account_3 = new Account();
		account_3.setUsername("Chris");
		account_3.setNickname("clever_Chris");
		account_3.setPassword("chris123");
		// Dannis
		Account account_4 = new Account();
		account_4.setUsername("Dannis");
		account_4.setNickname("industrious_dannis");
		account_4.setPassword("dannis123");
		// DAO save
		accountDao.save(account_1);
		accountDao.save(account_2);
		accountDao.save(account_3);
		accountDao.save(account_4);
	}

	public Account findByUsername(String username) {
		return accountDao.findByUsername(username);
	}
	
	public List<String> findAuthenticationsById(Integer id) {
		List<Integer> authenIdList = new ArrayList<>();
		accountAuthenticationDao.findByAccountId(id).forEach((aa) -> authenIdList.add(aa.getAccountId()));
		List<String> authenList = new ArrayList<>();
		authenIdList
				.forEach((authenId) -> authenList.add(authenticationDao.findById(authenId).get().getAuthentication()));
		return authenList;
	}

	public List<String> findAuthorizationsById(Integer accountId) {
		List<Integer> authorIdList = new ArrayList<>();
		accountAuthorizationDao.findByAccountId(accountId).forEach((aa) -> authorIdList.add(aa.getAuthorizationId()));
		//accountAuthorizationDao.findByAccountId(accountId).forEach((aa) -> System.out.println("=>> "+aa.getAuthorizationId()));
		List<String> authorList = new ArrayList<>();
		authorIdList
				.forEach((authorId) -> authorList.add(authorizationDao.findById(authorId).get().getAuthorization()));
		return authorList;
	}
}
