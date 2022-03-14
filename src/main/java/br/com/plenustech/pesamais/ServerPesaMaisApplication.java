package br.com.plenustech.pesamais;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ServerPesaMaisApplication implements CommandLineRunner{
	
	public static void main(String[] args) {
		SpringApplication.run(ServerPesaMaisApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
	}

}
