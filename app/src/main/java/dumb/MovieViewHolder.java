package dumb;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import acs.castac.ricsvil.mrmadom3.R;


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
    }
}
