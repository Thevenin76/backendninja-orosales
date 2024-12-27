package com.udemy.backendninja.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.stereotype.Controller;

import org.springframework.data.authentication.UserCredentials;

@Controller
@RequestMapping("/")
public class LoginController {
	private static final Log LOG = LogFactory.getLog(LoginController.class);

	@GetMapping("/")
	public String redirectToLogin() {
		return "redirect:/login";
	}

	@GetMapping("/login")
	public String showLoginForm(Model model, @RequestParam(name="error", defaultValue="", required=false) String e) {
		model.addAttribute("userCredentials", "UserCredentials userCredential");
		return "login";
	}
	
	@PostMapping("/logincheck")
	public String loginCheck(@ModelAttribute(name="userCredentials") UserCredentials userCredential ) {
		LOG.info("Method: loginCheck() -- PARAMS: " + userCredential.toString() );
		if (userCredential.getUsername().equals("user") && userCredential.getPassword().equals("user")) {
			return "contacts";
		}
		return "redirect:/login?error";
	}
	
}