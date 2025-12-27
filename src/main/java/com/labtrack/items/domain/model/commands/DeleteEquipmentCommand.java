package com.labtrack.items.domain.model.commands;

import com.labtrack.items.domain.model.valueobjects.EquipmentId;

public record DeleteEquipmentCommand(EquipmentId equipmentId) {}