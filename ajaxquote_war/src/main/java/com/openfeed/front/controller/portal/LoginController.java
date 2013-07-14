package com.openfeed.front.controller.portal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * @author sy
 * @author jb
 * 
 */

@Controller
public class LoginController {

	@RequestMapping("/login")
	public String login(HttpServletRequest request, Model model) {
		return "login";
	}
	
	@RequestMapping("/login_error")
	public String loginError(HttpServletRequest request, Model model) {
		model.addAttribute("errorMsg","Username or Password is incorrect");
		return "login";
	}


}
