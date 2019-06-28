package com.example.utaputranto.firstsubmission.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.utaputranto.firstsubmission.DetailsActivity;
import com.example.utaputranto.firstsubmission.R;
import com.example.utaputranto.firstsubmission.model.Movie;

import java.util.ArrayList;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {

    Context context;
    ArrayList<Movie> movies ;

    public void setMovies(ArrayList<Movie> movies) {
        this.movies = movies;
    }

    public MovieAdapter(Context context, ArrayList<Movie> movies) {
        this.context = context;
        this.movies = movies;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View listItem   = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_movie, viewGroup,false);
        return new ViewHolder(listItem) ;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        final Movie movie= movies.get(i);

        Glide.with(context)
                .load(movie.getPoster())
                .into(viewHolder.imgPoster);

        viewHolder.tvName.setText(movie.getName());
        viewHolder.tvRelease.setText(movie.getRelease());

        viewHolder.tvOverview.setText(movie.getOverview());
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, movie.getName(), Toast.LENGTH_SHORT).show();
                Intent gotodetails  = new Intent(context, DetailsActivity.class);
                gotodetails.putExtra("MovieId", movie);
                context.startActivity(gotodetails);
            }
        });
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvName, tvRelease, tvOverview;
        ImageView imgPoster;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvName      = itemView.findViewById(R.id.tv_name);
            tvRelease   = itemView.findViewById(R.id.tv_release);
            tvOverview  = itemView.findViewById(R.id.tv_overview);
            imgPoster   = itemView.findViewById(R.id.img_poster);

        }
    }
}
