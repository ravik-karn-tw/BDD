package com.flight.mileage;

import com.flight.airport.Passenger;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Mileage {

    public static final int VIP_FACTOR = 10;
    public static final int USUAL_FACTOR = 20;

    private Map<Passenger, Integer> passengerMileageMap = new HashMap<>();

    public Map<Passenger, Integer> getPassengerPointsMap() {
        return Collections.unmodifiableMap(passengerPointsMap);
    }

    private Map<Passenger, Integer> passengerPointsMap = new HashMap<>();


    public void addMileage(Passenger passenger, int miles) {
        if(passengerMileageMap.containsKey(passenger)) {
            passengerMileageMap.put(passenger, passengerMileageMap.get(passenger) + miles);
        } else {
            passengerMileageMap.put(passenger, miles);
        }
    }

    public void calculateGivenPoints() {
        for(Passenger passenger : passengerMileageMap.keySet()) {
            if(passenger.isVip())
                passengerPointsMap.put(passenger, passengerMileageMap.get(passenger) / VIP_FACTOR);
            else
                passengerPointsMap.put(passenger, passengerMileageMap.get(passenger) / USUAL_FACTOR);
        }
    }

}
