package com.project.cse248garage.model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Demo {

    public static void main(String[] args) throws InterruptedException{

        //AS LONG AS USER IS LOGGED IN, METHOD WORKS, IF NO USER LOGGED IN, USERS ALL DELETED
        //GO THROUGH ACTIVITIES AGAIN TO SEE IF USER IS ALWAYS LOGGED IN WHEN THAT METHOD IS CALLED


       // UserAccountBag bag = new UserAccountBag();


        // bag.createManagerAccount("jackg45", "MjsRas1118!", "eric", "poop", true );
       //  bag.createAttendantAccount("mike211", "MjsRas1118!", "jack", "spadaro");

       // User user = bag.getUser("jackg45", bag.getUserAccountHash());
       // user.setLoggedIn(true);

       // bag.displayBagHash();



   //User user3 = bag.getLoggedInUser(bag.getUserAccountHash());

  //  bag.displayBagHash();

  // User user2 =  bag.getLoggedInUser(bag.getUserAccountHash());


    //   bag.displayBagHash();
    //    System.out.println("-----------------------------");

    //    System.out.println(user3);

        //  bag.displayBagHash();
        // System.out.println(garage.toString());

        //   SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        //   Date date = new Date();

          String time = String.valueOf(java.time.LocalTime.now());
          String date = String.valueOf(java.time.LocalDate.now());
          System.out.println(time + " " + date);
          String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
          System.out.println(timeStamp);

        //Reciept.sleep(5500);

        //  Reciept reciept = new Reciept("gfsdgdfg", "car", "mike", "johnson", "4/27/19",time , 2.50 );

        // reciept.getTimeSeconds();
     //  Reciept reciept = new Reciept("12:00:00", "12:01:30");
     //  reciept.setRate(2.5);
     //   reciept.sleep(5000);
      //  System.out.println(reciept.getTimeSeconds());
      //  System.out.println(reciept.calculatePayment());
      //  System.out.println(Reciept.convertTimeFromMilitary("12:47:03.234"));
      //  System.out.println(Ticket.addZeroToRate(2.54));

    }

}
