package com.yml.hashtable;

public class HashTableMain {

	public static void main(String[] args) {
		System.out.println("Welcome to hashTable program");
		String sentence = "Paranoids are not paranoid because they are paranoid but because they keep putting themselves "
				+ "deliberately into paranoid avoidable "
				+ "situations";
		MyLinkedListHashMap<String,Integer> myLinkedHashMap = new MyLinkedListHashMap<>();
		String[] words = sentence.toLowerCase().split(" ");
		for (String string : words) {
			Integer value = myLinkedHashMap.get(string);
			if(value == null) value = 1;
			else value = value + 1;
			myLinkedHashMap.add(string, value);
		}
		System.out.println(myLinkedHashMap);

	}

}
