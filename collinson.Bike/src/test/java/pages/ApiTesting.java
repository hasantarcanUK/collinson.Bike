package pages;

import static io.restassured.RestAssured.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
//import APITest.pages.apiPages.LocalStorage;
//import APITest.utilities.TestBase;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;

import javax.swing.*;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class ApiTesting {


//    As a biker I would like to know the exact location of city bikes around the world in a given application.
//•	Endpoint: http://api.citybik.es/v2/networks
//            •	Auth: No
//•	HTTPS: No
//•	Understands how the API works.
//•	Create some BDD scenarios and automate them using Java to test the API
//•	Test this particular scenario: “As a user I want to verify that the city Frankfurt is in Germany and return their corresponded latitude and longitude”
//    As a biker I would like to know the exact location of city bikes around the world in a given application.
//•	Endpoint: http://api.citybik.es/v2/networks
//            •	Auth: No
//•	HTTPS: No
//•	Understands how the API works.
//•	Create some BDD scenarios and automate them using Java to test the API
//•	Test this particular scenario: “As a user I want to verify that the city Frankfurt is in Germany
// and return their corresponded latitude and longitude”


    //String url = "http://api.citybik.es/v2/networks";


    Response response;
    int i=0;

//    @Test
//    @DisplayName("verify that the city Frankfurt is in Germany")
    public void getL(){
     response = RestAssured.get();


        List<Map> bodies = response.jsonPath().getList("networks.location");

        for (i = 0; i <bodies.size() ; i++) {
            if (bodies.get(i).containsValue("Frankfurt")){
                System.out.println(bodies.get(i));
                System.out.println("Index number of Frankfurt :"+i);
           break;
            }
        }

    }

    public void verifycountryTest(){

        Assert.assertEquals("DE",response.jsonPath().getString("networks.location["+i+"].country"));
        Assert.assertEquals("Frankfurt",response.jsonPath().getString("networks.location["+i+"].city"));

    }

    public void printLocationTest(){
        System.out.println("Latitude: "+response.jsonPath().getString("networks.location["+i+"].latitude"));

        System.out.println("Longitude: "+response.jsonPath().getString("networks.location["+i+"].longitude"));

    }




}
