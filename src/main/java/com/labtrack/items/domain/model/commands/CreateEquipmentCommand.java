package com.labtrack.items.domain.model.commands;

public record CreateEquipmentCommand(
        String name,
        String serialNumber,
        String location
) {}