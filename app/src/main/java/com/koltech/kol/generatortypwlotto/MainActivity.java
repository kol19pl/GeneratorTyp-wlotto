package com.koltech.kol.generatortypwlotto;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.RequestConfiguration;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {


    //private AdView AdView;
    private AdView adView;
    private FrameLayout adContainerView;
    private static final String AD_UNIT_ID = "ca-app-pub-4834003578511022/4886516208";

    private static long back_pressed;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

       Admob admob = new Admob();
        adContainerView = findViewById(R.id.adContainer);
       admob.AdmobBaner(AD_UNIT_ID,adContainerView,this,this);

    }


  //  @Override
 //   public void onBackPressed()
  //  {
   //     if (back_pressed + 4000 > System.currentTimeMillis()) super.onBackPressed();
   //     else Toast.makeText(getBaseContext(), R.string.pop_up_zamykanie, Toast.LENGTH_SHORT).show();
   //     back_pressed = System.currentTimeMillis();
   // }


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





}
