package com.labtrack.items.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record LabLocation(String value) {

    public LabLocation {
        if (value == null || value.isBlank())
            throw new IllegalArgumentException("Location cannot be empty");
    }
    public String getValue() {
        return value;
    }
}