package Main;
import MyGraphs.*;
import Tree.*;
import Paths.*;
import Objects.*;
import java.util.*;

/*
 * Group member:
 * Juan Zaragoza, Sebastian Abarca, Eros Lorenzo
 * 
 * Contribution:
 * Juan Zaragoza
 *      AVL tree, Passenger, and Main classes
 * 
 * Sebastian Abarca
 *     Graph, Paths, and Main class
 * 
 * Eros Lorenzo
 *      HashMap
 */


public class Main
{
    final static Vertex miami = new Vertex("Miami");
    final static Vertex tokyo = new Vertex("Tokyo");
    final static Vertex losAngeles = new Vertex("Los Angeles");
    final static Vertex buenosAires = new Vertex("Buenos Aires");
    final static Vertex madrid = new Vertex("Madrid");
    final static Vertex cairo = new Vertex("Cairo");
    final static Vertex paris = new Vertex("Paris");
    final static Vertex shanghai = new Vertex("Shanghai");
    final static Vertex newDehli = new Vertex("New Dehli");

    final static List<Vertex> vertices = Arrays.asList(
            miami, tokyo, losAngeles, buenosAires, madrid, cairo, paris, shanghai, newDehli);

    final static List<Edge> edges = Arrays.asList(
    new Edge(miami, madrid, 8), new Edge(miami, losAngeles, 6), new Edge(miami, buenosAires, 9),
    new Edge(losAngeles, tokyo, 12), new Edge(losAngeles, buenosAires, 14), new Edge(madrid, paris, 2),
    new Edge(madrid, cairo, 4), new Edge(paris, cairo, 4), new Edge(cairo,shanghai, 14),
    new Edge(cairo, newDehli, 8), new Edge(tokyo, newDehli, 8), new Edge(shanghai, newDehli, 10),
    new Edge(tokyo, shanghai, 3),new Edge(madrid, miami, 8), new Edge(losAngeles, miami, 6), new Edge(buenosAires, miami, 9),
    new Edge(tokyo, losAngeles, 12), new Edge(buenosAires, losAngeles, 14), new Edge(paris, madrid, 2),
    new Edge(cairo, madrid, 4), new Edge(cairo, paris, 4), new Edge(shanghai, cairo, 14),
    new Edge(newDehli, cairo, 8), new Edge(newDehli, tokyo, 8), new Edge(newDehli, shanghai, 10),
    new Edge(shanghai, tokyo, 3)
            );
    static HashMap<String, Flight> flyFo = new HashMap<String, Flight>();
    static Flight nakondaAirlines = new Flight("Miami", "Madrid", 3476, 8.35);
    static Flight aMerryCano = new Flight("Miami", "Los Angeles", 537, 6.06);
    static Flight sebby = new Flight("Miami", "Buenos Aires", 843, 8.50);
    static Flight juanNa = new Flight("Los Angeles", "Tokyo", 7834, 11.50);
    static Flight birdie = new Flight("Los Angeles", "Buenos Aires", 9433, 14.30);
    static Flight eronda = new Flight("Madrid", "Paris", 4362, 2.00);
    static Flight ilmarAirlines = new Flight("Madrid", "Cairo", 3623, 4.35);
    static Flight USAirAir = new Flight("Paris", "Cairo", 4284, 4.20);
    static Flight TDFly = new Flight("Cairo", "Shanghai", 8532, 15.40);
    static Flight KFlights = new Flight("Cairo", "New Dehli", 9434, 8.20);
    static Flight JPAir = new Flight("Tokyo", "New Dehli", 1462, 7.50);
    static Flight TokyoFlights = new Flight("Tokyo", "Shanghai", 3452, 2.55);
    static Flight ShangHeight = new Flight("Shanghai", "New Dehli", 4831, 9.35);
    static Flight[] allFlights = {nakondaAirlines, aMerryCano, sebby,juanNa,birdie,eronda,ilmarAirlines,USAirAir
            ,TDFly,KFlights,JPAir,TokyoFlights,ShangHeight};

    public static void main(String[] args){
        for(int i = 0;i< allFlights.length;i++){
            flyFo.put(allFlights[i].getDeparture(), allFlights[i]);
        }
        GraphExtended map = new GraphExtended(vertices, edges);

        Paths p = new Paths();

        AVLtree tree = new AVLtree();

        menu(map,tree,p);
    
    } 

