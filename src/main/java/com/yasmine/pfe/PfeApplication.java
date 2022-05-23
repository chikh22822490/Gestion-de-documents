package com.yasmine.pfe;

import javax.annotation.Resource;

import com.yasmine.pfe.services.interfaces.DocumentService;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PfeApplication implements CommandLineRunner{

	@Resource
	DocumentService documentUtilService;
	public static void main(String[] args) {
		SpringApplication.run(PfeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		documentUtilService.init();
	}

}
