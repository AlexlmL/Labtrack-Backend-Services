package com.labtrack.items.domain.model.valueobjects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.util.UUID;

@Embeddable
public class MaintenanceId {

    @Column(name = "maintenance_uuid", nullable = false, updatable = false)
    private UUID value;

    protected MaintenanceId() {
    }

    public MaintenanceId(UUID value) {
        if (value == null) throw new IllegalArgumentException("Maintenance id cannot be null");
        this.value = value;
    }

    public static MaintenanceId generate() {
        return new MaintenanceId(UUID.randomUUID());
    }

    public UUID getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value.toString();
    }
}