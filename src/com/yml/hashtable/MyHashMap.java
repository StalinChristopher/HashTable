package com.yml.hashtable;

/**
 * @author Stalin Christopher
 *
 * @param <K>
 * @param <V>
 * This class is a custom implementation of hashMap where a linkedList is present with nodes containing the key and value pairs
 */
public class MyHashMap <K,V> {
	
	LinkedList<K> linkedList;
	
	MyHashMap(){
		this.linkedList = new LinkedList<K>();
	}
	
	/**
	 * @param key
	 * @return
	 * This method searches for the key in the hashMap where it checks if the key is preset
	 * in the linkedList if not it returns null else it returns the respective value of the key
	 */
	public V get(K key) {
		MyMapNode<K,V> mapNode = (MyMapNode<K, V>) this.linkedList.search(key);
		return (mapNode == null) ? null :mapNode.getValue();
	}
	
	/**
	 * @param key
	 * @param value
	 * This method adds a key, value pair into the hashMap, it first searches for the key in the linkedList,
	 * if the key is present it appends the key value pair to the existing linkedList else it sets the value for the respective key
	 */
	public void add(K key, V value) {
		MyMapNode<K,V> mapNode = (MyMapNode<K, V>) this.linkedList.search(key);
		if(mapNode == null) {
			mapNode = new MyMapNode<>(key,value);
			this.linkedList.append(mapNode);
		}else {
			mapNode.setValue(value);
		}
	}

	@Override
	public String toString() {
		return "MyHashMap {" + linkedList.toString() + "}";
	}
}
