package com.stackroute.movieservice.service;

import com.stackroute.movieservice.domain.Movie;
import com.stackroute.movieservice.exception.MovieAlreadyExistsException;
import com.stackroute.movieservice.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

import static java.lang.Integer.parseInt;

@Service
@Primary
public class MovieServiceImplementation implements MovieService {
    MovieRepository movieRepository;
    @Autowired

    public MovieServiceImplementation(MovieRepository movieRepository) {
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
