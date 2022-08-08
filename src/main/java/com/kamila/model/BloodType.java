package com.kamila.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum BloodType {
    A_POSITIVE("A+"),
    O_POSITIVE("O+"),
    B_POSITIVE("B+"),
    AB_POSITIVE("AB+"),
    A_NEGATIVE("A-"),
    O_NEGATIVE("O-"),
    B_NEGATIVE("B-"),
    AB_NEGATIVE("AB-");

    private final String type;

    BloodType(String type) {
        this.type = type;
    }

    public String getType() {
        return this.type;
    }

    public static List<String> getAllTypes() {
        return Arrays.stream(BloodType.values()).map(BloodType::getType).collect(Collectors.toList());
    }

    public static BloodType fromType(String type) {
        return Arrays.stream(BloodType.values())
                .filter(e -> e.getType().equalsIgnoreCase(type))
                .findFirst()
                .orElse(null);
    }
}
