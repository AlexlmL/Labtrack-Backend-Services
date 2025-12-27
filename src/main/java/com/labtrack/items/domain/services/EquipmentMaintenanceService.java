package com.labtrack.items.domain.services;

import com.labtrack.items.domain.model.aggregates.Equipment;
import com.labtrack.items.domain.model.entities.MaintenanceRecord;
import com.labtrack.items.domain.model.valueobjects.EquipmentStatus;

public interface EquipmentMaintenanceService {
    void registerMaintenance(Equipment equipment, MaintenanceRecord record);
    void changeStatus(Equipment equipment, EquipmentStatus newStatus);
}