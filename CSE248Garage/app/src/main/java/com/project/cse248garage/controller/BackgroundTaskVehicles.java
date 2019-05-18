package com.project.cse248garage.controller;

import android.content.Context;
import android.os.AsyncTask;

import com.project.cse248garage.model.Car;
import com.project.cse248garage.model.Garage;
import com.project.cse248garage.model.Motorcycle;
import com.project.cse248garage.model.Truck;
import com.project.cse248garage.model.Vehicle;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * The type Background task vehicles.
 */
class BackgroundTaskVehicles extends AsyncTask<String, Void, String> {
    /**
     * The Context.
     */
    Context context;
    /**
     * The Json object.
     */
    JSONObject jsonObject;
    /**
     * The Json array.
     */
    JSONArray jsonArray;
    /**
     * The Garage.
     */
    Garage garage;

    /**
     * Instantiates a new Background task vehicles.
     *
     * @param ctx the ctx
     */
    public BackgroundTaskVehicles(Context ctx) {

        context = ctx;
    }


    /**
     * The Json url vehicles.
     */
    String json_url_vehicles;
    /**
     * The Json string.
     */
    String JSON_STRING;
    /**
     * The Json result vehicles.
     */
    String json_result_vehicles;


    @Override
    protected void onPreExecute() {

    }


    @Override
    protected String doInBackground(String... param) {

        json_url_vehicles = "http://smurf211.com/json_get_data_vehicles.php";


        String type = param[0];


        if (type.equals("vehicles")) {


            try {
                URL url = new URL(json_url_vehicles);
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


        json_result_vehicles = result;


        MainActivity.setJson_result_vehicles(result);

        // garage.toString();
        //  createGarage();


    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }


}
