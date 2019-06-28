package com.example.utaputranto.firstsubmission.model;

import android.os.Parcel;
import android.os.Parcelable;


public class Movie implements Parcelable {
    private int poster;
    private String name, overview, release, budget, revenue, genres;

    public Movie(Parcel in) {
        poster = in.readInt();
        name = in.readString();
        overview = in.readString();
        release = in.readString();
        budget = in.readString();
        revenue = in.readString();
        genres = in.readString();
    }

    public static final Creator<Movie> CREATOR = new Creator<Movie>() {
        @Override
        public Movie createFromParcel(Parcel in) {
            return new Movie(in);
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };

    public Movie() {
    }

    public int getPoster() {
        return poster;
    }

    public void setPoster(int poster) {
        this.poster = poster;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getRelease() {
        return release;
    }

    public void setRelease(String release) {
        this.release = release;
    }

    public String getBudget() {
        return budget;
    }

    public void setBudget(String budget) {
        this.budget = budget;
    }

    public String getRevenue() {
        return revenue;
    }

    public void setRevenue(String revenue) {
        this.revenue = revenue;
    }

    public String getGenres() {
        return genres;
    }

    public void setGenres(String genres) {
        this.genres = genres;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(poster);
        dest.writeString(name);
        dest.writeString(overview);
        dest.writeString(release);
        dest.writeString(budget);
        dest.writeString(revenue);
        dest.writeString(genres);
    }
}
