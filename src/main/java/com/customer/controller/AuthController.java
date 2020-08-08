package com.customer.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.customer.profileDTO.ProfileDTO;
import com.customer.service.ProfileService;

@Controller
public class AuthController {
	@Autowired
	private ProfileService profileService;

	@GetMapping({ "/", "/auth" })
	public String showLogin() {
		return "login";
	}

	@PostMapping({ "/", "/auth" })
	public String AuthServlet(@RequestParam("username") String username, @RequestParam("password") String password,
			Model model, HttpSession session) {

		ProfileDTO profileDTO = profileService.login(username, password);
		System.out.println(username+password);
		if (profileDTO != null) {

			session.setAttribute("userData", profileDTO);
			return "dashboard";
		} else {
			model.addAttribute("msg", "Incorrect Username/Password");
			return "login";
		}
	}

	@GetMapping("/logout")

	public String logout(HttpSession session, Model model) {
		if (session != null) {
			session.invalidate();
		}
		model.addAttribute("msg", "User Logged Out");
		return "login";
	}

	@GetMapping("/resetpw")
	public String resetPwPage() {
		return "resetpw";
	}

	@PostMapping("/resetpw")
	public String resetPw(@RequestParam("username") String usernameEmail, Model model) {

		String pw = profileService.resetpw(usernameEmail);

		if (pw.length() != 0) {
			model.addAttribute("reset", "Your password is " + pw);
		} else {
			model.addAttribute("msg", "Username not found");
		}
		return "resetpw";

	}
}
