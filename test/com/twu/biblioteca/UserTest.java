package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class UserTest {

    private User user;

    @Before
    public void setUpUser() {
        user = new User("usr-1001", "password1", ROLE.AUTHENTICATED_USER);
    }

    @Test
    public void shouldNotBeEqualToNull() {
        assertNotEquals(user, null);
    }

    @Test
    public void shouldBeOfTypeUser() {
        assertNotEquals(user, "this is not a valid object");
    }

    @Test
    public void shouldBeEqualToItself() {
        assertEquals(user, user);
    }

    @Test
    public void shouldBeEqualToAnotherUserWithTheSameUserNameAndPassword() {
        User user1 = new User("usr-1001", "password1", ROLE.GUEST_USER);

        assertEquals(user, user1);
    }

    @Test
    public void shouldNotBeEqualToAnotherUserWithTheSameUserNameAndDifferentPassword() {
        User user1 = new User("usr-1001", "password", ROLE.GUEST_USER);

        assertNotEquals(user, user1);
    }

    @Test
    public void shouldNotBeEqualToAnotherUserWithADifferentUserNameAndSamePassword() {
        User user1 = new User("usr-1000", "password1", ROLE.GUEST_USER);

        assertNotEquals(user, user1);
    }

    @Test
    public void shouldNotBeEqualToAnotherUserWithDifferentUserNameAndPassword() {
        User user1 = new User("usr-1000", "password", ROLE.GUEST_USER);

        assertNotEquals(user, user1);
    }

    @Test
    public void shouldHaveTheSameHashCodeIfItIsTheSameObject() {
        assertEquals(user.hashCode(), user.hashCode());
    }

    @Test
    public void shouldNotHaveTheSameHashCodeIfNotTheSameObject() {
        User user1 = new User("usr-1000", "password", ROLE.GUEST_USER);

        assertNotEquals(user, user1);
    }
}