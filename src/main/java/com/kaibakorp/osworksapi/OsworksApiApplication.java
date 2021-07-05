package com.kaibakorp.osworksapi;

import com.kaibakorp.osworksapi.business.ClienteService;
import com.kaibakorp.osworksapi.controler.ClienteController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OsworksApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(OsworksApiApplication.class, args);
	}
}
