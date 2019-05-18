package com.project.cse248garage.controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.project.cse248garage.R;
import com.project.cse248garage.model.CheckCredentials;
import com.project.cse248garage.model.Garage;
import com.project.cse248garage.model.User;

/**
 * The type Remove attendant activity.
 */
public class RemoveAttendantActivity extends AppCompatActivity {

    /**
     * The Garage.
     */
    Garage garage;
    /**
     * The Check.
     */
    CheckCredentials check;
    /**
     * The User name field.
     */
    EditText userNameField;

    /**
     * The User name.
     */
    String userName;
    /**
     * The Background worker.
     */
    BackgroundWorker backgroundWorker;
    /**
     * The User id.
     */
    int userID;
    /**
     * The Type.
     */
    String type = "remove attendant";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remove_attendant);

        garage = (Garage) getIntent().getSerializableExtra("Garage");
        check = new CheckCredentials();
        backgroundWorker = new BackgroundWorker(this);
    }

    /**
     * Remove attendant.
     *
     * @param view the view
     */
    public void removeAttendant(View view) {

        userNameField = findViewById(R.id.username_field);
        userName = userNameField.getText().toString();

        if (userName.equals("")) {

            userNameField.setError("enter a username");
            return;
        }


        TextView displayField = findViewById(R.id.display_field);

        User user = garage.getBag().getUser(userName, garage.getBag().getUserAccountHash());

        if (user == null) {

            userNameField.setError("user not found!");
            return;
        }
        userID = user.emitID();


        garage.getBag().removeUser(user);

        backgroundWorker.execute(type, String.valueOf(userID));


        garage.getBag().displayBagHash();
        displayField.setText(user.toString() + " Removed!");
        userNameField.setText("");

    }

    /**
     * Next view.
     *
     * @param view the view
     */
    public void nextView(View view) {
        Intent intent = new Intent(this, ManagerSelectActivity.class);
        intent.putExtra("Garage", garage);
        startActivity(intent);


    }
}
