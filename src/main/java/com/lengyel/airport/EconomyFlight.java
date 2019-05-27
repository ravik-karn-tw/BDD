package com.lengyel.airport;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class EconomyFlight implements Flight {

    private String id;
    private Set<Passenger> passengerSet;
    private boolean isEconomy;


    public EconomyFlight(String id) {
        this.id = id;
        passengerSet = new HashSet<>();
        isEconomy = true;
    }

    public String getId() {
        return id;
    }

    public Set<Passenger> getPassengersList() {
        return Collections.unmodifiableSet(passengerSet);
    }

    public boolean addPassenger(Passenger passenger) {
        return passengerSet.add(passenger);
    }

    public boolean removePassenger(Passenger passenger) {
        if(!passenger.isVip()) {
            return passengerSet.remove(passenger);
        } else {
            return false;
        }
    }
}
