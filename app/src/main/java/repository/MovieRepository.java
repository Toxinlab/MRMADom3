package repository;

import android.util.Log;

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


    public MovieRepository() {
        this.mMovieApi = new MovieApi();
        this.mMovieLiveData = new MutableLiveData<>();
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
                    Log.e("ALO1", "USEPO");
//                    for (int i = 0; i <= response.body().size(); i++){
//                        Log.e("ALO", ""+response.body().get(i));
//                    }


                }

                @Override
                public void onFailure(Call<List<Movie>> call, Throwable t) {
                    Resource<List<Movie>> resource = new Resource<List<Movie>>(new ArrayList<Movie>(), false);
                    mMovieLiveData.setValue(resource);
                    t.printStackTrace();

            }
        });
    }
}
