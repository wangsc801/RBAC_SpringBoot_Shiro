package rbac.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RbacController {
	
	@GetMapping("/")
	public String index() {
		return "index";
	}

	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@PostMapping("/login")
	public ModelAndView login(String username, String password) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("login");
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(username, password);
		try {
			subject.login(token);
			mv.setViewName("manage");
			return mv;
		} catch (UnknownAccountException e) {
			e.printStackTrace();
			mv.addObject("hint", "no such user");
			return mv;
		} catch (IncorrectCredentialsException e) {
			e.printStackTrace();
			mv.addObject("hint", "wrong password");
		}
		return mv;
	}
	
	@GetMapping("/manage")
	public String manage() {
		return "manage";
	}
}
