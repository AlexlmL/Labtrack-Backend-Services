package com.labtrack.items.domain.model.aggregates;

import com.labtrack.items.domain.model.entities.MaintenanceRecord;
import com.labtrack.items.domain.model.valueobjects.*;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "equipment")
public class Equipment {

    @Id
    @Column(name = "value")
    private EquipmentId id;


    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "name"))
    private EquipmentName name;

    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "serial_number"))
    private SerialNumber serialNumber;

    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "location"))
    private LabLocation location;

    @Enumerated(EnumType.STRING)
    private EquipmentStatus status;

    @ElementCollection
    @CollectionTable(
            name = "maintenance_records",
            joinColumns = @JoinColumn(name = "equipment_id")
    )
    private final List<MaintenanceRecord> maintenanceHistory = new ArrayList<>();

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    protected Equipment() {}

    public static Equipment create(
            EquipmentName name,
            SerialNumber serialNumber,
            LabLocation location
    ) {
        Equipment equipment = new Equipment();
        equipment.id = EquipmentId.generate();
        equipment.name = name;
        equipment.serialNumber = serialNumber;
        equipment.location = location;
        equipment.status = EquipmentStatus.ACTIVE;
        equipment.createdAt = LocalDateTime.now();
        equipment.updatedAt = LocalDateTime.now();
        return equipment;
    }

    public void changeStatus(EquipmentStatus newStatus) {
        this.status = newStatus;
        this.updatedAt = LocalDateTime.now();
    }

    public void updateLocation(LabLocation newLocation) {
        this.location = newLocation;
        this.updatedAt = LocalDateTime.now();
    }

    public void registerMaintenance(MaintenanceRecord record) {
        this.maintenanceHistory.add(record);
        this.status = EquipmentStatus.IN_MAINTENANCE;
    }

    public void updateInfo(EquipmentName name, SerialNumber serialNumber, LabLocation location) {
        this.name = name;
        this.serialNumber = serialNumber;
        this.location = location;
        this.updatedAt = LocalDateTime.now();
    }

    public EquipmentId getId() { return id; }
    public EquipmentStatus getStatus() { return status; }
    public List<MaintenanceRecord> getMaintenanceHistory() { return maintenanceHistory; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public EquipmentName getName() { return name; }
    public SerialNumber getSerialNumber() { return serialNumber; }
    public LabLocation getLocation() { return location; }
}