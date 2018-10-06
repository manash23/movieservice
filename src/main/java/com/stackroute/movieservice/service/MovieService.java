package com.stackroute.movieservice.service;

import com.stackroute.movieservice.domain.Movie;
import com.stackroute.movieservice.exception.MovieAlreadyExistsException;

import java.util.List;

public interface MovieService {
    Movie saveMovie(Movie movie) throws MovieAlreadyExistsException;
    List<Movie> getAllMovies();
    Movie getMovieById(String imdbId);
 Boolean deleteMovieById(String imdbId);
  List<Movie> getMovieByName(String movieTitle);


}
