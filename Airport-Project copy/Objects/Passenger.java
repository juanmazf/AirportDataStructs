package Objects;

import java.util.ArrayList;
import java.util.Random;


public class Passenger {
    private String name;
    private String passport;
    private Flight flightinfo;
    
    public Passenger(String name, String passport, Flight flightinfo) {
        this.name = name;
        this.passport = passport;
        this.flightinfo = flightinfo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public Flight getFlightinfo() {
        return flightinfo;
    }

    public void setFlightinfo(Flight flightinfo) {
        this.flightinfo = flightinfo;
    }

    @Override
    public String toString() {
        return "Passenger:\n" + "  " + name + "\nPassport number:" +"\n  " + passport + "\nFlightinfo: " + flightinfo + "\n" ;
    }

    // genrates random passaport number that resembles a US passaport.
    public static String randomPassaport(){
        String passportNumber = "";
        Random rand = new Random();
        
        passportNumber += "US";

        for (int i = 0; i < 7; i++) {
            passportNumber += rand.nextInt(10);
        }
        
        return passportNumber;
    }

    // compares names and if names are the same compares passport numbers.
    public int compareTo(Passenger other) {
        int nameComparison = name.compareTo(other.getName());
        if (nameComparison != 0) {
            return nameComparison;
        }
        return passport.compareTo(other.getPassport());
    }
    // creates predetermined passengers and adds them to an arrayList that it returns.
    public static ArrayList<Passenger> createPassengers(){
        ArrayList<Passenger> myList = new ArrayList<Passenger>();

        Flight nakondaAirlines = new Flight("Miami", "Madrid", 3476, 8.35);
        Flight aMerryCano = new Flight("Miami", "Los Angeles", 537, 6.06);
        Flight sebby = new Flight("Miami", "Buenos Aires", 843, 8.50);
        Flight juanNa = new Flight("Los Angeles", "Tokyo", 7834, 11.50);
        Flight birdie = new Flight("Los Angeles", "Buenos Aires", 9433, 14.30);
        Flight eronda = new Flight("Madrid", "Paris", 4362, 2.00);
        Flight ilmarAirlines = new Flight("Madrid", "Cairo", 3623, 4.35);
        Flight USAirAir = new Flight("Paris", "Cairo", 4284, 4.20);
        Flight TDFly = new Flight("Cairo", "Shanghai", 8532, 15.40);
        Flight KFlights = new Flight("Cairo", "New Delhi", 9434, 8.20);
        Flight JPAir = new Flight("Tokyo", "New Delhi", 1462, 7.50);
        Flight TokyoFlights = new Flight("Tokyo", "Shanghai", 3452, 2.55);
        Flight ShangHeight = new Flight("Shanghai", "New Delhi", 4831, 9.35);
        
        Passenger p1 = new Passenger(" Ava Patel", randomPassaport(),nakondaAirlines);
        Passenger p2 = new Passenger("Joshua Kim", randomPassaport(), aMerryCano);
        Passenger p3 = new Passenger("Isabella Nguyen", randomPassaport(),sebby);
        Passenger p4 = new Passenger("Sophia Garcia", randomPassaport(), juanNa);
        Passenger p5 = new Passenger("Michael Rodriguez", randomPassaport(), birdie);
        Passenger p6 = new Passenger("Emily Leer", randomPassaport(),eronda);
        Passenger p7 = new Passenger("Benjamin Davis", randomPassaport(),ilmarAirlines);
        Passenger p8 = new Passenger("Victoria Hernandez", randomPassaport(),USAirAir);
        Passenger p9 = new Passenger("William Baker", randomPassaport(),TDFly);
        Passenger p10 = new Passenger("Gabriella Chavez", randomPassaport(),KFlights);
        Passenger p11 = new Passenger("Christopher Green", randomPassaport(),JPAir);
        Passenger p12 = new Passenger("Olivia Taylor", randomPassaport(),TokyoFlights);
        Passenger p13 = new Passenger("Daniel Wong", randomPassaport(),ShangHeight);
        

        myList.add(p1);
        myList.add(p2);
        myList.add(p3);
        myList.add(p4);
        myList.add(p5);
        myList.add(p6);
        myList.add(p7);
        myList.add(p8);
        myList.add(p9);
        myList.add(p10);
        myList.add(p11);
        myList.add(p12);
        myList.add(p13);

        return myList;

    }

    
}
