package Objects;
public class Flight {
    private String departure, destination;
    private int flightnum;
    private double duration;
    
    public Flight(String departure, String destination, int flightnum, double duration) {
        this.departure = departure;
        this.destination = destination;
        this.flightnum = flightnum;
        this.duration = duration;
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

    public int getFlightnum() {
        return flightnum;
    }

    public void setFlightnum(int flightnum) {
        this.flightnum = flightnum;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "\n  Departure: " + departure + "\n  Destination: " + destination + "\n  Flight number: " + flightnum
                + "\n  Duration: " + duration ;
    }

    
}
