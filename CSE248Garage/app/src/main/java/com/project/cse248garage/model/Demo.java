package com.project.cse248garage.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Demo {

    public static void main(String[] args) {


        Garage garage = new Garage(5, 5, 5);
        Manager manager = new Manager("john", "johnson", true);
        UserAccountBag bag = new UserAccountBag();
        bag.insertHash("john", "johnson", true);

         System.out.println(bag.createManagerAccount("jackg45", "MjsRas1118!", "eric", "poop", true ));
         bag.displayBagHash();
        System.out.println(garage.toString());








    }

}
