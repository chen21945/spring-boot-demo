package org.chen.arch.controller;

import org.chen.arch.core.exception.BusinessException;
import org.chen.arch.core.request.Limit;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

	@Limit(size = 10)
	@RequestMapping("h")
	@ResponseBody
	public String hello(){
		return "Hello World!";
	}

	/**
	 * Thymeleaf
	 * @param map
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/h1")
	public String hello(ModelMap map) throws Exception{
		map.addAttribute("data", "test thymeleaf");
		//返回模板名称，默认目录 src/main/resources/templates
		return "hello";
	}
	
	@RequestMapping("/h/error")
	public String helloError() throws Exception{
		throw new BusinessException("出错拉");
	}
	
	@RequestMapping("/h/error1")
	public String helloError1() throws Exception{
		throw new Exception("出错啦");
	}
}
