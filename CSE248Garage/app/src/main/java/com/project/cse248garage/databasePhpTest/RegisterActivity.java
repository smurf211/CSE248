package com.project.cse248garage.databasePhpTest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.project.cse248garage.R;

public class RegisterActivity extends AppCompatActivity {
    EditText firstnameEt;
    EditText lastnameEt;
    EditText usernameEt;
    EditText passwordEt;
    EditText adminEt;
    String str_firstname, str_lastname, str_username, str_password, str_admin;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        firstnameEt = (EditText)findViewById(R.id.firstname_field);
        lastnameEt = (EditText)findViewById(R.id.lastname_field);
        usernameEt = (EditText)findViewById(R.id.username_field);
        passwordEt = (EditText)findViewById(R.id.password_field);
        adminEt = (EditText)findViewById(R.id.admin_field);



    }

    public void OnReg(View view){

        str_firstname = firstnameEt.getText().toString();
        str_lastname = passwordEt.getText().toString();
        str_username = usernameEt.getText().toString();
        str_password = passwordEt.getText().toString();
        str_admin = adminEt.getText().toString();

        System.out.println(str_username + str_password);
        String type = "register";

        BackgroundWorkerTest backgroundWorker = new BackgroundWorkerTest(this);
        backgroundWorker.execute(type, str_firstname, str_lastname, str_username, str_password, str_admin);



    }
}
