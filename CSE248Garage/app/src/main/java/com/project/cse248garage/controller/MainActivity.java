package com.project.cse248garage.controller;

import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.os.AsyncTask;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.project.cse248garage.R;

import com.project.cse248garage.model.Car;
import com.project.cse248garage.model.CheckCredentials;
import com.project.cse248garage.model.Garage;
import com.project.cse248garage.model.Motorcycle;
import com.project.cse248garage.model.ParkingSpace;
import com.project.cse248garage.model.Reciept;
import com.project.cse248garage.model.Record;
import com.project.cse248garage.model.Truck;
import com.project.cse248garage.model.User;
import com.project.cse248garage.model.UserAccountBag;
import com.project.cse248garage.model.Vehicle;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ExecutionException;

/**
 * The type Main activity.
 */
public class MainActivity extends AppCompatActivity {


    CheckCredentials checkCredentials = new CheckCredentials();
    Garage garage;
    String JSON_STRING;
    String json_result_user;
    static String json_result_garage;
    static String json_result_vehicles;
    static String json_result_history;
    JSONObject jsonObject;
    JSONArray jsonArray;
    String typeUser = "user";
    String typeGarage = "garage";
    String typeVehicles = "vehicles";
    String typeHistory = "history";
    String test = "";
    int counter = 0;
    Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        button = findViewById(R.id.button);


        Intent intent = getIntent();


        garage = new Garage();


        getJSON(typeUser);
        BackgroundTaskGarage b1 = new BackgroundTaskGarage(this);
        b1.execute(typeGarage);
        BackgroundTaskVehicles b2 = new BackgroundTaskVehicles(this);
        b2.execute(typeVehicles);
        BackgroundTaskHistory b3 = new BackgroundTaskHistory(this);
        b3.execute(typeHistory);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_mainactivity, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item1:

                Toast.makeText(this, "Load Garage", Toast.LENGTH_SHORT).show();


                return true;


