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

    public String authenticate(String thatLibraryNumber, String thatPassword) {
        if(this.libraryNumber.equals(thatLibraryNumber) && this.password.equals(thatPassword))
            return "Login successful";
        else
            return "Login unsuccessful";
    }
}