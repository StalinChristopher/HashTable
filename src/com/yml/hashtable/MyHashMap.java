package com.yml.hashtable;

public class MyHashMap <K,V> {
	
	LinkedList<K> linkedList;
	
	MyHashMap(){
		this.linkedList = new LinkedList<K>();
	}
	
	public V get(K key) {
		MyMapNode<K,V> mapNode = (MyMapNode<K, V>) this.linkedList.search(key);
		return (mapNode == null) ? null :mapNode.getValue();
	}
	
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
