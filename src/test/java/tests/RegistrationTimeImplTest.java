package tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import src.utils.RegistrationTime;
import src.utils.RegistrationTimeImpl;

public class RegistrationTimeImplTest {

    private static final String REGISTRATION_TIME = "12:35 18/04/20017";


    @Test
    public void getHour(){
        RegistrationTime time = new RegistrationTimeImpl(REGISTRATION_TIME);
        int actual =((RegistrationTimeImpl) time).getHour();
        int result = 12;
        Assert.assertEquals(result,actual);
    }
}
