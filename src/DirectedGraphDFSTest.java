/**
 * This is a driver/test program for testing both the UndirectedGraph, DirectedGraph
 * and GraphDFS implementations. Both a directed graph and undirected graph are created,
 * edges are added to each and a depth first search is performed on each.
 */
public class DirectedGraphDFSTest {
    public static void main(String[] args) {
        // Two arrays whose elements will become vertices in graphs.
        final int[] testOne = {1, 2, 3, 4, 5, 6, 7};
        final int[] testTwo = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        // Initialize the directed graph
        DirectedGraph testCaseOneGraph = new DirectedGraph(testOne.length);
        // Add edges between the vertices.
        testCaseOneGraph.addEdge(1, 2);
        testCaseOneGraph.addEdge(1, 6);
        testCaseOneGraph.addEdge(2, 3);
        testCaseOneGraph.addEdge(2, 4);
        testCaseOneGraph.addEdge(2, 5);
        testCaseOneGraph.addEdge(3, 5);
        testCaseOneGraph.addEdge(4, 5);
        testCaseOneGraph.addEdge(5, 1);
        testCaseOneGraph.addEdge(6, 4);
        testCaseOneGraph.addEdge(6, 7);
        // Perform a depth first search on the graph
        GraphDFS testCaseOneDFS = new GraphDFS(testCaseOneGraph, testOne[0]);

        System.out.println("Graph One:");
        // Traverse the depth first search order of the graph
        for (int v : testCaseOneDFS.directedOrder()) {
            // Output the parent vertex of the current vertex v
            int parent = testCaseOneDFS.parentNode(v);
            // Output the order in which the vertex was discovered
            int discovery = testCaseOneDFS.discovery(v);
            // Output the order in which the vertex was finished
            int finish = testCaseOneDFS.finish(v);

            // If the vertex does not have a parent in the depth first search order
            if (parent == -1)
                System.out.println("Vertex: " + v + " Parent: No parent" +
                                    " Discovery: " + discovery + " Finish: " + finish);
            else
                System.out.println("Vertex: " + v + " Parent: " + parent +
                                    " Discovery: " + discovery + " Finish: " + finish);
        }
        System.out.println();

        // Initialize the undirected graph
        UndirectedGraph testCaseTwoGraph = new UndirectedGraph(testTwo.length);
        // Add edges between the vertices
        testCaseTwoGraph.addEdge(1, 2);
        testCaseTwoGraph.addEdge(1, 3);
        testCaseTwoGraph.addEdge(1, 6);
        testCaseTwoGraph.addEdge(1, 7);
        testCaseTwoGraph.addEdge(6, 4);
        testCaseTwoGraph.addEdge(6, 5);
        testCaseTwoGraph.addEdge(7, 5);
        testCaseTwoGraph.addEdge(7, 9);
        testCaseTwoGraph.addEdge(5, 4);
        testCaseTwoGraph.addEdge(5, 8);
        testCaseTwoGraph.addEdge(8, 9);
        testCaseTwoGraph.addEdge(9, 10);

        // Perform a depth first search on the graph
        GraphDFS testCaseTwoDFS = new GraphDFS(testCaseTwoGraph, testTwo[0]);
        System.out.println("Graph Two:");
        // Traverse the depth first search order of the graph
        for (int v : testCaseTwoDFS.directedOrder()) {
            // Output the parent vertex of the current vertex v
            int parent = testCaseTwoDFS.parentNode(v);
            // Output the order in which the vertex was discovered
            int discovery = testCaseTwoDFS.discovery(v);
            // Output the order in which the vertex was finished
            int finish = testCaseTwoDFS.finish(v);

            // If the vertex does not have a parent in the depth first search order
            if (parent == -1)
                System.out.println("Vertex: " + v + " Parent: No parent" +
                        " Discovery: " + discovery + " Finish: " + finish);
            else
                System.out.println("Vertex: " + v + " Parent: " + parent +
                        " Discovery: " + discovery + " Finish: " + finish);
        }
        System.out.println();
    }
}
