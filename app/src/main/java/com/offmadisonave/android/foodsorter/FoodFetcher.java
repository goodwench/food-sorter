package com.offmadisonave.android.foodsorter;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import android.app.Activity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class FoodFetcher {
    private static final String TAG = "FoodFetcher";
    private static final String APIKey = "57b78c84b3051576768edd66";
    private byte[] getUrlBytes(String urlSpec) throws IOException {
        URL url = new URL(urlSpec);
        HttpURLConnection connection = (HttpURLConnection)url.openConnection();
        connection.addRequestProperty("Authorization", APIKey);

        try {
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            InputStream in = connection.getInputStream();

            if (connection.getResponseCode() != HttpURLConnection.HTTP_OK) {
                throw new IOException(connection.getResponseMessage() +
                    ": with " +
                        urlSpec);

            }

            int bytesRead;
            byte[] buffer = new byte[1024];
            while ((bytesRead = in.read(buffer)) > 0 ) {
                out.write(buffer, 0, bytesRead);
            }

            out.close();
            return out.toByteArray();
        } finally {
            connection.disconnect();
        }
    }

    private String getUrlString(String urlSpec) throws IOException {
        return new String(getUrlBytes(urlSpec));
    }

    public List<Food> fetchItems() {
        
        try {
            String url = Uri.parse("https://food-sorter-api.herokuapp.com/records")
                    .buildUpon()
                    .appendQueryParameter("format", "json")
                    .build().toString();

            String jsonString = getUrlString(url);
            Log.i(TAG, "Received JSON: " + jsonString);
            JSONArray jsonBody = new JSONArray(jsonString);
            
        } catch (JSONException je) {
            Log.e(TAG, "Failed to parse JSON", je);
        } catch (IOException ioe) {
            Log.e(TAG, "Failed to fetch items", ioe);
        }

        return parseItems(jsonBody);;
    }

    private List<Food> parseItems(JSONArray jsonBody)
        throws IOException, JSONException {

        List<Food> mFoods = new ArrayList<>();

        for (int i = 0; i < jsonBody.length(); i++) {
            JSONObject foodJsonObject = jsonBody.getJSONObject(i);

            Food item = new Food();

            item.setfId(foodJsonObject.getString("_id"));
            item.setTitle(foodJsonObject.getString("name"));
            item.setServing(foodJsonObject.getString("servingSize"));
            item.setCalories(foodJsonObject.getString("calories"));
            item.setFat(foodJsonObject.getString("fat"));
            item.setCholesterol(foodJsonObject.getString("cholesterol"));
            item.setSodium(foodJsonObject.getString("sodium"));
            item.setCarbs(foodJsonObject.getString("totalCarbs"));
            item.setFiber(foodJsonObject.getString("dietaryFiber"));
            item.setSugars(foodJsonObject.getString("sugars"));
            item.setProtein(foodJsonObject.getString("protein"));


            Log.i(TAG, "Log Item: " + item);

            mFoods.add(item);

        }

        return mFoods;


    }


}
