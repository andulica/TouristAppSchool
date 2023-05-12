package andreibalan.com.touristappschool;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class TripsSearchFindingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trips_search_findings);



    }

    Intent intent = getIntent();
    String departure = intent.getStringExtra("departure");
    String destination = intent.getStringExtra("destination");
    int duration = intent.getIntExtra("duration", 0);
    int passengers = intent.getIntExtra("passengers",0);
    List<TripModel> tripsToCheck = tripsAdded();


    //checks if the parameters introduced by the user match the parameters of the trips in the ArrayList
    //if they match then the trip is set to unavailable and I will display the trip in the RecyclerView
    public TripModel checkIfParametersMatch() {
        for (int i = 0; i < tripsToCheck.size(); i++) {
            if (departure.equals(tripsToCheck.get(i).getDeparture()) && destination.equals(tripsToCheck.get(i).getDestination()) &&
                    duration <= tripsToCheck.get(i).getDurationAccommodation() && passengers <= tripsToCheck.get(i).getPassengers() && tripsToCheck.get(i).isAvailable() == true) {
                tripsToCheck.get(i).setAvailable(false);
                return tripsToCheck.get(i);
            }
        }
        return null;
    }

    //this method displays the trips that match the parameters introduced by the user
    //in the RecyclerView
    private void displayTripFound() {
        TripModel tripToDisplay = checkIfParametersMatch();

    }


    //this method adds trips to the ArrayList
    private List<TripModel> tripsAdded() {
        List<TripModel> tripsArrayList = new ArrayList<>();

        TripModel tripModel = new TripModel("Bucharest", "Madrid",  20, 6, true);
        TripModel tripModel1 = new TripModel("London", "Canary Islands",  20, 6, true);
        TripModel tripModel2 = new TripModel("Manchester", "Cancun",  20, 6, true);
        TripModel tripModel3 = new TripModel("Milano", "Barcelona",  30, 6, true);
        TripModel tripModel4 = new TripModel("London", "Madrid",  20, 6, true);
        TripModel tripModel5 = new TripModel("London", "Cancun",  20, 6, true);
        TripModel tripModel6 = new TripModel("Manchester", "Cancun",  20, 6, true);
        TripModel tripModel7 = new TripModel("London", "Barcelona",  30, 6, true);
        TripModel tripModel8 = new TripModel("Leeds", "Madrid",  20, 6, true);
        TripModel tripModel9 = new TripModel("Leeds", "Canary Islands",  20, 6, true);
        TripModel tripModel10 = new TripModel("Leeds", "Cancun",  20, 6, true);




        return tripsArrayList;
    }




    //need to create a method that checks the parameters passed from the search activity with
    //the parameters of the TRIPS_TABLE in the database
    //if the parameters match then I will create a TripModel object based on those parameters and display
    // the object properties such as image of the destination, price , hotel to an RecyclerView
    // same technique for disabilitiesSearchFindingsActivity
}