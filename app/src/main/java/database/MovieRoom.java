package database;



import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Movie")
public class MovieRoom {


    @PrimaryKey
    private String mId;
    @ColumnInfo(name = "year")
    private String mYear;

    @ColumnInfo(name = "title")
    private String mTitle;

    @ColumnInfo(name = "director")
    private String mDirector;

    @ColumnInfo(name = "score")
    private int mScore;

    @ColumnInfo(name = "url")
    private String mFilmUrl;


}
