package src.models.emergencies;

import src.enums.EmergencyLevel;
import src.utils.RegistrationTime;
import src.utils.RegistrationTimeImpl;

public class HealthEmergency extends BaseEmergency{

    private Integer casualtes;
    public HealthEmergency(String description, EmergencyLevel emergencyLevel
            , RegistrationTime registrationTime, Integer casualtes) {
        super(description, emergencyLevel, registrationTime);
        this.casualtes = casualtes;
    }

    @Override
    public Integer getResultAfterProcessing() {
        return this.casualtes;
    }
}
