/*has a list of movies and check out option*/
package com.twu.biblioteca;

import java.util.ArrayList;

public class MovieLibrary {
    private final int NO_YEAR_PUBLISHED = 0;
    private final String NO_DIRECTOR_NAME = "";
    private final String NO_MOVIE_RATING = "";

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
        Movie thatMovie = new Movie(thatMovieName, NO_YEAR_PUBLISHED, NO_DIRECTOR_NAME, NO_MOVIE_RATING);
        String checkOutMovieMessage = "That movie is not available";

        for (Movie thisMovie : movieList) {
            if (thisMovie.equals(thatMovie))
                checkOutMovieMessage = "Thank you! Enjoy the movie";
        }

        return checkOutMovieMessage;
    }
}
