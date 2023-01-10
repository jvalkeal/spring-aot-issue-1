package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import com.example.demo.DemoRegistrar.Holder;

@SpringBootApplication
@Import(DemoRegistrar.class)
public class DemoApplication implements CommandLineRunner {

	private final static Logger log = LoggerFactory.getLogger(DemoApplication.class);

	@Autowired
	Holder holder;

	@Override
	public void run(String... args) throws Exception {
		log.info("HOLDER {}", holder);
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
