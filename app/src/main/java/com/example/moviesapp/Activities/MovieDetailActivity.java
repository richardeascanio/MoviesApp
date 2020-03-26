package com.example.moviesapp.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.example.moviesapp.R;

import java.util.Objects;

public class MovieDetailActivity extends AppCompatActivity {

    private ImageView detail_movie_img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);

        detail_movie_img = findViewById(R.id.detail_movie_img);

        // get data from Home
        String movieTitle = getIntent().getStringExtra("title");
        int movieImg = Objects.requireNonNull(getIntent().getExtras()).getInt("imgUrl");

        detail_movie_img.setImageResource(movieImg);

    }
}
