package rbac;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import rbac.jpa.service.AccountAuthenticationService;
import rbac.jpa.service.AccountAuthorizationService;
import rbac.jpa.service.AccountService;
import rbac.jpa.service.AuthenticationService;
import rbac.jpa.service.AuthorizationService;

@SpringBootTest
class RbacSpringBootShiroApplicationTests {

	@Autowired
	AccountService accountService;
	@Autowired
	AuthenticationService authenticationService;
	@Autowired
	AuthorizationService authorizationService;
	@Autowired
	AccountAuthorizationService accountAuthorizationService;
	@Autowired
	AccountAuthenticationService accountAuthenticationService;

	@Test
	void contextLoads() {
	}

	@Test
	void createExampleData() {
		accountService.createExamples();
		authenticationService.createExamples();
		authorizationService.createExamples();
		accountAuthenticationService.createExamples();
		accountAuthorizationService.createExamples();
	}

	@Test
	void getAccountAuthorizations() {
		for (int i = 1; i <= 4; i++) {
			accountAuthorizationService.findAuthorizationsByAccountId(i)
					.forEach(a -> System.out.println("author >> " + a.getAuthorization()));
			System.out.println("---");
		}
	}

	@Test
	void accountAuthentication() {
		for (int i = 1; i <= 4; i++) {
			accountAuthenticationService.findAuthenticationsByAccountId(i)
					.forEach(a -> System.out.println("authen >> " + a.getAuthentication()));
		}
	}

}
