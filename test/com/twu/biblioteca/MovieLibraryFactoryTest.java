package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MovieLibraryFactoryTest {

    @Test
    public void shouldCreateAnObjectOfTypeMovieFactory() {
        MovieLibraryFactory movieLibraryFactory = new MovieLibraryFactory();

        assertEquals(MovieLibrary.class, movieLibraryFactory.createMovieLibrary().getClass());
    }
}