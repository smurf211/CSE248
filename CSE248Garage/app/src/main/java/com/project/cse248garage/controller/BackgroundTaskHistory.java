package com.project.cse248garage.controller;

import android.content.Context;
import android.os.AsyncTask;

import com.project.cse248garage.model.Garage;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

class BackgroundTaskHistory extends AsyncTask<String, Void, String> {
    Context context;
    JSONObject jsonObject;
    JSONArray jsonArray;
    Garage garage;

    public BackgroundTaskHistory(Context ctx) {

        context = ctx;
    }




    String json_url_history;
    String JSON_STRING;
    String json_result_history;



    @Override
    protected void onPreExecute() {

    }


    @Override
    protected String doInBackground(String... param) {

        json_url_history = "http://smurf211.com/json_get_data_history.php";



        String type = param[0];


        if(type.equals("history")){


            try {
                URL url = new URL(json_url_history);
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




        json_result_history = result;


        MainActivity.setJson_result_history(result);

        // garage.toString();
        //  createGarage();



    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }


}