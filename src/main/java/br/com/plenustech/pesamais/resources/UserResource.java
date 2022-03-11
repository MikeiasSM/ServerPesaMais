package br.com.plenustech.pesamais.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.plenustech.pesamais.domain.User;

@RestController
@RequestMapping(value="/users")
public class UserResource {

	@RequestMapping(method = RequestMethod.GET)
	public List<User> listing() {
		
		User user1 = new User(1, "Miqueias", "adm123", "mikeiassantos16@gmail.com", true);
		User user2 = new User(2, "Dilan", "adm123", "dilan@gmail.com", true);
		
		List<User> list = new ArrayList<User>();
		list.add(user1);
		list.add(user2);
		
		return list;
	}
}
