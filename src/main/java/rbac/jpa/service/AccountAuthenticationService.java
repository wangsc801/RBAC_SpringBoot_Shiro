package rbac.jpa.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rbac.jpa.dao.AccountAuthenticationDao;
import rbac.jpa.dao.AccountAuthorizationDao;
import rbac.jpa.dao.AuthenticationDao;
import rbac.jpa.dao.AuthorizationDao;
import rbac.jpa.entity.AccountAuthentication;

@Service
public class AccountAuthenticationService {

	@Autowired
	AccountAuthenticationDao accountAuthenticationDao;
	@Autowired
	AuthenticationDao authenticationDao;
	@Autowired
	AuthorizationDao authorizationDao;
	@Autowired
	AccountAuthorizationDao accountAuthorizationDao;

	public void createExamples() {
		// Alice - user
		AccountAuthentication accountAuthen_1 = new AccountAuthentication(1,1,1);
		// Ben - user
		AccountAuthentication accountAuthen_2 = new AccountAuthentication(2,2,1);
		// Chris - manager
		AccountAuthentication accountAuthen_3 = new AccountAuthentication(3,3,2);
		// Dannis - administrator
		AccountAuthentication accountAuthen_4 = new AccountAuthentication(4,4,3);
		accountAuthenticationDao.save(accountAuthen_1);
		accountAuthenticationDao.save(accountAuthen_2);
		accountAuthenticationDao.save(accountAuthen_3);
		accountAuthenticationDao.save(accountAuthen_4);
	}
	
	public List<AccountAuthentication> findByAccountId(Integer id) {
		return accountAuthenticationDao.findByAccountId(id);
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
		accountAuthorizationDao.findByAccountId(accountId).forEach((aa) -> authorIdList.add(aa.getId()));
		List<String> authorList = new ArrayList<>();
		authorIdList
				.forEach((authorId) -> authorList.add(authorizationDao.findById(authorId).get().getAuthorization()));
		return authorList;
	}
}
