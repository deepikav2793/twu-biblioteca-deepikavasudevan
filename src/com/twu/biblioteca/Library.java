/*A library interface has a list of its collection and checks out entities from itself*/
package com.twu.biblioteca;

public interface Library {

    public String list();
    public String checkOut(String entityToBeCheckedOut);
}
