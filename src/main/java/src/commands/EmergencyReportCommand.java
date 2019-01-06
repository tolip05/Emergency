package src.commands;

import src.core.ManagementSystem;

public class EmergencyReportCommand extends BaseCommand {



    public EmergencyReportCommand(ManagementSystem managementSystem) {
        super(managementSystem);
    }

    @Override
    public String execute() {
        return super.getManagementSystem().emergencyReport();
    }
}
