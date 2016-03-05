package com.example.jites.moviesmania;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SingleMovie extends AppCompatActivity {
    private final String TITLE = "title";
    private final String RELEASE_DATE = "release_date";
    private final String MOVIE_POSTER = "poster_path";
    private final String VOTE_AVERAGE = "vote_average";
    private final String PLOT_SYNOPSIS = "overview";
    private TextView plotView, voteAvg, releaseDate, Title;
    private ImageView imageView;
    private String title, release, poster, vote, plot;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movies_main);
        plotView = (TextView) findViewById(R.id.synopsis);
        voteAvg = (TextView) findViewById(R.id.vote_average);
        releaseDate = (TextView) findViewById(R.id.release_date);
        Title = (TextView) findViewById(R.id.name);
        imageView = (ImageView) findViewById(R.id.big_poster);
        UIUpdate();


    }

    public void UIUpdate() {

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        if (extras != null) {
            if (extras.containsKey(TITLE) && extras.containsKey(RELEASE_DATE) && extras.containsKey(MOVIE_POSTER) && extras.containsKey(VOTE_AVERAGE) && extras.containsKey(PLOT_SYNOPSIS)) {
                title = intent.getStringExtra(TITLE);
                release = intent.getStringExtra(RELEASE_DATE);
                poster = intent.getStringExtra(MOVIE_POSTER);
                vote = intent.getStringExtra(VOTE_AVERAGE);
                plot = intent.getStringExtra(PLOT_SYNOPSIS);
                poster = "http://image.tmdb.org/t/p/w500/" + poster;
            }
        }
        plotView.setText(plot);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = format.parse(release);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        DateFormat df = new SimpleDateFormat("MMM dd, yyyy");
        releaseDate.setText("Release Date : "+df.format(date).toString());
        Title.setText(title);
        View myview=(View)findViewById(R.id.moviedetail);


        voteAvg.setText(vote.toString());
        Picasso.with(this)
                .load(poster)
                .into(imageView);
//Toast
        Context context = getApplicationContext();
        CharSequence text =  title;
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();



    }



    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

}

