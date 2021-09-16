package com.yml.hashtable;
import java.util.*;

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

	private int getBucketIndex(K key) {
		int hashCode = Math.abs(key.hashCode());
		int index = hashCode % numOfBuckets;
		return index;
	}

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
	
	public void remove(K key) {
		int index = this.getBucketIndex(key);
		LinkedList<K> linkedList = this.bucketArray.get(index);
		if(linkedList == null) {
			System.out.println("Element is not found");
			return;
		}
		else {
			MyMapNode<K, V> mapNode = (MyMapNode<K,V>) linkedList.search(key);
			if(mapNode == null) {
				System.out.println("key not present in linkedList");
			}
			else {
				linkedList.remove(mapNode);
				System.out.println(key+" is removed from the linkedHashMap");
				return;
			}
			
		}
	}

	public V get(K key) {
		int index = this.getBucketIndex(key);
		LinkedList<K> linkedList = this.bucketArray.get(index);
		if(linkedList == null)
			return null;
		MyMapNode<K,V> mapNode = (MyMapNode<K, V>) linkedList.search(key);
		return (mapNode == null) ? null : mapNode.getValue(); 
	}

	public void printBucketArray(){
		System.out.println("My linkedHashMap:\n");
		for(LinkedList<K> item : bucketArray){
			if(item == null){
				continue;
			}
			System.out.println(item.toString());
			System.out.println();
		}
	}


}
