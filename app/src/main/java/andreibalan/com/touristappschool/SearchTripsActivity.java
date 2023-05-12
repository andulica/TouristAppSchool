package andreibalan.com.touristappschool;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchTripsActivity extends AppCompatActivity {

    private String[] arrayDepartures = {"Bucharest", "Milano", "London", "Manchester"};
    private String[] arrayDestinations = {"Barcelona", "Madrid", "Canary Islands", "Cancun"};
    private List<Integer> durationList = new ArrayList<>();
    private List<Integer> passengersList = new ArrayList<>();
    private String[] arrayDisabilities = {"Yes", "No"};
    Button btnSearch;
    private int durationDay;
    private String departure;
    private String destination;
    private int passengers;
    private String disability;

    AutoCompleteTextView autoCompleteTextViewDepartures, autoCompleteTextViewDestinations, autoCompleteTextViewDuration, autoCompleteTextViewPassengers, autoCompleteTextViewDisability;
    ArrayAdapter<Integer> adapterItemsDuration, adapterItemsPassengers;
    ArrayAdapter<String> adapterItemsDepartures, adapterItemsDestinations,adapterItemsDisability;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_trips);

        btnSearch = findViewById(R.id.search_button);
        autoCompleteTextViewDepartures = findViewById(R.id.auto_complete_txt_from);
        autoCompleteTextViewDestinations = findViewById(R.id.auto_complete_txt_to);
        autoCompleteTextViewDuration = findViewById(R.id.auto_complete_txt_duration);
        autoCompleteTextViewPassengers = findViewById(R.id.auto_complete_txt_passengers);
        autoCompleteTextViewDisability = findViewById(R.id.auto_complete_txt_disabilities);

        //populates the arraylist meant for the duration of the trip
        Integer[] arrayDuration = {1,2,3,4,5,6,7,8,9,10};
        durationList = Arrays.asList(arrayDuration);

        //populates the arraylist meant for the number of
        Integer[] arrayPassengers = {1 ,2, 3, 4, 5};
        passengersList = Arrays.asList(arrayPassengers);

        //sets the adapter for the autocomplete textview meant for departure
        adapterItemsDepartures = new ArrayAdapter<String>(this, R.layout.list_item, arrayDepartures);

        autoCompleteTextViewDepartures.setAdapter(adapterItemsDepartures);

        autoCompleteTextViewDepartures.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                departure = adapterView.getItemAtPosition(i).toString();
                Toast.makeText(SearchTripsActivity.this, "Item: " + departure, Toast.LENGTH_SHORT).show();
                autoCompleteTextViewDepartures.setVisibility(View.VISIBLE);

            }
        });

        //sets the adapter for the autocomplete textview meant for destination
        adapterItemsDestinations = new ArrayAdapter<String>(this, R.layout.list_item, arrayDestinations);

        autoCompleteTextViewDestinations.setAdapter(adapterItemsDestinations);

        autoCompleteTextViewDestinations.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                destination = adapterView.getItemAtPosition(i).toString();
                Toast.makeText(SearchTripsActivity.this, "Item: " + destination, Toast.LENGTH_SHORT).show();
            }
        });

        //sets the adapter for the autocomplete textview meant for duration
        adapterItemsDuration = new ArrayAdapter<Integer>(this, R.layout.list_item, durationList);

        autoCompleteTextViewDuration.setAdapter(adapterItemsDuration);

        autoCompleteTextViewDuration.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                durationDay = (int) adapterView.getItemAtPosition(i);
                autoCompleteTextViewDuration.setText(String.valueOf(durationDay));

                Toast.makeText(SearchTripsActivity.this, "Item: " + durationDay, Toast.LENGTH_SHORT).show();
            }
        });

        //sets the adapter for the autocomplete textview meant for passengers
        adapterItemsPassengers = new ArrayAdapter<Integer>(this, R.layout.list_item, passengersList);

        autoCompleteTextViewPassengers.setAdapter(adapterItemsPassengers);

        autoCompleteTextViewPassengers.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                passengers = (int) adapterView.getItemAtPosition(i);
                Toast.makeText(SearchTripsActivity.this, "Item: " + passengers, Toast.LENGTH_SHORT).show();
            }
        });

        //sets the adapter for the autocomplete textview meant for disabilities
        ArrayAdapter<String> adapterItemsDisabilities = new ArrayAdapter<String>(this, R.layout.list_item, arrayDisabilities);

        autoCompleteTextViewDisability.setAdapter(adapterItemsDisability);

        autoCompleteTextViewDisability.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                disability = adapterView.getItemAtPosition(i).toString();
                Toast.makeText(SearchTripsActivity.this, "Item: " + disability, Toast.LENGTH_SHORT).show();
            }
        });

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                //checks if the fields are empty
                if (departure == null || destination == null || durationDay == 0 || passengers == 0 || disability == null) {
                    Toast.makeText(SearchTripsActivity.this, "Please fill in all the fields", Toast.LENGTH_SHORT).show();
                }
                //checks if all the fields are not empty and if the user has a disability. If the user has a disability, then
                //the user will be redirected to the DisabilitiesSearchFindings activity along with the data passed from the user input
                if (departure != null && destination != null && durationDay != 0 && passengers != 0 && disability.equals("Yes")){
                    Intent intent = new Intent(SearchTripsActivity.this, DisabilitiesSearchFindingsActivity.class);
                    intent.putExtra("departure", departure);
                    intent.putExtra("destination", destination);
                    intent.putExtra("duration", durationDay);
                    intent.putExtra("passengers", passengers);
                    startActivity(intent);
                }

                //sends the user to the TripsSearchFindings activity along with the data passed from the user input
                if (departure != null && destination != null && durationDay != 0 && passengers != 0 && disability.equals("No")) {
                    Intent intent = new Intent(SearchTripsActivity.this, TripsSearchFindingsActivity.class);
                    intent.putExtra("departure", departure);
                    intent.putExtra("destination", destination);
                    intent.putExtra("duration", durationDay);
                    intent.putExtra("passengers", passengers);
                    startActivity(intent);
                }
            }
        });
    }
}