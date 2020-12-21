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
import org.junit.jupiter.api.DisplayName;

import javax.swing.*;
import java.util.*;

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



    String url = "http://api.citybik.es/v2/networks";

    @Test

    public void statusCode(){
        Response response = RestAssured.get(url);
        assertEquals(response.statusCode(), 200);

    }

    @Test
    @DisplayName("verify that the city Frankfurt is in Germany")
    public void getL(){
        Response response = RestAssured.get(url);


        List<Map> bodies = response.jsonPath().getList("networks.location");


        int i=0;
        for (i = 0; i <bodies.size() ; i++) {
            if (bodies.get(i).containsValue("Frankfurt")){
                System.out.println(bodies.get(i));
                System.out.println("Index number of Frankfurt :"+i);
                break;
            }
        }

        Assert.assertEquals("DE",response.jsonPath().getString("networks.location["+i+"].country"));
        Assert.assertEquals("Frankfurt",response.jsonPath().getString("networks.location["+i+"].city"));
        System.out.println("Latitude: "+response.jsonPath().getString("networks.location["+i+"].latitude"));
        System.out.println("Longitude: "+response.jsonPath().getString("networks.location["+i+"].longitude"));
    }

}
