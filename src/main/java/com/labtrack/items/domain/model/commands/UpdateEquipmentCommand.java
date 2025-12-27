package com.labtrack.items.domain.model.commands;

public record UpdateEquipmentCommand(
        String id,
        String name,
        String serialNumber,
        String location
) {}