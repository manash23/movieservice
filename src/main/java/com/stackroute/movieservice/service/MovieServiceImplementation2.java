package com.stackroute.movieservice.service;

import com.stackroute.movieservice.domain.Movie;
import com.stackroute.movieservice.exception.MovieAlreadyExistsException;
import com.stackroute.movieservice.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("Implementation2")
public class MovieServiceImplementation2 implements MovieService {

    @Autowired
    MovieRepository movieRepository;


    public MovieServiceImplementation2(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }
    @Override
    public Movie saveMovie(Movie movie) throws MovieAlreadyExistsException {
        if(movieRepository.existsById(movie.getImdbId())){
            throw new MovieAlreadyExistsException("Movie already exists");
        }
        Movie movie1=new Movie();
        movie1=movieRepository.save(movie);
        return movie1;
    }
    @Override
    public List<Movie> getAllMovies(){
        return movieRepository.findAll();
    }
    @Override
    public Movie getMovieById(String imdbId){
        return movieRepository.findById(imdbId).get();
    }
    @Override
    public Boolean deleteMovieById(String imdbId){
        movieRepository.deleteById(imdbId);
        return true;

    }
    @Override
    public List<Movie> getMovieByName(String movieTitle){
        return movieRepository.getBymovieTitle(movieTitle);
    }


}
