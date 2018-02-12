package com.codepath.fliks.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by brh on 2/9/2018.
 */

public class Movie {
    private String posterPath;
    private String originalTitle;
    private String overview;

    public String getPosterPath() {
        return String.format("https://image.tmdb.org/t/p/w342/%s",posterPath);
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public String getOverview() {
        return overview;
    }

    public Movie(JSONObject jsonObject)throws JSONException{
        this.posterPath=jsonObject.getString("poster_path");
        this.originalTitle=jsonObject.getString("original_title");
        this.overview=jsonObject.getString("overview");

    }
    public static ArrayList<Movie> fromJSONArray(JSONArray array){
        ArrayList<Movie> movies =new ArrayList<>();
        for (int i=0; i<array.length();i++){
            try {
                movies.add(new Movie(array.getJSONObject(i)));
                //Log.d("DEBUG",array.getJSONArray(i).toString());
            }
            catch(JSONException e){
                e.printStackTrace();
            }
        }
        return movies;
    }
}
