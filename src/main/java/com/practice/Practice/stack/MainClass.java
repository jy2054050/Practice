package com.practice.Practice.stack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class MainClass {

	public static void main(String[] args) {

		// String testPhrase = "[\"5\",\"2\",\"C\",\"D\",\"+\"]";
		// System.out.println(isValid(testPhrase));

		// String s = "y#fo##f";
		// String t = "y#f#o##f";
		// System.out.println(backspaceCompare(s, t));
		// String s = "(()())(())";
		// System.out.println(removeOuterParentheses(s));
		// String s = "abbaca";
		// System.out.println(removeDuplicates(s));
		// int[] p = new int[]{8,4,6,2,3};
		// finalPrices(p);
//		String s = "kkdsFuqUfSDKK";
//		System.out.println(makeGood(s));

//		int[] nums1 = new int[] {1,3,5,2,4}; 
//		int[] nums2 = new int[] {6,5,4,3,2,1,7};
//		
//		nextGreaterElement(nums1, nums2);

//		String[] logs = new String[] { "d1/", "../", "../", "../" };
//		System.out.println(minOperations(logs));

//		int[] students = new int[] { 1, 1, 1, 0, 0, 1 };
//		int[] sandwiches = new int[] { 1, 0, 0, 0, 1, 1 };
//		System.out.println(countStudents(students, sandwiches));

//		int[] tickets = new int[] { 2, 3, 2 };
//		System.out.println(timeRequiredToBuy(tickets, 2));

//		String s = "RLRRLLRLRL";
//		System.out.println(balancedStringSplit(s));
		
//		int[] temperatures = new int[] {73,74,75,71,69,72,76,73};
//		System.out.println(Arrays.toString(dailyTemperatures(temperatures)));
		
		int[] nums2 = new int[] {6,5,4,3,2,1,7};
		Stack <Integer> st = new Stack<>();
		for(int num : nums2) {
			st.push(num);
		}
		
		System.out.println("printing sorted");
		printStack(sortSingleStack(st));
		

	}

	public static Stack<Integer> sortSingleStack(Stack<Integer> st){
		if(!st.empty()) {
			int top = st.pop();
			sortSingleStack(st);
			placeStackItem(st, top);
		}
		return st;
	}

	private static void placeStackItem(Stack<Integer> st, int top) {
		if(!st.empty() && st.peek() < top) {
			int temp = st.pop();
			placeStackItem(st, top);
			st.push(temp);
		}else {
			st.push(top);
		}
		
	}

	public static int[] dailyTemperatures(int[] temperatures) {
		Stack<Integer> st = new Stack<>();
		
		for(int i =0; i <temperatures.length ; i++) {
			int curr = temperatures[i];
			if (st.isEmpty()) st.push(i);
			else {
				while(!st.isEmpty() && temperatures[st.peek()] < curr) {
					int temp = st.pop();
					temperatures[temp] = i-temp;
				}
				st.push(i);
			}
		}
		while(!st.isEmpty()) temperatures[st.pop()] = 0;
		return temperatures;
	}

	public static int countKDifference(int[] nums, int k) {
		Map<Integer, Integer> map = new HashMap<>();

		int count = 0;
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(nums[i] - k)) {
				count += map.get(nums[i] - k);
			}
			if (map.containsKey(nums[i] + k)) {
				count += map.get(nums[i] + k);
			}
			map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
		}
		return count;
	}

	public static int balancedStringSplit(String s) {
		int count = 0;
		Stack<Character> st = new Stack<>();
		st.push(s.charAt(0));
		for (int i = 1; i < s.length(); i++) {
			if (s.charAt(i) == 'R')
				st.push('R');
			if (s.charAt(i) == 'L')
				st.pop();
			if (st.isEmpty())
				count++;
		}
		return count;

	}

	public static int timeRequiredToBuy(int[] tickets, int k) {
		int time = 0;

		int i = 0;
		while (tickets[k - 1] != 0) {
			if (tickets[i] == 0) {
				// do nothing
			} else {
				tickets[i]--;
				time++;
			}
			i++;
			if (i == tickets.length)
				i = 0;
		}
		return time - 1;
	}

	public static int countStudents(int[] students, int[] sandwiches) {
		int studentWant1 = 0;
		int studentWant0 = 0;
		Queue<Integer> q = new LinkedList<>();
		for (int stu : students) {
			if (stu == 0)
				studentWant0++;
			else
				studentWant1++;

			q.add(stu);
		}
		Stack<Integer> st = new Stack<>();
		for (int i = sandwiches.length - 1; i >= 0; i--) {
			st.push(sandwiches[i]);
		}

		while (true) {
			if (st.isEmpty())
				break;
			else {
				if ((studentWant1 == 0 && st.peek() == 1) || (studentWant0 == 0 && st.peek() == 0))
					break;
				else {
					if (st.peek() == q.peek()) {
						int temp = st.pop();
						q.remove();
						if (temp == 1)
							studentWant1--;
						else
							studentWant0--;
					} else {
						int temp = q.remove();
						q.add(temp);
					}
				}
			}

		}
		return q.size();
	}

	public static int minOperations(String[] logs) {
		Stack<String> st = new Stack<>();
		for (String log : logs) {
			if (log.equals("../")) {
				if (!st.isEmpty())
					st.pop();
			} else if (log.equals("./")) {

			} else {
				st.push(log);
			}
		}

		return st.size();
	}

	public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
		int[] result = new int[nums1.length];
		for (int i = 0; i < result.length; i++) {
			result[i] = -1;
		}
		HashMap<Integer, Integer> map = new HashMap<>();
		Stack<Integer> st = new Stack<>();

		for (int i = 0; i < nums1.length; i++) {
			map.put(nums1[i], i);
		}

		for (int i = 0; i < nums2.length; i++) {
			if (st.isEmpty())
				st.push(nums2[i]);
			else {
				int curr = nums2[i];
				while (!st.isEmpty() && st.peek() < curr) {
					int sCurr = st.peek();
					if (map.containsKey(sCurr)) {
						int val = map.get(sCurr);
						result[val] = curr;
					}
					st.pop();
				}
				st.push(curr);
			}
		}
		return result;
	}

	public static String makeGood(String s) {
		Stack<Character> st = new Stack<>();

		for (int i = 0; i < s.length(); i++) {
			char curr = s.charAt(i);
			if (st.isEmpty())
				st.push(curr);
			else {
				if (Math.abs((int) st.peek() - (int) curr) == 32) {
					st.pop();
				} else {
					st.push(curr);
				}
			}
		}
		char[] result = new char[st.size()];
		for (int i = st.size() - 1; i >= 0; i--) {
			result[i] = st.pop();
		}
		return new String(result);
	}

	public static int[] finalPrices(int[] prices) {

		Stack<Integer> st = new Stack<>();
		int[] disc = new int[prices.length];
		for (int i = 0; i < prices.length; i++) {
			if (st.isEmpty())
				st.push(i);
			else {
				while (!st.isEmpty() && prices[i] <= prices[st.peek()]) {
					int j = st.pop();
					disc[j] = prices[i];
				}
				st.push(i);
			}
		}
		for (int i = 0; i < prices.length; i++) {
			prices[i] -= disc[i];
		}
		return prices;
	}

	public static String removeDuplicates(String s) {
		Stack<Character> st = new Stack<>();

		for (int i = 0; i < s.length(); i++) {
			char curr = s.charAt(i);
			if (st.isEmpty()) {
				st.push(curr);
			} else {
				if (st.peek() == curr) {
					st.pop();
				} else {
					st.push(curr);
				}
			}
		}

		char[] result = new char[st.size()];
		for (int i = st.size() - 1; i >= 0; i--) {
			result[i] = st.pop();
		}
		return new String(result);
	}

	public static String removeOuterParentheses(String s) {
		Stack<Character> st = new Stack<>();
		StringBuilder result = new StringBuilder();

		for (int i = 0; i < s.length(); i++) {
			char curr = s.charAt(i);

			if (curr == '(') {
				if (!st.isEmpty())
					result.append(curr);
				st.push(curr);
			} else {
				st.pop();
				if (!st.isEmpty())
					result.append(curr);
			}
		}
		return result.toString();
	}

	public static boolean backspaceCompare(String s, String t) {
		Stack<Character> st1 = new Stack<>();
		Stack<Character> st2 = new Stack<>();

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '#') {
				if (st1.isEmpty()) {
					// do nothing
				} else {
					st1.pop();
				}
			} else
				st1.push(s.charAt(i));
		}
		for (int i = 0; i < t.length(); i++) {
			if (t.charAt(i) == '#') {
				if (st2.isEmpty()) {
					// do nothing
				} else
					st2.pop();
			} else
				st2.push(t.charAt(i));
		}

		if (st1.isEmpty() && st2.isEmpty())
			return true;
		else {
			while (!st1.isEmpty() && !st2.isEmpty()) {
				if (st1.pop() == st2.pop())
					continue;
				else
					return false;
			}
		}

		if (!st1.isEmpty() || !st2.isEmpty())
			return false;

		return true;
	}

	/*
	 * An integer x - Record a new score of x. "+" - Record a new score that is the
	 * sum of the previous two scores. It is guaranteed there will always be two
	 * previous scores. "D" - Record a new score that is double the previous score.
	 * It is guaranteed there will always be a previous score. "C" - Invalidate the
	 * previous score, removing it from the record. It is guaranteed there will
	 * always be a previous score.
	 */

	public int calPoints(String[] ops) {

		Stack<Integer> st = new Stack<>();
		for (String op : ops) {
			if (op.equalsIgnoreCase("+")) {
				int num1 = st.pop();
				int num2 = st.pop();
				st.push(num1);
				st.push(num2);
				st.push(num1 + num2);
			} else if (op.equalsIgnoreCase("D")) {
				st.push(2 * st.peek());
			} else if (op.equalsIgnoreCase("C")) {
				st.pop();
			} else {
				st.push(Integer.valueOf(op));
			}
		}
		int sum = 0;
		while (!st.isEmpty())
			sum += st.pop();

		return sum;
	}

	public static boolean isValid(String s) {
		Stack<Character> st = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{')
				st.push(s.charAt(i));
			else {
				if (st.isEmpty())
					return false;
				else {
					char c = st.pop();
					if (s.charAt(i) == ')' && c == '(')
						continue;
					else if (s.charAt(i) == ']' && c == '[')
						continue;
					else if (s.charAt(i) == '}' && c == '{')
						continue;
					else
						return false;
				}
			}
		}

		if (st.isEmpty())
			return true;
		else
			return false;
	}
	
	private static void printStack(Stack<Integer> st) {
		while(!st.isEmpty()) System.out.println(st.pop());
	}

}
