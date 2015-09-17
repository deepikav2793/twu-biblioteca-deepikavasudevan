/*Creates an object of type Movie Library class*/
package com.twu.biblioteca;

import java.util.ArrayList;

public class MovieLibraryFactory {

    private MovieLibrary movieLibrary;

    public MovieLibrary createMovieLibrary() {
        ArrayList<Movie> movieList = new ArrayList<>();
        movieLibrary  = new MovieLibrary(movieList);

        return movieLibrary;
    }
}
