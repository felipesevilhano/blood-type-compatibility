package com.kamila.model;

public class Donor extends Person {
    private final BloodType bloodType;

    public Donor(String firstName, String lastName, BloodType bloodType) {
        super(firstName, lastName);
        this.bloodType = bloodType;
    }

    public BloodType getBloodType() {
        return bloodType;
    }
}
