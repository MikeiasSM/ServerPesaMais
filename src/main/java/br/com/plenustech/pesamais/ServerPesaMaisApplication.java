package br.com.plenustech.pesamais;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.plenustech.pesamais.domain.City;
import br.com.plenustech.pesamais.domain.State;
import br.com.plenustech.pesamais.domain.User;
import br.com.plenustech.pesamais.repositories.CityRepository;
import br.com.plenustech.pesamais.repositories.StateRepository;
import br.com.plenustech.pesamais.repositories.UserRepository;

@SpringBootApplication
public class ServerPesaMaisApplication implements CommandLineRunner{

	@Autowired
	private UserRepository userrepo;
	@Autowired
	private StateRepository staterepo;
	@Autowired
	private CityRepository cityrepo;
	
	public static void main(String[] args) {
		SpringApplication.run(ServerPesaMaisApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		User user1 = new User(null, "SUPORTE", "1234", "suporte@email.com", true);
		User user2 = new User(null, "ADM", "1234", "adm@email.com", true);
		User user3 = new User(null, "SUPERVIDOR", "1234", "super@email.com", true);
		userrepo.saveAll(Arrays.asList(user1, user2, user3));
		
		State state1 = new State(null, "MATO GROSSO", "MT");
		State state2 = new State(null, "MATO GROSSO DO SUL", "MS");
		State state3 = new State(null, "BAHIA", "BA");
		State state4 = new State(null, "SÃO PAULO", "SP");
		staterepo.saveAll(Arrays.asList(state1, state2, state3, state4));
		
		City city1 = new City(null, "JUINA", state1);
		City city2 = new City(null, "CAMPO GRANDE", state2);
		City city3 = new City(null, "LUIS EDUARDO MAGALHÃES", state3);
		City city4 = new City(null, "UTINGA", state3);
		City city5 = new City(null, "SINOP", state1);
		cityrepo.saveAll(Arrays.asList(city1, city2, city3, city4, city5));
	}

}
