package graphs;

import java.util.Scanner;

public class P10_HasPath {

	public static void main(String[] args) {
		 /* Let us create the following graph
		        2    3
		    (0)--(1)--(2)
		     |   / \   |
		    6| 8/   \5 |7
		     | /     \ |
		    (3)-------(4)
		          9          
		*/		
		int[][] g = {{0, 2, 0, 6, 0},
                {2, 0, 3, 8, 5},
                {0, 0, 0, 0, 0},
                {6, 8, 0, 0, 9},
                {0, 5, 7, 9, 0},
               	};
		Scanner inp = new Scanner(System.in);
		System.out.println("Enter source vertex");
		int src = inp.nextInt();
		System.out.println("Enter destination vertex");
		int dst = inp.nextInt();
		boolean ans = hasPath(g, src, dst);
		if(ans == true){
			System.out.println("There exists a path between src and destination");
		}
		else{
			System.out.println("No such path is there between src and destination");
		}
	}

	private static boolean hasPath(int[][] g, int src, int dst) {
		boolean[] visited = new boolean[g.length];
		return dfsUtil(g, src, dst, visited);
	}
	
	private static boolean dfsUtil(int[][] g, int vertex, int dst, boolean[] visited) {
		if(vertex == dst)
			return true;
		
		visited[vertex] = true;
		
		for(int i = 0; i < g.length; i++){
			//node not visited and there exists an edge
			if(visited[i] == false && g[vertex][i] != 0){
				return dfsUtil(g, i, dst, visited);
			}
		}
		return false;
	}

}
