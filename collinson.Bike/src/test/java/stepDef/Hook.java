package stepDef;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.restassured.RestAssured;
import utilities.ConfigurationReader;


public class Hook {



    @Before
    public void setup(){

        RestAssured.baseURI = ConfigurationReader.get("url");


    }


    @After
    public void tearDown(){

        RestAssured.reset();
    }


}
