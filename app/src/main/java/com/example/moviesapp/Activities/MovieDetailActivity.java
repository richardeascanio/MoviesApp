package com.example.moviesapp.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.moviesapp.Adapters.CastAdapter;
import com.example.moviesapp.Models.Cast;
import com.example.moviesapp.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MovieDetailActivity extends AppCompatActivity {

    private ImageView detail_movie_img, movie_cover;
    private TextView txt_title, txt_description;
    private FloatingActionButton play_fab;
    private RecyclerView rv_cast;
    private CastAdapter castAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);

        // init views
        initcomponents();
        // set up list cast
        setupRvCast();
    }

    public void initcomponents() {
        detail_movie_img = findViewById(R.id.detail_movie_img);
        movie_cover = findViewById(R.id.detail_movie_cover);
        txt_title = findViewById(R.id.detail_movie_title);
        txt_description = findViewById(R.id.detail_movie_description);
        play_fab = findViewById(R.id.play_fab);
        rv_cast = findViewById(R.id.rv_cast);

        // get data from Home
        String movieTitle = getIntent().getStringExtra("title");
        int movieImg = Objects.requireNonNull(getIntent().getExtras()).getInt("imgUrl");
        int movieCover = Objects.requireNonNull(getIntent().getExtras()).getInt("imgCover");

        Glide.with(this).load(movieImg).into(detail_movie_img);
        Glide.with(this).load(movieCover).into(movie_cover);
        txt_title.setText(movieTitle);
        Objects.requireNonNull(getSupportActionBar()).setTitle(movieTitle);

        // setup animation
        movie_cover.setAnimation(AnimationUtils.loadAnimation(this, R.anim.scale_animation));
        play_fab.setAnimation(AnimationUtils.loadAnimation(this, R.anim.scale_animation));

        play_fab.setOnClickListener(view -> {
            Intent i = new Intent(this, MoviePlayerActivity.class);
            startActivity(i);
        });
    }

    private void setupRvCast() {
        List<Cast> mData = new ArrayList<>();
        mData.add(new Cast("Ali Mahershala", R.drawable.ali_mahershala));
        mData.add(new Cast("Chris Pine", R.drawable.chris_pine));
        mData.add(new Cast("Hailee Steinfield", R.drawable.hailee_steinfield));
        mData.add(new Cast("Jake Johnson", R.drawable.jake_johnson));
        mData.add(new Cast("Ali Mahershala", R.drawable.ali_mahershala));
        mData.add(new Cast("Chris Pine", R.drawable.chris_pine));
        mData.add(new Cast("Hailee Steinfield", R.drawable.hailee_steinfield));
        mData.add(new Cast("Jake Johnson", R.drawable.jake_johnson));

        castAdapter = new CastAdapter(this, mData);
        rv_cast.setAdapter(castAdapter);
        rv_cast.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
    }

    @Override
    public void onBackPressed() {
        Intent i = new Intent(this, Home.class);
        startActivity(i);
    }
}
