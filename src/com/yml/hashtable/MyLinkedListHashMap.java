package com.yml.hashtable;
import java.util.*;

/**
 * @author Stalin Christopher
 *
 * @param <K>
 * @param <V>
 * This is a custom implementation of the linkedHashMap where an array list of type linkedList is present and key value 
 * pairs are added into the arrayList based on the bucketIndex and append the pair to the linkedList present in
 * that index
 */
public class MyLinkedListHashMap<K,V> {
	
	private final int numOfBuckets;
	ArrayList<LinkedList<K>> bucketArray;

	public MyLinkedListHashMap() {
		this.numOfBuckets = 10;
		this.bucketArray = new ArrayList<>(numOfBuckets);
		for(int i=0 ; i<numOfBuckets ; i++) {
			this.bucketArray.add(null);
		}
	}

	/**
	 * @param key
	 * @return
	 * This method calculates the hashCode and divides it by the no of buckets and returns a index for the arrayList
	 */
	private int getBucketIndex(K key) {
		int hashCode = Math.abs(key.hashCode());
		int index = hashCode % numOfBuckets;
		return index;
	}

	/**
	 * @param key
	 * @param value
	 * This method adds the key value pair into the arrayList by finding the index of the arrayList and then
	 * appending the pair into the linkedList present in that index
	 */
	public void add(K key, V value) {
		int index=this.getBucketIndex(key); 
		LinkedList<K> linkedList = this.bucketArray.get(index);

		if (linkedList == null){
			linkedList = new LinkedList<>();
			this.bucketArray.set(index, linkedList);
		}
		MyMapNode<K, V> mapNode = (MyMapNode<K,V>) linkedList.search(key);
		if (mapNode == null)
		{ 
			mapNode = new MyMapNode<>(key,value); 
			linkedList.append(mapNode);
		} else {
			mapNode.setValue(value);
		}
	}

	/**
	 * @param key
	 * @return
	 * This method returns the value of the given key if it is present in the LinkedHashMap
	 */
	public V get(K key) {
		int index = this.getBucketIndex(key);
		LinkedList<K> linkedList = this.bucketArray.get(index);
		if(linkedList == null)
			return null;
		MyMapNode<K,V> mapNode = (MyMapNode<K, V>) linkedList.search(key);
		return (mapNode == null) ? null: mapNode.getValue(); 
	}

	@Override
	public String toString() {
		return "MyLinkedHashMap List{"+bucketArray+"}";
	}

}
