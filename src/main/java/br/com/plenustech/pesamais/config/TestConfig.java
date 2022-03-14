package br.com.plenustech.pesamais.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.plenustech.pesamais.services.DBService;

@Configuration
@Profile("dev")
public class TestConfig {
	
	@Autowired
	private DBService service;
	
	@Value("${spring.jpa.hibernate.ddl-auto}")
	private String strategy;
	
	@Bean
	public boolean instantiateDatabase() {
	
		if(!"create".equals(strategy)) {
			return false;
		}
		
		service.instantiateTesteDatabase();
		return true;
	}

}
