package com.bujuzuoye;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

/**
 * Created by Administrator on 2016/6/12.
 */
public interface gupiaojiekou {
    @GET("/apistore/stockservice/hkstock")
    Call<gupiaobean> getgupian(@Header("apikey") String apikey, @Query("stockid") String gupianid,@Query("list") String shu);

}
