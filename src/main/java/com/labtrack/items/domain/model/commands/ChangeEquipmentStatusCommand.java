package com.labtrack.items.domain.model.commands;

public record ChangeEquipmentStatusCommand(
        String equipmentId,
        String newStatus
) {}