package graphs;

import java.util.ArrayDeque;
import java.util.Queue;

public class ShortestPath_Unweighted {
	
	public static AdjacencyListG4G g;
	
	public static void main(String[] args) {
		createGraph();
		System.out.println("Shortest distance calculated from vertex 0");
		unweightedShortestPath(0);
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
		g.addUndirEdge(5, 2);
        g.addUndirEdge(5, 0);
        g.addUndirEdge(4, 0);
        g.addUndirEdge(4, 1);
        g.addUndirEdge(2, 3);
        g.addUndirEdge(3, 1);
	}
}
