package com.labtrack.items.domain.model.valueobjects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class EquipmentName {

    @Column(name = "name", nullable = false)
    private String value;

    protected EquipmentName() {}

    public EquipmentName(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}