package com.koltech.kol.generatortypwlotto;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LootoFragment extends Fragment implements AdapterView.OnItemSelectedListener {


    int Liczbalosowan = 6;


    List<Integer> ListaNumeruw;

    TextView jeden;
    TextView dwa;
    TextView trzy;
    TextView cztery;
    TextView piec;
    TextView szesc;
    TextView siedem;
    TextView Osiem;
    TextView Dziewienc;
    TextView Dziesienc;
    TextView Jedenascie;
    TextView Dwanascie;


    Spinner mySpinner;


    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.lotto_main, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        jeden = (TextView) view.findViewById(R.id.Pierwszaliczba);
        dwa = (TextView) view.findViewById(R.id.Drugaliczba);
        trzy=(TextView) view.findViewById(R.id.Trzecialiczba);
        cztery=(TextView)view.findViewById(R.id.czwartaliczba);
        piec=(TextView)view.findViewById(R.id.piontaliczba);
        szesc=(TextView)view.findViewById(R.id.szustaliczba);
        siedem = (TextView) view.findViewById(R.id.Siudmaliczba);
        Osiem = (TextView) view.findViewById(R.id.Usmaliczba);
        Dziewienc=(TextView) view.findViewById(R.id.Dziewiontaliczba);
        Dziesienc=(TextView)view.findViewById(R.id.Dziesiontaliczba);
        Jedenascie=(TextView)view.findViewById(R.id.Jedenastaliczba);
        Dwanascie=(TextView)view.findViewById(R.id.Dwunastaliczba);

        mySpinner = (Spinner) view.findViewById(R.id.spinner1);
        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(getContext(),android.R.layout.simple_spinner_item,getResources().getStringArray(R.array.menu_loto));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner.setAdapter(myAdapter);
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner.setAdapter(myAdapter);
        mySpinner.setOnItemSelectedListener(this);

        view.findViewById(R.id.buttonLosuj).setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {
                  Reset();
                 Losuj(Liczbalosowan,49);
                  Wyswietl();
               }
          });

    }


    void  Losuj(int liczbalosowanych,int max){

        ListaNumeruw = new ArrayList<Integer>();
        Random r = new Random();

        while(ListaNumeruw.size()<liczbalosowanych){
           int numer =r.nextInt(max)+1;
           if(!ListaNumeruw.contains(numer)){
               ListaNumeruw.add(numer);
           }
        }

    }

    void Reset(){
            jeden.setText("XX");
            dwa.setText("XX");
            trzy.setText("XX");
            cztery.setText("XX");
            piec.setText("XX");
            szesc.setText("XX");
            siedem.setText("XX");
            Osiem.setText("XX");
            Dziewienc.setText("XX");
            Dziesienc.setText("XX");
            Jedenascie.setText("XX");
            Dwanascie.setText("XX");

    }

    void Wyswietl(){

        jeden.setText(Integer.toString(ListaNumeruw.get(0)));
        dwa.setText(Integer.toString(ListaNumeruw.get(1)));
        trzy.setText(Integer.toString(ListaNumeruw.get(2)));
        cztery.setText(Integer.toString(ListaNumeruw.get(3)));
        piec.setText(Integer.toString(ListaNumeruw.get(4)));
        szesc.setText(Integer.toString(ListaNumeruw.get(5)));
        try {
        siedem.setText(Integer.toString(ListaNumeruw.get(6)));
        } catch (Exception IndexOutOfBoundsException) {
            siedem.setText("XX");
        }
        try{
        Osiem.setText(Integer.toString(ListaNumeruw.get(7)));
        } catch (Exception IndexOutOfBoundsException) {
            Osiem.setText("XX");
        }
        try {
        Dziewienc.setText(Integer.toString(ListaNumeruw.get(8)));
        } catch (Exception IndexOutOfBoundsException) {
        Dziewienc.setText("XX"); }
        try {
        Dziesienc.setText(Integer.toString(ListaNumeruw.get(9))); } catch (Exception IndexOutOfBoundsException) {
            Dziesienc.setText("XX");
        }
        try {
        Jedenascie.setText(Integer.toString(ListaNumeruw.get(10))); } catch (Exception IndexOutOfBoundsException) {
            Jedenascie.setText("XX");
        }
        try {
        Dwanascie.setText(Integer.toString(ListaNumeruw.get(11))); } catch (Exception IndexOutOfBoundsException) {
            Dwanascie.setText("XX");
        }

    }


    /**
     * <p>Callback method to be invoked when an item in this view has been
     * selected. This callback is invoked only when the newly selected
     * position is different from the previously selected position or if
     * there was no selected item.</p>
     * <p>
     * Implementers can call getItemAtPosition(position) if they need to access the
     * data associated with the selected item.
     *
     * @param parent   The AdapterView where the selection happened
     * @param view     The view within the AdapterView that was clicked
     * @param position The position of the view in the adapter
     * @param id       The row id of the item that is selected
     */
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
      Liczbalosowan = 6+position;
    }

    /**
     * Callback method to be invoked when the selection disappears from this
     * view. The selection can disappear for instance when touch is activated
     * or when the adapter becomes empty.
     *
     * @param parent The AdapterView that now contains no selected item.
     */
    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
