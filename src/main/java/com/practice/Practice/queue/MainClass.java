package com.practice.Practice.queue;

import java.util.LinkedList;
import java.util.Queue;

public class MainClass {

	public static void main(String[] args) {

		System.out.println(findTheWinner(5, 2));

	}

	public static int findTheWinner(int n, int k) {
		Queue<Integer> q = new LinkedList<>();
		for (int i = 1; i <= n; i++)
			q.add(i);

		int tempCounter = 1;
		while (q.size() > 1) {
			if (tempCounter != k) {
				q.add(q.remove());
				tempCounter++;
			} else {
				q.remove();
				tempCounter = 1;
			}
		}
		return q.remove();
	}

}
