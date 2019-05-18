package com.project.cse248garage.controller;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.project.cse248garage.R;
import com.project.cse248garage.model.Car;
import com.project.cse248garage.model.Garage;
import com.project.cse248garage.model.Motorcycle;
import com.project.cse248garage.model.Truck;
import com.project.cse248garage.model.User;
import com.project.cse248garage.model.UserAccountBag;

/**
 * The type Garage setup activity.
 */
public class GarageSetupActivity extends AppCompatActivity {


    Garage garage;
    EditText carSpaceField;
    EditText truckSpaceField;
    EditText motorcycleSpaceField;
    int carSpaces;
    int truckSpaces;
    int motorcycleSpaces;
    EditText carEarlyBird;
    EditText carPerHour;
    EditText truckEarlyBird;
    EditText truckPerHour;
    EditText motorcycleEarlyBird;
    EditText motorcyclePerHour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_garagesetup);


        garage = (Garage) getIntent().getSerializableExtra("Garage");
        UserAccountBag bag = garage.getBag();

            garage = new Garage();
            garage.setBag(bag);

      //  User user = garage.getBag().getUser("admin", garage.getBag().getUserAccountHash());
     //   user.setLoggedIn(true);



    }

    /**
     * Create garage.
     *
     * @param view the view
     */
    public void createGarage(View view) {


        carSpaceField = findViewById(R.id.carspace_field);
        truckSpaceField = findViewById(R.id.truckspace_field);
        motorcycleSpaceField = findViewById(R.id.motorcyclespace_field);
        carEarlyBird = findViewById(R.id.car_earlybird);
        carPerHour = findViewById(R.id.car_perhour);
        truckEarlyBird = findViewById(R.id.truck_earlybird);
        truckPerHour = findViewById(R.id.truck_perhour);
        motorcycleEarlyBird = findViewById(R.id.motorcycle_earlybird);
        motorcyclePerHour = findViewById(R.id.motorcycle_perhour);

        if (!checkEmptyValues()) {
            return;
        }


        carSpaces = Integer.parseInt(carSpaceField.getText().toString());
        truckSpaces = Integer.parseInt(truckSpaceField.getText().toString());
        motorcycleSpaces = Integer.parseInt(motorcycleSpaceField.getText().toString());

        garage.setSpaces(carSpaces, truckSpaces, motorcycleSpaces);


        String carValueEarlyBird = carEarlyBird.getText().toString();
        garage.setCarEarlyBird(Double.valueOf(carValueEarlyBird));


        String carValuePerHour = carPerHour.getText().toString();
        garage.setCarPerHour(Double.valueOf(carValuePerHour));


        String truckValueEarlyBird = truckEarlyBird.getText().toString();
        garage.setTruckEarlyBird(Double.valueOf(truckValueEarlyBird));


        String truckValuePerHour = truckPerHour.getText().toString();
        garage.setTruckPerHour(Double.valueOf(truckValuePerHour));


        String motoValueEarlyBird = motorcycleEarlyBird.getText().toString();
        garage.setMotoEarlyBird(Double.valueOf(motoValueEarlyBird));


        String motoValuePerHour = motorcyclePerHour.getText().toString();
        garage.setMotoPerHour(Double.valueOf(motoValuePerHour));


        String type = "create garage";

        BackgroundWorker backgroundWorker = new BackgroundWorker(this);
        backgroundWorker.execute(type, String.valueOf(carSpaces), String.valueOf(truckSpaces), String.valueOf(motorcycleSpaces), carValueEarlyBird,
                carValuePerHour, truckValueEarlyBird, truckValuePerHour, motoValueEarlyBird, motoValuePerHour);


        System.out.println("**************************************************************************");


        TextView displayGarage = findViewById(R.id.display_field);
        displayGarage.setText("Garage Created!");

    }

    /**
     * Next view.
     *
     * @param view the view
     */
    public void nextView(View view) {


        Intent intent = new Intent(this, CreateAttendantActivity.class);


        intent.putExtra("Garage", garage);
        startActivity(intent);
    }

    /**
     * Check empty values boolean.
     *
     * @return the boolean
     */
    public boolean checkEmptyValues() {


        EditText[] arrayText = new EditText[12];
        arrayText[0] = carSpaceField;
        arrayText[1] = truckSpaceField;
        arrayText[2] = motorcycleSpaceField;
        arrayText[3] = carEarlyBird;
        arrayText[4] = carPerHour;
        arrayText[5] = truckEarlyBird;
        arrayText[6] = truckPerHour;
        arrayText[7] = motorcycleEarlyBird;
        arrayText[8] = motorcyclePerHour;
        arrayText[9] = carSpaceField;
        arrayText[10] = motorcycleSpaceField;
        arrayText[11] = truckSpaceField;


        for (int i = 0; i < arrayText.length; i++) {

            if (arrayText[i].getText().toString().equals("") || arrayText[i].getText().toString().equals("0")) {
                alert();
                return false;

            }


        }


        return true;


    }

    /**
     * Alert.
     */
    public void alert() {

        AlertDialog.Builder builder = new AlertDialog.Builder(GarageSetupActivity.this);
        builder.setCancelable(true);
        builder.setTitle("Alert!");
        builder.setMessage("Please enter a numerical value for all fields...");

        builder.setNegativeButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();

            }
        });


        builder.show();
    }
}
