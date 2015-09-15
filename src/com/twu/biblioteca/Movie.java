/*Movie that has movie name, director, year and rating which is formatted in column format*/
package com.twu.biblioteca;

public class Movie {

    String nameOfMovie;
    int yearOfRelease;
    String nameOfDirector;
    String movieRating;

    public Movie(String nameOfMovie, int yearOfRelease, String nameOfDirector, String movieRating) {
        this.nameOfMovie = nameOfMovie;
        this.yearOfRelease = yearOfRelease;
        this.nameOfDirector = nameOfDirector;
        this.movieRating = movieRating;
    }

    @Override
    public String toString() {
        return nameOfMovie + "\t" + yearOfRelease + "\t" + nameOfDirector + "\t" + movieRating;
    }
}