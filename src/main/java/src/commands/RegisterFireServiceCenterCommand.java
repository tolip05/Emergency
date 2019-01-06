package src.commands;

import src.anotations.InjectArgs;
import src.core.ManagementSystem;
import src.models.centers.EmergencyCenter;
import src.models.centers.FiremanServiceCenter;

public class RegisterFireServiceCenterCommand extends BaseCommand {

    @InjectArgs
    private String[] params;
    private EmergencyCenter emergencyCenter;

    public RegisterFireServiceCenterCommand(ManagementSystem managementSystem) {
        super(managementSystem);
    }

    @Override
    public String execute() {
        String name = this.params[1];
        Integer amountOfEmergency = Integer.valueOf(this.params[2]);
        this.emergencyCenter = new FiremanServiceCenter(name,amountOfEmergency);
        return super.getManagementSystem().registerFireServiceCenter(this.emergencyCenter);

    }
}
