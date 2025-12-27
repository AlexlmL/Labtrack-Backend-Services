package com.labtrack.items.domain.exceptions;

public class EquipmentNotFoundException extends RuntimeException {
    public EquipmentNotFoundException(String id) {
        super("Equipment not found with id: " + id);
    }
}