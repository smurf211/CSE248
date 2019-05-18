package com.project.cse248garage.model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * The type Record bag.
 */
public class RecordBag implements Serializable {

    /**
     * The Record list.
     */
    ArrayList<Record> recordList = new ArrayList<Record>();
    private int nElems = 0;


    /**
     * Instantiates a new Record bag.
     */
    public RecordBag() {


    }

    /**
     * Add record.
     *
     * @param record the record
     */
    public void addRecord(Record record) {

        recordList.add(record);
        nElems++;
    }

    /**
     * Remove record.
     *
     * @param record the record
     */
    public void removeRecord(Record record) {

        recordList.remove(record);
        nElems--;
    }


    /**
     * Gets record.
     *
     * @param licensePlate the license plate
     * @return the record
     */
    public Record getRecord(String licensePlate) {
        Record record;

        for (int i = 0; i < recordList.size(); i++) {

            if (recordList.get(i).getLicensePlate().equals(licensePlate)) {

                record = recordList.get(i);
                return record;
            }
        }

        return null;


    }

    /**
     * Gets license plates.
     *
     * @param garage the garage
     * @return the license plates
     */
    public ArrayList<String> getLicensePlates(Garage garage) {


        ArrayList<String> list = new ArrayList<String>();

        for (int i = 0; i < recordList.size(); i++) {
            if (garage.findByPlateBoolean(recordList.get(i).getLicensePlate())) {
                list.add(recordList.get(i).getLicensePlate() + " (Present)");

            } else {
                list.add(recordList.get(i).getLicensePlate());
            }
        }


        return list;

    }


}
