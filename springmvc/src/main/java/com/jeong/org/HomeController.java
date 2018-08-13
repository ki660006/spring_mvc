package com.jeong.org;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		return "home";
	}
	
	@RequestMapping(value = "/javaproject")
	public String javaproject(Locale locale, Model model) {
		return "javaproject";
	}
	
	@RequestMapping(value = "/jspproject")
	public String jspproject(Locale locale, Model model) {
		return "jspproject";
	}
	
	@RequestMapping(value = "/csharp")
	public String csharp(Locale locale, Model model) {
		return "csharp";
	}
	
	@RequestMapping(value = "/profile")
	public String profile(Locale locale, Model model) {
		return "profile";
	}
}
