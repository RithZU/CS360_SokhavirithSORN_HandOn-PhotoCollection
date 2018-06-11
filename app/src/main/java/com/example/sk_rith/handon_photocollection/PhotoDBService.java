package com.example.sk_rith.handon_photocollection;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by SK_Rith on 6/9/2018.
 */

public interface PhotoDBService {

    @GET("services/rest/?method=flickr.photos.getRecent&api_key=a6d819499131071f158fd740860a5a88&extras=url_h,date_taken&format=json&nojsoncallback=1")
    Call<PhotoCollection> getPhotos();
}
