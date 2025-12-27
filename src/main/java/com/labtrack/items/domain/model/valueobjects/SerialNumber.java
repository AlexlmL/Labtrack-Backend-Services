package com.labtrack.items.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record SerialNumber(String value) {

    public SerialNumber {
        if (value == null || value.isBlank())
            throw new IllegalArgumentException("Serial number cannot be empty");

        if (value.length() > 50)
            throw new IllegalArgumentException("Serial number too long");
    }
    public String getValue() {
        return value;
    }
}