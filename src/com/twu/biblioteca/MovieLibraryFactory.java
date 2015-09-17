/*Creates an object of type Movie Library class*/
package com.twu.biblioteca;

import java.util.ArrayList;

public class MovieLibraryFactory {

    private MovieLibrary movieLibrary;

    public MovieLibrary createMovieLibrary() {
        ArrayList<Movie> movieList = new ArrayList<>();
        movieList.add(new Movie("Funny Girl", 1968, "William Wyler", "8"));
        movieList.add(new Movie("Pretty in Pink", 1986, "John Hughes", "10"));
        movieLibrary  = new MovieLibrary(movieList);

        return movieLibrary;
    }
}
