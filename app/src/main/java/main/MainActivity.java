package main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.List;

import acs.castac.ricsvil.mrmadom3.R;
import dumb.MovieAdapter;
import dumb.OnButtonClickCallback;
import model.Movie;
import model.Resource;

import static java.security.AccessController.getContext;

public class MainActivity extends AppCompatActivity {

    private MovieAdapter movieAdapter;
    public static Drawable circleMeh;
    public static Drawable circleBad;
    public static Drawable circleGood;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        circleBad = getResources().getDrawable(R.drawable.circle,null);
        circleGood = getResources().getDrawable(R.drawable.circle_good,null);
        circleMeh = getResources().getDrawable(R.drawable.circle_meh,null);

    }

    @Override
    protected void onStart() {
        super.onStart();

        MainViewModel mainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        mainViewModel.getMovies().observe(this, new Observer<Resource<List<Movie>>>() {
            @Override
            public void onChanged(Resource<List<Movie>> listResource) {
                if(listResource.isSucc()){
                    Toast.makeText(getBaseContext(), "Data fetched from the server!", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getBaseContext(), "Data fetch failed!", Toast.LENGTH_LONG).show();
                    Log.e("TAG", "Something went terribly wrong, check your connection!");
                }
                movieAdapter.setData(listResource.getData());

            }
        });

    }

    public void init(){

        MainViewModel mainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        RecyclerView mainView = findViewById(R.id.recyclerView);

        mainView.setLayoutManager(new LinearLayoutManager(this));

        movieAdapter = new MovieAdapter();

        movieAdapter.setOnButtonClickCallback(new OnButtonClickCallback() {
            @Override
            public void onButtonClick(Movie movie) {
                Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(movie.getmFilmUrl()));
                startActivity(myIntent);
            }
        });

        mainView.setAdapter(movieAdapter);
        mainView.setVisibility(View.VISIBLE);

        EditText nameFilter = findViewById(R.id.filter1);
        nameFilter.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String filter = nameFilter.getText().toString();
                //mainViewModel.setFilter(filter);

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });


    }
}
