package com.example.moviesapp.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.moviesapp.Adapters.MovieAdapter;
import com.example.moviesapp.Adapters.SliderPagerAdapter;
import com.example.moviesapp.Models.Movie;
import com.example.moviesapp.R;
import com.example.moviesapp.Models.Slide;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class Home extends AppCompatActivity {

    private List<Slide> lstSlides;
    private ViewPager sliderPager;
    private TabLayout indicator;
    private RecyclerView rv_movies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        sliderPager = findViewById(R.id.slider_pager);
        indicator = findViewById(R.id.indicator);
        rv_movies = findViewById(R.id.rv_movies);

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

        // RecyclerView Setup
        List<Movie> lstMovies = new ArrayList<>();
        lstMovies.add(new Movie("Spiderman Far From Home", R.drawable.spiderman));
        lstMovies.add(new Movie("The Martian", R.drawable.themartian));
        lstMovies.add(new Movie("Spiderman Homecoming", R.drawable.spidey));
        lstMovies.add(new Movie("Spiderman Far From Home", R.drawable.spiderman));
        lstMovies.add(new Movie("The Martian", R.drawable.themartian));
        lstMovies.add(new Movie("Spiderman Homecoming", R.drawable.spidey));
        lstMovies.add(new Movie("Spiderman Far From Home", R.drawable.spiderman));
        lstMovies.add(new Movie("The Martian", R.drawable.themartian));
        lstMovies.add(new Movie("Spiderman Homecoming", R.drawable.spidey));

        MovieAdapter adapter1 = new MovieAdapter(this, lstMovies);
        rv_movies.setAdapter(adapter1);
        rv_movies.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
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
