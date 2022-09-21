package com.practice.Practice.hashset;

public class MainClass {

	public static void main(String[] args) {
		//["MyHashSet","add","add","contains","contains"  ,"add","contains","remove","contains"]
		//[[],[1],[2] ,[1],[3]   ,[2],[2],[2],[2]]
		
		MyHashSet h = new MyHashSet();
		h.add(1);
		h.add(2);
		System.out.println(h.contains(1));
		System.out.println(h.contains(3));
		h.add(2);
		System.out.println(h.contains(2));
		
		h.remove(2);
		System.out.println(h.contains(2));
		
	}

}
