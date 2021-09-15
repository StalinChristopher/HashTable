package com.yml.hashtable;

public class LinkedList <K> {
	INode<K> head;
	INode<K> tail;
	
	public LinkedList() {
		this.head = null;
		this.tail = null;	
	}
		
	public void append(INode<K> newNode) {
		if(this.head == null) {
			this.head = newNode;
		}
		if(this.tail == null) {
			this.tail = newNode;
		}
		else {
			this.tail.setNext(newNode);
			this.tail = newNode;

		}
	}
	
	public INode<K> search(K Key) {
		INode<K> tempNode = head;
		while(tempNode != null && tempNode.getNext() != null) {
			if (tempNode.getKey().equals(Key)){
				return tempNode;
			}
			tempNode = tempNode.getNext();
		}
		return null;
	}
	
	
	public String toString() {
		return "My Nodes: "+head;
	}
}
