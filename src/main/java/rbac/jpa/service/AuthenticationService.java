package rbac.jpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rbac.jpa.dao.AuthenticationDao;
import rbac.jpa.entity.Authentication;

@Service
public class AuthenticationService {

	@Autowired
	AuthenticationDao authenticationDao;

	public void createExamples() {
		Authentication authen_1 = new Authentication(1, "user");
		Authentication authen_2 = new Authentication(2, "manager");
		Authentication authen_3 = new Authentication(3, "administrator");
		authenticationDao.save(authen_1);
		authenticationDao.save(authen_2);
		authenticationDao.save(authen_3);
	}
}
