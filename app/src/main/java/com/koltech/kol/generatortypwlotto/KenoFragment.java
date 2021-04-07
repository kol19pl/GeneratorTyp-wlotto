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
        trzy=(TextView) view.findViewById(R.id.Trzecialiczba);
        cztery=(TextView)view.findViewById(R.id.czwartaliczba);
        piec=(TextView)view.findViewById(R.id.piontaliczba);
        szesc=(TextView)view.findViewById(R.id.szustaliczba);
        siedem=(TextView)view.findViewById(R.id.Siudmaliczba);
        osiem=(TextView)view.findViewById(R.id.Usmaliczba);
        dziewienc=(TextView)view.findViewById(R.id.Dziewiontaliczba);
        dziesienc=(TextView)view.findViewById(R.id.Dziesiontaliczba);

        view.findViewById(R.id.buttonLosuj).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Losuj(10,70);
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

    void Wyswietl(){
        jeden.setText(Integer.toString(ListaNumeruw.get(0)));
        dwa.setText(Integer.toString(ListaNumeruw.get(1)));
        trzy.setText(Integer.toString(ListaNumeruw.get(2)));
        cztery.setText(Integer.toString(ListaNumeruw.get(3)));
        piec.setText(Integer.toString(ListaNumeruw.get(4)));
        szesc.setText(Integer.toString(ListaNumeruw.get(5)));
        siedem.setText(Integer.toString(ListaNumeruw.get(6)));
        osiem.setText(Integer.toString(ListaNumeruw.get(7)));
        dziewienc.setText(Integer.toString(ListaNumeruw.get(8)));
        dziesienc.setText(Integer.toString(ListaNumeruw.get(9)));
    }
}
