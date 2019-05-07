package com.project.cse248garage.databasePhpTest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.project.cse248garage.R;

public class DataBaseLoginActivity extends AppCompatActivity {

    EditText userNameEt;
    EditText passwordEt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_base_login);

        userNameEt = (EditText)findViewById(R.id.userName);
        passwordEt = (EditText)findViewById(R.id.password);





    }


    public void onLogin(View view){

        String userName = userNameEt.getText().toString();
        String password = passwordEt.getText().toString();
        System.out.println(userName + password);
        String type = "login";

        BackgroundWorkerTest backgroundWorker = new BackgroundWorkerTest(this);
        backgroundWorker.execute(type, userName, password);


    }

    public void OpenReg(View view){
        startActivity(new Intent(this, RegisterActivity.class));



    }
}
