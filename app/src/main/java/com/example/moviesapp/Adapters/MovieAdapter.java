package com.example.moviesapp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.moviesapp.Models.Movie;
import com.example.moviesapp.R;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MyViewHolder> {

    private Context mContext;
    private List<Movie> mData;
    private MovieInterfaceClickListener movieInterfaceClickListener;

    public MovieAdapter(Context mContext, List<Movie> mData, MovieInterfaceClickListener movieInterfaceClickListener) {
        this.mContext = mContext;
        this.mData = mData;
        this.movieInterfaceClickListener = movieInterfaceClickListener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(mContext).inflate(R.layout.movie_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.txt_title.setText(mData.get(position).getTitle());
        holder.img_movie.setImageResource(mData.get(position).getThumbnail());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView txt_title;
        private ImageView img_movie;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            txt_title = itemView.findViewById(R.id.item_movie_title);
            img_movie = itemView.findViewById(R.id.item_movie_img);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    movieInterfaceClickListener.onMovieClick(mData.get(getAdapterPosition()), img_movie);
                }
            });
        }
    }

    public interface MovieInterfaceClickListener {
        // we will need the ImageView to make the shared animation between the two activities
        void onMovieClick(Movie movie, ImageView movieImageView);
    }
}
