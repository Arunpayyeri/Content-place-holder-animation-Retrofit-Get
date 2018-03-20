package com.example.signet.betaretetz;

import com.example.signet.betaretetz.POJO.EmpListPOJO;

import retrofit.Callback;
import retrofit.http.GET;

/**
 * Created by signet on 09-Mar-18.
 */

public class REST {
    public static String BASEURL="https://api.myjson.com";

    public interface api_carCompanies {

        @GET("/bins/10t0ix") // specify the sub url for the base url
        void getData(Callback<EmpListPOJO> response); // will give you the json data
    }
}
