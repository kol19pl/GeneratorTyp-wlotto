package com.koltech.kol.generatortypwlotto;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SprawdzWyniki#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SprawdzWyniki extends Fragment {


    private TextView textViewWyniki;
    String gra= "Lotto";
    int liczba= 1;

    Button button;

    Spinner mySpinner;
    EditText editText;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public SprawdzWyniki() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SprawdzWyniki.
     */
    // TODO: Rename and change types and number of parameters
    public static SprawdzWyniki newInstance(String param1, String param2) {
        SprawdzWyniki fragment = new SprawdzWyniki();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sprawdz_wyniki, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        textViewWyniki = view.findViewById(R.id.textViewWyniki); // Inicjalizacja TextView



        button = view.findViewById(R.id.buttonSprawdz);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showGameSelectionDialog();
               // new SprawdzLottoTask().execute();
            }
        });

        editText = view.findViewById(R.id.editTextNumber);




        liczba = Integer.valueOf(editText.getText().toString());

        new SprawdzLottoTask().execute();




    }


    private void showGameSelectionDialog() {
        final String[] gamesArray = getResources().getStringArray(R.array.games_array);

        AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
        builder.setTitle("Wybierz grę");
        builder.setItems(gamesArray, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                gra = gamesArray[which];
                button.setText(gra);
                liczba = Integer.valueOf(editText.getText().toString());
                new SprawdzLottoTask().execute();
            }
        });
        builder.show();
    }



    private class SprawdzLottoTask extends AsyncTask<Void, Void, String> {
        @Override
        protected String doInBackground(Void... voids) {
            String apiUrl = "https://www.lotto.pl/api/lotteries/draw-results/by-gametype?game="+gra+"&index=1&size="+liczba+"&sort=drawDate&order=DESC";
            try {
                // Pobieramy dane JSON z API
                return getJsonResponse(apiUrl);
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }

        @Override
        public void onPostExecute(String jsonResponse) {
            if (jsonResponse != null) {
                StringBuilder wynikiText = new StringBuilder();

                try {
                    JSONObject jsonObject = new JSONObject(jsonResponse);
                    JSONArray itemsArray = jsonObject.getJSONArray("items");

                    for (int i = 0; i < itemsArray.length(); i++) {
                        JSONObject itemObject = itemsArray.getJSONObject(i);
                        String drawDate = itemObject.getString("drawDate");
                        JSONArray resultsArray = itemObject.getJSONArray("results");

                        wynikiText.append("Losowanie ").append(i + 1).append(":").append("\n");
                        wynikiText.append("Data losowania: ").append(drawDate).append("\n");

                        for (int j = 0; j < resultsArray.length(); j++) {
                            JSONObject resultObject = resultsArray.getJSONObject(j);
                            String gameType = resultObject.getString("gameType");
                            JSONArray resultsJsonArray = resultObject.getJSONArray("resultsJson");
                            JSONArray specialResultsArray = resultObject.getJSONArray("specialResults");

                            wynikiText.append("Typ gry: ").append(gameType).append("\n");
                            wynikiText.append("Wyniki: ").append(resultsJsonArray.toString()).append("\n");
                            wynikiText.append("Wyniki specjalne: ").append(specialResultsArray.toString()).append("\n");
                            wynikiText.append("\n");
                        }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                // Aktualizacja TextView z wynikami
                textViewWyniki.setText(wynikiText.toString());
            } else {
                textViewWyniki.setText("Błąd podczas pobierania danych z API");
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