package repository;

import java.util.List;

import model.Movie;
import retrofit2.Call;
import retrofit2.http.GET;

public interface MovieService {

    @GET("films?limit=2")
    public Call<List<Movie>> getMovies();
}
