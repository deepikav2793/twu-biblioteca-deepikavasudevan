/*Book formats its details to column format*/
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
}
