package com.project.cse248garage.model;

import java.io.Serializable;

/**
 * The type Truck.
 */
public class Truck extends Vehicle implements Serializable {


    @Override
    public String getCategory() {
        return "truck";
    }

    /**
     * Instantiates a new Truck.
     *
     * @param licensePlate       the license plate
     * @param attendantFirstName the attendant first name
     * @param attendantLastName  the attendant last name
     * @param attendantId        the attendant id
     */
    public Truck(String licensePlate, String attendantFirstName, String attendantLastName, int attendantId) {
        super(licensePlate, attendantFirstName, attendantLastName, attendantId);
    }

    /**
     * Instantiates a new Truck.
     *
     * @param vehicleId     the vehicle id
     * @param attendantId   the attendant id
     * @param licensePlate  the license plate
     * @param falseCategory the false category
     * @param spaceID       the space id
     * @param dateIn        the date in
     * @param timeIn        the time in
     * @param earlyBird     the early bird
     * @param rate          the rate
     */
    public Truck(int vehicleId, int attendantId, String licensePlate, String falseCategory, String spaceID, String dateIn, String timeIn, boolean earlyBird, double rate) {
        super(vehicleId, attendantId, licensePlate, falseCategory, spaceID, dateIn, timeIn, earlyBird, rate);
    }
}

