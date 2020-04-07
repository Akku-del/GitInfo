package practest.info.tests;

import org.testng.annotations.Test;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class Information {

    @Test (groups = { "Smoke", "Regression","TC_03" })
    public void validAuthenticationTest(){
        System.out.println(" Sniff + Regression" + System.getProperty("environment"));
    }
}

