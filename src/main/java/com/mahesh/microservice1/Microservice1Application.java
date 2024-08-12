package com.mahesh.microservice1;

import com.mahesh.microservice1.model.entity.MovieData;
import com.mahesh.microservice1.repository.MovieRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class Microservice1Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Microservice1Application.class, args);
	}

	@Autowired
	private MovieRepo movieRepo;

	@Override
	public void run(String... args) throws Exception {
		MovieData movie1 = new MovieData();
		movie1.setMid(1);
		movie1.setMname("Sairat");
		movie1.setMtype("comedy");
		movie1.setMrelease(2016);
		movieRepo.save(movie1);

		MovieData movie2 = new MovieData();
		movie2.setMid(2);
		movie2.setMname("Maharaja");
		movie2.setMtype("Mystry");
		movie2.setMrelease(2024);
		movieRepo.save(movie2);

	}

	@Bean
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}
}
