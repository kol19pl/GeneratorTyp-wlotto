package com.koltech.kol.generatortypwlotto;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.widget.FrameLayout;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

public class Admob {

    AdView adView;
    Activity activity;





    public void AdmobBaner(String AD_UNIT_ID,FrameLayout adContainerView,Context context,Activity activity1){
        activity = activity1;
        //Call the function to initialize AdMob SDK
        MobileAds.initialize(context, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        //get the reference to your FrameLayout
        //adContainerView = findViewById(R.id.adView_container);

        //Create an AdView and put it into your FrameLayout
        adView = new AdView(context);
        adContainerView.addView(adView);
        adView.setAdUnitId(AD_UNIT_ID);

        //start requesting banner ads
        loadBanner(context);
    }


    private void loadBanner(Context context) {
        AdRequest adRequest = new AdRequest.Builder()
               // .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();

        AdSize adSize = getAdSize(context);
        // Set the adaptive ad size to the ad view.
        adView.setAdSize(adSize);

        // Start loading the ad in the background.
        adView.loadAd(adRequest);
    }

    private AdSize getAdSize(Context context) {
        //Determine the screen width to use for the ad width.
        Display display = activity.getWindowManager().getDefaultDisplay();
        DisplayMetrics outMetrics = new DisplayMetrics();
        display.getMetrics(outMetrics);

        float widthPixels = outMetrics.widthPixels;
        float density = outMetrics.density;

        //you can also pass your selected width here in dp
        int adWidth = (int) (widthPixels / density);

        //return the optimal size depends on your orientation (landscape or portrait)
        return AdSize.getCurrentOrientationAnchoredAdaptiveBannerAdSize(context, adWidth);
    }
}
