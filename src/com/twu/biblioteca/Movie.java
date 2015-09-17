/*Movie that has movie name, director, year and rating which is formatted in column format*/
package com.twu.biblioteca;

public class Movie {

    String name;
    int yearOfRelease;
    String nameOfDirector;
    String movieRating;

    public Movie(String name, int yearOfRelease, String nameOfDirector, String movieRating) {
        this.name = name;
        this.yearOfRelease = yearOfRelease;
        this.nameOfDirector = nameOfDirector;
        this.movieRating = movieRating;
    }

    @Override
    public String toString() {
        return name + "\t" + yearOfRelease + "\t" + nameOfDirector + "\t" + movieRating;
    }

    @Override
    public boolean equals(Object that) {
        if (that != null && that.getClass() == this.getClass()) {
            Movie thatMovie = (Movie) that;
            if(this == thatMovie || this.name.equals(thatMovie.name))
                return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        if (this != null) {
            for (int i = 0; i < name.length(); i++) {
                hash = Character.getNumericValue(name.charAt(i)) + (hash << 6) + (hash << 16) - hash;
            }
        }
        return hash;
    }
}