package com.example.moviesapp.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.moviesapp.Adapters.MovieAdapter;
import com.example.moviesapp.Adapters.SliderPagerAdapter;
import com.example.moviesapp.Models.Movie;
import com.example.moviesapp.R;
import com.example.moviesapp.Models.Slide;
import com.example.moviesapp.Utils.DataSource;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class Home extends AppCompatActivity implements MovieAdapter.MovieInterfaceClickListener {

    private List<Slide> lstSlides;
    private ViewPager sliderPager;
    private TabLayout indicator;
    private RecyclerView rv_movies;
    private RecyclerView rv_movies_week;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        sliderPager = findViewById(R.id.slider_pager);
        indicator = findViewById(R.id.indicator);
        rv_movies = findViewById(R.id.rv_movies);
        rv_movies_week = findViewById(R.id.rv_movies_week);

        // Preparing a list of slides
        lstSlides = new ArrayList<>();
        lstSlides.add(new Slide(R.drawable.wolverine, "Wolverine\nmore text here"));
        lstSlides.add(new Slide(R.drawable.deadpool, "Deadpool\nmore text here"));
        lstSlides.add(new Slide(R.drawable.wolverine, "Wolverine\nmore text here"));
        lstSlides.add(new Slide(R.drawable.deadpool, "Deadpool\nmore text here"));
        lstSlides.add(new Slide(R.drawable.wolverine, "Wolverine\nmore text here"));
        lstSlides.add(new Slide(R.drawable.deadpool, "Deadpool\nmore text here"));

        SliderPagerAdapter adapter = new SliderPagerAdapter(this, lstSlides);
        sliderPager.setAdapter(adapter);

        // Setup time
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new Home.SliderTimer(), 4000, 6000);

        // Tell de indicator that he has to work with our view pager
        indicator.setupWithViewPager(sliderPager, true);

        // Set up recycler view of movies
        MovieAdapter adapter1 = new MovieAdapter(this, DataSource.getPopularMovies(), this);
        rv_movies.setAdapter(adapter1);
        rv_movies.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        // Set up recycler view of best of the week
        MovieAdapter adapter2 = new MovieAdapter(this, DataSource.getWeekMovies(), this);
        rv_movies_week.setAdapter(adapter2);
        rv_movies_week.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
    }

    @Override
    public void onMovieClick(Movie movie, ImageView movieImageView) {
        // here we send movie information to detail activity
        // also we will create the transition animation between the two activities
//        Toast.makeText(this, "clicked " + movie.getTitle(), Toast.LENGTH_SHORT).show();

        Intent i = new Intent(Home.this, MovieDetailActivity.class);
        i.putExtra("title", movie.getTitle());
        i.putExtra("imgUrl", movie.getThumbnail());
        i.putExtra("imgCover", movie.getCoverPhoto());
        // lets create the animation
        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(Home.this, movieImageView, "sharedName");
        startActivity(i, options.toBundle());
    }

    public class SliderTimer extends TimerTask {

        @Override
        public void run() {
            Home.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (sliderPager.getCurrentItem() < lstSlides.size()-1) {
                        sliderPager.setCurrentItem(sliderPager.getCurrentItem()+1);
                    } else {
                        sliderPager.setCurrentItem(0);
                    }
                }
            });
        }

    }
}
