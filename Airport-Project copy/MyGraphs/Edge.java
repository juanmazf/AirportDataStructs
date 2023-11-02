package MyGraphs;

public class Edge 
{
    public Vertex departure, dest;
    public int time;

    public Edge(Vertex departure, Vertex dest, int weight)
    {
        this.departure = departure;
        this.dest = dest;
        this.time = weight;
    }

    public String getDeparture() {
        return departure.getCity();
    }

    public Vertex getDepartureVertex()
    {
        return departure;
    }

    public void setDeparture(Vertex departure) {
        this.departure = departure;
    }

    public String getDest() {
        return dest.getCity();
    }

    public Vertex getDestVertex()
    {
        return dest;
    }

    public void setDest(Vertex dest) {
        this.dest = dest;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }


    @Override
    public String toString() 
    {
        return  departure.getCity() + " <---> " + dest.getCity()
            + " ; Time: " + time;
    }
    
    
}
