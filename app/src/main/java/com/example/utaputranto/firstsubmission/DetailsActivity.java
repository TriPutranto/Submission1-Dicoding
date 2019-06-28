package com.example.utaputranto.firstsubmission;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.utaputranto.firstsubmission.model.Movie;

public class DetailsActivity extends AppCompatActivity {

    ImageView img_backdrop, img_poster;
    TextView tv_name, tv_release, tv_budget,
            tv_revenue, tv_genres, tv_overview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        img_backdrop        = findViewById(R.id.img_backdrop);
        img_poster          = findViewById(R.id.img_poster);
        tv_name             = findViewById(R.id.tv_name);
        tv_release          = findViewById(R.id.tv_release);
        tv_budget           = findViewById(R.id.tv_budget);
        tv_revenue          = findViewById(R.id.tv_revenue);
        tv_genres           = findViewById(R.id.tv_genres);
        tv_overview         = findViewById(R.id.tv_overview);

        Movie movie = getIntent().getParcelableExtra("MovieId");

        tv_name.setText(movie.getName());
        tv_release.setText(movie.getRelease());
        tv_budget.setText(movie.getBudget());
        tv_revenue.setText(movie.getRevenue());
        tv_genres.setText(movie.getGenres());
        tv_overview.setText(movie.getOverview());
        Glide.with(this)
                .load(movie.getPoster())
                .into(img_poster);
        Glide.with(this)
                .load(movie.getPoster())
                .into(img_backdrop);



    }
}
