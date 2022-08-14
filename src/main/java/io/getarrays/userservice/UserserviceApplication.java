package io.getarrays.userservice;

import io.getarrays.userservice.domain.Role;
import io.getarrays.userservice.domain.User;
import io.getarrays.userservice.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class UserserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserserviceApplication.class, args);
	}

	@Bean
	CommandLineRunner run(UserService userService){
		return args->{
		userService.saveRole(new Role(null, "ROLE_USER"));
		userService.saveRole(new Role(null, "ROLE_MANAGER"));
		userService.saveRole(new Role(null, "ROLE_ADMIN"));
		userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));

		userService.saveUser(new User(null,"BoS3eed","Sweed95","1234",new ArrayList<>()));
		userService.saveUser(new User(null,"Hamed","Hamed","1234",new ArrayList<>()));
		userService.saveUser(new User(null,"Ra3yElGln","Ra3yElGln","1234",new ArrayList<>()));
		userService.saveUser(new User(null,"WdS3dnnah","WdS3dnnah","1234",new ArrayList<>()));

		userService.addRole("BoS3eed", "ROLE_SUPER_ADMIN");
		userService.addRole("Hamed", "ROLE_USER");
		userService.addRole("Ra3yElGln", "ROLE_USER");
		userService.addRole("WdS3dnnah", "ROLE_USER");
		};

	}

	@Bean
	PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder(10);
	}
}
