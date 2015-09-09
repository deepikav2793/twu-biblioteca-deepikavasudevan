/*Book formats its details into column format and checks if it is equal to another book*/
package com.twu.biblioteca;

public class Book {

    private int yearPublished;
    private String authorName;
    private String name;

    public Book(String name, String authorName, int yearPublished) {
        this.name = name;
        this.authorName = authorName;
        this.yearPublished = yearPublished;
    }

    @Override
    public String toString() {
        return name + "\t" + authorName + "\t" + yearPublished;
    }

    @Override
    public boolean equals(Object that) {
        if (that != null && that.getClass() == this.getClass()) {
            Book thatBook = (Book) that;
            if (this == thatBook || this.name.equals(thatBook.name))
                return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        if(this != null) {
            for (int i = 0; i < name.length(); i++) {
                hash = Character.getNumericValue(name.charAt(i)) + (hash << 6) + (hash << 16) - hash;
            }
        }
        return hash;
    }
}
