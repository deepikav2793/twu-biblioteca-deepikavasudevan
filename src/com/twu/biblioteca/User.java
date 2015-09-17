/*A User has a library number, role and password with which it authenticates itself*/
package com.twu.biblioteca;

public class User {

    private String libraryNumber;
    private String password;
    private ROLE role;

    public User(String libraryNumber, String password, ROLE role) {
        this.libraryNumber = libraryNumber;
        this.password = password;
        this.role = role;
    }

    public boolean authenticate(String thatLibraryNumber, String thatPassword) {
        if(this.libraryNumber.equals(thatLibraryNumber) && this.password.equals(thatPassword))
            return true;
        else
            return false;
    }
}