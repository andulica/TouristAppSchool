package andreibalan.com.touristappschool;

public class CityBreak {

    private int id;
    private String departure;
    private String destination;
    private int durationAccommodation;
    private int passengers;
    private boolean disability;

    //params constructor for the CityBreak class
    public CityBreak(int id, String departure, String destination, int durationAccommodation, int passengers, boolean disability) {
        this.id = id;
        this.departure = departure;
        this.destination = destination;
        this.durationAccommodation = durationAccommodation;
        this.passengers = passengers;
        this.disability = disability;
    }

    //default constructor for the CityBreak class
    public CityBreak() {
    }

    //toString method for the CityBreak class needed for printing contents of a class object
    @Override
    public String toString() {
        return "CityBreak{" +
                "id=" + id +
                ", departure='" + departure + '\'' +
                ", destination='" + destination + '\'' +
                ", durationAccommodation=" + durationAccommodation +
                ", passengers=" + passengers +
                ", disability=" + disability +
                '}';
    }

    //getter and setter methods for the CityBreak class
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public boolean isDisability() {
        return disability;
    }

    public void setDisability(boolean disability) {
        this.disability = disability;
    }
}
