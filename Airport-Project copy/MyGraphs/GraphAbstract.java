package MyGraphs;
import java.util.List;

public abstract class GraphAbstract implements GraphInterface
{
    protected List<Vertex> vertices;
    protected List<Edge> edges;


    GraphAbstract(List<Vertex> vertices, List<Edge> edges) {
        this.vertices = vertices;
        this.edges = edges;
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

}