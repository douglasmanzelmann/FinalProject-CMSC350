/**
 * Created by douga_000 on 12/13/2014.
 */
public class DirectedGraphDFSTest {
    public static void main(String[] args) {
        final int[] testOne = {1, 2, 3, 4, 5, 6, 7};
        final int[] testTwo = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        DirectedGraph testCaseOneGraph = new DirectedGraph(testOne.length+1);
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
        GraphDFS testCaseOneDFS = new GraphDFS(testCaseOneGraph, testOne[0]);

        System.out.println("Graph One:");
        for (int v : testCaseOneDFS.directedOrder()) {
            int parent = testCaseOneDFS.parentNode(v);
            int discovery = testCaseOneDFS.discovery(v);
            int finish = testCaseOneDFS.finish(v);

            if (parent == -1)
                System.out.println("Vertex: " + v + " Parent: No parent" +
                                    " Discovery: " + discovery + " Finish: " + finish);
            else
                System.out.println("Vertex: " + v + " Parent: " + parent +
                                    " Discovery: " + discovery + " Finish: " + finish);
        }
        System.out.println();

        UndirectedGraph testCaseTwoGraph = new UndirectedGraph(testTwo.length+1);
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

        GraphDFS testCaseTwoDFS = new GraphDFS(testCaseTwoGraph, testTwo[0]);
        System.out.println("Graph Two:");
        for (int v : testCaseTwoDFS.directedOrder()) {
            int parent = testCaseTwoDFS.parentNode(v);
            int discovery = testCaseTwoDFS.discovery(v);
            int finish = testCaseTwoDFS.finish(v);

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
