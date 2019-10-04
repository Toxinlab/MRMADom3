package util;

import androidx.recyclerview.widget.DiffUtil;

import java.util.List;

import model.Movie;

public class MovieDiffCallback extends DiffUtil.Callback {
    private List<Movie> mOldList;
    private List<Movie> mNewList;

    public MovieDiffCallback(List<Movie> mOldList, List<Movie> mNewList) {
        this.mOldList = mOldList;
        this.mNewList = mNewList;
    }

    @Override
    public int getOldListSize() {
        return mOldList.size();
    }

    @Override
    public int getNewListSize() {
        return mNewList.size();
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        Movie oldMovie = mOldList.get(oldItemPosition);
        Movie newMovie = mNewList.get(newItemPosition);

        return oldMovie.getmId() == newMovie.getmId();
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        Movie oldMovie = mOldList.get(oldItemPosition);
        Movie newMovie = mNewList.get(newItemPosition);

        return oldMovie.getmTitle().equals(newMovie.getmTitle()) &&
                oldMovie.getmDirector().equals(newMovie.getmDirector());
    }
}
