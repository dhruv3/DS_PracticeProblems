package graphs;

import java.util.Stack;
//tutorial: http://www.geeksforgeeks.org/topological-sorting/
public class TopologicalSort {
	
	public static AdjacencyListG4G g;
	
	public static void main(String[] args) {
		createGraph();
		System.out.println("Topological Sort of the given graph:");
		topologicalSort();
	}
	
	private static void topologicalSort() {
		Stack<Integer> st = new Stack<Integer>();
		int totalVertex = g.vertexCount();
		boolean visited[] = new boolean[totalVertex];
		//loop to ensure everything is visited
		for(int i = 0; i < totalVertex; i++){
			if(visited[i] == false)
				tpsUtil(i, visited, st);
		}
		//printing out topologically sorted vertices
		while(!st.isEmpty()){
			System.out.print(st.pop() + "\t");
		}
	}

	private static void tpsUtil(int i, boolean[] visited, Stack<Integer> st) {
		visited[i] = true;
		//get the LL corresponding to our vertex
		//get the head and travel the LL
		LinkedList ll = g.getList(i);
		listNode temp = ll.getHead();
		//call tpsUtil for unvisited neighboring vertices
		while(temp != null){
			if(visited[temp.getData()] == false)
				tpsUtil(temp.getData(), visited, st);
			temp = temp.getNode();
		}
		st.push(i);
	}

	private static void createGraph() {
		g = new AdjacencyListG4G(6);
		g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);
	}
}
