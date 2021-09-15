package com.yml.hashtable;

public class HashTableMain {

	public static void main(String[] args) {
		System.out.println("Welcome to hashTable program");
		String sentence = "To be or not to be";
		MyHashMap<String,Integer> myHashMap = new MyHashMap<>();
		String[] words = sentence.toLowerCase().split(" ");
		for (String string : words) {
			Integer value = myHashMap.get(string);
			if(value == null) value = 1;
			else value = value + 1;
			myHashMap.add(string, value);
		}
		System.out.println(myHashMap);

	}

}
