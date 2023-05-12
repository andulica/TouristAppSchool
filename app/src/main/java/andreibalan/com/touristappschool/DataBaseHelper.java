package andreibalan.com.touristappschool;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;


// This Database will be used in future versions of the app. For now I will stick with an ArrayList of the TripsModel class.
public class DataBaseHelper extends SQLiteOpenHelper {


    public static final String TRIPS_TABLE = "TRIPS_TABLE";
    public static final String COLUMN_ID = "ID";
    public static final String COLUMN_DEPARTURE = "DEPARTURE";
    public static final String COLUMN_DESTINATION = "DESTINATION";
    public static final String COLUMN_MAX_DURATION_ACCOMMODATION = "DURATIONACCOMMODATION";
    public static final String COLUMN_MAX_PASSENGERS = "PASSENGERS";

    public DataBaseHelper(@Nullable Context context) {
        super(context, "trips.db", null, 1);
    }

    // This method is called when the database is created for the first time.
    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableStatement = "CREATE TABLE " + TRIPS_TABLE + " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_DEPARTURE + " TEXT, " + COLUMN_DESTINATION + " TEXT, " + COLUMN_MAX_DURATION_ACCOMMODATION + " INT, " + COLUMN_MAX_PASSENGERS + " INT) ";

        db.execSQL(createTableStatement);
    }

    // This method is called when the database needs to be upgraded.
    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }

    public void addOne(TripModel tripModel) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_DEPARTURE, tripModel.getDeparture());
        cv.put(COLUMN_DESTINATION, tripModel.getDestination());
        cv.put(COLUMN_MAX_DURATION_ACCOMMODATION, tripModel.getDurationAccommodation());
        cv.put(COLUMN_MAX_PASSENGERS, tripModel.getPassengers());


        db.insert(TRIPS_TABLE, null, cv);
    }


}
