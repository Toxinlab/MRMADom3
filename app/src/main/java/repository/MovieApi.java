package repository;

import java.util.List;

import model.Movie;
import retrofit2.Call;

public class MovieApi {

    private MovieService mMovieService;

    public MovieApi(){
        mMovieService = ServiceGenerator.createService(MovieService.class);
    }

    public Call<List<Movie>> getMovies(){
        return mMovieService.getMovies();
    }


}
