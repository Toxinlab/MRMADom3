package repository;

import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;

import model.Movie;
import model.Resource;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieRepository {

    private MovieApi mMovieApi;
    private MutableLiveData<Resource<List<Movie>>> mMovieLiveData;


    public MovieRepository(MovieApi mMovieApi, MutableLiveData<Resource<List<Movie>>> mMovieLiveData) {
        this.mMovieApi = mMovieApi;
        this.mMovieLiveData = mMovieLiveData;
    }

    public MutableLiveData<Resource<List<Movie>>> getMovieLiveData() {
        fetchMovieData();
        return mMovieLiveData;
    }

    public void refreshMovies(){
        fetchMovieData();
    }

    public void fetchMovieData(){
        mMovieApi.getMovies().enqueue(new Callback<List<Movie>>() {
            @Override
            public void onResponse(Call<List<Movie>> call, Response<List<Movie>> response) {
                Resource<List<Movie>> resource = new Resource<>(response.body(), true);
                mMovieLiveData.setValue(resource);
            }

            @Override
            public void onFailure(Call<List<Movie>> call, Throwable t) {
                Resource<List<Movie>> resource = new Resource<List<Movie>>(new ArrayList<Movie>(), true);
                mMovieLiveData.setValue(resource);
            }
        });
    }
}
