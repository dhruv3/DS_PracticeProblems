package hashing;

//A node of chains
public class HashNode<K,V> {
	K key;
	V value;
	
	// Reference to next node
	HashNode<K, V> next;
	
	// Constructor
	public HashNode()
	{
		this.key=key;
		this.value=value;
	}
}
