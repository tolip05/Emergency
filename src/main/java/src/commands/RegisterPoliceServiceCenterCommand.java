package src.commands;

import src.anotations.InjectArgs;
import src.core.ManagementSystem;
import src.models.centers.EmergencyCenter;
import src.models.centers.MedicalServiceCenter;
import src.models.centers.PoliceServiceCenter;

public class RegisterPoliceServiceCenterCommand extends BaseCommand {
    @InjectArgs
    private String[] params;
    private EmergencyCenter emergencyCenter;

    public RegisterPoliceServiceCenterCommand(ManagementSystem managementSystem) {
        super(managementSystem);
    }

    @Override
    public String execute() {
        String name = this.params[1];
        Integer amountOfEmergency = Integer.valueOf(this.params[2]);
        this.emergencyCenter = new PoliceServiceCenter(name,amountOfEmergency);
        return super.getManagementSystem().registerPoliceServiceCenter(this.emergencyCenter);
    }
}
