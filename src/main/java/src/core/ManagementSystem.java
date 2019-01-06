package src.core;

import src.models.centers.EmergencyCenter;
import src.models.emergencies.Emergency;

public interface ManagementSystem {
    String registerPropertyEmergency(Emergency emergency);

    String registerHealthEmergency(Emergency emergency);

    String registerOrderEmergency(Emergency emergency);

    String registerFireServiceCenter(EmergencyCenter emergency);

    String registerMedicalServiceCenter(EmergencyCenter emergency);

    String registerPoliceServiceCenter(EmergencyCenter emergency);

    String processEmergencies(String type);

    String emergencyReport();
}
