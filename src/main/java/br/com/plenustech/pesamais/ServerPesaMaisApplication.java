package br.com.plenustech.pesamais;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.plenustech.pesamais.domain.Address;
import br.com.plenustech.pesamais.domain.City;
import br.com.plenustech.pesamais.domain.Person;
import br.com.plenustech.pesamais.domain.State;
import br.com.plenustech.pesamais.domain.User;
import br.com.plenustech.pesamais.domain.enums.TypeAddress;
import br.com.plenustech.pesamais.repositories.AddressRepository;
import br.com.plenustech.pesamais.repositories.CityRepository;
import br.com.plenustech.pesamais.repositories.PersonRepository;
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
	@Autowired
	private PersonRepository personrepo;
	@Autowired
	private AddressRepository addressrepo;
	
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
		
		City city1 = new City(null, "JUINA", state1);
		City city2 = new City(null, "CAMPO GRANDE", state2);
		City city3 = new City(null, "LUIS EDUARDO MAGALHÃES", state3);
		City city4 = new City(null, "UTINGA", state3);
		City city5 = new City(null, "SINOP", state1);
		City city6 = new City(null, "GUARULHOS", state4);

		state1.getCities().addAll(Arrays.asList(city1, city5));
		state2.getCities().addAll(Arrays.asList(city2));
		state3.getCities().addAll(Arrays.asList(city2, city3));
		state4.getCities().addAll(Arrays.asList(city6));
		
		staterepo.saveAll(Arrays.asList(state1, state2, state3, state4));
		cityrepo.saveAll(Arrays.asList(city1, city2, city3, city4, city5, city6));
		
		Person p1 = new Person(null, "MIQUEIAS SANTOS", "MIKAO", "85938693519", "1461129702", "77999419930", "", "MIQUEIAS", "", "mikeiassantos16@gmail.com", "", true, false, true, false, false, true);
		Person p2 = new Person(null, "GRAZIELI ALVES", "GRAZY", "05938693519", "0061129702", "77999215544", "", "GRAZY", "", "grazielialves.020@gmail.com", "", true, false, true, false, false, true);
		
		Address ad1 = new Address(null, "CASA1", TypeAddress.RESIDENCIAL,"RUA IBIPORA", "MODULO 5","70", "APT 03", "78320000", city1, p1);
		Address ad2 = new Address(null, "CASA2", TypeAddress.RESIDENCIAL,"RUA ACRE", "MIMOSO 2","937", "", "47850000", city3, p1);
		Address ad3 = new Address(null, "CASA3", TypeAddress.RESIDENCIAL,"RUA ACRE", "MIMOSO 2","937", "", "47850000", city3, p2);
			
		p1.getAddresses().addAll(Arrays.asList(ad1, ad2));
		p2.getAddresses().addAll(Arrays.asList(ad3));
		
		personrepo.saveAll(Arrays.asList(p1,p2));
		addressrepo.saveAll(Arrays.asList(ad1, ad2, ad3));
	}

}
