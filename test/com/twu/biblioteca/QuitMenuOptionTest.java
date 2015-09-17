package com.twu.biblioteca;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;

public class QuitMenuOptionTest {

    @Rule
    public final ExpectedSystemExit exit = ExpectedSystemExit.none();

    @Test
    public void shouldQuitApplication() {
        exit.expectSystemExitWithStatus(0);
        QuitMenuOption quitMenuOption = new QuitMenuOption();
        quitMenuOption.executeOptionOperation();
    }
}