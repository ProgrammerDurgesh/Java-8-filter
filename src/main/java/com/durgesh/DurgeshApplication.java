package com.durgesh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
public class DurgeshApplication {

	/*@RequestMapping(value = "/test")
	public static String get()
	{
		return "Okay Tested OKay ";
	}*/
	public static void main(String[] args) {
		SpringApplication.run(DurgeshApplication.class, args);
	}

	
}
