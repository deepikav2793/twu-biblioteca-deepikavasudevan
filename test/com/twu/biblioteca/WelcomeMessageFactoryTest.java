package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WelcomeMessageFactoryTest {

    @Test
    public void shouldCreateAnObjectOfTypeWelcomeMessage() {
        WelcomeMessageFactory welcomeMessageFactory = new WelcomeMessageFactory();

        assertEquals(WelcomeMessage.class, welcomeMessageFactory.createWelcomeMessage().getClass());
    }

    @Test
    public void shouldInitialiseWelcomeMessageWithMessage() {
        WelcomeMessageFactory welcomeMessageFactory = new WelcomeMessageFactory();
        WelcomeMessage welcomeMessage = welcomeMessageFactory.createWelcomeMessage();

        assertEquals("Hello! Welcome to Bangalore Public Library!", welcomeMessage.getWelcomeMessage());
    }
}