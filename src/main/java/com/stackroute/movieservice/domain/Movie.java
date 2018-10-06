package com.stackroute.movieservice.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Movie {
    @Id
    String imdbId;
    String movieTitle;
    String posterUrl;
     float rating;
    String yearOfRelease;

    public Movie(String imdbId, String movieTitle, String posterUrl, float rating, String yearOfRelease) {
        this.imdbId = imdbId;
        this.movieTitle = movieTitle;
        this.posterUrl = posterUrl;
        this.rating = rating;
        this.yearOfRelease = yearOfRelease;
    }

    public Movie() {
    }

    public String getImdbId() {
        return imdbId;
    }

    public void setImdbId(String imdbId) {
        this.imdbId = imdbId;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public String getPosterUrl() {
        return posterUrl;
    }

    public void setPosterUrl(String posterUrl) {
        this.posterUrl = posterUrl;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getYearOfRelease() {
        return yearOfRelease;
    }

    public void setYearOfRelease(String yearOfRelease) {
        this.yearOfRelease = yearOfRelease;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "imdbId='" + imdbId + '\'' +
                ", movieTitle='" + movieTitle + '\'' +
                ", posterUrl='" + posterUrl + '\'' +
                ", rating=" + rating +
                ", yearOfRelease='" + yearOfRelease + '\'' +
                '}';
    }
}
