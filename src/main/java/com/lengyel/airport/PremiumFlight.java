package com.lengyel.airport;

import java.util.*;

public class PremiumFlight implements Flight {

    private String id;
    private Set<Passenger> passengerSet;
    private boolean isPremium;

    public PremiumFlight(String id) {
        this.id = id;
        passengerSet = new HashSet<>();
        isPremium = true;
    }

    public String getId() {
        return id;
    }

    public Set<Passenger> getPassengersList() {
        return Collections.unmodifiableSet(passengerSet);
    }

    public boolean addPassenger(Passenger passenger) {
        if(passenger.isVip()) {
            return passengerSet.add(passenger);
        } else {
            return false;
        }
    }

    public boolean
    removePassenger(Passenger passenger) {
        if(!passenger.isVip()) {
            return passengerSet.remove(passenger);
        } else {
            return false;
        }
    }
}
