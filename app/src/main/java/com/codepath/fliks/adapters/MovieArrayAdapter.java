package com.codepath.fliks.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.codepath.fliks.R;
import com.codepath.fliks.models.Movie;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by brh on 2/9/2018.
 */

public class MovieArrayAdapter extends ArrayAdapter<Movie> {

    public MovieArrayAdapter (Context context, List<Movie> movies){
        super(context, android.R.layout.simple_list_item_1,movies);

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Movie movie =getItem(position);
        if (convertView==null){
            LayoutInflater inflater=LayoutInflater.from(getContext());
            convertView =inflater.inflate(R.layout.item_movie,parent, false);
        }
        ImageView ivImage = (ImageView) convertView.findViewById(R.id.ivMovieChange);
        ivImage.setImageResource(0);

        TextView tvTitle = (TextView) convertView.findViewById(R.id.tvTitle);
        TextView tvOverview = (TextView) convertView.findViewById(R.id.tvOverview);

        tvTitle.setText(movie.getOriginalTitle());
        tvOverview.setText(movie.getOverview());

        Picasso.with(getContext()).load(movie.getPosterPath()).into(ivImage);
        Log.d("DEBUG", "TEST");
        return convertView;
    }

       // return super.getView(position, convertView, parent);

}
