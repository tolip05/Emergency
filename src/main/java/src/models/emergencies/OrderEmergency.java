package src.models.emergencies;

import src.enums.EmergencyLevel;
import src.enums.Status;
import src.utils.RegistrationTime;
import src.utils.RegistrationTimeImpl;

public class OrderEmergency extends BaseEmergency {

     private Status status;

    public OrderEmergency(String description,
                          EmergencyLevel emergencyLevel,
                          RegistrationTime registrationTime, Status status) {
        super(description, emergencyLevel, registrationTime);
        this.status = status;
    }

    @Override
    public Integer getResultAfterProcessing() {
        switch (this.status){
            case SPECIAL:return 1;
            case NON_SPECIAL:return 0;
            default:return null;
        }

    }
}
