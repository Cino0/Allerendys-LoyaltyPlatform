package it.unicam.cs.ids.Allerendys.LoyaltyPlatform;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class LoyaltyPlatformApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoyaltyPlatformApplication.class, args);
	}

}
