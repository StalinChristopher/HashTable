package com.yml.hashtable;

public class LinkedList <K> {
	INode<K> head;
	INode<K> tail;
	
	public LinkedList() {
		this.head = null;
		this.tail = null;	
	}
		
	/**
	 * @param newNode
	 * in this method a new node is appended into the linkedList
	 */
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
	
	/**
	 * @param Key
	 * @return
	 * In this method a given key is searched in the linked list, if it is present it returns the node else returns null 
	 */
	public INode<K> search(K Key) {
		INode<K> tempNode = head;
		while(tempNode != null) {
			if (tempNode.getKey().equals(Key)){
				return tempNode;
			}
			tempNode = tempNode.getNext();
		}
		return null;
	}
	
	public boolean remove(INode<K> node) {
		INode<K> tempNode = head;
		INode<K> prev = null;
		boolean isFound = false;
		if(tempNode != null && tempNode.getKey() == node.getKey()) {
			head = tempNode.getNext();
			return true;
			
		}
		while(tempNode != null) {
			if(tempNode.getKey().equals(node.getKey())) {
				isFound = true;
				break;
			}
			prev = tempNode;
			tempNode = tempNode.getNext();
		}
		if(isFound) {
			prev.setNext(tempNode.getNext());
			System.out.println("Element deleted from the linkedList");
			return isFound;
		}
		else {
			System.out.println("Not found");
			return isFound;
		}
	}
	
	
	/**
	 *This is a toString method to prints the nodes of the linkedList
	 */
	public String toString() {
		return "My Nodes: "+head;
	}
}
