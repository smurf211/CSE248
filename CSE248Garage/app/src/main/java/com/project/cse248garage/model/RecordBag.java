package com.project.cse248garage.model;

import java.io.Serializable;
import java.util.ArrayList;

public class RecordBag implements Serializable {

    ArrayList<Record> recordList = new ArrayList<Record>();
    private int nElems = 0;


    public RecordBag(){



    }

    public void addRecord(Record record){

        recordList.add(record);
        nElems++;
    }

    public void removeRecord(Record record){

        recordList.remove(record);
        nElems--;
    }


    public Record getRecord(String licensePlate){
        Record record;

        for(int i =0; i < recordList.size(); i++){

            if(recordList.get(i).getLicensePlate().equals(licensePlate)){

                record = recordList.get(i);
                return record;
            }
        }

        return null;



    }

    public ArrayList<String> getLicensePlates(Garage garage){



        ArrayList<String> list = new ArrayList<String>();

       for(int i =0; i < recordList.size(); i++){
           if(garage.findByPlateBoolean(recordList.get(i).getLicensePlate())){
               list.add(recordList.get(i).getLicensePlate() + " (Present)");

           }
           else {
               list.add(recordList.get(i).getLicensePlate());
           }
       }


        return list;

    }


}
