package rbac.jpa.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rbac.jpa.dao.AccountAuthorizationDao;
import rbac.jpa.dao.AuthorizationDao;
import rbac.jpa.entity.AccountAuthorization;
import rbac.jpa.entity.Authorization;

@Service
public class AccountAuthorizationService {

	@Autowired
	AccountAuthorizationDao accountAuthorizationDao;
	@Autowired
	AuthorizationDao authorizationDao;
	
	public void createExamples() {
		// Alice - user - permissions[login,upload]
		AccountAuthorization accountAuthen_1_1 = new AccountAuthorization(1,1,1);
		AccountAuthorization accountAuthen_1_2 = new AccountAuthorization(2,1,2);
		// Ben - user - permissions[login]
		AccountAuthorization accountAuthen_2 = new AccountAuthorization(3,2,1);
		// Chris - manager  - permissions[login,upload,download_resource]
		AccountAuthorization accountAuthen_3_1 = new AccountAuthorization(4,3,1);
		AccountAuthorization accountAuthen_3_2 = new AccountAuthorization(5,3,2);
		AccountAuthorization accountAuthen_3_3 = new AccountAuthorization(6,3,3);
		// Dannis - administrator permissions[(all)]
		AccountAuthorization accountAuthen_4_1 = new AccountAuthorization(7,4,1);
		AccountAuthorization accountAuthen_4_2 = new AccountAuthorization(8,4,2);
		AccountAuthorization accountAuthen_4_3 = new AccountAuthorization(9,4,3);
		AccountAuthorization accountAuthen_4_4 = new AccountAuthorization(10,4,4);
		accountAuthorizationDao.save(accountAuthen_1_1);
		accountAuthorizationDao.save(accountAuthen_1_2);
		accountAuthorizationDao.save(accountAuthen_2);
		accountAuthorizationDao.save(accountAuthen_3_1);
		accountAuthorizationDao.save(accountAuthen_3_2);
		accountAuthorizationDao.save(accountAuthen_3_3);
		accountAuthorizationDao.save(accountAuthen_4_1);
		accountAuthorizationDao.save(accountAuthen_4_2);
		accountAuthorizationDao.save(accountAuthen_4_3);
		accountAuthorizationDao.save(accountAuthen_4_4);
	}
	
	List<AccountAuthorization> findByAccountId(Integer accountId){
		return accountAuthorizationDao.findByAccountId(accountId);
	}
	
	public List<Authorization> findAuthorizationsByAccountId(Integer accountId) {
		List<Integer> authorIdList = new ArrayList<>();
		accountAuthorizationDao.findByAccountId(accountId).forEach((aa) -> authorIdList.add(aa.getAuthorizationId()));
		List<Authorization> authorList = new ArrayList<>();
		authorIdList
				.forEach((authorId) -> authorList.add(authorizationDao.findById(authorId).get()));
		return authorList;
	}
}
