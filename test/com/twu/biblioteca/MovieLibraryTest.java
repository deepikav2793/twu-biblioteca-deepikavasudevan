package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class MovieLibraryTest {

    private MovieLibrary movieLibrary;

    @Before
    public void setUpMovie() {
        ArrayList<Movie> movieList = new ArrayList<>();
        movieList.add(new Movie("Funny Girl", 1968, "William Wyler", "8"));
        movieList.add(new Movie("Pretty in Pink", 1986, "John Hughes", "10"));
        movieLibrary = new MovieLibrary(movieList);
    }

    @Test
    public void shouldDisplayMovieDetails() {
        movieLibrary.list();
        String formattedMovieString = String.format("%-30s%-15s%-30s%-15s\n", "NAME OF MOVIE", "YEAR", "DIRECTOR", "MOVIE RATING") +
                String.format("%-30s%-15s%-30s%-15s\n", "Funny Girl", 1968, "William Wyler", "8") +
                String.format("%-30s%-15s%-30s%-15s\n", "Pretty in Pink", 1986, "John Hughes", "10");

        assertEquals(formattedMovieString, movieLibrary.list());
    }

    @Test
    public void shouldReturnSuccessfulCheckOutMessageIfMovieIsCheckedOut() {
        User currentUser = new User("GUEST USER", "NO PASSWORD", ROLE.GUEST_USER, "NO NAME", "NO EMAIL ADDRESS", 0);
        assertEquals("Thank you! Enjoy the movie", movieLibrary.checkOut("Funny Girl", currentUser));
    }

    @Test
    public void shouldReturnUnsuccessfulCheckOutMessageIfMovieIsNotCheckedOut() {
        User currentUser = new User("GUEST USER", "NO PASSWORD", ROLE.GUEST_USER, "NO NAME", "NO EMAIL ADDRESS", 0);
        assertEquals("That movie is not available", movieLibrary.checkOut("Funny", currentUser));
    }

    @Test
    public void shouldNotContainCheckedOutMovieInMovieList() {
        User currentUser = new User("GUEST USER", "NO PASSWORD", ROLE.GUEST_USER, "NO NAME", "NO EMAIL ADDRESS", 0);
        movieLibrary.checkOut("Funny Girl", currentUser);

        String formattedMovieString = String.format("%-30s%-15s%-30s%-15s\n", "NAME OF MOVIE", "YEAR", "DIRECTOR", "MOVIE RATING") +
                String.format("%-30s%-15s%-30s%-15s\n", "Pretty in Pink", 1986, "John Hughes", "10");

        assertEquals(formattedMovieString, movieLibrary.list());
    }
}