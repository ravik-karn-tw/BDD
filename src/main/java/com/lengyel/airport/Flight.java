package com.lengyel.airport;

import java.util.Set;

public interface Flight {


    String getId();

    Set<Passenger> getPassengersList();


    boolean addPassenger(Passenger passenger);

    //vip passenger cannot be removed
    boolean removePassenger(Passenger passenger);
}
