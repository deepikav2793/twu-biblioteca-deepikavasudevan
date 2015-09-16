/*Sets up the Biblioteca Application*/
package com.twu.biblioteca;

import java.util.ArrayList;

public class Setup {

    public WelcomeMessage initialiseWelcomeMessage() {
        return new WelcomeMessage("Hello! Welcome to Bangalore Public Library!");
    }

    public MovieLibrary initialiseMovieLibraryWithMovies() {
        ArrayList<Movie> movieList = new ArrayList<>();
        movieList.add(new Movie("Funny Girl", 1968, "William Wyler", "8"));
        movieList.add(new Movie("Pretty in Pink", 1986, "John Hughes", "10"));

        return new MovieLibrary(movieList);
    }
}