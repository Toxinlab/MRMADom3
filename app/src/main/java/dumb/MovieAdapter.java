package dumb;

import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import acs.castac.ricsvil.mrmadom3.R;
import main.MainActivity;
import model.Movie;
import util.MovieDiffCallback;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {

    private List<Movie> mDataSet;

    private OnButtonClickCallback onButtonClickCallback;

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
        holder.mScoreTV.setText(String.valueOf(movie.getmScore()));
        holder.mDirectorTV.setText(movie.getmDirector());
        setCircleColor(holder);
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

    public OnButtonClickCallback getOnButtonClickCallback() {
        return onButtonClickCallback;
    }

    public void setOnButtonClickCallback(OnButtonClickCallback onButtonClickCallback) {
        this.onButtonClickCallback = onButtonClickCallback;
    }

    public class MovieViewHolder extends RecyclerView.ViewHolder {

        TextView mNameTV;
        TextView mYearTV;
        TextView mDirectorTV;
        TextView mScoreTV;
        Button mSeeMoreButton;

        public MovieViewHolder(@NonNull View itemView) {
            super(itemView);

            mNameTV = itemView.findViewById(R.id.titleView);
            mYearTV = itemView.findViewById(R.id.yearView);
            mDirectorTV = itemView.findViewById(R.id.directorView);
            mScoreTV = itemView.findViewById(R.id.scoreView);

            mSeeMoreButton = itemView.findViewById(R.id.seeMoreButton);
            mSeeMoreButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION){
                        if (onButtonClickCallback != null) {
                            Movie tempMovie = mDataSet.get(position);
                            onButtonClickCallback.onButtonClick(tempMovie);
                        }
                    }
                }
            });

        }
    }

    private void setCircleColor(MovieViewHolder holder){
        int tempScore = Integer.parseInt(holder.mScoreTV.getText().toString());
        holder.mScoreTV.setBackground(MainActivity.circleBad);

        if(tempScore>66 && tempScore<90){

            holder.mScoreTV.setBackground(MainActivity.circleMeh);
        }

        if(tempScore>90){

            holder.mScoreTV.setBackground(MainActivity.circleGood);
        }

    }
}
