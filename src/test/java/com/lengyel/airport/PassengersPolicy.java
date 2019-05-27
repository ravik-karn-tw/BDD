package com.lengyel.airport;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PassengersPolicy {

    private EconomyFlight economyFlight;
    private BusinessFlight businessFlight;
    private PremiumFlight premiumFlight;
    private Passenger lukas;
    private Passenger alena;

    @Given("there is an economy flight")
    public void thereIsAnEconomyFlight() {
        economyFlight = new EconomyFlight("1");
    }

    @When("we have a usual passenger")
    public void weHaveAUsualPassenger() {
        lukas = new Passenger("lukas", false);
    }


    @Then("you can add and remove him or her from an economy flight")
    public void youCanAddAndRemoveHimOrHerFromAnEconomyFlight() {
        assertAll("Verify all conditions for a usual passenger and an economy flight",
                () -> Assertions.assertEquals("1", economyFlight.getId()),
                () -> Assertions.assertEquals(true, economyFlight.addPassenger(lukas)),
                () -> Assertions.assertEquals(1, economyFlight.getPassengersList().size()),
                () -> Assertions.assertEquals(true, economyFlight.getPassengersList().contains(lukas)),
                () -> Assertions.assertEquals(true, economyFlight.removePassenger(lukas)),
                () -> Assertions.assertEquals(0, economyFlight.getPassengersList().size()));
    }

    @When("we have a VIP passenger")
    public void weHaveAVIPPassenger() {
        alena = new Passenger("alena", true);
    }

    @Then("you can add him but cannot remove him from an economy flight")
    public void youCanAddHimButCannotRemoveHimFromAnEconomyFlight() {
        assertAll("Verify all conditions for a VIP passenger and an economy flight",
                () -> Assertions.assertEquals("1", economyFlight.getId()),
                () -> Assertions.assertEquals(true, economyFlight.addPassenger(alena)),
                () -> Assertions.assertEquals(1, economyFlight.getPassengersList().size()),
                () -> Assertions.assertEquals(true, economyFlight.getPassengersList().contains(alena)),
                () -> Assertions.assertEquals(false, economyFlight.removePassenger(alena)),
                () -> Assertions.assertEquals(1, economyFlight.getPassengersList().size()));
    }

    @Given("there is a business flight")
    public void thereIsABusinessFlight() {
        businessFlight = new BusinessFlight("10");
    }


    @Then("you can add him but cannot remove him from a business flight")
    public void youCanAddHimButCannotRemoveHimFromABusinessFlight() {
        assertAll("Verify all conditions for a usual passenger and a business flight",
                () -> Assertions.assertEquals("10", businessFlight.getId()),
                () -> Assertions.assertTrue(businessFlight.addPassenger(alena)),
                () -> Assertions.assertEquals(1, businessFlight.getPassengersList().size()),
                () -> Assertions.assertTrue(businessFlight.getPassengersList().contains(alena)),
                () -> Assertions.assertFalse(businessFlight.removePassenger(alena)),
                () -> Assertions.assertEquals(1, businessFlight.getPassengersList().size()));
    }

    @Then("you cannot add or remove him from a business flight")
    public void youCannotAddOrRemoveHimFromABusinessFlight() {
        assertAll("Verify all conditions for a usual passenger and a business flight",
                () -> Assertions.assertEquals("10", businessFlight.getId()),
                () -> Assertions.assertEquals(false, businessFlight.addPassenger(lukas)),
                () -> Assertions.assertEquals(0, businessFlight.getPassengersList().size()));
    }

    @Given("there is a premium flight")
    public void thereIsAPremiumFlight() {
        premiumFlight = new PremiumFlight("100");
    }

    @Then("you cannot add or remove him from a premium flight")
    public void youCannotAddOrRemoveHimFromAPremiumFlight() {
        assertAll("Verify all conditions for a usual passenger and a premium flight",
                () -> Assertions.assertEquals("100", premiumFlight.getId()),
                () -> Assertions.assertEquals(false, premiumFlight.addPassenger(lukas)),
                () -> Assertions.assertEquals(0, premiumFlight.getPassengersList().size()));
    }

    @Then("you can add him but cannot remove him from a premium flight")
    public void youCanAddHimButCannotRemoveHimFromAPremiumFlight() {
        assertAll("Verify all conditions for a usual passenger and a business flight",
                () -> Assertions.assertEquals("100", premiumFlight.getId()),
                () -> Assertions.assertTrue(premiumFlight.addPassenger(alena)),
                () -> Assertions.assertEquals(1, premiumFlight.getPassengersList().size()),
                () -> Assertions.assertTrue(premiumFlight.getPassengersList().contains(alena)),
                () -> Assertions.assertFalse(premiumFlight.removePassenger(alena)),
                () -> Assertions.assertEquals(1, premiumFlight.getPassengersList().size()));
    }

    @And("you cannot add a usual passenger to an economy flight more than once")
    public void youCannotAddAUsualPassengerToAnEconomyFlightMoreThanOnce() {
        assertAll("Verify all conditions for a usual passenger and an economy flight",
                () -> Assertions.assertEquals("1", economyFlight.getId()),
                () -> Assertions.assertTrue(economyFlight.addPassenger(lukas)),
                () -> Assertions.assertEquals(1, economyFlight.getPassengersList().size()),
                () -> Assertions.assertTrue(economyFlight.getPassengersList().contains(lukas)),
                () -> Assertions.assertFalse(economyFlight.addPassenger(lukas)),
                () -> Assertions.assertEquals(1, economyFlight.getPassengersList().size()));

    }

    @And("you cannot add a VIP passenger to an economy flight more than once")
    public void youCannotAddAVIPPassengerToAnEconomyFlightMoreThanOnce() {
        assertAll("Verify all conditions for a vip passenger and an economy flight",
                () -> Assertions.assertTrue(economyFlight.getPassengersList().contains(alena)),
                () -> Assertions.assertFalse(economyFlight.addPassenger(alena)),
                () -> Assertions.assertEquals(1, economyFlight.getPassengersList().size()));
    }

    @And("you cannot add a VIP passenger to a business flight more than once")
    public void youCannotAddAVIPPassengerToABusinessFlightMoreThanOnce() {
        assertAll("Verify all conditions for a vip passenger and a business flight",
                () -> Assertions.assertTrue(businessFlight.getPassengersList().contains(alena)),
                () -> Assertions.assertEquals("alena", new ArrayList<>(businessFlight.getPassengersList()).get(0).getName()),
                () -> Assertions.assertFalse(businessFlight.addPassenger(alena)),
                () -> Assertions.assertEquals(1, businessFlight.getPassengersList().size()));
    }

    @And("you cannot add a VIP passenger to a premium flight more than once")
    public void youCannotAddAVIPPassengerToAPremiumFlightMoreThanOnce() {
        assertAll("Verify all conditions for a vip passenger and a premium flight",
                () -> Assertions.assertTrue(premiumFlight.getPassengersList().contains(alena)),
                () -> Assertions.assertFalse(premiumFlight.addPassenger(alena)),
                () -> Assertions.assertEquals(1, premiumFlight.getPassengersList().size()));
    }
}