    static Scanner scnr = new Scanner(System.in);
    public static void menu(GraphExtended map,AVLtree tree, Paths p){
        
        boolean flag = false;
        int input = -1;
    do{
        try{
                System.out.println("1.Show map");
                System.out.println("2.add passenger");
                System.out.println("3.Print shortest path");
                System.out.println("4.print passenger list");
                System.out.println("5.remove passenger");
                System.out.println("6.find passenger");
                System.out.println("7.add flight");
                System.out.println("8.Show flight information");
                System.out.println("9. Exit");
                input = scnr.nextInt();

                if(input <= 9 && input >= 1){
                    swi(input, map, tree, p);
                }
                else if(input == 9){
                    flag = true;
                }else{
                    System.out.println("Please try again using numbers 1 through 9");
                }
            
            }catch(InputMismatchException e){
                System.out.println("please try again using numbers 1 through 9");
                flag = false;
                scnr.next();
            }
        }while(flag == false);
    }

    public static void swi(int input, GraphExtended map, AVLtree tree, Paths p){
        switch(input){
            case 1:
                map.showMap();
                System.out.println();
            break;

            case 2:
                int a;

                System.out.println("Here are the passenger that are available to be added please select one.");

                ArrayList<Passenger> myList = Passenger.createPassengers();

                for(int i = 0; i < myList.size();i++){
                    System.out.println(i+1 + ". " + myList.get(i));
                }
                a = scnr.nextInt();

                tree.add(myList.get(a));

                System.out.println();
            break;

            case 3: // find shortest path between 2 cities
                Vertex v1 = null;
                Vertex v2 = null;
                String departure;
                String destination;
                scnr.nextLine();
            
            do{
                System.out.println("Please select a where you will be departing from: ");
                System.out.println(map.vertices());
                departure = scnr.nextLine();

                System.out.println("Please select a destination: ");
                System.out.println(map.vertices());
                destination = scnr.nextLine();
            
                v1 = findVertex(destination, map);
                v2 = findVertex(departure, map);
            
            }while((v1 == null || v2 == null) && (v1 == null && v2 == null));

                System.out.println(p.findShortestPath(map, v2, v1));

                System.out.println();
            break;

            case 4: // add passenger
                tree.printTree();
                System.out.println();
            break;

            case 5: // remove passenger
                int b;

                System.out.println("Here are the passenger that are available to be removed please select one.");

                ArrayList<Passenger> myList2 = Passenger.createPassengers();

                for(int i = 0; i < myList2.size();i++){
                    System.out.println(i+1 + ". " + myList2.get(i));
                }

                b = scnr.nextInt();

                tree.remove(myList2.get(b));

                System.out.println();
            break;

            case 6: // find passenger
                int c;

                System.out.println("Here are the passenger that are available to be removed please select one.");

                ArrayList<Passenger> myList3 = Passenger.createPassengers();

                for(int i = 0; i < myList3.size();i++){
                    System.out.println(i+1 + ". " + myList3.get(i));
                }

                c = scnr.nextInt();

                tree.find(myList3.get(c));

                System.out.println();
            break;
            
            case 7:
                System.out.println("Hello what is a flight you would like to add to our catalogue");
                addFlight(map);
                System.out.println();
            break;

            case 8:
                showFlightList(flyFo);
                System.out.println();
            break;

            case 9:
                System.exit(0);
            break;
        
        }

    }
    

    public static void showFlightList(HashMap<String, Flight> flytfo){
        for (Map.Entry<String, Flight> entry : flytfo.entrySet()){
            Flight value = entry.getValue();

            System.out.println("Flight #" + value.getFlightnum() + ": Departure(" + value.getDeparture() + 
            ") Destination(" + value.getDestination() + ") duration: " + value.getDuration());
        }

    }

