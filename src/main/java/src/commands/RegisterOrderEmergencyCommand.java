package src.commands;

import src.anotations.InjectArgs;
import src.core.ManagementSystem;
import src.enums.EmergencyLevel;
import src.enums.Status;
import src.models.emergencies.Emergency;
import src.models.emergencies.OrderEmergency;
import src.models.emergencies.PropertyEmergency;
import src.utils.RegistrationTime;
import src.utils.RegistrationTimeImpl;

public class RegisterOrderEmergencyCommand extends BaseCommand {

    @InjectArgs
    private String[] params;
    private Emergency emergency;
    private RegistrationTime registrationTime;

    public RegisterOrderEmergencyCommand(ManagementSystem managementSystem) {
        super(managementSystem);
    }

    @Override
    public String execute() {
        String description = this.params[1];
        EmergencyLevel level =
                EmergencyLevel.valueOf(this.params[2].toUpperCase());

        this.setRegistrationTime(this.params[3]);
        Status status = Status.valueOf(this.params[4].replaceAll("-","_").toUpperCase());
        this.emergency = new OrderEmergency(description,level,this.registrationTime,status);
        return super.getManagementSystem().registerOrderEmergency(this.emergency);
    }
    private void setRegistrationTime(String time){
        this.registrationTime = new RegistrationTimeImpl(time);
    }
}
