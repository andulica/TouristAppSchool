package andreibalan.com.touristappschool;

public class TripModel {

    private String departure;
    private String destination;
    private int durationAccommodation;
    private int passengers;

    private boolean isAvailable;


    //params constructor for the CityBreak class
    public TripModel(String departure, String destination, int durationAccommodation, int passengers, boolean isAvailable) {
        this.departure = departure;
        this.destination = destination;
        this.durationAccommodation = durationAccommodation;
        this.passengers = passengers;
        this.isAvailable = isAvailable;
    }

    //default constructor for the CityBreak class
    public TripModel() {
    }

    //toString method for the CityBreak class needed for printing contents of a class object
    @Override
    public String toString() {
        return "CityBreak{" +
                ", departure='" + departure + '\'' +
                ", destination='" + destination + '\'' +
                ", durationAccommodation=" + durationAccommodation +
                ", passengers=" + passengers +
                ", isAvailable=" + isAvailable +
                '}';
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getDurationAccommodation() {
        return durationAccommodation;
    }

    public void setDurationAccommodation(int durationAccommodation) {
        this.durationAccommodation = durationAccommodation;
    }

    public int getPassengers() {
        return passengers;
    }

    public void setPassengers(int passengers) {
        this.passengers = passengers;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}
