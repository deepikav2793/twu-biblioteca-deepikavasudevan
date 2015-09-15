/*has a list of movies and check out option*/
package com.twu.biblioteca;

import java.util.ArrayList;

public class MovieLibrary {

    private ArrayList<Movie> movieList = new ArrayList<>();

    public MovieLibrary(ArrayList<Movie> movieList) {
        this.movieList = movieList;
    }

    public String listOfMovies() {
        String listOfMovies = "NAME OF MOVIE\tYEAR\tDIRECTOR\tMOVIE RATING\n";

        for (Movie movie : movieList) {
            listOfMovies += movie.toString() + "\n";
        }

        return listOfMovies;
    }

    public String checkOutMovie(String thatMovieName) {
        return "Thank you! Enjoy the movie";
    }
}
