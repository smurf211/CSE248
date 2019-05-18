package com.project.cse248garage.controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.project.cse248garage.R;
import com.project.cse248garage.model.Garage;
import com.project.cse248garage.model.ParkingSpace;
import com.project.cse248garage.model.Reciept;
import com.project.cse248garage.model.User;

/**
 * The type Attendant remove activity.
 */
public class AttendantRemoveActivity extends AppCompatActivity {
    /**
     * The Garage.
     */
    Garage garage;
    /**
     * The Reciept.
     */
    Reciept reciept;
    /**
     * The Background worker.
     */
    BackgroundWorker backgroundWorker;
    /**
     * The History worker.
     */
    BackgroundWorker historyWorker;
    /**
     * The Button 7.
     */
    Button button7;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendant_remove);

        garage = (Garage) getIntent().getSerializableExtra("Garage");
        backgroundWorker = new BackgroundWorker(this);
        historyWorker = new BackgroundWorker(this);
        button7 = findViewById(R.id.button7);
    }

    /**
     * Remove vehicle.
     *
     * @param view the view
     */
    public void removeVehicle(View view) {

        EditText licenseField = findViewById(R.id.license_field);
        String licensePlate = licenseField.getText().toString();


        if (garage.findByPlate(licensePlate) == null) {

            licenseField.setError("Vehicle not found..");
            return;
        }


        reciept = garage.removeCar(licensePlate, backgroundWorker, historyWorker);
        button7.setEnabled(false);
        float alpha = 0.45f;
        button7.setAlpha(alpha);


    }

    /**
     * Done.
     *
     * @param view the view
     */
    public void done(View view) {

        Intent intent = new Intent(this, AttendantOptionsActivity.class);
        intent.putExtra("Garage", garage);

        startActivity(intent);
    }

    /**
     * Next view.
     *
     * @param view the view
     */
    public void nextView(View view) {


        Intent intent = new Intent(this, RecieptActivity.class);
        intent.putExtra("Garage", garage);
        intent.putExtra("Reciept", reciept);
        startActivity(intent);

    }
}
