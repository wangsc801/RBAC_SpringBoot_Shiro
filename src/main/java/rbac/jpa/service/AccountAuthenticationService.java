package rbac.jpa.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rbac.jpa.dao.AccountAuthenticationDao;
import rbac.jpa.dao.AuthenticationDao;
import rbac.jpa.entity.AccountAuthentication;
import rbac.jpa.entity.Authentication;

@Service
public class AccountAuthenticationService {

	@Autowired
	AccountAuthenticationDao accountAuthenticationDao;
	@Autowired
	AuthenticationDao authenticationDao;

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
	

	public List<Authentication> findAuthenticationsByAccountId(Integer accoundId) {
		List<Integer> authenIdList = new ArrayList<>();
		accountAuthenticationDao.findByAccountId(accoundId).forEach(aa -> authenIdList.add(aa.getAuthenticationId()));
		List<Authentication> authenList = new ArrayList<>();
		authenIdList.forEach(id -> authenList.add(authenticationDao.findById(id).get()));
		return authenList;
	}
}
