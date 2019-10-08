package model;

import com.google.gson.annotations.SerializedName;

public class Movie {

    @SerializedName("id")
    private int mId;
    @SerializedName("release_date")
    private String mYear;
    @SerializedName("title")
    private String mTitle;
    @SerializedName("director")
    private String mDirector;
    @SerializedName("rt_score")
    private int mScore;
    @SerializedName("url")
    private String mFilmUrl;

    public Movie(int mId, String mYear, String mTitle, String mDirector, int mScore, String mFilmUrl) {
        this.mId = mId;
        this.mYear = mYear;
        this.mTitle = mTitle;
        this.mDirector = mDirector;
        this.mScore = mScore;
        this.mFilmUrl = mFilmUrl;
    }

    public int getmId() {
        return mId;
    }

    public void setmId(int mId) {
        this.mId = mId;
    }

    public String getmYear() {
        return mYear;
    }

    public void setmYear(String mYear) {
        this.mYear = mYear;
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getmDirector() {
        return mDirector;
    }

    public void setmDirector(String mDirector) {
        this.mDirector = mDirector;
    }

    public int getmScore() {
        return mScore;
    }

    public void setmScore(int mScore) {
        this.mScore = mScore;
    }

    public String getmFilmUrl() {
        return mFilmUrl;
    }

    public void setmFilmUrl(String mFilmUrl) {
        this.mFilmUrl = mFilmUrl;
    }
}
