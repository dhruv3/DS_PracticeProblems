package graphs;

import java.util.Hashtable;
import java.util.Set;

//tutorial: http://www.geeksforgeeks.org/dynamic-programming-set-23-bellman-ford-algorithm/
public class BellmanFord {

	public static AdjacencyListG4G g;
	//new data structure added so as to store edges
	static Hashtable<String, Integer> edgeTable;
	
	public static void main(String[] args) {
		createGraph();
		System.out.println("Shortest distance calculated from vertex 0");
		bellmanFord(0);
	}
	
	private static void bellmanFord(int startVertex) {
		int totalVertex = g.vertexCount();
		//array to hold distances
		int[] dist = new int[totalVertex];
		//initialize array
		for(int i = 0; i < dist.length; i++){
			dist[i] = Integer.MAX_VALUE;
		}
		
		dist[startVertex] = 0;
		//http://www.java2novice.com/java-collections-and-util/hashtable/all-keys/
		Set<String> keys = edgeTable.keySet();
		for(int  i = 1; i < totalVertex; i++){
			for(String key : keys){
				int src = Integer.parseInt(key.split(",")[0]);
				int dst = Integer.parseInt(key.split(",")[1]);
				int weight = edgeTable.get(key);
				//src has been set and dist condition is checked
				if(dist[src] != Integer.MAX_VALUE && (dist[dst] > dist[src]+weight)){
					dist[dst] = dist[src] + weight;
				}
			}
		}
		//print output
		printDist(dist);
	}

	private static void printDist(int[] dist) {
		System.out.println("Vertex" + "\t" + "Distance");
		for(int i = 0; i < dist.length; i++){
			System.out.print("  " + i + "  " + "\t" + "   " +  dist[i] + "  " + "\n");
		}
	}
	
	private static void createGraph() {
		edgeTable  = new Hashtable<String, Integer>();
		g = new AdjacencyListG4G(5);
		g.addEdge(0, 1, -1);
		edgeTable.put("0,1", -1);
        g.addEdge(0, 2, 4);
        edgeTable.put("0,2", 4);
        g.addEdge(1, 2, 3);
        edgeTable.put("1,2", 3);
        g.addEdge(1, 3, 2);
        edgeTable.put("1,3", 2);
        g.addEdge(1, 4, 2);
        edgeTable.put("1,4", 2);
        g.addEdge(3, 2, 5);
        edgeTable.put("3,2", 5);
        g.addEdge(3, 1, 1);
        edgeTable.put("3,1", 1);
        g.addEdge(4, 3, -3);
        edgeTable.put("4,3", -3);
	}
}
