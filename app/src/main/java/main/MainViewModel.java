package main;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import model.Movie;
import model.Resource;
import repository.MovieRepository;

public class MainViewModel extends AndroidViewModel {

    private MovieRepository movieRepository;

    public MainViewModel(@NonNull Application application) {
        super(application);
        movieRepository = new MovieRepository();
    }

    public LiveData<Resource<List<Movie>>> getMovies(){
        return movieRepository.getMovieLiveData();
    }
    public void refreshMovies(){
        movieRepository.refreshMovies();
    }
}
