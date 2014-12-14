import java.util.HashMap;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * Created by douga_000 on 12/13/2014.
 */
public class GraphDFS {
    //private boolean[] marked;
    private HashMap<Integer, Boolean> marked;
    private ArrayBlockingQueue<Integer> vertexDFS;
    private int[] edgeTo;
    private int count;
    private HashMap<Integer, Integer> parents;
    private HashMap<Integer, Integer> discovery;
    private HashMap<Integer, Integer> finish;

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



    private void dfs(DirectedGraph G, int v) {
        //marked[v] = true;
        marked.put(v, true);
        discovery.put(v, count++);

        for (int w : G.adj(v)) {
            if (!marked.containsKey(w)) { //!marked[w]
                parents.put(w , v);
                dfs(G, w);
            }
        }
        vertexDFS.add(v);
        finish.put(v, count++);
    }

    private void dfs(UndirectedGraph G, int v) {
        //marked[v] = true;
        marked.put(v, true);
        discovery.put(v, count++);

        for (int w : G.adj(v)) {
            if (!marked.containsKey(w)) {
                parents.put(w , v);
                dfs(G, w);
            }
        }
        vertexDFS.add(v);
        finish.put(v, count++);
    }

    public boolean marked(int v) {
        //return marked[v];
        return marked.containsKey(v);
    }

    public Iterable<Integer> directedOrder() {
        return vertexDFS;
    }

    public int discovery(int v) {
        return discovery.get(v);
    }

    public int finish(int v) {
        return finish.get(v);
    }

    public int parentNode(int v) {
        if (parents.get(v) == null)
            return -1;
        else
            return parents.get(v);
    }
}
