package com.project.cse248garage.controller;

import android.content.Context;
import android.os.AsyncTask;

import com.project.cse248garage.model.Garage;

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
 * The type Background task garage.
 */
class BackgroundTaskGarage extends AsyncTask<String, Void, String> {

    Context context;
    JSONObject jsonObject;
    JSONArray jsonArray;
    Garage garage;

    /**
     * Instantiates a new Background task garage.
     *
     * @param ctx the ctx
     */
    public BackgroundTaskGarage(Context ctx) {

        context = ctx;
    }

    /**
     * Create garage.
     */
    public void createGarage() {


        try {
            jsonObject = new JSONObject((json_result_garage));
            jsonArray = jsonObject.getJSONArray("server_response");
            int count = 0;
            String carsize, trucksize, motosize, car_early, car_per_hour, truck_early, truck_per_hour, moto_early, moto_per_hour;
            while (count < jsonObject.length()) {

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
        } catch (JSONException e) {
            e.printStackTrace();
        }
        garage.getBag().displayBagHash();

    }



    String json_url_garage;
    String JSON_STRING;
    String json_result_garage;


    @Override
    protected void onPreExecute() {

    }


    @Override
    protected String doInBackground(String... param) {

        json_url_garage = "http://smurf211.com/json_get_data_garage.php";


        String type = param[0];


        if (type.equals("garage")) {


            try {
                URL url = new URL(json_url_garage);
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


        json_result_garage = result;


        MainActivity.setJson_result_garage(result);


    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    /**
     * Gets json result garage.
     *
     * @return the json result garage
     */
    public String getJson_result_garage() {
        return json_result_garage;
    }
}