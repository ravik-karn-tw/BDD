package com.lengyel.mileage;

import com.lengyel.airport.Passenger;
import com.lengyel.mileage.Mileage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BonusPolicy {

    private Passenger lukas;
    private Passenger alena;
    private Mileage mileage;

    @Given("we have a usual passenger with a mileage")
    public void weHaveAUsualPassengerWithAMileage() {
        lukas = new Passenger("lukas", false);
        mileage = new Mileage();
    }


    @When("the usual passenger travels {int} and {int} and {int}")
    public void the_usual_passenger_travels_and_and(Integer int1, Integer int2, Integer int3) {
        mileage.addMileage(lukas, int1);
        mileage.addMileage(lukas, int2);
        mileage.addMileage(lukas, int3);
    }

    @Then("the bonus points of the usual passenger should be {int}")
    public void the_bonus_points_of_the_usual_passenger_should_be(Integer int1) {
        mileage.calculateGivenPoints();
        assertEquals(int1, mileage.getPassengerPointsMap().get(lukas).intValue());
    }

    @Given("we have a VIP passenger with a mileage")
    public void weHaveAVIPPassengerWithAMileage() {
        alena = new Passenger("alena", true);
        mileage = new Mileage();
    }

    @When("the VIP passenger travels {int} and {int} and {int}")
    public void the_VIP_passenger_travels_and_and(Integer int1, Integer int2, Integer int3) {
        mileage.addMileage(alena, int1);
        mileage.addMileage(alena, int2);
        mileage.addMileage(alena, int3);
    }

    @Then("the bonus points of the VIP passenger should be {int}")
    public void the_bonus_points_of_the_VIP_passenger_should_be(Integer int1) {
        mileage.calculateGivenPoints();
        assertEquals(int1, mileage.getPassengerPointsMap().get(alena).intValue());
    }
}
