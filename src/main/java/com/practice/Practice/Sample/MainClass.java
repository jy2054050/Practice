package com.practice.Practice.Sample;

import java.util.Arrays;

public class MainClass {

	public static void main(String[] args) {
		int[][] queries = new int[][] { { 2, 3, 1 }, { 4, 3, 1 }, { 1, 1, 2 } };
		int[][] points = new int[][] { { 1, 3 }, { 3, 3 }, { 5, 3 }, { 2, 2 } };

		System.out.println(Arrays.toString(countPoints(points, queries)));

	}

	public static int[] countPoints(int[][] points, int[][] queries) {
		int[] result = new int[queries.length];

		for (int i = 0; i < queries.length; i++) {
			int[] query = queries[i];
			result[i] = findPointInCircle(points, query);
		}
		return result;
	}

	private static int findPointInCircle(int[][] points, int[] query) {
		int count = 0;
		for (int i = 0; i < points.length; i++) {
			int[] point = points[i];
			double distance = Math.sqrt(Math.pow((query[0] - point[0]), 2) + Math.pow((query[1] - point[1]), 2));
			if (distance <= query[2])
				count++;
		}
		return count;
	}

}
