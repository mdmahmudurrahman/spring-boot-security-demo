package com.start.sboot.security.demoapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {
	@GetMapping("/demos")
	public String showDemoPage() {
		return "demo";
	}
}
