package com.example.sk_rith.handon_photocollection;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final RecyclerView recyclerView = findViewById( R.id.photos_recyclerview );
        String photoUrl =  "https://api.flickr.com/";
        Retrofit retrofit = new Retrofit.Builder().baseUrl(photoUrl).addConverterFactory(GsonConverterFactory.create()).build();
        PhotoDBService webservice = retrofit.create(PhotoDBService.class);

        Call<PhotoCollection> call = webservice.getPhotos();
        call.enqueue(new Callback<PhotoCollection>() {
            @Override
            public void onResponse(Call<PhotoCollection> call, Response<PhotoCollection> response) {
                Photos photos = response.body().getPhotos();

                PhotoAdapter adapter = new PhotoAdapter( photos.getPhoto() );
                recyclerView.setLayoutManager( new LinearLayoutManager( getApplicationContext(), LinearLayoutManager.VERTICAL, false ) );
                recyclerView.setAdapter( adapter );

            }

            @Override
            public void onFailure(Call<PhotoCollection> call, Throwable t) {

            }
        });

    }
}
