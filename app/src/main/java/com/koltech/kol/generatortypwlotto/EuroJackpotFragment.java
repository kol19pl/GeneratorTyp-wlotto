package com.koltech.kol.generatortypwlotto;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class EuroJackpotFragment extends Fragment {



    List<Integer> ListaNumeruw;
    List<Integer> ListaNumeruw2;

    TextView jeden;
    TextView dwa;
    TextView trzy;
    TextView cztery;
    TextView piec;
    TextView dziesiencjeden;
    TextView dziesienc2;


    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.euro_jakpot, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        jeden = (TextView) view.findViewById(R.id.Pierwszaliczba);
        dwa = (TextView) view.findViewById(R.id.Drugaliczba);
        trzy=(TextView) view.findViewById(R.id.Trzecialiczba);
        cztery=(TextView)view.findViewById(R.id.czwartaliczba);
        piec=(TextView)view.findViewById(R.id.piontaliczba);
        dziesiencjeden=(TextView)view.findViewById(R.id.pierwsadychaliczba);
        dziesienc2=(TextView)view.findViewById(R.id.drugaliczbaliczba);

        view.findViewById(R.id.buttonLosuj).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Losuj(5,50);
                Wyswietl();
            }
        });
    }



    void  Losuj(int liczbalosowanych,int max){

        ListaNumeruw = new ArrayList<Integer>();
        ListaNumeruw2 = new ArrayList<Integer>();
        Random r = new Random();

        while(ListaNumeruw.size()<liczbalosowanych){
            int numer =r.nextInt(max)+1;
            if(!ListaNumeruw.contains(numer)){
                ListaNumeruw.add(numer);
            }
        }
        Random a = new Random();
        while(ListaNumeruw2.size()<2){
            int numer =a.nextInt(10)+1;
            if(!ListaNumeruw2.contains(numer)){
                ListaNumeruw2.add(numer);
            }
        }

    }

    void Wyswietl(){
        jeden.setText(Integer.toString(ListaNumeruw.get(0)));
        dwa.setText(Integer.toString(ListaNumeruw.get(1)));
        trzy.setText(Integer.toString(ListaNumeruw.get(2)));
        cztery.setText(Integer.toString(ListaNumeruw.get(3)));
        piec.setText(Integer.toString(ListaNumeruw.get(4)));
        dziesiencjeden.setText(Integer.toString(ListaNumeruw2.get(0)));
        dziesienc2.setText(Integer.toString(ListaNumeruw2.get(1)));


    }
}
