package rbac.jpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rbac.jpa.dao.AccountAuthorizationDao;
import rbac.jpa.entity.AccountAuthorization;

@Service
public class AccountAuthorizationService {

	@Autowired
	AccountAuthorizationDao accountAuthorizationDao;

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
}
