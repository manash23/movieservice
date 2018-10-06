package com.stackroute.movieservice;

import com.stackroute.movieservice.domain.Movie;
import com.stackroute.movieservice.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

@SpringBootApplication
public class MovieServiceApplication implements ApplicationListener<ContextRefreshedEvent>,CommandLineRunner {
	@Autowired

    MovieRepository movieRespository;

	@Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
	    Movie movie=new Movie("t3","m99","www.google.com",4,"2015");
		movieRespository.save(movie);

	}

	@Override
	public void run(String... args) throws Exception {
		Movie movie=new Movie("t4","m13","www.google2.com",3,"2010");
		movieRespository.save(movie);

	}



	public static void main(String[] args) {
		SpringApplication.run(MovieServiceApplication.class, args);
	}
}
