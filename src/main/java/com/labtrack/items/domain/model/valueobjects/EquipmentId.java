package com.labtrack.items.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

import java.util.UUID;

@Embeddable
public record EquipmentId(UUID value) {

    public EquipmentId {
        if (value == null) throw new IllegalArgumentException("Equipment id cannot be null");
    }

    public static EquipmentId generate() {
        return new EquipmentId(UUID.randomUUID());
    }
    public UUID getValue() {
        return value;
    }
    public static EquipmentId of(String value) {
        return new EquipmentId(UUID.fromString(value));
    }
}