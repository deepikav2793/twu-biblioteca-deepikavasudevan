package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class MovieLibraryTest {

    private MovieLibrary movieLibrary;

    @Before
    public void setUpMovie(){
        ArrayList<Movie> movieList = new ArrayList<>();
        movieList.add(new Movie("Funny Girl", 1968, "William Wyler", "8"));
        movieList.add(new Movie("Pretty in Pink", 1986, "John Hughes", "10"));
        movieLibrary = new MovieLibrary(movieList);
    }

    @Test
    public void shouldDisplayMovieDetails() {
        movieLibrary.list();

        assertEquals("NAME OF MOVIE\tYEAR\tDIRECTOR\tMOVIE RATING\nFunny Girl\t1968\tWilliam Wyler\t8\n" +
                "Pretty in Pink\t1986\tJohn Hughes\t10\n", movieLibrary.list());
    }

    @Test
    public void shouldReturnSuccessfulCheckOutMessageIfMovieIsCheckedOut() {
        assertEquals("Thank you! Enjoy the movie", movieLibrary.checkOut("Funny Girl"));
    }

    @Test
    public void shouldReturnUnsuccessfulCheckOutMessageIfMovieIsNotCheckedOut() {
        assertEquals("That movie is not available", movieLibrary.checkOut("Funny"));
    }

    @Test
    public void shouldNotContainCheckedOutMovieInMovieList() {
        movieLibrary.checkOut("Funny Girl");

        assertEquals("NAME OF MOVIE\tYEAR\tDIRECTOR\tMOVIE RATING\nPretty in Pink\t1986\tJohn Hughes\t10\n", movieLibrary.list());
    }
}