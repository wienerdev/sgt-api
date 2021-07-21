package br.com.basis.sgt2;

import br.com.basis.sgt2.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import br.com.basis.sgt2.repositories.UserRepository;


@SpringBootApplication
public class Sgt2Application implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(Sgt2Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		User user1 = new User(1L,"Caio", "agronomocardoso@gmail.com");
		User user2 = new User(2L, "Osorio", "osorio21@gmail.com");

	userRepository.save(user1);
	userRepository.save(user2);
	}
}
