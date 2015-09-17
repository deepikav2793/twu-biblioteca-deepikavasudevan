package com.twu.biblioteca;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;

public class QuitMainMenuOptionTest {

    @Rule
    public final ExpectedSystemExit exit = ExpectedSystemExit.none();

    @Test
    public void shouldQuitApplication() {
        User currentUser = new User("Guest User","No Password",ROLE.GUEST_USER);
        exit.expectSystemExitWithStatus(0);
        QuitMenuOption quitMenuOption = new QuitMenuOption(currentUser);
        quitMenuOption.executeOptionOperation();
    }
}