package main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.List;

import acs.castac.ricsvil.mrmadom3.R;
import dumb.MovieAdapter;
import model.Movie;
import model.Resource;

import static java.security.AccessController.getContext;

public class MainActivity extends AppCompatActivity {

    private MovieAdapter movieAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView mainView = findViewById(R.id.recyclerView);

        mainView.setLayoutManager(new LinearLayoutManager(this));

        movieAdapter = new MovieAdapter();

        mainView.setAdapter(movieAdapter);
        mainView.setVisibility(View.VISIBLE);
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
}
