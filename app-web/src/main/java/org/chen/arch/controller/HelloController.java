package org.chen.arch.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
	
	@RequestMapping("h")
	@ResponseBody
	public String hello(){
		return "Hello World!";
	}

	/**
	 * Thymeleaf
	 * @param map
	 * @return
	 */
	@RequestMapping("/h1")
	public String hello(ModelMap map){
		map.addAttribute("data", "test thymeleaf");
		//返回模板名称，默认目录 src/main/resources/templates
		return "hello";
	}
}
