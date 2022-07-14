package com.koltech.kol.generatortypwlotto;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

import java.util.Random;

public class Looto extends AppCompatActivity {



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



    //private AdView AdView;
    private AdView adView;
    private FrameLayout adContainerView;
    private static final String AD_UNIT_ID = "ca-app-pub-4834003578511022/4886516208";

    private static long back_pressed;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lotto_main);
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



     //   MobileAds.initialize(this, "ca-app-pub-4834003578511022~4923781209");
        // Initialize the Mobile Ads SDK.
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {}
        });

        // MobileAds.setRequestConfiguration(
        //        new RequestConfiguration.Builder().setTestDeviceIds(Arrays.asList("ABCDEF012345")).build());




        adContainerView = findViewById(R.id.adContainer);

        // Since we're loading the banner based on the adContainerView size, we need to wait until this
        // view is laid out before we can get the width.
       // adContainerView.post(new Runnable() {
       //     @Override
       //     public void run() {
       //         loadBanner();
       //     }
      //  });
    }



    public void  Losuj(View v){


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





    @Override
    public void onBackPressed()
    {
        if (back_pressed + 4000 > System.currentTimeMillis()) super.onBackPressed();
        else Toast.makeText(getBaseContext(), R.string.pop_up_zamykanie, Toast.LENGTH_SHORT).show();
        back_pressed = System.currentTimeMillis();
    }


    /** Called when leaving the activity */
    @Override
    public void onPause() {
        if (adView != null) {
            adView.pause();
        }
        super.onPause();
    }

    /** Called when returning to the activity */
    @Override
    public void onResume() {
        super.onResume();
        if (adView != null) {
            adView.resume();
        }
    }

    /** Called before the activity is destroyed */
    @Override
    public void onDestroy() {
        if (adView != null) {
            adView.destroy();
        }
        super.onDestroy();
    }

  //  private void loadBanner() {
        // Create an ad request.
  //      adView = new AdView(this);
  //      adView.setAdUnitId(AD_UNIT_ID);
  //      adContainerView.removeAllViews();
  //      adContainerView.addView(adView);

  //      AdSize adSize = getAdSize();
  //      adView.setAdSize(adSize);

   //     AdRequest adRequest = new AdRequest.Builder().build();

        // Start loading the ad in the background.
   //     adView.loadAd(adRequest);
   // }

  //  private AdSize getAdSize() {
  //      // Determine the screen width (less decorations) to use for the ad width.
  //      Display display = getWindowManager().getDefaultDisplay();
  //      DisplayMetrics outMetrics = new DisplayMetrics();
  //      display.getMetrics(outMetrics);

  //      float density = outMetrics.density;

  //      float adWidthPixels = adContainerView.getWidth();

        // If the ad hasn't been laid out, default to the full screen width.
  //      if (adWidthPixels == 0) {
  //          adWidthPixels = outMetrics.widthPixels;
  //      }

  //      int adWidth = (int) (adWidthPixels / density);

  //      return AdSize.getCurrentOrientationInlineAdaptiveBannerAdSize(this, adWidth);
  //  }










}
