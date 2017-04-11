package graphs;
//tutorial: http://www.geeksforgeeks.org/greedy-algorithms-set-6-dijkstras-shortest-path-algorithm/
//implemented without using heaps
public class PrimMST {
	
	public static AdjacencyListG4G g;
	
	public static void main(String[] args) {
		createGraph();
		System.out.println("Shortest distance calculated from vertex 0");
		dijkstra(0);
	}
	
	private static void dijkstra(int startVertex) {
		int totalVertex = g.vertexCount();
		boolean[] sptSet = new boolean[totalVertex];
		//array to hold distances
		int[] dist = new int[totalVertex];
		//initialize array
		for(int i = 0; i < dist.length; i++){
			dist[i] = Integer.MAX_VALUE;
		}
		
		dist[startVertex] = 0;
		//looping till totalVertex-1
		for(int idx = 0; idx < totalVertex-1; idx++){
			//select a vertex
			int selVtx = minDist(dist, sptSet);
			sptSet[selVtx] = true;
			//update neighboring vertices
			LinkedList ll = g.getList(selVtx);
			listNode temp = ll.getHead();
			while(temp != null){
				int v = temp.getData();
				//neighbor not yet visited and distance is larger
				if(sptSet[v] == false && (dist[v] > dist[selVtx] + temp.getWeight())){
					dist[v] = dist[selVtx] + temp.getWeight();
				}
				temp = temp.getNode();
			}
		}
		//print results
		printDist(dist);
	}
	
	//get vertex with min dist value and that vertex is not yet in shortest path set
	private static int minDist(int[] dist, boolean[] sptSet) {
		int min = Integer.MAX_VALUE;
		int v = -1;
		for(int  i = 0; i < sptSet.length; i++){
			if(sptSet[i] == false && dist[i] < min){
				min = dist[i];
				v = i;
			}
		}
		return v;
	}

	private static void printDist(int[] dist) {
		System.out.println("Vertex" + "\t" + "Distance");
		for(int i = 0; i < dist.length; i++){
			System.out.print("  " + i + "  " + "\t" + "   " +  dist[i] + "  " + "\n");
		}
	}

	private static void createGraph() {
		g = new AdjacencyListG4G(9);
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
