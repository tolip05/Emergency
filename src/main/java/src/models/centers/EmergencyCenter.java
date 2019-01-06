package src.models.centers;

public interface EmergencyCenter {

    String getName();

    Integer getAmountOfMaximumEmergencies();

    Boolean isForRetirement();

    Integer getProcessEmergencies();

    void processEmergency();
}
