package com.practice.Practice.binarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainClass {

	public static void main(String[] args) {
		int[] nums = new int[] { 1, 2, 5, 2, 3 };

		targetIndices(nums, 2).stream().forEach(i -> System.out.println(i));
	}

	public static int peakIndexInMountainArray(int[] arr) {
		int resultInd = -1;
		int n = arr.length;
		int start = 0;
		int end = n - 1;

		while (start <= end) {
			int mid = (start + end) / 2;

			if (arr[mid - 1] < arr[mid] && arr[mid] > arr[mid + 1]) {
				resultInd = mid;
				break;
			} else if (arr[mid - 1] < arr[mid] && arr[mid] < arr[mid + 1]) {
				start = mid;
			} else if (arr[mid - 1] > arr[mid] && arr[mid] > arr[mid + 1]) {
				end = mid;
			}
		}
		return resultInd;
	}

	public static List<Integer> targetIndices(int[] nums, int target) {
		List<Integer> result = new ArrayList<>();
		Arrays.sort(nums);

		printArrayAndIndexes(nums);
		int ub = findUpperBoundofSortedArray(nums, target);
		if (ub == -1)
			return result;

		int lb = findLowerBoundofSortedArray(nums, target);

		for (int i = lb; i <= ub; i++)
			result.add(i);
		return result;
	}

	public int countNegatives(int[][] grid) {

		int result = 0;

		int totalRows = grid.length;
		int totalColumsn = grid[0].length;

		int row = 0;
		int column = totalColumsn - 1;

		while (row < totalRows && column >= 0) {
			if (grid[row][column] < 0) {
				result += (totalRows - row);
				column--;
			} else {
				row++;
			}
		}
		return result;
	}

	private static int findLowerBoundofSortedArray(int[] nums, int target) {
		int n = nums.length;
		int start = 0;
		int end = n - 1;
		int lb = -1;

		while (start <= end) {
			int mid = (start + end) / 2;
			if (nums[mid] == target) {
				lb = mid;
				end = mid - 1;
			} else if (nums[mid] < target) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		return lb;
	}

	private static int findUpperBoundofSortedArray(int[] nums, int target) {
		int n = nums.length;
		int start = 0;
		int end = n - 1;
		int ub = -1;

		while (start <= end) {
			int mid = (start + end) / 2;
			if (nums[mid] == target) {
				ub = mid;
				start = mid + 1;
			} else if (nums[mid] < target) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		return ub;
	}

	public static void printArrayAndIndexes(int[] nums) {
		System.out.print("Array :: ");
		for (int i = 0; i < nums.length; i++)
			System.out.print(nums[i] + "->");

		System.out.println();
		System.out.print("Index :: ");
		for (int i = 0; i < nums.length; i++)
			System.out.print(i + "->");

	}

}
