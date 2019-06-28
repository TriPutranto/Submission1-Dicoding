package com.example.utaputranto.firstsubmission;

import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.utaputranto.firstsubmission.adapter.MovieAdapter;
import com.example.utaputranto.firstsubmission.model.Movie;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    String[] dataName, dataRelease, dataOverview, dataBudget, dataRevenue, dataGenres ;
    TypedArray dataPoster;
    RecyclerView rvMovie;
    MovieAdapter movieAdapter;
    ArrayList<Movie> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvMovie         = findViewById(R.id.rv_movie);

        initView();
        prepare();
        addData();

    }
    public void initView(){
        rvMovie.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        rvMovie.setLayoutManager(layoutManager);
    }

    private void prepare() {
        dataName = getResources().getStringArray(R.array.data_movie);
        dataRelease = getResources().getStringArray(R.array.data_release);
        dataOverview = getResources().getStringArray(R.array.data_overview);
        dataBudget = getResources().getStringArray(R.array.data_budget);
        dataRevenue = getResources().getStringArray(R.array.data_revenue);
        dataGenres = getResources().getStringArray(R.array.data_genres);
        dataPoster = getResources().obtainTypedArray(R.array.data_poster);
    }

    private void addData() {

        data = new ArrayList<>();
        for (int i = 0; i < dataName.length; i++){

            Movie movie = new Movie();
            movie.setName(dataName[i]);
            Log.i("movie","result : " + movie.getName());
            movie.setRelease(dataRelease[i]);
            movie.setOverview(dataOverview[i]);
            movie.setBudget(dataBudget[i]);
            movie.setRevenue(dataRevenue[i]);
            movie.setGenres(dataGenres[i]);
            Log.i("movie", "genres :" +movie.getGenres());
            movie.setPoster(dataPoster.getResourceId(i,-1));
            Log.i("movie", "poster :" + movie.getPoster());
            data.add(movie);
        }

        movieAdapter = new MovieAdapter(MainActivity.this,data);
        rvMovie.setAdapter(movieAdapter);
        movieAdapter.setMovies(data);

    }
}
