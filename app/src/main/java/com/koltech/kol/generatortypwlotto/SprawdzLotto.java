package com.koltech.kol.generatortypwlotto;

import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SprawdzLotto {

    private class SprawdzLottoTask extends AsyncTask<Void, Void, String> {
        @Override
        protected String doInBackground(Void... voids) {
            String apiUrl = "https://www.lotto.pl/api/lotteries/draw-results/by-gametype?game=EkstraPremia&index=1&size=10&sort=drawDate&order=DESC";
            try {
                // Pobieramy dane JSON z API
                return getJsonResponse(apiUrl);
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }

        @Override
        protected void onPostExecute(String jsonResponse) {
            if (jsonResponse != null) {
                // Parsujemy dane JSON i wypisujemy wyniki
                try {
                    JSONArray resultsArray = new JSONArray(jsonResponse);
                    for (int i = 0; i < resultsArray.length(); i++) {
                        JSONObject resultObject = resultsArray.getJSONObject(i);
                        String drawDate = resultObject.getString("drawDate");
                        JSONArray results = resultObject.getJSONArray("resultsJson");

                        Log.d("LottoResults", "Losowanie " + (i + 1) + ":");
                        Log.d("LottoResults", "Data losowania: " + drawDate);
                        Log.d("LottoResults", "Wyniki: " + results.toString());
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            } else {
                Log.e("LottoResults", "Błąd podczas pobierania danych z API");
            }
        }
    }

    // Metoda do pobierania danych JSON z API
    private String getJsonResponse(String apiUrl) throws IOException {
        URL url = new URL(apiUrl);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

        if (conn.getResponseCode() != 200) {
            throw new IOException("Błąd w odpowiedzi HTTP: " + conn.getResponseCode());
        }

        BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        StringBuilder responseBuilder = new StringBuilder();
        String line;

        while ((line = reader.readLine()) != null) {
            responseBuilder.append(line);
        }

        reader.close();
        conn.disconnect();

        return responseBuilder.toString();
    }
}
