package src.commands;

import src.anotations.InjectType;
import src.core.ManagementSystem;
import src.models.centers.EmergencyCenter;

public class ProcessEmergenciesCommand extends BaseCommand {

    @InjectType
    private String type;


    public ProcessEmergenciesCommand(ManagementSystem managementSystem) {
        super(managementSystem);
    }

    @Override
    public String execute() {
        return super.getManagementSystem().processEmergencies(this.type);
    }
}
