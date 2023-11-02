package Paths;
import MyGraphs.Vertex;

public class PathVertex extends Vertex
{
    public Integer distance;
    public Vertex parent;
    public boolean visited;

    PathVertex(String label) {
        super(label);
        this.distance = Integer.MAX_VALUE;
        this.parent = null;
        this.visited = false;
    }
    PathVertex(String label, Integer i)
    {
        super(label);
        this.distance = i;
        this.parent = null;
        this.visited = false;
    }

    

    public void setDistance(Integer distance) {
        this.distance = distance;
    }
    public void setParent(Vertex parent) {
        this.parent = parent;
    }
    public void setVisited(boolean visited) {
        this.visited = visited;
    }
    public Integer getDistance() {
        return distance;
    }
    public Vertex getParent() {
        return parent;
    }
    public boolean isVisited() {
        return visited;
    }

}
