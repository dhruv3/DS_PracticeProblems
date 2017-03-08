package BinaryHeap;

public class AdvancedBinaryHeap {

	public int[] array;    
	public int count;		//total elements in heap 
	public int capacity;	//size of heap
	public int heap_type;	//min or max heap
	
	//creating heap
	public AdvancedBinaryHeap(int capacity, int heap_type){
		this.capacity = capacity;
		this.heap_type = heap_type;
		this.count = 0;
		this.array = new int[capacity];
	}
	
	//parent node
	public int Parent(int childIdx){
		if(childIdx <= 0 || childIdx >= this.count)
			return -1;
		
		return (childIdx-1)/2;
	}
	
	//children of a node
	//left child idx is returned
	public int LeftChild(int parentIdx){
		int leftChildIdx = 2*parentIdx + 1;
		if(leftChildIdx >= this.count)
			return -1;
		return leftChildIdx;
	}
	
	//right child idx is returned
	public int RightChild(int parentIdx){
		int rightChildIdx = 2*parentIdx + 2;
		if(rightChildIdx >= this.count)
			return -1;
		return rightChildIdx;
	}
	
	//getting the max element
	//add for heap_type functionality
	public int GetMaxElement(){
		if(this.count == 0)
			return -1;
		return this.array[0];
	}
	
	//heapifying an element
	public void PercolateDown(int i){
		int max;
		int leftChildIdx = LeftChild(i);
		int rightChildIdx = RightChild(i);
		if((leftChildIdx != -1 && rightChildIdx == -1) || (leftChildIdx != -1 && array[leftChildIdx] > array[rightChildIdx])){
			max = leftChildIdx;
		}
		else if(rightChildIdx != -1 && array[leftChildIdx] < array[rightChildIdx]){
			max = rightChildIdx;
		}
		else{
			max = i;
			//randomly added to end recursions..=
			return;
		}
		
		if(array[i] < array[max]){
			int temp = array[max];
			array[max] = array[i];
			array[i] = temp;
		}
		PercolateDown(max);
	}
	
	//get the heap element 
	public int DeleteMax(){
		int tempRoot = array[0];
		array[0] = array[this.count - 1];
		this.count--; //size needs to be reduced before we percolate down
		PercolateDown(0);
		return tempRoot;
	}
	
	public void Insert(int data){
		if(this.count == this.capacity)
			ResizeHeap();
		
		this.count++;
		int i = this.count - 1;
		this.array[i] = data;
		int temp;
		while(i >= 0 && this.array[i] > this.array[(i-1)/2]){
			temp = this.array[i];
			this.array[i] = this.array[(i-1)/2];
			this.array[(i-1)/2] = temp;
			i = (i-1)/2;
		}
	}

	private void ResizeHeap() {
		int[] array_old = new int[this.capacity];
		System.arraycopy(this.array, 0, array_old, 0, this.capacity);
		this.array = new int[this.capacity*2];
		for(int i = 0; i < this.capacity; i++)
			this.array[i] = array_old[i];
		this.capacity = this.capacity*2;
		array_old = null;
	}
	
	//destroying heap
	public void DestroyHeap(){
		this.count = 0;
		this.array = null;
	}
	
	//get string output of array
	public String getString(){
		String out = "";
		for(int i = 0; i < this.count; i++){
			out = out + " " + array[i] ;
		}
		return out;
	}
	
	//heapify the array
	public void BuildHeap(AdvancedBinaryHeap h, int[] inpArr, int n){
		while(n > this.capacity)
			h.ResizeHeap();
		//add elements to heap array
		for(int i = 0; i < n; i++){
			h.array[i] = inpArr[i];
		}
		this.count = n;
		//no need to check for leafs
		//start from 1st non leaf node
		//this node is parent parent of last leaf
		for(int i = (n-1)/2; i >= 0; i--){
			h.PercolateDown(i);
		}
	}

	//P11
	public void printAnswer(int i, int k) {
		if(i >= this.count)
			return;
		
		if(array[i] < k)
			System.out.println(array[i] + " ");
		
		int leftChildIdx = LeftChild(i);
		if(leftChildIdx != -1)
			printAnswer(leftChildIdx, k);
		
		int rightChildIdx = RightChild(i);
		if(rightChildIdx != -1)
			printAnswer(rightChildIdx, k);
	}
}
