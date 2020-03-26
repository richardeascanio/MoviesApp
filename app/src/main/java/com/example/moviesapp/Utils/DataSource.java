package com.example.moviesapp.Utils;

import com.example.moviesapp.Models.Movie;
import com.example.moviesapp.R;

import java.util.ArrayList;
import java.util.List;

public class DataSource {

    public static List<Movie> getPopularMovies() {
        List<Movie> lstMovies = new ArrayList<>();
        lstMovies.add(new Movie("Spiderman Far From Home", R.drawable.spiderman, R.drawable.coverspiderman));
        lstMovies.add(new Movie("The Martian", R.drawable.themartian, R.drawable.themartiancover));
        lstMovies.add(new Movie("Spiderman into the Spiderverse", R.drawable.spiderverse, R.drawable.spiderversecover));
        lstMovies.add(new Movie("Spiderman Homecoming", R.drawable.spidey, R.drawable.homecomingcover));
        lstMovies.add(new Movie("Spiderman Far From Home", R.drawable.spiderman, R.drawable.coverspiderman));
        lstMovies.add(new Movie("The Martian", R.drawable.themartian, R.drawable.themartiancover));
        lstMovies.add(new Movie("Spiderman into the Spiderverse", R.drawable.spiderverse, R.drawable.spiderversecover));
        lstMovies.add(new Movie("Spiderman Homecoming", R.drawable.spidey, R.drawable.homecomingcover));
        lstMovies.add(new Movie("Spiderman Far From Home", R.drawable.spiderman, R.drawable.coverspiderman));
        lstMovies.add(new Movie("The Martian", R.drawable.themartian, R.drawable.themartiancover));
        lstMovies.add(new Movie("Spiderman into the Spiderverse", R.drawable.spiderverse, R.drawable.spiderversecover));
        lstMovies.add(new Movie("Spiderman Homecoming", R.drawable.spidey, R.drawable.homecomingcover));

        return lstMovies;
    }

    public static List<Movie> getWeekMovies() {
        List<Movie> lstMovies = new ArrayList<>();
        lstMovies.add(new Movie("Spiderman Far From Home", R.drawable.spiderman, R.drawable.coverspiderman));
        lstMovies.add(new Movie("The Martian", R.drawable.themartian, R.drawable.themartiancover));
        lstMovies.add(new Movie("Spiderman into the Spiderverse", R.drawable.spiderverse, R.drawable.spiderversecover));
        lstMovies.add(new Movie("Spiderman Homecoming", R.drawable.spidey, R.drawable.homecomingcover));

        return lstMovies;
    }
}
