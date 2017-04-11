package graphs;

//tutorial: http://www.geeksforgeeks.org/greedy-algorithms-set-5-prims-minimum-spanning-tree-mst-2/
public class PrimMST {
	
	public static AdjacencyListG4G g;
	
	public static void main(String[] args) {
		createGraph();
		System.out.println("MST of the given graph using Prim's Algorithm");
		prim(0);
	}
	
	private static void prim(int startVertex) {
		int totalVertex = g.vertexCount();
		
		int[] parent = new int[totalVertex];
		boolean[] mstSet = new boolean[totalVertex];
		//array to hold distances
		int[] dist = new int[totalVertex];
		//initialize array
		for(int i = 0; i < dist.length; i++){
			dist[i] = Integer.MAX_VALUE;
		}
		
		dist[startVertex] = 0;
		parent[0] = -1;
		//looping till totalVertex-1
		for(int idx = 0; idx < totalVertex-1; idx++){
			//select a vertex
			int selVtx = minDist(dist, mstSet);
			mstSet[selVtx] = true;
			//update neighboring vertices
			LinkedList ll = g.getList(selVtx);
			listNode temp = ll.getHead();
			while(temp != null){
				int v = temp.getData();
				//neighbor not yet visited and distance is larger
				if(mstSet[v] == false && (dist[v] > dist[selVtx] + temp.getWeight())){
					parent[v] = selVtx;
					dist[v] = dist[selVtx] + temp.getWeight();
				}
				temp = temp.getNode();
			}
		}
		//print results
		printDist(parent);
	}
	
	//get vertex with min dist value and that vertex is not yet in minimum set
	private static int minDist(int[] dist, boolean[] mstSet) {
		int min = Integer.MAX_VALUE;
		int v = -1;
		for(int  i = 0; i < mstSet.length; i++){
			if(mstSet[i] == false && dist[i] < min){
				min = dist[i];
				v = i;
			}
		}
		return v;
	}

	private static void printDist(int[] parent) {
		for(int i = 1; i < parent.length; i++){
			System.out.print("  " + i + "  " + "\t" + "   " +  parent[i] + "  " + "\n");
		}
	}

	private static void createGraph() {
		g = new AdjacencyListG4G(5);
		g.addUndirEdge(0, 1, 2);
        g.addUndirEdge(0, 3, 6);
        g.addUndirEdge(1, 3, 8);
        g.addUndirEdge(1, 2, 3);
        g.addUndirEdge(1, 4, 5);
        g.addUndirEdge(2, 4, 7);
        g.addUndirEdge(3, 4, 9);
	}
}
