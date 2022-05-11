package rbac.realm;

import java.util.HashSet;
import java.util.Set;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import rbac.jpa.entity.Account;
import rbac.jpa.service.AccountAuthenticationService;
import rbac.jpa.service.AccountAuthorizationService;
import rbac.jpa.service.AccountService;

public class AccountRealm extends AuthorizingRealm {

	@Autowired
	AccountService accountService;
	@Autowired
	AccountAuthorizationService accountAuthorizationService;
	@Autowired
	AccountAuthenticationService accountAuthenticationService;

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		Subject subject = SecurityUtils.getSubject();
		Account account = (Account) subject.getPrincipal();
		System.out.println("\n--- ---\nRealm [account principals] "+account.toString());
		// add roles to SimpleAuthorizationInfo
		Set<String> roles = new HashSet<>();
		accountAuthenticationService.findAuthenticationsByAccountId(account.getId())
				.forEach(role -> roles.add(role.getAuthentication()));
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo(roles);
		// add permissions to SimpleAuthorizationInfo
		Set<String> perms = new HashSet<>();
		accountAuthorizationService.findAuthorizationsByAccountId(account.getId())
				.forEach(perm -> perms.add(perm.getAuthorization()));
		roles.forEach(role->System.out.println("Realm [role] -> "+role));
		perms.forEach(perm->System.out.println("Realm [perm] ---> "+perm));
		System.out.println("=== === ===");
		info.addStringPermissions(perms);
		return info;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;
		Account account = accountService.findByUsername(usernamePasswordToken.getUsername());
		if (account != null) {
			return new SimpleAuthenticationInfo(account, account.getPassword(), getName());
		}
		return null;
	}

}
