package com.koltech.kol.generatortypwlotto;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class KenoFragment extends Fragment {


    List<Integer> ListaNumeruw;

    TextView jeden;
    TextView dwa;
    TextView trzy;
    TextView cztery;
    TextView piec;
    TextView szesc;
    TextView siedem;
    TextView osiem;
    TextView dziewienc;
    TextView dziesienc;

    SeekBar seekBar;
    TextView iloscliczb;

    Button Randomize;


    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.keno, container, false);
    }


    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        jeden = (TextView) view.findViewById(R.id.Pierwszaliczba);
        dwa = (TextView) view.findViewById(R.id.Drugaliczba);
        trzy = (TextView) view.findViewById(R.id.Trzecialiczba);
        cztery = (TextView) view.findViewById(R.id.czwartaliczba);
        piec = (TextView) view.findViewById(R.id.piontaliczba);
        szesc = (TextView) view.findViewById(R.id.szustaliczba);
        siedem = (TextView) view.findViewById(R.id.Siudmaliczba);
        osiem = (TextView) view.findViewById(R.id.Usmaliczba);
        dziewienc = (TextView) view.findViewById(R.id.Dziewiontaliczba);
        dziesienc = (TextView) view.findViewById(R.id.Dziesiontaliczba);

        Randomize = (Button) view.findViewById(R.id.buttonLosuj);


        seekBar = (SeekBar) view.findViewById(R.id.seekBar);
        iloscliczb = (TextView) view.findViewById(R.id.textViewIloscLiczb);

        Randomize.setOnClickListener(v -> {
            //if (seekBar.getProgress() != null)
            Losuj(seekBar.getProgress(),70);
            Wyswietl();
        });



        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                @Override
                public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                      iloscliczb.setText(String.valueOf(progress));
                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {

                }

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {
                    Losuj(seekBar.getProgress(),70);
                    Wyswietl();
                }


            });


        }
    }


        void Losuj ( int liczbalosowanych, int max){

            ListaNumeruw = new ArrayList<>();
            Random r = new Random();

            while (ListaNumeruw.size() < liczbalosowanych) {
                int numer = r.nextInt(max) + 1;
                if (!ListaNumeruw.contains(numer)) {
                    ListaNumeruw.add(numer);
                }
            }

        }

        @SuppressLint("SetTextI18n")
        void Wyswietl () {



            jeden.setText(Integer.toString(ListaNumeruw.get(0)));
            if(ListaNumeruw.size()>1) {
                dwa.setText(Integer.toString(ListaNumeruw.get(1)));
            }else {
                dwa.setText("XX");
            }
            if(ListaNumeruw.size()>2){
            trzy.setText(Integer.toString(ListaNumeruw.get(2)));
            }else {
                trzy.setText("XX");
            }
            if(ListaNumeruw.size()>3){
            cztery.setText(Integer.toString(ListaNumeruw.get(3)));
            }else {
                cztery.setText("XX");
            }
            if(ListaNumeruw.size()>4) {
                piec.setText(Integer.toString(ListaNumeruw.get(4)));
            }else {
                piec.setText("XX");
            }
            if(ListaNumeruw.size()>5){
            szesc.setText(Integer.toString(ListaNumeruw.get(5)));
            }else {
                szesc.setText("XX");
            }
            if(ListaNumeruw.size()>6){
            siedem.setText(Integer.toString(ListaNumeruw.get(6)));
            }else {
                siedem.setText("XX");
            }
            if(ListaNumeruw.size()>7){
            osiem.setText(Integer.toString(ListaNumeruw.get(7)));
            }else {
                osiem.setText("XX");
            }
            if(ListaNumeruw.size()>8){
            dziewienc.setText(Integer.toString(ListaNumeruw.get(8)));
            }else {
                dziewienc.setText("XX");
            }
            if(ListaNumeruw.size()>9){
            dziesienc.setText(Integer.toString(ListaNumeruw.get(9)));
            }else {
                dziesienc.setText("XX");
            }


        }
    }

