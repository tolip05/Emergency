package src.commands;

import src.anotations.InjectArgs;
import src.core.ManagementSystem;
import src.models.centers.EmergencyCenter;
import src.models.centers.FiremanServiceCenter;
import src.models.centers.MedicalServiceCenter;
import src.models.emergencies.Emergency;

public class RegisterMedicalServiceCenterCommand extends BaseCommand {

    @InjectArgs
    private String[] params;
    private EmergencyCenter emergencyCenter;

    public RegisterMedicalServiceCenterCommand(ManagementSystem managementSystem) {
        super(managementSystem);
    }

    @Override
    public String execute() {
        String name = this.params[1];
        Integer amountOfEmergency = Integer.valueOf(this.params[2]);
        this.emergencyCenter = new MedicalServiceCenter(name,amountOfEmergency);
        return super.getManagementSystem().registerMedicalServiceCenter(this.emergencyCenter);
    }
}
