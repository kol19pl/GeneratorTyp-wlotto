package com.koltech.kol.generatortypwlotto;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

import java.util.Random;

public class MainActivity extends AppCompatActivity {



    int pierwsza=0;
    int druga=0 ;
    int trzecia=0;
    int czwarta=0;
    int pionta=0;
    int szusta=0;


    int min= 1;
    int max=49;

    TextView jeden;
    TextView dwa;
    TextView trzy;
    TextView cztery;
    TextView piec;
    TextView szesc;

    private AdView mAdView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        jeden = (TextView) findViewById(R.id.Pierwszaliczba);
        dwa = (TextView) findViewById(R.id.Drugaliczba);
        trzy=(TextView) findViewById(R.id.Trzecialiczba);
        cztery=(TextView)findViewById(R.id.czwartaliczba);
        piec=(TextView)findViewById(R.id.piontaliczba);
        szesc=(TextView)findViewById(R.id.szustaliczba);

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

     //   MobileAds.initialize(this, "ca-app-pub-4834003578511022~4923781209");
    }



    public  void  losuj(View v){


        Random r = new Random();
        pierwsza =  r.nextInt(48)+1;
        druga = r.nextInt(48)+1;
        trzecia = r.nextInt(48)+1;
        czwarta = r.nextInt(48)+1;
        pionta = r.nextInt(48)+1;
        szusta = r.nextInt(48)+1;
        if(pierwsza == druga )
            druga = r.nextInt(48)+1;
        if(pierwsza==trzecia)
            trzecia = r.nextInt(48)+1;
        if(pierwsza==czwarta)
            czwarta = r.nextInt(48)+1;
        if(pierwsza==pionta)
            pionta = r.nextInt(48)+1;
        if(pierwsza==szusta)
            szusta = r.nextInt(48)+1;
        if(druga==trzecia)
            trzecia = r.nextInt(48)+1;
        if(druga==czwarta)
            czwarta = r.nextInt(48)+1;
        if(druga==pionta)
            pionta = r.nextInt(48)+1;
        if(druga==szusta)
            szusta = r.nextInt(48)+1;
        if(trzecia==czwarta)
            czwarta = r.nextInt(48)+1;
        if(trzecia==pionta)
            pionta = r.nextInt(48)+1;
        if(trzecia==szusta)
            szusta = r.nextInt(48)+1;
        if(czwarta==pionta)
            pionta = r.nextInt(48)+1;
        if(czwarta==szusta)
            szusta = r.nextInt(48)+1;
        if(pionta==szusta)
            szusta = r.nextInt(48)+1;
        if(pierwsza == druga )
            druga = r.nextInt(48)+1;
        if(pierwsza==trzecia)
            trzecia = r.nextInt(48)+1;
        if(pierwsza==czwarta)
            czwarta = r.nextInt(48)+1;
        if(pierwsza==pionta)
            pionta = r.nextInt(48)+1;
        if(pierwsza==szusta)
            szusta = r.nextInt(48)+1;
        if(druga==trzecia)
            trzecia = r.nextInt(48)+1;
        if(druga==czwarta)
            czwarta = r.nextInt(48)+1;
        if(druga==pionta)
            pionta = r.nextInt(48)+1;
        if(druga==szusta)
            szusta = r.nextInt(48)+1;
        if(trzecia==czwarta)
            czwarta = r.nextInt(48)+1;
        if(trzecia==pionta)
            pionta = r.nextInt(48)+1;
        if(trzecia==szusta)
            szusta = r.nextInt(48)+1;
        if(czwarta==pionta)
            pionta = r.nextInt(48)+1;
        if(czwarta==szusta)
            szusta = r.nextInt(48)+1;
        if(pionta==szusta)
            szusta = r.nextInt(48)+1;
        if(pierwsza == druga )
            druga = r.nextInt(48)+1;
        if(pierwsza==trzecia)
            trzecia = r.nextInt(48)+1;
        if(pierwsza==czwarta)
            czwarta = r.nextInt(48)+1;
        if(pierwsza==pionta)
            pionta = r.nextInt(48)+1;
        if(pierwsza==szusta)
            szusta = r.nextInt(48)+1;
        if(druga==trzecia)
            trzecia = r.nextInt(48)+1;
        if(druga==czwarta)
            czwarta = r.nextInt(48)+1;
        if(druga==pionta)
            pionta = r.nextInt(48)+1;
        if(druga==szusta)
            szusta = r.nextInt(48)+1;
        if(trzecia==czwarta)
            czwarta = r.nextInt(48)+1;
        if(trzecia==pionta)
            pionta = r.nextInt(48)+1;
        if(trzecia==szusta)
            szusta = r.nextInt(48)+1;
        if(czwarta==pionta)
            pionta = r.nextInt(48)+1;
        if(czwarta==szusta)
            szusta = r.nextInt(48)+1;
        if(pionta==szusta)
            szusta = r.nextInt(48)+1;
        if(pierwsza == druga )
            druga = r.nextInt(48)+1;
        if(pierwsza==trzecia)
            trzecia = r.nextInt(48)+1;
        if(pierwsza==czwarta)
            czwarta = r.nextInt(48)+1;
        if(pierwsza==pionta)
            pionta = r.nextInt(48)+1;
        if(pierwsza==szusta)
            szusta = r.nextInt(48)+1;
        if(druga==trzecia)
            trzecia = r.nextInt(48)+1;
        if(druga==czwarta)
            czwarta = r.nextInt(48)+1;
        if(druga==pionta)
            pionta = r.nextInt(48)+1;
        if(druga==szusta)
            szusta = r.nextInt(48)+1;
        if(trzecia==czwarta)
            czwarta = r.nextInt(48)+1;
        if(trzecia==pionta)
            pionta = r.nextInt(48)+1;
        if(trzecia==szusta)
            szusta = r.nextInt(48)+1;
        if(czwarta==pionta)
            pionta = r.nextInt(48)+1;
        if(czwarta==szusta)
            szusta = r.nextInt(48)+1;
        if(pionta==szusta)
            szusta = r.nextInt(48)+1;





     wpisz();
    }

    public void wpisz(){



       jeden.setText(Integer.toString(pierwsza));
       dwa.setText(Integer.toString(druga));
       trzy.setText(Integer.toString(trzecia));
       cztery.setText(Integer.toString(czwarta));
       piec.setText(Integer.toString(pionta));
       szesc.setText(Integer.toString(szusta));




    }















}
