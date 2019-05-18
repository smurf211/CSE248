package com.project.cse248garage.controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.project.cse248garage.R;
import com.project.cse248garage.model.Garage;
import com.project.cse248garage.model.Reciept;
import com.project.cse248garage.model.Ticket;
import com.project.cse248garage.model.User;

/**
 * The type Reciept activity.
 */
public class RecieptActivity extends AppCompatActivity {

    Garage garage;
    Reciept reciept;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reciept);

        garage = (Garage) getIntent().getSerializableExtra("Garage");
        reciept = (Reciept) getIntent().getSerializableExtra("Reciept");

    }


    /**
     * Print reciept.
     *
     * @param view the view
     */
    public void printReciept(View view) {


        TextView displayField = findViewById(R.id.display_field);
        displayField.setText(reciept.toStringSpan());


    }

    /**
     * Done.
     *
     * @param view the view
     */
    public void done(View view) {


        User user = garage.getBag().getLoggedInUser(garage.getBag().getUserAccountHash());

        if (user.isAdmin()) {
            Intent intent = new Intent(this, ManagerSelectActivity.class);
            intent.putExtra("Garage", garage);
            startActivity(intent);


        } else {


            Intent intent = new Intent(this, AttendantOptionsActivity.class);
            intent.putExtra("Garage", garage);
            startActivity(intent);
        }


    }


}
