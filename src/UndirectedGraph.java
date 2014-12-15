import java.util.ArrayList;
import java.util.HashMap;

/**
 * The UndirectedGraph data type represents a undirected graph.
 * It is implemented using a HashMap, the key which stores an integer/vertex
 * and the value which stores the adjacency list for the vertex
 */
public class UndirectedGraph {
    // Number of vertices
    private final int V;

    // Number of edges
    private int E;

    // A HashMap which stores the adjacency lists for each vertex
    private HashMap<Integer, ArrayList<Integer>> adj;

    /**
     * A constructor which accepts the number of vertices as an argument
     * @param V the number of vertices
     */
    public UndirectedGraph(int V) {
        this.V = V;
        this.E = 0;
        // Initialize the HashMap
        adj = new HashMap<Integer, ArrayList<Integer>>();
    }

    /**
     * Returns the number of vertices in the graph
     * @return an integer
     */
    public int V() {
        return V;
    }

    /**
     * Returns the number of edges in the graph
     * @return an integer
     */
    public int E() {
        return E;
    }

    /**
     * The Method for adding an edge between a vertex v and a vertex w.
     * An edge is added to v and w's adjacency lists.
     * @param v a vertex
     * @param w a vertex
     */
    public void addEdge(int v, int w) {
        // If vertex v already has an initialized adjacency list (i.e., other edges),
        // add w to its current adjacency list
        if (adj.containsKey(v)) {
            adj.get(v).add(w);
        }
        else {
            ArrayList<Integer> temp = new ArrayList<Integer>();
            temp.add(w);
            adj.put(v, temp);
        }

        // If vertex w doesn't have an itialized adjacency list (i.e. no edges),
        // create an ArrayList (temp) then add v to it.
        if (adj.containsKey(w)) {
            adj.get(w).add(v);
        }
        else {
            ArrayList<Integer> temp = new ArrayList<Integer>();
            temp.add(w);
            adj.put(w, temp);
        }
        E++;
    }

    /**
     * Return the adjacency list for a vertex
     * @param v a vertex
     * @return an ArrayList
     */
    public Iterable<Integer> adj(int v) {
        // If the HashMap has the vertex v and its not null (i.e. the vertex has an edge(s)
        // Return the adjacency list for v
        if (adj.containsKey(v) && adj.get(v) != null) {
            return adj.get(v);
        }

        // If the vertex has never been initialized (i.e., it has no edges or outgoing edges)
        // initialize an ArrayList and return it.
        adj.put(v, new ArrayList<Integer>());
        return adj.get(v);
    }
}
