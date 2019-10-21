package com.java.stream.api;

import java.util.Objects;
import java.util.Optional;

public final class Actor {

    private String firstName;

    private String lastName;

    public Actor(String  firstName, String lastName){
        Optional.of(firstName).ifPresent((first)->this.firstName = first);
        Optional.of(lastName).ifPresent((last)->this.lastName = last);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Actor actor = (Actor) o;
        if (firstName == null) {
            if (actor.firstName != null)
                return false;
        } else if (!firstName.equals(actor.firstName))
            return false;
        if (lastName == null) {
            if (actor.lastName != null)
                return false;
        } else if (!lastName.equals(actor.lastName))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}