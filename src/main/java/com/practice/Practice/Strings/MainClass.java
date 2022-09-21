package com.practice.Practice.Strings;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class MainClass {

	public static void main(String[] args) {
		// System.out.println(interpret("G()(al)"));

//		String s = "codeleet";
//		int[] indices = new int[] { 4, 5, 6, 7, 0, 2, 1, 3 };
		// System.out.println(restoreString(s, indices));

		// System.out.println(cellsInRange("K1:L2"));
		// System.out.println(sortSentence("is2 sentence4 This1 a3"));

//		List<List<String>> items = List.of(List.of("phone", "blue", "pixel"), List.of("computer", "silver", "lenovo"),
//				List.of("phone", "gold", "iphone"));
//		System.out.println(countMatches(items, "color", "silver"));
//		System.out.println(countAsterisks("yo|uar|e**|b|e***au|tifu|l"));

		// System.out.println(toLowerCase("Hello"));

//		String allowed = "ab";
//		String[] words = new String[] { "ad", "bd", "aaab", "baa", "badab" };
//		System.out.println(countConsistentStrings(allowed, words));

//		String s = "Hello how are you Contestant";
//		System.out.println(truncateSentence(s, 4));

		// System.out.println(reverseWords("Let's take LeetCode contest"));

		//System.out.println(replaceDigits("a1c1e1"));
		
		String [] str = new String [] {"abc","car","ada","racecar","cool"};
		System.out.println(firstPalindrome(str));

	}

	public static String firstPalindrome(String[] words) {
		String result = null ;
		for(String s : words) {
			if(isPalindrome(s)) {
				result = s;
				break;
			}
		}
		return (result==null)? "" : result ;
	}

	public static String replaceDigits(String s) {
		char[] result = new char[s.length()];
		int j = 0;

		for (int i = 0; i < s.length(); i++) {
			if (i % 2 != 0) {
				int num = ((int) s.charAt(i - 1));
				int n = (int) (s.charAt(i) - '0');
				result[j] = (char) (n + num);
			} else
				result[j] = s.charAt(i);

			j++;
		}
		return new String(result);
	}

	public static String reverseWords(String s) {

		StringBuilder str = new StringBuilder();

		String[] split = s.split(" ");
		for (String each : split) {
			str.append(reverseWord(each));
			str.append(" ");
		}
		return str.toString().stripTrailing();
	}

	private static Object reverseWord(String each) {
		char[] result = new char[each.length()];
		int j = 0;
		for (int i = each.length() - 1; i >= 0; i--) {
			result[j] = each.charAt(i);
			j++;
		}
		return new String(result);
	}

	public static boolean checkIfPangram(String sentence) {
		int[] exists = new int[26];

		for (int i = 0; i < sentence.length(); i++) {
			exists[(int) (sentence.charAt(i) - 'a')] = 1;
		}

		for (int a : exists) {
			if (a == 0) {
				return false;
			}
		}
		return true;
	}

	public static String truncateSentence(String s, int k) {

		StringBuilder str = new StringBuilder();
		int counter = 0;
		String[] split = s.split(" ");
		for (String w : split) {
			if (counter == k)
				break;
			else {
				str.append(w);
				str.append(" ");
				counter++;
			}

		}
		return str.toString().trim();
	}

	public static int countConsistentStrings(String allowed, String[] words) {
		Map<Character, Boolean> map = new HashMap<>();
		for (int i = 0; i < allowed.length(); i++) {
			map.put(allowed.charAt(i), true);
		}
		int count = 0;
		int counter = 1;

		for (String word : words) {
			for (int i = 0; i < word.length(); i++) {
				counter = 1;
				if (!map.containsKey(word.charAt(i))) {
					counter = 0;
					break;
				}
			}
			count += counter;
		}
		return count;

	}

	public static String toLowerCase(String s) {
		StringBuilder str = new StringBuilder();

		for (int i = 0; i < s.length(); i++) {
			int ascii = (int) s.charAt(i);
			if (ascii > 64 && ascii < 91)
				str.append((char) (ascii + 32));
			else
				str.append(s.charAt(i));
		}
		return str.toString();
	}

	public static int countAsterisks(String s) {
		int count = 0;
		boolean counter = false;

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '|')
				counter = !counter;

			if (!counter && s.charAt(i) == '*')
				count++;
		}
		return count;
	}

	public static int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
		int total = 0;
		int i = -1;
		switch (ruleKey) {
		case "type":
			i = 0;
			break;
		case "color":
			i = 1;
			break;
		case "name":
			i = 2;
			break;
		default:
			// default statements
		}

		for (List<String> list : items) {
			if (list.get(i).equalsIgnoreCase(ruleValue))
				total += 1;
		}
		return total;
	}

	public static boolean isStrictlyPalindromic(int n) {
		boolean result = true;
		for (int i = 2; i < n - 1; i++) {
			String tmp = Integer.toString(n, i);
			if (!isPalindrome(tmp)) {
				result = false;
				break;
			}
		}
		return result;
	}

	private static boolean isPalindrome(String tmp) {

		boolean res = true;
		int i = 0;
		int j = tmp.length() - 1;
		while (i <= j) {
			if (tmp.charAt(i) != tmp.charAt(j)) {
				res = false;
				break;
			}
			i++;
			j--;
		}
		return res;
	}

	public static String sortSentence(String s) {
		String[] split = s.split(" ");
		Map<Integer, String> map = new HashMap<>();

		StringBuilder result = new StringBuilder();

		for (String s1 : split) {
			map.put(s1.charAt(s1.length() - 1) - '0', s1.substring(0, s1.length() - 1));
		}

		for (int i = 0; i <= 9; i++) {
			if (map.containsKey(i)) {
				result.append(map.get(i));
				result.append(" ");
			}
		}
		return result.toString().trim();

	}

	public int numIdenticalPairs(int[] nums) {
		int count = 0;
		int n = nums.length;

		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				if (nums[i] == nums[j])
					count++;
			}
		}
		return count;
	}

	public static List<String> cellsInRange(String s) {
		List<String> result = new LinkedList<>();

		String[] splitStr = s.split(":");
		int startingColumn = splitStr[0].charAt(0);
		int startingRow = splitStr[0].charAt(1) - '0';

		int endingColumn = splitStr[1].charAt(0);
		int endingRow = (int) splitStr[1].charAt(1) - '0';

		for (int i = startingColumn; i <= endingColumn; i++) {
			for (int j = startingRow; j <= endingRow; j++) {
				StringBuilder tem = new StringBuilder();
				tem.append((char) i);
				tem.append(j);
				result.add(tem.toString());
			}
		}
		return result;
	}

	public static String restoreString(String s, int[] indices) {
		if (s == null || indices.length == 0)
			return null;

		char[] result = new char[s.length()];
		for (int i = 0; i < s.length(); i++) {
			result[indices[i]] = s.charAt(i);
		}
		return new String(result);

	}

	public static String interpret(String command) {
		int n = command.length();
		int i = 0;
		StringBuilder str = new StringBuilder();
		while (i < n) {
			if (command.charAt(i) == 'G') {
				str.append('G');
				i++;
				continue;
			} else if (i < n - 1 && command.charAt(i) == '(' && command.charAt(i + 1) == ')') {
				str.append('o');
				i += 2;
			} else {
				if (i < n - 3) {
					str.append("al");
					i += 4;
				}
			}
		}
		return str.toString();
	}

	public int numJewelsInStones(String jewels, String stones) {
		Map<Character, Boolean> map = new HashMap<>();
		for (int i = 0; i < jewels.length(); i++) {
			map.put(jewels.charAt(i), true);
		}
		int counter = 0;
		for (int i = 0; i < stones.length(); i++) {
			if (map.containsKey(stones.charAt(i)))
				counter++;
		}
		return counter;
	}

	public int mostWordsFound(String[] sentences) {
		int max = 0;
		for (String sent : sentences) {
			String[] temp = sent.split(" ");
			if (temp.length > max)
				max = temp.length;
		}
		return max;
	}

}
