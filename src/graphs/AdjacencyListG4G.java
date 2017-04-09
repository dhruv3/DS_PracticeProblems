package graphs;

//tutorial: http://www.geeksforgeeks.org/depth-first-traversal-for-a-graph/
public class AdjacencyListG4G {
	//array of linked lists
	private LinkedList adj[];
	//total vertices
	private int vertexCount = 0;
	
	public AdjacencyListG4G(int vertexCount){
		this.vertexCount = vertexCount;
		adj = new LinkedList[vertexCount];
		for(int i = 0; i < this.vertexCount; i++){
			adj[i] = new LinkedList();
		}
	}
	
	//directed graph
	public void addEdge(int src, int dst){
		adj[src].insertAtStart(new listNode(dst));
	}
	
	public int vertexCount(){
		return vertexCount;
	}
	
	public LinkedList getList(int v){
		return adj[v];
	}
}
