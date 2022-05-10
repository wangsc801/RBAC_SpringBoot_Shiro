package rbac.config;

import java.util.Hashtable;
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
		Map<String,String> filterChainDefinition=new Hashtable<>();
		filterChainDefinition.put("/**", "authc");
		filterChainDefinition.put("/", "anon");
		factoryBean.setFilterChainDefinitionMap(filterChainDefinition);
		factoryBean.setLoginUrl("/login");
		return factoryBean;
	}
}
