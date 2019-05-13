package com.project.cse248garage.controller;

import android.app.AlertDialog;
import android.content.Context;
import android.os.AsyncTask;

import com.project.cse248garage.model.Garage;
import com.project.cse248garage.model.User;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class BackgroundWorker extends AsyncTask<String, Void, String> {

    Context context;
    AlertDialog alertDialog;
    String idResult;
    String result;


    public BackgroundWorker(Context ctx) {

        context = ctx;
    }


    @Override
    protected String doInBackground(String... params) {
        String type = params[0];

        String login_url = "http://smurf211.com/login.php";
        String register_url = "http://smurf211.com/register.php";
        String create_garage_url = "http://smurf211.com/creategarage.php";
        String create_vehicle_url = "http://smurf211.com/createvehicle.php";
        String park_vehicle_url = "http://smurf211.com/parkvehicle.php";
        String remove_vehicle_url = "http://smurf211.com/removevehicle.php";
        String remove_attendant_url = "http://smurf211.com/removeattendant.php";
        String create_history_url = "http://smurf211.com/createhistory.php";
        String destroy_garage_url = "http://smurf211.com/destroygarage.php";

        if (type.equals("login")) {

            try {
                String user_name = params[1];
                String password = params[2];

                URL url = new URL(login_url);

                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_data = URLEncoder.encode("user_name", "UTF-8") + "=" + URLEncoder.encode(user_name, "UTF-8") + "&"
                        + URLEncoder.encode("password", "UTF-8") + "=" + URLEncoder.encode(password, "UTF-8");
                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader((new InputStreamReader(inputStream, "iso-8859-1")));
                result = "";
                String line = "";
                while ((line = bufferedReader.readLine()) != null) {
                    result += line;
                }


                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return result;


            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }


        } else if (type.equals("register")) {
            try {

                String firstname = params[1];
                String lastname = params[2];
                String username = params[3];
                String password = params[4];
                String admin = params[5];


                URL url = new URL(register_url);

                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));

                String post_data = URLEncoder.encode("firstname", "UTF-8") + "=" + URLEncoder.encode(firstname, "UTF-8") + "&" +
                        URLEncoder.encode("lastname", "UTF-8") + "=" + URLEncoder.encode(lastname, "UTF-8") + "&" +
                        URLEncoder.encode("username", "UTF-8") + "=" + URLEncoder.encode(username, "UTF-8") + "&" +
                        URLEncoder.encode("password", "UTF-8") + "=" + URLEncoder.encode(password, "UTF-8") + "&"
                        + URLEncoder.encode("admin", "UTF-8") + "=" + URLEncoder.encode(admin, "UTF-8");


                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader((new InputStreamReader(inputStream, "iso-8859-1")));
                result = "";
                String line = "";
                while ((line = bufferedReader.readLine()) != null) {
                    result += line;
                }


                // System.out.println(result);
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return result;


            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }


        } else if (type.equals("create garage")) {


            try {

                String carsize = params[1];
                String trucksize = params[2];
                String motosize = params[3];
                String car_early = params[4];
                String car_per_hour = params[5];
                String truck_early = params[6];
                String truck_per_hour = params[7];
                String moto_early = params[8];
                String moto_per_hour = params[9];

                System.out.println(truck_early + " " + moto_early);


                URL url = new URL(create_garage_url);

                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));

                String post_data = URLEncoder.encode("carsize", "UTF-8") + "=" + URLEncoder.encode(carsize, "UTF-8") + "&" +
                        URLEncoder.encode("trucksize", "UTF-8") + "=" + URLEncoder.encode(trucksize, "UTF-8") + "&" +
                        URLEncoder.encode("motosize", "UTF-8") + "=" + URLEncoder.encode(motosize, "UTF-8") + "&" +
                        URLEncoder.encode("car_early", "UTF-8") + "=" + URLEncoder.encode(car_early, "UTF-8") + "&"
                        + URLEncoder.encode("car_per_hour", "UTF-8") + "=" + URLEncoder.encode(car_per_hour, "UTF-8") + "&" +
                        URLEncoder.encode("truck_early", "UTF-8") + "=" + URLEncoder.encode(truck_early, "UTF-8") + "&"
                        + URLEncoder.encode("truck_per_hour", "UTF-8") + "=" + URLEncoder.encode(truck_per_hour, "UTF-8") + "&" +
                        URLEncoder.encode("moto_early", "UTF-8") + "=" + URLEncoder.encode(moto_early, "UTF-8") + "&"
                        + URLEncoder.encode("moto_per_hour", "UTF-8") + "=" + URLEncoder.encode(moto_per_hour, "UTF-8");


                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader((new InputStreamReader(inputStream, "iso-8859-1")));
                result = "";
                String line = "";
                while ((line = bufferedReader.readLine()) != null) {
                    result += line;
                }


                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return result;


            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }


        } else if (type.equals("create vehicle")) {


            try {

                String user_id = params[1];

                String license_plate = params[2];
                String f_category = params[3];
                String category = params[4];
                String space_id = params[5];
                String date_in = params[6];
                String date_out = params[7];
                String time_in = params[8];
                String time_out = params[9];
                String early_bird = params[10];
                String rate = params[11];
                String isDeleted = "N";


                URL url = new URL(create_vehicle_url);

                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));

                String post_data = URLEncoder.encode("user_id", "UTF-8") + "=" + URLEncoder.encode(user_id, "UTF-8") + "&" +

                        URLEncoder.encode("license_plate", "UTF-8") + "=" + URLEncoder.encode(license_plate, "UTF-8") + "&" +
                        URLEncoder.encode("f_category", "UTF-8") + "=" + URLEncoder.encode(f_category, "UTF-8") + "&"
                        + URLEncoder.encode("category", "UTF-8") + "=" + URLEncoder.encode(category, "UTF-8") + "&" +
                        URLEncoder.encode("space_id", "UTF-8") + "=" + URLEncoder.encode(space_id, "UTF-8") + "&"
                        + URLEncoder.encode("date_in", "UTF-8") + "=" + URLEncoder.encode(date_in, "UTF-8") + "&" +
                        URLEncoder.encode("date_out", "UTF-8") + "=" + URLEncoder.encode(date_out, "UTF-8") + "&"
                        + URLEncoder.encode("time_in", "UTF-8") + "=" + URLEncoder.encode(time_in, "UTF-8")
                        + "&" +
                        URLEncoder.encode("time_out", "UTF-8") + "=" + URLEncoder.encode(time_out, "UTF-8") + "&"
                        + URLEncoder.encode("early_bird", "UTF-8") + "=" + URLEncoder.encode(early_bird, "UTF-8")
                        + "&"
                        + URLEncoder.encode("rate", "UTF-8") + "=" + URLEncoder.encode(rate, "UTF-8")
                        + "&"
                        + URLEncoder.encode("isDeleted", "UTF-8") + "=" + URLEncoder.encode(isDeleted, "UTF-8");


                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader((new InputStreamReader(inputStream, "iso-8859-1")));
                result = "";
                String line = "";
                while ((line = bufferedReader.readLine()) != null) {
                    result += line;
                }


                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return result;


            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }


        } else if (type.equals("park vehicle")) {


            try {

                String category = params[1];
                String car_distance = params[2];
                String truck_distance = params[3];
                String moto_distance = params[4];
                String distance = params[5];
                String early_bird = params[6];

                String free = params[7];
                String vehicle_id = params[8];
                String time = params[9];
                String date = params[10];
                String space_id = params[11];
                String isDeleted = "N";


                URL url = new URL(park_vehicle_url);

                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));

                String post_data = URLEncoder.encode("category", "UTF-8") + "=" + URLEncoder.encode(category, "UTF-8") + "&" +
                        URLEncoder.encode("car_distance", "UTF-8") + "=" + URLEncoder.encode(car_distance, "UTF-8") + "&" +
                        URLEncoder.encode("truck_distance", "UTF-8") + "=" + URLEncoder.encode(truck_distance, "UTF-8") + "&"
                        + URLEncoder.encode("moto_distance", "UTF-8") + "=" + URLEncoder.encode(moto_distance, "UTF-8") + "&" +
                        URLEncoder.encode("distance", "UTF-8") + "=" + URLEncoder.encode(distance, "UTF-8") + "&"
                        + URLEncoder.encode("early_bird", "UTF-8") + "=" + URLEncoder.encode(early_bird, "UTF-8") + "&" +

                        URLEncoder.encode("free", "UTF-8") + "=" + URLEncoder.encode(free, "UTF-8")
                        + "&" +
                        URLEncoder.encode("vehicle_id", "UTF-8") + "=" + URLEncoder.encode(vehicle_id, "UTF-8") + "&"
                        + URLEncoder.encode("time", "UTF-8") + "=" + URLEncoder.encode(time, "UTF-8")
                        + "&"
                        + URLEncoder.encode("date", "UTF-8") + "=" + URLEncoder.encode(date, "UTF-8")
                        + "&"
                        + URLEncoder.encode("space_id", "UTF-8") + "=" + URLEncoder.encode(space_id, "UTF-8");


                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader((new InputStreamReader(inputStream, "iso-8859-1")));
                result = "";
                String line = "";
                while ((line = bufferedReader.readLine()) != null) {
                    result += line;
                }


                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return result;


            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }


        } else if (type.equals("remove vehicle")) {


            try {


                String vehicle_id = params[1];


                URL url = new URL(remove_vehicle_url);

                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));

                String post_data = URLEncoder.encode("vehicle_id", "UTF-8") + "=" + URLEncoder.encode(vehicle_id, "UTF-8");


                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader((new InputStreamReader(inputStream, "iso-8859-1")));
                result = "";
                String line = "";
                while ((line = bufferedReader.readLine()) != null) {
                    result += line;
                }


                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return result;


            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }


        } else if (type.equals("remove attendant")) {


            try {


                String user_id = params[1];


                URL url = new URL(remove_attendant_url);

                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));

                String post_data = URLEncoder.encode("user_id", "UTF-8") + "=" + URLEncoder.encode(user_id, "UTF-8");


                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader((new InputStreamReader(inputStream, "iso-8859-1")));
                result = "";
                String line = "";
                while ((line = bufferedReader.readLine()) != null) {
                    result += line;
                }


                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return result;


            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }


        } else if (type.equals("create history")) {


            try {


                String date_in = params[1];
                String date_out = params[2];
                String time_in = params[3];
                String time_out = params[4];
                String early_bird = params[5];
                String space_id = params[6];
                String license_plate = params[7];
                String user_parked_id = params[8];
                String user_removed_id = params[9];
                String category = params[10];
                String false_category = params[11];
                String rate = params[12];
                String payment_scheme = params[13];
                String vehicle_id = params[14];

                URL url = new URL(create_history_url);

                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));

                String post_data = URLEncoder.encode("date_in", "UTF-8") + "=" + URLEncoder.encode(date_in, "UTF-8") + "&" +
                        URLEncoder.encode("date_out", "UTF-8") + "=" + URLEncoder.encode(date_out, "UTF-8") + "&" +
                        URLEncoder.encode("time_in", "UTF-8") + "=" + URLEncoder.encode(time_in, "UTF-8") + "&"
                        + URLEncoder.encode("time_out", "UTF-8") + "=" + URLEncoder.encode(time_out, "UTF-8") + "&" +
                        URLEncoder.encode("early_bird", "UTF-8") + "=" + URLEncoder.encode(early_bird, "UTF-8") + "&"
                        + URLEncoder.encode("space_id", "UTF-8") + "=" + URLEncoder.encode(space_id, "UTF-8") + "&" +

                        URLEncoder.encode("license_plate", "UTF-8") + "=" + URLEncoder.encode(license_plate, "UTF-8")
                        + "&" +
                        URLEncoder.encode("user_parked_id", "UTF-8") + "=" + URLEncoder.encode(user_parked_id, "UTF-8") + "&"
                        + URLEncoder.encode("user_removed_id", "UTF-8") + "=" + URLEncoder.encode(user_removed_id, "UTF-8")
                        + "&"
                        + URLEncoder.encode("category", "UTF-8") + "=" + URLEncoder.encode(category, "UTF-8")
                        + "&"
                        + URLEncoder.encode("false_category", "UTF-8") + "=" + URLEncoder.encode(false_category, "UTF-8")
                        + "&"
                        + URLEncoder.encode("rate", "UTF-8") + "=" + URLEncoder.encode(rate, "UTF-8")
                        + "&"
                        + URLEncoder.encode("payment_scheme", "UTF-8") + "=" + URLEncoder.encode(payment_scheme, "UTF-8")
                        + "&"
                        + URLEncoder.encode("vehicle_id", "UTF-8") + "=" + URLEncoder.encode(vehicle_id, "UTF-8");


                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader((new InputStreamReader(inputStream, "iso-8859-1")));
                result = "";
                String line = "";
                while ((line = bufferedReader.readLine()) != null) {
                    result += line;
                }


                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return result;


            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }


        }

        if (type.equals("destroy garage")) {

            try {


                URL url = new URL(destroy_garage_url);

                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_data = "";
                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader((new InputStreamReader(inputStream, "iso-8859-1")));
                result = "";
                String line = "";
                while ((line = bufferedReader.readLine()) != null) {
                    result += line;
                }


                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return result;


            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }


        }
        return null;
    }

    @Override
    protected void onPreExecute() {
        alertDialog = new AlertDialog.Builder(context).create();
        alertDialog.setTitle("Login Status");

    }

    @Override
    protected void onPostExecute(String result) {

        alertDialog.setMessage(result);

        alertDialog.show();
        CreateAttendantActivity.setResultID(result);
        AttendantParkActivity.setResultID(result);

    }

    public String getIdResult() {
        return idResult;
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }
}
