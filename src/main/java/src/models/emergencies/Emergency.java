package src.models.emergencies;

import src.enums.EmergencyLevel;
import src.utils.RegistrationTime;
import src.utils.RegistrationTimeImpl;

public interface Emergency {
    String getDescription();

    EmergencyLevel getEmergencyLevel();

    RegistrationTime getRegistrationTime();

    Integer getResultAfterProcessing();

}
