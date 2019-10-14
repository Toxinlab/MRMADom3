package database;



import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class MovieAsItsown {


    @PrimaryKey
    private String mId;

    @NonNull
    @ColumnInfo(year = "Year")
    private String mYear;


    private String mTitle;

    private String mDirector;

    private int mScore;

    private String mFilmUrl;
}
