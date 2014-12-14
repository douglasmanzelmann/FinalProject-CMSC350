import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by douga_000 on 12/14/2014.
 */
public class UndirectedGraph {
    private final int V;
    private int E;
    private HashMap<Integer, ArrayList<Integer>> adj;

    public UndirectedGraph(int V) {
        this.V = V;
        this.E = 0;
        adj = new HashMap<Integer, ArrayList<Integer>>();
    }

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    public void addEdge(int v, int w) {
        if (adj.containsKey(v)) {
            adj.get(v).add(w);
        }
        else {
            ArrayList<Integer> temp = new ArrayList<Integer>();
            temp.add(w);
            adj.put(v, temp);
        }

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

    public Iterable<Integer> adj(int v) {
        if (adj.containsKey(v) && adj.get(v) != null) {
            return adj.get(v);
        }

        adj.put(v, new ArrayList<Integer>());
        return adj.get(v);
    }
}
