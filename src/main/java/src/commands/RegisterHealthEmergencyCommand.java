package src.commands;

import src.anotations.InjectArgs;
import src.core.ManagementSystem;
import src.enums.EmergencyLevel;
import src.models.emergencies.Emergency;
import src.models.emergencies.HealthEmergency;
import src.models.emergencies.PropertyEmergency;
import src.utils.RegistrationTime;
import src.utils.RegistrationTimeImpl;

public class RegisterHealthEmergencyCommand extends BaseCommand {


    @InjectArgs
    private String[] params;
    private Emergency emergency;
    private RegistrationTime registrationTime;

    public RegisterHealthEmergencyCommand(ManagementSystem managementSystem) {
        super(managementSystem);
    }

    @Override
    public String execute() {
        String description = this.params[1];
        EmergencyLevel level =
                EmergencyLevel.valueOf(this.params[2].toUpperCase());

        this.setRegistrationTime(this.params[3]);
        Integer casualtes = Integer.valueOf(this.params[4]);
        this.emergency = new HealthEmergency(description,level,this.registrationTime,casualtes);
        return super.getManagementSystem().registerHealthEmergency(this.emergency);
    }

    private void setRegistrationTime(String time){
        this.registrationTime = new RegistrationTimeImpl(time);
    }
}
