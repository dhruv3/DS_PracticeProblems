package graphs;

import java.util.ArrayDeque;
import java.util.Queue;

public class Dijkstra_WeightedShortestPath {
	
	public static AdjacencyListG4G g;
	
	public static void main(String[] args) {
		createGraph();
		System.out.println("Shortest distance calculated from vertex 0");
		dijkstra(0);
	}
	
	private static void dijkstra(int startVertex) {
		//array to hold distances
		int[] dist = new int[g.vertexCount()];
		for(int i = 0; i < dist.length; i++){
			dist[i] = -1;
		}
	}

	private static void unweightedShortestPath(int startVertex) {
		Queue<Integer> q = new ArrayDeque<Integer>();
		q.add(startVertex);
		
		//array to hold distances
		int[] dist = new int[g.vertexCount()];
		for(int i = 0; i < dist.length; i++){
			dist[i] = -1;
		}
		
		//dist to self is set to ZERO
		dist[startVertex] = 0;
		while(!q.isEmpty()){
			int v = q.poll();
			//get the LL corresponding to our vertex
			//get the head and travel the LL
			LinkedList ll = g.getList(v);
			listNode temp = ll.getHead();
			while(temp != null){
				//if uninitialized then update the distance
				//and add to queue so as to explore its neighbors
				if(dist[temp.getData()] == -1){
					dist[temp.getData()] = dist[v] + 1;
					q.add(temp.getData());
				}
				temp = temp.getNode();
			}
		}
		//output distances
		printDist(dist);
	}

	private static void printDist(int[] dist) {
		System.out.println("Vertex" + "\t" + "Distance");
		for(int i = 0; i < dist.length; i++){
			System.out.print("  " + i + "  " + "\t" + "   " +  dist[i] + "  " + "\n");
		}
	}

	private static void createGraph() {
		g = new AdjacencyListG4G(6);
		g.addUndirEdge(0, 1, 4);
        g.addUndirEdge(0, 7, 8);
        g.addUndirEdge(1, 2, 8);
        g.addUndirEdge(1, 7, 11);
        g.addUndirEdge(2, 3, 7);
        g.addUndirEdge(2, 8, 2);
        g.addUndirEdge(2, 5, 4);
        g.addUndirEdge(3, 4, 9);
        g.addUndirEdge(3, 5, 14);
        g.addUndirEdge(4, 5, 10);
        g.addUndirEdge(5, 6, 2);
        g.addUndirEdge(6, 8, 6);
        g.addUndirEdge(6, 7, 1);
        g.addUndirEdge(7, 8, 7);
	}
}
