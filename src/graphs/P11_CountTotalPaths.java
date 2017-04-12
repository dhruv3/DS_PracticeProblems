package graphs;

import java.util.Scanner;
import java.util.Stack;

//tutorial: http://www.geeksforgeeks.org/find-paths-given-source-destination/
public class P11_CountTotalPaths {

	public static int totalPath = 0;
	
	public static void main(String[] args) {	
		int[][] g = {
				{0, 1, 1, 1},
                {0, 0, 0, 1},
                {1, 1, 0, 0},
                {0, 0, 0, 0}
               	};
		Scanner inp = new Scanner(System.in);
		System.out.println("Enter source vertex");
		int src = inp.nextInt();
		System.out.println("Enter destination vertex");
		int dst = inp.nextInt();
		System.out.println("Printing all possible paths:");
		hasPath(g, src, dst);
		System.out.println("Total number of paths between " + src + " and " + dst + " : " + totalPath);
	}

	private static void hasPath(int[][] g, int src, int dst) {
		boolean[] visited = new boolean[g.length];
		//stack to store paths
		Stack<Integer> st = new Stack<Integer>();
		dfsUtil(g, src, dst, visited, st);
	}
	
	//performs dfs but while backtracking we update visited array intelligently
	private static void dfsUtil(int[][] g, int vertex, int dst, boolean[] visited, Stack<Integer> st) {
		visited[vertex] = true;
		st.push(vertex);
		
		if(vertex == dst){
			totalPath++;
			printPath(st);
		}
		else{
			for(int i = 0; i < g.length; i++){
				if(visited[i] == false && g[vertex][i] != 0){
					dfsUtil(g, i, dst, visited, st);
				}
			}
		}
		
		visited[vertex] = false;
		if(!st.isEmpty())
			st.pop();
	}
	//Stack is derived from Vector
	//this allows us to print its content using index
	private static void printPath(Stack<Integer> st) {
		for(int  i = 0; i <st.size(); i++){
			System.out.print(st.elementAt(i) + "\t");
		}
		System.out.print("\n");
	}

}
