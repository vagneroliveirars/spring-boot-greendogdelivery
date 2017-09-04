package com.boaglio.casadocodigo.greendogdelivery.controller;

import java.util.Properties;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller 	
@RequestMapping("/")
public class IndexController {
	
	@Autowired
	private Environment environment;

	@GetMapping("/")
	public String index() {
		return "index";
	}

	@GetMapping("/ambiente")
	public String ambiente() {
		return "ambiente";
	}

	@GetMapping("properties")
	@ResponseBody
	Properties properties() {
		return System.getProperties();
	}

	@GetMapping("/delivery")
	public String delivery() {
		return "delivery/index";
	}

	@GetMapping("/profile")
	@ResponseBody
	public String[] profile() {
		return this.environment.getActiveProfiles();
	}

	@GetMapping("/server")
	@ResponseBody
	public String server(HttpServletRequest request) {
		return request.getServerName() + ":" + request.getServerPort();
	}

}
