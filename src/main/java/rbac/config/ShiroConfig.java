package rbac.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import rbac.realm.AccountRealm;

@Configuration
public class ShiroConfig {

	@Bean
	AccountRealm accountRealm() {
		return new AccountRealm();
	}
	
	@Bean
	DefaultWebSecurityManager defaultWebSecurityManager(@Qualifier("accountRealm") AccountRealm accountRealm) {
		DefaultWebSecurityManager manager = new DefaultWebSecurityManager();
		manager.setRealm(accountRealm);
		return manager;
	}

	@Bean
	public ShiroFilterFactoryBean shiroFilterFactoryBean(
			@Qualifier("defaultWebSecurityManager") DefaultWebSecurityManager defaultWebSecurityManager) {
		ShiroFilterFactoryBean factoryBean = new ShiroFilterFactoryBean();
		factoryBean.setSecurityManager(defaultWebSecurityManager);
		factoryBean.setLoginUrl("/login");
		Map<String,String> filterChainDefinition=new HashMap<>();
		filterChainDefinition.put("/", "anon");
		filterChainDefinition.put("/manage", "roles[manager]");
		factoryBean.setFilterChainDefinitionMap(filterChainDefinition);
		return factoryBean;
	}
}
