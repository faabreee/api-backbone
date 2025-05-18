package com.joinify.backbone;

import com.joinify.backbone.domain.entity.UserDetail;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class BackboneApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackboneApplication.class, args);
	}

}
