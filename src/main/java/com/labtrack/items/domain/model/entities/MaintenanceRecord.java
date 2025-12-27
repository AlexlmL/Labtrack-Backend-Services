package com.labtrack.items.domain.model.entities;

import com.labtrack.items.domain.model.valueobjects.MaintenanceId;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;

import java.time.LocalDateTime;

@Embeddable
public class MaintenanceRecord {

    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "maintenance_id"))
    private MaintenanceId id;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String performedBy;

    @Column(nullable = false)
    private LocalDateTime date;

    protected MaintenanceRecord() {
    }

    public MaintenanceRecord(String description, String performedBy) {
        this.id = MaintenanceId.generate();
        this.description = description;
        this.performedBy = performedBy;
        this.date = LocalDateTime.now();
    }

    public MaintenanceId getId() { return id; }
    public String getDescription() { return description; }
    public String getPerformedBy() { return performedBy; }
    public LocalDateTime getDate() { return date; }
}