    public static void addFlight(GraphExtended g){
        String airline;
        String departure = "Not here";
        String destination = "nope";
        double time;
        boolean city = false;
        System.out.println("What airline manages this flight");
        airline = scnr.nextLine();

        do{
            try{
                System.out.println("""
                        Which city is it departing from?
                        Miami (MI)
                        Madrid (MD)
                        los Angeles (LA)
                        Buenos Aires (BA)
                        Tokyo (TK)
                        Paris (P)
                        Cairo (CO)
                        Shanghai (SH)
                        New Dehli (ND) 
                        Please type using the 2 letter code next to the location""");

                while(!city){
                    departure = scnr.nextLine();
                    if(departure.equalsIgnoreCase("mi") || departure.equalsIgnoreCase("md")
                        || departure.equalsIgnoreCase("la") || departure.equalsIgnoreCase("BA")
                        || departure.equalsIgnoreCase("TK") || departure.equalsIgnoreCase("P")
                        || departure.equalsIgnoreCase("CO") || departure.equalsIgnoreCase("SH")
                        || departure.equalsIgnoreCase("ND")){
                            city = true;

                        if(departure.equalsIgnoreCase("mi")){
                            departure = "Miami";
                        }else if(departure.equalsIgnoreCase("md")){
                            departure = "Madrid";
                        }else if(departure.equalsIgnoreCase("la")){
                            departure = "Los Angeles";
                        }else if(departure.equalsIgnoreCase("ba")){
                            departure = "Buenos Aires";
                        }else if(departure.equalsIgnoreCase("TK")){
                            departure = "Tokyo";
                        }else if(departure.equalsIgnoreCase("P")){
                            departure = "Paris";
                        }else if(departure.equalsIgnoreCase("CO")){
                            departure = "Cairo";
                        }else if(departure.equalsIgnoreCase("sh")){
                            departure = "Shanghai";
                        }else if(departure.equalsIgnoreCase("nd")){
                            departure = "New Dehli";
                        }
                    }
                    if(!city){
                        System.out.println("These are not valid cities");
                    }
                }

            }catch(InputMismatchException e){
                System.out.println("Sorry please enter a string.");
            }
        }while(!city);

        do{
            try{
                System.out.println("""
                        Which city is it departing from?
                        Miami (MI)
                        Madrid (MD)
                        los Angeles (LA)
                        Buenos Aires (BA)
                        Tokyo (TK)
                        Paris (P)
                        Cairo (CO)
                        Shanghai (SH)
                        New Dehli (ND) 
                        Please type using the 2 letter code next to the location""");
                while(!city) {
                    destination = scnr.nextLine();

                    if(destination.equalsIgnoreCase("mi") || destination.equalsIgnoreCase("md")
                        || destination.equalsIgnoreCase("la") || destination.equalsIgnoreCase("BA")
                        || destination.equalsIgnoreCase("TK") || destination.equalsIgnoreCase("P")
                        || destination.equalsIgnoreCase("CO") || destination.equalsIgnoreCase("SH")
                        || destination.equalsIgnoreCase("ND")){
                            city = true;

                        if(destination.equalsIgnoreCase("mi")){
                            destination = "Miami";
                        }else if(destination.equalsIgnoreCase("md")){
                            destination = "Madrid";
                        }else if(destination.equalsIgnoreCase("la")){
                            destination = "Los Angeles";
                        }else if(destination.equalsIgnoreCase("ba")){
                            destination = "Buenos Aires";
                        }else if(destination.equalsIgnoreCase("TK")){
                            destination = "Tokyo";
                        }else if(destination.equalsIgnoreCase("P")){
                            destination = "Paris";
                        }else if(destination.equalsIgnoreCase("CO")){
                            destination = "Cairo";
                        }else if(destination.equalsIgnoreCase("sh")){
                            destination = "Shanghai";
                        }else if(destination.equalsIgnoreCase("nd")){
                            destination = "New Dehli";
                        }
                    }

                    if(!city){
                        System.out.println("These are not valid cities");
                    }

                    for (HashMap.Entry<String, Flight> entry : flyFo.entrySet()) {
            
                        Flight value = entry.getValue();
                        String deppy = value.getDeparture();
                        String desty = value.getDestination();
                        if(deppy == departure && desty == destination){
                            city = false;
                        }
                    }

                    if(destination.equals(departure)){
                        city = false;
                        System.out.println("These 2 are the same city try again");
                    }
                }

            }catch(InputMismatchException e){
                System.out.println("Sorry please enter a string.");
            }
        }while(!city);

        int flightNum =  (int)Math.floor(Math.random() *(9999 - 100 + 1) + 100);
        System.out.println("How long would this flight take in hours? (Please type as a double)");
        time = scnr.nextDouble();

        Flight h1 = new Flight(departure, destination, flightNum, time);
        flyFo.put(departure, h1);
        
        System.out.println("Congratulations you have added your new flight.");
    }

    public static Vertex findVertex(String string, GraphExtended g)
    {
        Vertex v;
        List<Vertex> verticies = g.vertices();
        for(int i = 0; i < verticies.size(); i++)
        {
            if(string.equalsIgnoreCase(verticies.get(i).getCity()))
            {
                return verticies.get(i);
            }
        }
        return null;
    }
   
}
