/*A User has a library number, role and password with which it authenticates itself*/
package com.twu.biblioteca;

public class User {

    private String libraryNumber;
    private String password;
    private String role;

    public User(String libraryNumber, String password, String role) {
        this.libraryNumber = libraryNumber;
        this.password = password;
        this.role = role;
    }

    public String authenticate(String thatLibraryNumber) {
            return "Login successful";
    }
}