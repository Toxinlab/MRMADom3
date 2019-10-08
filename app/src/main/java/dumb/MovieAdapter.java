package dumb;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import acs.castac.ricsvil.mrmadom3.R;
import model.Movie;
import util.MovieDiffCallback;

public class MovieAdapter extends RecyclerView.Adapter<MovieViewHolder> {

    private List<Movie> mDataSet;

    public MovieAdapter() {
        mDataSet = new ArrayList<>();
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.list_view, parent, false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        Movie movie = mDataSet.get(position);
        holder.mNameTV.setText(movie.getmTitle());
        holder.mYearTV.setText(movie.getmYear());
        holder.mScoreTV.setText(movie.getmScore());
        holder.mDirectorTV.setText(movie.getmDirector());


    }

    @Override
    public int getItemCount() {
        return mDataSet.size();
    }

    public void setData(List<Movie> movies){
        MovieDiffCallback callback = new MovieDiffCallback(mDataSet, movies);
        DiffUtil.DiffResult result = DiffUtil.calculateDiff(callback);
        mDataSet.clear();
        mDataSet.addAll(movies);
        result.dispatchUpdatesTo(this);


    }
}
