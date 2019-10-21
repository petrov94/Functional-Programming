package com.java.stream.api;

import java.util.Objects;
import java.util.Optional;

public final class Actor {

    private String firstName;

    private String lastName;

    public Actor(String  firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Actor{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Actor actor = (Actor) o;
        return Objects.equals(getFirstName(), actor.getFirstName()) &&
                Objects.equals(getLastName(), actor.getLastName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFirstName(), getLastName());
    }
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Actor actor = (Actor) o;
//        if (firstName == null) {
//            if (actor.firstName != null)
//                return false;
//        } else if (!firstName.equals(actor.firstName))
//            return false;
//        if (lastName == null) {
//            if (actor.lastName != null)
//                return false;
//        } else if (!lastName.equals(actor.lastName))
//            return false;
//        return true;
//    }
//
//    @Override
//    public int hashCode() {
//        final int prime = 31;
//        int result = 1;
//        result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
//        result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
//        return result;
//    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}