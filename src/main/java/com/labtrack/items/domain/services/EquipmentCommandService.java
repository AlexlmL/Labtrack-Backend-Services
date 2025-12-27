package com.labtrack.items.domain.services;

import com.labtrack.items.domain.model.aggregates.Equipment;
import com.labtrack.items.domain.model.commands.*;

public interface EquipmentCommandService {

    Equipment handle(CreateEquipmentCommand command);

    Equipment handle(UpdateEquipmentCommand command);

    void handle(DeleteEquipmentCommand command);

    Equipment handle(ChangeEquipmentStatusCommand command);

    Equipment handle(RegisterMaintenanceCommand command);
}
