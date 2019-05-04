package com.project.cse248garage.model;

import java.io.Serializable;
import java.util.ArrayList;

public class RecordBag implements Serializable {

    ArrayList<Record> recordList = new ArrayList<Record>();
    private int nElems = 0;


    public RecordBag(){

        nElems++;

    }

    public void addRecord(Record record){

        recordList.add(record);
    }

    public void removeRecord(Record record){
        recordList.remove(record);
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

    public ArrayList<String> getLicensePlates(){



        ArrayList<String> list = new ArrayList<String>();

       for(int i =0; i < recordList.size(); i++){
           list.add(recordList.get(i).getLicensePlate());
       }


        return list;

    }


}
