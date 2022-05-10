package rbac.jpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rbac.jpa.dao.AuthorizationDao;
import rbac.jpa.entity.Authorization;

@Service
public class AuthorizationService {

	@Autowired
	AuthorizationDao authorizationDao;

	public void createExamples() {
		Authorization author_1 = new Authorization(1, "login");
		Authorization author_2 = new Authorization(2, "upload");
		Authorization author_3 = new Authorization(3, "download_resource");
		Authorization author_4 = new Authorization(4, "delete_account");
		authorizationDao.save(author_1);
		authorizationDao.save(author_2);
		authorizationDao.save(author_3);
		authorizationDao.save(author_4);
	}
}
