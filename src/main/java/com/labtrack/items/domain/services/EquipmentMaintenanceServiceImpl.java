package com.labtrack.items.domain.services;

import com.labtrack.items.domain.model.aggregates.Equipment;
import com.labtrack.items.domain.model.entities.MaintenanceRecord;
import com.labtrack.items.domain.model.valueobjects.EquipmentStatus;
import org.springframework.stereotype.Service;

@Service
public class EquipmentMaintenanceServiceImpl implements EquipmentMaintenanceService {

    @Override
    public void registerMaintenance(Equipment equipment, MaintenanceRecord record) {
        equipment.registerMaintenance(record);
    }

    @Override
    public void changeStatus(Equipment equipment, EquipmentStatus newStatus) {
        equipment.changeStatus(newStatus);
    }
}
