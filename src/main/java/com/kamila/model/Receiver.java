package com.kamila.model;

public class Receiver extends Person {
    private final BloodType bloodType;

    public Receiver(String firstName, String lastName, BloodType bloodType) {
        super(firstName, lastName);
        this.bloodType = bloodType;
    }

    public BloodType getBloodType() {
        return bloodType;
    }
}
