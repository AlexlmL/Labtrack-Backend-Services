package com.labtrack.items.domain.model.commands;

import com.labtrack.items.domain.model.valueobjects.EquipmentId;

public record RegisterMaintenanceCommand(
        EquipmentId equipmentId,
        String description,
        String performedBy
) {}