package org.chen.arch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableAutoConfiguration
@RestController
public class HomeController {

	
	@RequestMapping("/hello")
	public String hello(){
		return "Hello World!";
	}
	
	public static void main(String[] args) {
		SpringApplication.run(HomeController.class, "--server.port=8081");
	}
}
