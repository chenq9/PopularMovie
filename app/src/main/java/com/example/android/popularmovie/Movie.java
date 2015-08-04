package com.example.android.popularmovie;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by qiuch on 8/3/2015.
 */
public class Movie implements Parcelable {

    private String url;
    private String releaseDate;
    private String rating;
    private String plot;
    private String language;
    private String name;

    public Movie(String url, String releaseDate, String rating,
                 String plot, String language, String name) {
        this.url = url;
        this.releaseDate = releaseDate;
        this.rating = rating;
        this.plot = plot;
        this.language = language;
        this.name = name;
    }

    public Movie() {
    }

    public String getUrl() {
        return url;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        Bundle bundle = new Bundle();

        bundle.putString("url", url);
        bundle.putString("date", releaseDate);
        bundle.putString("rating", rating);
        bundle.putString("plot", plot);
        bundle.putString("language", language);
        bundle.putString("name", name);

        dest.writeBundle(bundle);
    }

    public static final Parcelable.Creator<Movie> CREATOR = new Creator<Movie>() {
        @Override
        public Movie createFromParcel(Parcel source) {
            Bundle bundle = source.readBundle();
            return new Movie(bundle.getString("url"),
                    bundle.getString("date"),
                    bundle.getString("rating"),
                    bundle.getString("plot"),
                    bundle.getString("language"),
                    bundle.getString("name"));
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
        }

    };

    public String getReleaseDate() {
        return releaseDate;
    }

    public String getRating() {
        return rating;
    }

    public String getPlot() {
        return plot;
    }

    public String getLanguage() {
        return language;
    }

    public String getName() {
        return name;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public void setName(String name) {
        this.name = name;
    }
}
