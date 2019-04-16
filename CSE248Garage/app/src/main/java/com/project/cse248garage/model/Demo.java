package com.project.cse248garage.model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Demo {

    public static void main(String[] args) throws InterruptedException{


      //  Garage garage = new Garage(5, 5, 5);
      //  Manager manager = new Manager("john", "johnson", true);
        UserAccountBag bag = new UserAccountBag();
       // bag.insertHash("john", "johnson", true);

         System.out.println(bag.createManagerAccount("jackg45", "MjsRas1118!", "eric", "poop", true ));
       //  bag.displayBagHash();
       // System.out.println(garage.toString());

     //   SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
     //   Date date = new Date();

      //  String time = String.valueOf(java.time.LocalTime.now());

        //Reciept.sleep(5500);

     //  Reciept reciept = new Reciept("gfsdgdfg", "car", "mike", "johnson", "4/27/19",time , 2.50 );

      // reciept.getTimeSeconds();

    CheckCredentials check = new CheckCredentials();
    check.login("jackg45", "MjsRas1118!", bag.getUserAccountHash());






    }

}
