import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class DirectedGraph {
    private final int V;
    private int E;
    //private ArrayList<Integer>[] adj;
    private HashMap<Integer, ArrayList<Integer>> adj;

    public DirectedGraph(int V) {
        this.V = V;
        this.E = 0;
        adj = new HashMap<Integer, ArrayList<Integer>>();
        //adj = (ArrayList<Integer>[]) new ArrayList[V];
        /*for (int v = 0; v < V; v++) {
            adj[v] = new ArrayList<Integer>();
        }*/
    }

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    public void addEdge(int v, int w) {
        if (adj.containsKey(v)) {
            ArrayList<Integer> temp = adj.get(v);
            temp.add(w);
            adj.put(v, temp);
        }
        else {
            ArrayList<Integer> temp = new ArrayList<Integer>();
            temp.add(w);
            adj.put(v, temp);
        }
        //adj[v].add(w);
        E++;
    }

    public Iterable<Integer> adj(int v) {
        if (adj.containsKey(v) && adj.get(v) != null) {
            return adj.get(v);
        }

        adj.put(v, new ArrayList<Integer>());
        return adj.get(v);
    }
}