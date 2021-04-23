package com.example.olioht;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class jsonhelper {
    private Double Restaurant;
    private String response;
    private String url2 = "https://ilmastodieetti.ymparisto.fi/ilmastodieetti/calculatorapi/v1/FoodCalculator?query.diet=omnivore&query.restaurantSpending=";

    public void readJSON() {
        String json = response;
        if (json != null) {
            try {
              //  JSONArray jarray = new JSONArray(json);
              //  for (int i = 0; i < jarray.length(); i++) {
              //      JSONObject jobject = jarray.getJSONObject(i);
                    JSONObject jobject = new JSONObject(json);
                    Restaurant =jobject.getDouble("Restaurant");
              //  }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

    }

    public void getJSON(String spending) {
        try {
            URL url = new URL(url2 + spending);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            InputStream in = new BufferedInputStream(conn.getInputStream());
            BufferedReader buf = new BufferedReader(new InputStreamReader(in));
            StringBuilder sb = new StringBuilder();
            String line = null;
            while ((line = buf.readLine()) != null) {
                sb.append(line).append("\n");
            }
            response = sb.toString();
            in.close();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public Double getRestaurant() {
        return Restaurant;
    }
}
