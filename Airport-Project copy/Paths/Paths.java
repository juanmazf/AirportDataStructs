package Paths;
import MyGraphs.*; 
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.List;



public class Paths {

    ArrayList<Vertex> path;
    int time;

    public Paths(ArrayList<Vertex> path, int time)
    {
        this.path = path;
        this.time = time;
    }
    public Paths()
    {
        path = null;
        time = Integer.MAX_VALUE;
    }

    public ArrayList<Vertex> getPath()
    {
        return path;
    }

    public int getTime()
    {
        return time;
    }

    public Paths findShortestPath(GraphExtended g, Vertex departure, Vertex destination)
    {
        Paths p = new Paths();
        ArrayList<PathVertex> dijkstraFinished = p.dijkstra(g, departure);
        int totalTime = 0;
        Vertex currVertex = destination;
        boolean done = false;
        ArrayList<Vertex> shortestPath = new ArrayList<Vertex>();
        
        for(int i = 1; i < dijkstraFinished.size(); i++)
        {
            if(currVertex.getCity().equals(dijkstraFinished.get(i).getCity()))
            {
                totalTime = dijkstraFinished.get(i).distance;
            }   
        }
        // runs dijikstras to get table

        
        while(!done)
        {
            for(int i = 0; i < dijkstraFinished.size() - 1; i++)
            {
                if(currVertex == null)
                {
                    currVertex = dijkstraFinished.get(i);
                }
                else{
                // goes through the table and finds the shortest path
                //starts from end works towards the departure city
                    if(currVertex.getCity().equals(dijkstraFinished.get(i).getCity()) 
                    && !currVertex.getCity().equals(departure.getCity()))
                    {
                        shortestPath.add(0,currVertex);
                        currVertex = dijkstraFinished.get(i).parent;
                    }
                    else if(currVertex.getCity().equals(departure.getCity()))
                    {
                        shortestPath.add(0,currVertex);
                        done = true;
                        break;
                    }
                }
            }
        
        }

       Paths shortest = new Paths(shortestPath, totalTime);

        return shortest;
    }

    public ArrayList<PathVertex> dijkstra(GraphExtended g, Vertex v){

        ArrayList<PathVertex> myPathVertex = initializeSingleSource(g, v);
        PriorityQueue<PathVertex> priorityQueue = updatePriorityQueueDistances(myPathVertex);
        
        PathVertex smallest;

        List<Edge> edges;


        while(!priorityQueue.isEmpty())
        {
            smallest = priorityQueue.poll();
            smallest.visited = true;
            edges = g.incidentEdges(smallest);

            for(Edge edge: edges)
            {
                Vertex incVertex = edge.dest;
                PathVertex inciPath = null;

                for(PathVertex path: myPathVertex)
                {
                    if(path.getCity().equals(incVertex.getCity()))
                    {
                        inciPath = path;
                        break;
                    }
                }

                if(relaxEdge(smallest, inciPath, edge.getTime()))
                {
                    priorityQueue = updatePriorityQueueDistances(myPathVertex);
                }
            }
            
        }




        return myPathVertex;
    }
    private static PriorityQueue<PathVertex> updatePriorityQueueDistances(List<PathVertex> paths) {
        PriorityQueue<PathVertex> pq = new PriorityQueue<>(new ComparatorByTime());
        for(int i = 0; i < paths.size(); i++) {
            PathVertex currentPV = paths.get(i);

            // If the currentPV is visited, skip
            if(currentPV.visited) {
                continue;
            }

            pq.add(currentPV);
        }
        return pq;
    }

    public static ArrayList<PathVertex> initializeSingleSource(GraphExtended g, Vertex s) {

        ArrayList<PathVertex> singleSource = new ArrayList<PathVertex>();
        List<Vertex> myVerticies = g.vertices();
        
        Vertex temporary;

        
        for(int i = 0; i < myVerticies.size(); i++)
        {
            if(myVerticies.get(i).getCity().equals(s.getCity()))
            {
                String label = s.getCity();
                PathVertex newPathVertex = new PathVertex(label,0);
                singleSource.add(newPathVertex);
            }
            else
            {
                temporary = myVerticies.get(i);
                PathVertex temp = new PathVertex(temporary.getCity());
                singleSource.add(temp);
            }
        }
        // This sets every PathVertex's parent to null and its distance to the source infinity
        // except for the source (s) where its distance is 0
        
        return singleSource;
    }

    public static boolean relaxEdge(PathVertex v, PathVertex w, int weight) {            //relaxes edge when necessary
        if(!v.distance.equals(Integer.MAX_VALUE) && v.distance + weight < w.distance) {
            w.distance = v.distance + weight;
            w.parent = v;
            
            return true;
        }
        return false;
    }

    public String toString() //shows route
    {
        String route = "";

        for(int i = 0; i < this.path.size(); i++)
        {
            route += this.path.get(i).getCity() + " --> ";
        }
        route += " ; total time: " + this.time;

        return route;
    }



    
}


