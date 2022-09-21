package com.practice.Practice.hashset;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class MyHashSet {

	HashMap<Integer, Boolean> hm;
	List<Integer> list;

	public MyHashSet() {
		hm = new HashMap<>();
		list = new LinkedList<>();
	}

	public void add(int key) {
		if(hm.containsKey(Integer.valueOf(key))){
			//
		}else {
			hm.put(Integer.valueOf(key), true);
			list.add(Integer.valueOf(key));
		}
	}

	public void remove(int key) {
		if(hm.containsKey(Integer.valueOf(key))){
			list.remove(Integer.valueOf(key));
			hm.remove(Integer.valueOf(key));	
		}
	}

	public boolean contains(int key) {
		return hm.containsKey(Integer.valueOf(key));

	}
}
