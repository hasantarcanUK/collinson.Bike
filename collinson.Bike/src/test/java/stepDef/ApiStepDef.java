package stepDef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ApiTesting;

public class ApiStepDef {
    ApiTesting apiTest = new ApiTesting();



    @Given("finding body index of Frankfurt")
    public void finding_body_index_of_Frankfurt() {

        apiTest.getL();

    }

    @When("verify country of Frankfurt")
    public void verify_country_of_Frankfurt() {
        apiTest.verifycountryTest();

    }

    @Then("print out latitude and longitude of Frankfurt")
    public void print_out_latitude_and_longitude_of_Frankfurt() {

        apiTest.printLocationTest();
}
}
