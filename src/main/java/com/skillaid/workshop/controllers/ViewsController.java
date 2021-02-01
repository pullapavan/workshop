package com.skillaid.workshop.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/view")
public class ViewsController {

	@GetMapping("{file}")
	public String contactus(@PathVariable(required = false) String file) {
		if (file == null || file.equalsIgnoreCase("")) {
			return "index";
		}
		return file;
	}

}
