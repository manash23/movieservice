package com.stackroute.movieservice.controller;

import com.stackroute.movieservice.domain.Movie;
import com.stackroute.movieservice.exception.MovieAlreadyExistsException;
import com.stackroute.movieservice.service.MovieService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/movie")

@Api("Movie application Controller")
public class MovieServiceController {
    @Autowired
    MovieService movieService;

    public MovieServiceController(@Qualifier("Implementation2") MovieService movieService) {
        this.movieService = movieService;
        System.out.println(movieService.getClass().getName()+"  Running!!");
    }


    @PostMapping("/")
    public ResponseEntity<?> saveMovie(@RequestBody Movie movie) {
        ResponseEntity responseEntity;
        try {
            this.movieService.saveMovie(movie);
            responseEntity = new ResponseEntity<String>("successfully created", HttpStatus.CREATED);
        }
        catch(MovieAlreadyExistsException e) {
            responseEntity = new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    @RequestMapping("/")
    public ResponseEntity<?> getAllUsers()  {
        return new ResponseEntity<List<Movie>>(this.movieService.getAllMovies(),HttpStatus.OK);
    }
    @GetMapping(path = "/{id}")
    public ResponseEntity<?> getMovieById(@PathVariable("id") final String id) {

        return new ResponseEntity<Movie>(movieService.getMovieById(id),HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteMovieById(@PathVariable("id") final String id){
        ResponseEntity responseEntity;
        try{movieService.deleteMovieById(id);

        responseEntity = new ResponseEntity<String>("successfully deleted", HttpStatus.CREATED);}
        catch(Exception e) {
            responseEntity = new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
        }
        return responseEntity;

    }


    @PutMapping(path = "/update/{put}")
    public ResponseEntity<?> updateMovie(@PathVariable("put") final String string,@RequestBody Movie movie){
        ResponseEntity responseEntity;
        movie.setImdbId(string);
        try {
            movieService.saveMovie(movie);
            responseEntity = new ResponseEntity<String>("successfully saved", HttpStatus.CREATED);
        }
        catch (MovieAlreadyExistsException e){
            responseEntity = new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
        }
        return responseEntity;
    }
    @GetMapping(path = "/byname/{name}")
    public ResponseEntity<?> getMovieByName(@PathVariable("name") final String name){
        return new ResponseEntity<List>(movieService.getMovieByName(name),HttpStatus.OK);
    }


}
