package br.com.plenustech.pesamais;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.plenustech.pesamais.domain.User;
import br.com.plenustech.pesamais.repositories.UserRepository;

@SpringBootApplication
public class ServerPesaMaisApplication implements CommandLineRunner{

	@Autowired
	private UserRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(ServerPesaMaisApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		User user1 = new User(null, "SUPORTE", "1234", "suporte@email.com", true);
		User user2 = new User(null, "ADM", "1234", "adm@email.com", true);
		User user3 = new User(null, "SUPERVIDOR", "1234", "super@email.com", true);
		repository.saveAll(Arrays.asList(user1, user2, user3));
	}

}
