package hashing;

import java.util.ArrayList;

//Class to represent entire hash table
public class Map<K,V> {
	
	// bucketArray is used to store array of chains
	ArrayList<HashNode<K, V>> bucket = new ArrayList<>();
	
	// Current capacity of array list
	int numBuckets = 10;
	
	// Current elements in array list
	int size = 0;
	
	// Constructor
	public Map()
	{
		for(int i=0;i<numBuckets;i++)
		{
			bucket.add(null);
		}
	}
	
	
	public int getSize()
	{
		return size;
	}
	
	public boolean isEmpty()
	{
		return size==0;
	}
	
	// This implements hash function to find index for key
	private int getBucketIndex(K key)
	{
		int hashCode = key.hashCode();
		return hashCode % numBuckets;
	}
	
	// Returns value for a key
	public V get(K key)
	{
		//which bucket will it get assigned to after going through hash function
		int index = getBucketIndex(key);
		//get the node present at above index
		HashNode<K, V> head = bucket.get(index);
		while(head!=null)
		{
			if(head.key.equals(key))
			{
				return head.value;
			}
			head=head.next;
		}
		return null;	
	}
	
	
	public V remove(K key)
	{
		int index = getBucketIndex(key);
		HashNode<K, V> head = bucket.get(index);
		if(head==null)
		{
			return null;
		}
		if(head.key.equals(key))
		{
			V val=head.value;
			head=head.next;
			bucket.set(index, head);
			size--;
			return val;
		}
		else
		{
			HashNode<K, V>prev=null;
			while(head!=null)
			{
				
				if(head.key.equals(key))
				{
					prev.next=head.next;
					size--;
					return head.value;
				}
				prev=head;
				head=head.next;
			}
			size--;
			return null;
		}
	}
	
	
	public void add(K key,V value)
	{
		int index = getBucketIndex(key);
		System.out.println(index);
		HashNode<K, V>head=bucket.get(index);
		
		//create new node and update its properties
		HashNode<K, V>toAdd=new HashNode<>();
		toAdd.key=key;
		toAdd.value=value;
		
		if(head==null)
		{
			bucket.set(index, toAdd);
			size++;
		}
		else
		{
			while(head!=null)
			{
				//head exists and key is same then update the value and BREAK
				if(head.key.equals(key))
				{
					head.value=value;
					//BUG
					//size++;
					break;
				}
				//traverse till the last node
				head=head.next;
			}
			
			if(head==null)
			{
				head = bucket.get(index);
				toAdd.next = head;
				bucket.set(index, toAdd);
				size++;
			}
		}
		if((1.0*size)/numBuckets>0.7)
		{
			//do something
			ArrayList<HashNode<K, V>> tmp = bucket;
			
			bucket = new ArrayList<>();
			numBuckets = 2*numBuckets;
			for(int i=0;i<numBuckets;i++)
			{
				bucket.add(null);
			}
			
			for(HashNode<K, V> headNode:tmp)
			{
				//traverse along every node till you reach the end
				while(headNode!=null)
				{
					add(headNode.key, headNode.value);
					headNode=headNode.next;
				}
			}
			
			
		}
		
	}
	
	
	public static void main(String[] args)
	{
		Map<String,Integer> map = new Map<>();
		map.add("this",1 );
		map.add("this",2 );
		System.out.println(map.remove("this"));
		System.out.println(map.remove("this"));
		
	}

}