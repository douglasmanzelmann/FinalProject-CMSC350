import java.util.HashMap;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * The GraphDFS class represents a class for determining the vertices
 * reachable from a given source vertex using depth first search (DFS).
 */
public class GraphDFS {
    // Keeps track of the marked vertices in the DFS
    private HashMap<Integer, Boolean> marked;

    // Vertices are added to this once this are exhausted in a DFS
    // i.e., the DFS order
    private ArrayBlockingQueue<Integer> vertexDFS;

    // Keeps track of each vertex's parent during the DFS
    private HashMap<Integer, Integer> parents;

    // Each vertex has a discovery count and finish count
    // These two HashMaps keep track of the count for each.
    private HashMap<Integer, Integer> discovery;
    private HashMap<Integer, Integer> finish;

    // Keeps count of the searches in the DFS
    private int count;

    /**
     * Constructor for a directed graph.
     * @param G a directed graph
     * @param s the source vertex, i.e. the vertex to start the DFS with.
     */
    public GraphDFS(DirectedGraph G, int s) {
        //marked = new boolean[G.V()];
        marked = new HashMap<Integer, Boolean>();
        vertexDFS = new ArrayBlockingQueue<Integer>(G.V());
        parents = new HashMap<Integer, Integer>();
        discovery = new HashMap<Integer, Integer>();
        finish = new HashMap<Integer, Integer>();
        count = 1;

        parents.put(s, null);
        dfs(G, s);
    }

    /**
     * Constructor for an undirected graph.
     * @param G an undirected graph
     * @param s the source vertex, i.e. the vertex to start the DFS with.
     */
    public GraphDFS(UndirectedGraph G, int s) {
        //marked = new boolean[G.V()];
        marked = new HashMap<Integer, Boolean>();
        vertexDFS = new ArrayBlockingQueue<Integer>(G.V());
        parents = new HashMap<Integer, Integer>();
        discovery = new HashMap<Integer, Integer>();
        finish = new HashMap<Integer, Integer>();
        count = 1;

        parents.put(s, null);
        dfs(G, s);
    }

    /**
     * The recursive dfs method for directed graphs.
     * @param G a directed graph
     * @param v the starting vertex
     */
    private void dfs(DirectedGraph G, int v) {
        // Set the vertex as marked
        marked.put(v, true);
        // And set the discovery count for the current vertex
        // Then increment count
        discovery.put(v, count++);

        // Increment through the adjacency list for the current vertex v
        // For each vertex w in the adjacency list of v, check to see if it
        // is currently marked. If it isn't, set w's parent as v.
        // Then begin a new dfs for w.
        for (int w : G.adj(v)) {
            if (!marked.containsKey(w)) {
                parents.put(w , v);
                dfs(G, w);
            }
        }

        // Once v's adjacency list is exhausted (i.e., the dfs is done for v)
        // add v to vertexDFS. Additionally, put the current count for its finish.
        vertexDFS.add(v);
        finish.put(v, count++);
    }

    /**
     * The recursive dfs method for directed graphs.
     * @param G an undirected graph
     * @param v the starting vertex
     */
    private void dfs(UndirectedGraph G, int v) {
        // Set the vertex as marked
        marked.put(v, true);
        // And set the discovery count for the current vertex
        // Then increment count
        discovery.put(v, count++);

        // Increment through the adjacency list for the current vertex v
        // For each vertex w in the adjacency list of v, check to see if it
        // is currently marked. If it isn't, set w's parent as v.
        // Then begin a new dfs for w.
        for (int w : G.adj(v)) {
            if (!marked.containsKey(w)) {
                parents.put(w , v);
                dfs(G, w);
            }
        }

        // Once v's adjacency list is exhausted (i.e., the dfs is done for v)
        // add v to vertexDFS. Additionally, put the current count for its finish.
        vertexDFS.add(v);
        finish.put(v, count++);
    }

    /**
     * Returns true or false if the vertex is marked
     * @param v a vertex
     * @return boolean
     */
    public boolean marked(int v) {
        return marked.containsKey(v);
    }

    /**
     * Returns the dfs order for the graph
     * @return vertexDFS
     */
    public Iterable<Integer> dfsOrder() {
        return vertexDFS;
    }

    /**
     * Returns when the vertex was discovered
     * @param v a vertex
     * @return an int
     */
    public int discovery(int v) {
        return discovery.get(v);
    }

    /**
     * Returns when the dfs is done with the vertex
     * @param v a vertex
     * @return an int
     */
    public int finish(int v) {
        return finish.get(v);
    }

    /**
     * Returns the parent node/vertex of a vertex
     * @param v
     * @return an int
     */
    public int parentNode(int v) {
        if (parents.get(v) == null)
            return -1;
        else
            return parents.get(v);
    }
}
