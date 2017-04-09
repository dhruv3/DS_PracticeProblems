package graphs;

public class listNode {
	private int data;
	private listNode next;
	private int weight = 1;
	
	public listNode(int data){
		this.data = data;
	}
	
	public void setData(int data){
		this.data= data;
	}
	
	public int getData(){
		return data;
	}
	
	public void setNext(listNode next){
		this.next = next;
	}
	
	public listNode getNode(){
		return this.next;
	}
	
	public void setWeight(int weight){
		this.weight = weight;
	}
	
	public int getWeight(){
		return weight;
	}
}
