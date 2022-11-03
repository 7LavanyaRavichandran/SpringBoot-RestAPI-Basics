package org.rest.RestApiBasics;

import com.sun.swing.internal.plaf.synth.resources.synth_sv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestApiBasicsApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestApiBasicsApplication.class, args);
		System.out.println("Welcome to REST API Project");
	}



}
