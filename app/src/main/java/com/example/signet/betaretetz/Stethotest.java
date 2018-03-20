package com.example.signet.betaretetz;

import android.app.Application;

import com.facebook.stetho.Stetho;
import com.facebook.stetho.okhttp3.StethoInterceptor;

import okhttp3.OkHttpClient;

/**
 * Created by signet on 16-Mar-18.
 */

public class Stethotest extends Application{
    public OkHttpClient httpClient;

    @Override
    public void onCreate() {
        super.onCreate();

        if (BuildConfig.DEBUG) {

            // Create an InitializerBuilder
            Stetho.InitializerBuilder initializerBuilder = Stetho.newInitializerBuilder(this);

            // Enable Chrome DevTools
            initializerBuilder.enableWebKitInspector(Stetho.defaultInspectorModulesProvider(this));

            // Enable command line interface
            initializerBuilder.enableDumpapp(Stetho.defaultDumperPluginsProvider(this));

            // Use the InitializerBuilder to generate an Initializer
            Stetho.Initializer initializer = initializerBuilder.build();

            // Initialize Stetho with the Initializer
            Stetho.initialize(initializer);

            //Initialize Stetho Interceptor into OkHttp client
            httpClient = new OkHttpClient.Builder().addNetworkInterceptor(new StethoInterceptor()).build();
        } else {
            httpClient = new OkHttpClient();
        }
    }
}
