package database;

import android.content.Context;

import androidx.room.Room;
import androidx.room.RoomDatabase;

public abstract class MovieDatabase extends RoomDatabase {

    public static volatile  MovieDatabase DATABASE;
    public static final String DATABASE_NAME = "movie.db";

    public abstract MovieDao getMoiveDao();


    public static MovieDatabase getDb(Context context){
        if(DATABASE == null) {
            synchronized (MovieDatabase.class) {
                if (DATABASE == null) {
                    DATABASE = Room.databaseBuilder(context.getApplicationContext(),
                            MovieDatabase.class, DATABASE_NAME).build();
                }
            }
        }
        return DATABASE;
    }
}
