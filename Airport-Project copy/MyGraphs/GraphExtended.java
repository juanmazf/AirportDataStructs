package MyGraphs;
import java.util.ArrayList;
import java.util.List;

public class GraphExtended extends GraphAbstract 
{
    public GraphExtended(List<Vertex> vertices, List<Edge> edges) {
        super(vertices, edges);
    };

    /**
     * Return list of edges around vertex
     * @param v the vertex to get edges from
     */
    // ** TO DO **
    public List<Edge> incidentEdges(Vertex v) {
        // Returns the edges around vertex v

        ArrayList<Edge> inEdges = new ArrayList<Edge>();

    
        for(int i = 0; i < edges.size(); i++)
        {
            if(edges.get(i).departure.getCity().equals(v.getCity()))
            {
                inEdges.add(edges.get(i));
            }
        }

        return inEdges;
    }

    public List<Vertex> vertices()
    {
        return vertices;
    }

    public List<Edge> edges()
    {
        return edges;
    }

    public Vertex getVertex(int index)
    {
        return this.vertices.get(index);
    }

    public void showMap()
    {
        List<Edge> edges = edges();

        for(int i = 0; i < edges.size(); i++)
        {
            System.out.println(edges.get(i).toString());
        }
    }


    
}