            default:
                return super.onOptionsItemSelected(item);

        }

    }

    /**
     * Admin login.
     *
     * @param view the view
     */
    public void adminLogin(View view) {
        if (counter == 0) {
            createUsers();
            createGarage();
            createVehicles();
            createHistory();
        }
        counter++;


        EditText userNameField = findViewById(R.id.username_field);
        EditText passwordField = findViewById(R.id.password_field);


        String userName = userNameField.getText().toString();
        String password = passwordField.getText().toString();
        String type = "login";


        if (checkCredentials.login(userName, password, garage.getBag().getUserAccountHash())) {


            User user = garage.getBag().getUser(userName, password, garage.getBag().getUserAccountHash());


            if (user.isAdmin()) {


                BackgroundWorker backgroundWorker = new BackgroundWorker(this);
                backgroundWorker.execute(type, userName, password);


                user.setLoggedIn(true);
                Intent intent1 = new Intent(this, ManagerSelectActivity.class);
                intent1.putExtra("Garage", garage);


                startActivity(intent1);
            } else {
                BackgroundWorker backgroundWorker = new BackgroundWorker(this);
                backgroundWorker.execute(type, userName, password);

                user.setLoggedIn(true);
                Intent intent2 = new Intent(this, AttendantOptionsActivity.class);
                intent2.putExtra("Garage", garage);
                startActivity(intent2);
            }


        } else {
            userNameField.setText("");
            passwordField.setText("");
            userNameField.setError("Invalid username or password...");
            passwordField.setError("Invalid username or password...");

            userNameField.setHint("invalid credentials");
            passwordField.setHint("invalid credentials");
        }


    }


    /**
     * Create users.
     */
    public void createUsers() {


        try {
            jsonObject = new JSONObject((json_result_user));
            jsonArray = jsonObject.getJSONArray("server_response");
            if (jsonArray.length() > 0) {

                int count = 0;
                String id, firstname, lastname, username, password, admin;
                while (count < jsonArray.length()) {

                    JSONObject JO = jsonArray.getJSONObject(count);
                    id = JO.getString("id");
                    firstname = JO.getString("firstname");
                    lastname = JO.getString("lastname");
                    username = JO.getString("username");
                    password = JO.getString("password");
                    admin = JO.getString("admin");
                    User user = new User(Integer.valueOf(id), firstname, lastname, username, password, Boolean.valueOf(admin));
                    garage.getBag().getUserAccountHash().put(user, user.emitUserName());

                    count++;
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }


    }

    /**
     * Create garage.
     */
    public void createGarage() {


        try {
            jsonObject = new JSONObject((json_result_garage));
            jsonArray = jsonObject.getJSONArray("server_response");

            if (jsonArray.length() > 0) {
                int count = 0;
                String carsize, trucksize, motosize, car_early, car_per_hour, truck_early, truck_per_hour, moto_early, moto_per_hour;
                while (count < jsonArray.length()) {

                    JSONObject JO = jsonArray.getJSONObject(count);
                    carsize = JO.getString("carsize");
                    trucksize = JO.getString("trucksize");
                    motosize = JO.getString("motosize");
                    car_early = JO.getString("car_early");
                    car_per_hour = JO.getString("car_per_hour");
                    truck_early = JO.getString("truck_early");
                    truck_per_hour = JO.getString("truck_per_hour");
                    moto_early = JO.getString("moto_early");
                    moto_per_hour = JO.getString("moto_per_hour");

                    garage.setSpaces(Integer.valueOf(carsize), Integer.valueOf(trucksize), Integer.valueOf(motosize));
                    garage.setCarEarlyBird(Double.valueOf(car_early));
                    garage.setCarPerHour(Double.valueOf(car_per_hour));
                    garage.setTruckEarlyBird(Double.valueOf(truck_early));
                    garage.setTruckPerHour(Double.valueOf(truck_per_hour));
                    garage.setMotoEarlyBird(Double.valueOf(moto_early));
                    garage.setMotoPerHour(Double.valueOf(moto_per_hour));

                    count++;
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }


    }

    /**
     * Create vehicles.
     */
    public void createVehicles() {
        Vehicle vehicle = null;

        System.out.println(json_result_vehicles);
        try {
            jsonObject = new JSONObject((json_result_vehicles));
            jsonArray = jsonObject.getJSONArray("server_response");
            if (jsonArray.length() > 0) {
                int count = 0;
                String ID, user_id, license_plate, f_category, category, space_id, date_in, date_out, time_in, time_out, early_bird, rate, firstname, lastname;
                while (count < jsonArray.length()) {

                    JSONObject JO = jsonArray.getJSONObject(count);
                    ID = JO.getString("ID");
                    user_id = JO.getString("user_id");
                    license_plate = JO.getString("license_plate");
                    f_category = JO.getString("f_category");
                    category = JO.getString("category");
                    space_id = JO.getString("space_id");
                    date_in = JO.getString("date_in");
                    date_out = JO.getString("date_out");
                    time_in = JO.getString("time_in");
                    time_out = JO.getString("time_out");
                    early_bird = JO.getString("early_bird");
                    rate = JO.getString("rate");
                    firstname = JO.getString("firstname");
                    lastname = JO.getString("lastname");


                    if (category.equals("car")) {

                        vehicle = new Car(Integer.valueOf(ID), Integer.valueOf(user_id), license_plate, f_category, space_id, date_in, time_in, Boolean.valueOf(early_bird), Double.valueOf(rate));
                        vehicle.setAttendantFirstName(firstname);
                        vehicle.setAttendantLastName(lastname);

                    }

                    if (category.equals("truck")) {

                        vehicle = new Truck(Integer.valueOf(ID), Integer.valueOf(user_id), license_plate, f_category, space_id, date_in, time_in, Boolean.valueOf(early_bird), Double.valueOf(rate));
                        vehicle.setAttendantFirstName(firstname);
                        vehicle.setAttendantLastName(lastname);
                    }
                    if (category.equals("motorcycle")) {

                        vehicle = new Motorcycle(Integer.valueOf(ID), Integer.valueOf(user_id), license_plate, f_category, space_id, date_in, time_in, Boolean.valueOf(early_bird), Double.valueOf(rate));
                        vehicle.setAttendantFirstName(firstname);
                        vehicle.setAttendantLastName(lastname);
                    }

                    garage.parkFromDatabase(vehicle);


                    count++;
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        garage.getBag().displayBagHash();

    }

    /**
     * Create history.
     */
    public void createHistory() {

        Vehicle vehicle = null;

        System.out.println(json_result_history);
        try {
            jsonObject = new JSONObject((json_result_history));
            jsonArray = jsonObject.getJSONArray("server_response");
            if (jsonArray.length() > 0) {
                int count = 0;
                String date_in, date_out, time_in, time_out, early_bird, space_id, license_plate, user_parked_id, user_removed_id, category,
                        false_category, rate, payment_scheme, vehicle_id, id1, firstname1, lastname1, username1, password1, id2, firstname2, lastname2, username2, password2;

                while (count < jsonArray.length()) {

                    JSONObject JO = jsonArray.getJSONObject(count);

                    date_in = JO.getString("date_in");
                    date_out = JO.getString("date_out");
                    time_in = JO.getString("time_in");
                    time_out = JO.getString("time_out");
                    early_bird = JO.getString("early_bird");
                    space_id = JO.getString("space_id");
                    license_plate = JO.getString("license_plate");
                    user_parked_id = JO.getString("user_parked_id");
                    user_removed_id = JO.getString("user_removed_id");
                    category = JO.getString("category");
                    false_category = JO.getString("false_category");
                    rate = JO.getString("rate");
                    payment_scheme = JO.getString("payment_scheme");
                    vehicle_id = JO.getString("vehicle_id");
                    id1 = JO.getString("id1");
                    firstname1 = JO.getString("firstname1");
                    lastname1 = JO.getString("lastname1");
                    username1 = JO.getString("username1");
                    password1 = JO.getString("password1");
                    id2 = JO.getString("id2");
                    firstname2 = JO.getString("firstname2");
                    lastname2 = JO.getString("lastname2");
                    username2 = JO.getString("username2");
                    password2 = JO.getString("password2");


                    if (category.equals("car")) {

                        vehicle = new Car(Integer.valueOf(vehicle_id), Integer.valueOf(id1), license_plate, false_category, space_id, date_in, time_in, Boolean.valueOf(early_bird), Double.valueOf(rate));
                        vehicle.setAttendantId(Integer.valueOf(id1));
                        vehicle.setAttendantFirstName(firstname1);
                        vehicle.setAttendantLastName(lastname1);
                        vehicle.setAttendantRemovedFirst(firstname2);
                        vehicle.setAttendantRemovedLast(lastname2);
                        vehicle.setAttendantRemovedId(Integer.valueOf(id2));


                    }

                    if (category.equals("truck")) {
                        vehicle = new Truck(Integer.valueOf(vehicle_id), Integer.valueOf(id1), license_plate, false_category, space_id, date_in, time_in, Boolean.valueOf(early_bird), Double.valueOf(rate));
                        vehicle.setAttendantId(Integer.valueOf(id1));
                        vehicle.setAttendantFirstName(firstname1);
                        vehicle.setAttendantLastName(lastname1);
                        vehicle.setAttendantRemovedFirst(firstname2);
                        vehicle.setAttendantRemovedLast(lastname2);
                        vehicle.setAttendantRemovedId(Integer.valueOf(id2));


                    }
                    if (category.equals("motorcycle")) {
                        vehicle = new Motorcycle(Integer.valueOf(vehicle_id), Integer.valueOf(id1), license_plate, false_category, space_id, date_in, time_in, Boolean.valueOf(early_bird), Double.valueOf(rate));
                        vehicle.setAttendantId(Integer.valueOf(id1));
                        vehicle.setAttendantFirstName(firstname1);
                        vehicle.setAttendantLastName(lastname1);
                        vehicle.setAttendantRemovedFirst(firstname2);
                        vehicle.setAttendantRemovedLast(lastname2);
                        vehicle.setAttendantRemovedId(Integer.valueOf(id2));


                    }


                    Reciept reciept = new Reciept(vehicle, date_in, date_out,
                            time_in, time_out, Boolean.valueOf(early_bird), space_id, Double.valueOf(rate), Double.valueOf(payment_scheme), garage);

                    Record record = garage.getRecordBag().getRecord(license_plate);

                    if (record == null) {

                        record = new Record(vehicle, license_plate);
                        garage.getRecordBag().addRecord(record);
                    }

                    record.addReciept(reciept);


                    count++;
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        garage.getBag().displayBagHash();

    }

    /**
     * Gets json.
     *
     * @param type the type
     */
    public void getJSON(String type) {

        new BackgroundTask().execute(type);


    }


    /**
     * The type Background task.
     */
    class BackgroundTask extends AsyncTask<String, Void, String> {
        /**
         * The Json url user.
         */
        String json_url_user;
        /**
         * The Json url garage.
         */
        String json_url_garage;


        @Override
        protected void onPreExecute() {

        }


        @Override
        protected String doInBackground(String... param) {
            json_url_user = "http://smurf211.com/json_get_data_user.php";
            json_url_garage = "http://smurf211.com/json_get_data_garage.php";


            String type = param[0];

            if (type.equals("user")) {
                test = typeUser;

                try {
                    URL url = new URL(json_url_user);
                    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                    InputStream inputStream = httpURLConnection.getInputStream();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                    StringBuilder stringBuilder = new StringBuilder();
                    while ((JSON_STRING = bufferedReader.readLine()) != null) {

                        stringBuilder.append(JSON_STRING + "\n");
                    }


                    bufferedReader.close();
                    inputStream.close();
                    httpURLConnection.disconnect();
                    return stringBuilder.toString().trim();


                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            return null;
        }


        @Override
        protected void onPostExecute(String result) {


            json_result_user = result;


        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }
    }

    /**
     * Sets json result garage.
     *
     * @param json_result_garage the json result garage
     */
    public static void setJson_result_garage(String json_result_garage) {
        MainActivity.json_result_garage = json_result_garage;
    }

    /**
     * Sets garage.
     *
     * @param garage the garage
     */
    public void setGarage(Garage garage) {
        this.garage = garage;
    }

    /**
     * Sets json result vehicles.
     *
     * @param json_result_vehicles the json result vehicles
     */
    public static void setJson_result_vehicles(String json_result_vehicles) {
        MainActivity.json_result_vehicles = json_result_vehicles;
    }

    /**
     * Sets json result history.
     *
     * @param json_result_history the json result history
     */
    public static void setJson_result_history(String json_result_history) {
        MainActivity.json_result_history = json_result_history;
    }


}
