package com.example.demo;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}

@RestController
@RequestMapping
class Controller {

	@Value("${hirist.elasticsearch}")
	String elasticString;
	
	@Value("${application.elasticsearch}")
	String elasticApplication;
	
	@GetMapping(value = "/env")
	public String getDataString() {
		
		Properties prop = System.getProperties();
		for (Object key : prop.keySet()) {
			String temp = (key + ": " + prop.getProperty(key.toString()));
			System.out.println(temp);

		}
		
		return "Hirst env: " + elasticString + " || application env : " + elasticApplication;
		
	}
}
