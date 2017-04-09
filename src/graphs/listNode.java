package graphs;

public class listNode {
	private int data;
	private listNode next;
	
	public listNode(int data){
		this.data = data;
	}
	
	public void setData(int data){
		this.data= data;
	}
	
	public int getData(){
		return data;
	}
//	public int getData(listNode node){
//		return node.data;
//	}
	
	public void setNext(listNode next){
		this.next = next;
	}
	
	public listNode getNode(){
		return this.next;
	}
}
