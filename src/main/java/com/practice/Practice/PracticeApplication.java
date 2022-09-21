package com.practice.Practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PracticeApplication {

	public static void main(String[] args) {
		SpringApplication.run(PracticeApplication.class, args);
		System.out.println("Hello World");

		// int[] nums = new int[] { 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 };
		// System.out.println(removeElement(nums, 3));
		// removeDuplicates(nums);
		// System.out.println(Arrays.toString(nums));
		// System.out.println(searchInsert(nums, 2));
		// System.out.println(Arrays.toString(plusOne(nums)));

		// int[] nums1 = new int[] { 2, 1 };
		// System.out.println(Arrays.toString(nums1));

		// System.out.println(Arrays.toString(nums1));
		// moveZeroes(nums1);
		// System.out.println(Arrays.toString(nums1));

		// System.out.print(thirdMax(nums1));

		// System.out.println(firstUniqChar("leetcode"));

//		int[] nums = new int[] { 0, 1, 2, 3, 4 };
//		int[] index = new int[] { 0, 1, 2, 2, 1 };
//		System.out.println(Arrays.toString(createTargetArray(nums, index)));

//		String[] garbage = new String[] { "MMM", "PGM", "GP" };
//		int[] travel = new int[] { 3, 10 };
//
//		System.out.println(garbageCollection(garbage, travel));
		
//		System.out.println(freqAlphabets("10#11#12"));
		
		int [] arr = new int[] {2,3,4,7,11};
		System.out.println(findKthPositive(arr, 5));
	}
	
	public static int findKthPositive(int[] arr, int k) {
        int n = arr.length;
        Map<Integer, Boolean> map = new HashMap<>();
        for(int i : arr) map.put(i, true);
        int missing = 0;
        for(int j =1; j< arr[n-1] ; j ++){
            if(!map.containsKey(j)) missing++;
            if(missing == k) return j;
        }
        return arr[n-1] + (k-missing);
    }
	
	
    public static String freqAlphabets(String s) {
        int n = s.length();
        StringBuilder result = new StringBuilder();
        for (int i = n-1 ; i>=0; ){
            if(s.charAt(i) == '#') {
            	char temp  = (char) (Integer.parseInt(s.substring(i-2, i)) + 96 );
                result.append(temp);
                i-=3;
            }else{
                result.append((char)(96+(int)(s.charAt(i)-'0')));
                i--;
            }
        }
        return result.reverse().toString();
    }
    
	// garbage = ["G","P","GP","GG"], travel = [2,4,3]
	public static int garbageCollection(String[] garbage, int[] travel) {

		Map<Integer, Map<Character, Integer>> map = new HashMap<>();
		int totalPaper = 0;
		int totalMetal = 0;
		int totalGlass = 0;

		for (int i = 0; i < garbage.length; i++) {

			int g = 0;
			int p = 0;
			int m = 0;
			for (int j = 0; j < garbage[i].length(); j++) {
				switch (garbage[i].charAt(j)) {
				case 'G':
					g++;
					totalGlass++;
					break;
				case 'P':
					p++;
					totalPaper++;
					break;
				case 'M':
					m++;
					totalMetal++;
					break;
				default:
					// default statements
				}
			}
			Map<Character, Integer> tempMap = new HashMap<>();
			tempMap.put('g', g);
			tempMap.put('p', p);
			tempMap.put('m', m);
			map.put(i, tempMap);
		}

		int totalTime = 0;

		int collectedMetal = 0;
		int collectedPaper = 0;
		int collectedGlass = 0;
		// collecting metal
		for (int i = 0; i < garbage.length; i++) {

			if (map.get(i).get('m') != 0) {
				totalTime += map.get(i).get('m');
				collectedMetal += map.get(i).get('m');
			}
			if (collectedMetal == totalMetal)
				break;
			totalTime += travel[i];
		}

		for (int i = 0; i < garbage.length; i++) {
			if (map.get(i).get('p') != 0) {
				totalTime += map.get(i).get('p');
				collectedPaper += map.get(i).get('p');
			}
			if (collectedPaper == totalPaper)
				break;
			totalTime += travel[i];
		}

		for (int i = 0; i < garbage.length; i++) {
			if (map.get(i).get('g') != 0) {
				totalTime += map.get(i).get('g');
				collectedGlass += map.get(i).get('g');
			}
			if (collectedGlass == totalGlass)
				break;
			totalTime += travel[i];
		}
		return totalTime;
	}
	// garbage = ["G","P","GP","GG"], travel = [2,4,3]

	public static int[] createTargetArray(int[] nums, int[] index) {
		int[] target = new int[nums.length];
		Arrays.fill(target, -1);

		for (int i = 0; i < nums.length; i++) {
			if (target[index[i]] == -1)
				target[index[i]] = nums[i];
			else {
				rightShiftArary(target, index[i]);
				target[index[i]] = nums[i];
			}

		}
		return target;
	}

	// int[] nums = new int[] {0,1,2,3,4};
	// int[] index = new int[] {0,1,2,2,1};
	private static void rightShiftArary(int[] target, int m1) {

		for (int i = target.length - 2; i >= m1; i--) {
			target[i + 1] = target[i];
		}
		System.out.println(Arrays.toString(target));

	}

	public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
		List<Boolean> result = new ArrayList<>();

		int max = 0;
		for (int c : candies) {
			if (c > max)
				max = c;
		}

		for (int i = 0; i < candies.length; i++) {
			result.add(candies[i] + extraCandies >= max);
		}

		return result;
	}

	public static int firstUniqChar(String s) {
		int[] freq = new int[26];
		for (int i = 0; i < s.length(); i++) {
			int ascii = (int) (s.charAt(i) - 'a');
			freq[ascii]++;
		}

		for (int i = 0; i < s.length(); i++) {
			if (freq[(int) (s.charAt(i) - 'a')] == 1)
				return i;
		}

		return -1;
	}

	public static int thirdMax(int[] nums) {

		Integer max1 = null;
		Integer max2 = null;
		Integer max3 = null;

		for (Integer num : nums) {
			if (num.equals(max1) || num.equals(max2) || num.equals(max3)) {
				continue;
			}

			if (max1 == null || num > max1) {
				max3 = max2;
				max2 = max1;
				max1 = num;
			} else if (max2 == null || num > max2) {
				max3 = max2;
				max2 = num;
			} else if (max3 == null || num > max3) {
				max3 = num;
			}
		}

		if (max3 != null)
			return max3;
		else
			return max1;
	}

	public int[] intersection(int[] nums1, int[] nums2) {
		HashSet<Integer> set1 = new HashSet<>();
		for (int num : nums1) {
			set1.add(num);
		}

		HashSet<Integer> set2 = new HashSet<>();

		for (int num : nums2) {
			if (set1.contains(num)) {
				set2.add(num);
			}
		}
		int[] nums3 = new int[set2.size()];
		int i = 0;
		for (int num : set2) {
			nums3[i++] = num;
		}
		return nums3;
	}

	public static void moveZeroes(int[] nums) {
		int count = 0;
		int j = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != 0) {
				nums[j] = nums[i];
				j++;

			}
		}
		while (j < nums.length) {
			nums[j] = 0;
			j++;
		}

	}

	public boolean containsDuplicate(int[] nums) {
		HashMap<Integer, Integer> h = new HashMap<>();
		for (int num : nums) {
			if (h.containsKey(num))
				return true;
			else
				h.put(num, 0);
		}
		return false;
	}

	public boolean containsNearbyDuplicate(int[] nums, int k) {
		HashMap<Integer, Integer> h = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (h.containsKey(nums[i])) {
				if (Math.abs(Integer.valueOf(i) - h.get(nums[i])) <= k)
					return true;
			} else
				h.put(nums[i], i);
		}
		return false;
	}

	public int maxProfit(int[] prices) {
		int maxProfit = 0;
		int minSoFar = prices[0];
		for (int i = 0; i < prices.length; i++) {

			int profit = prices[i] - minSoFar;
			if (profit > maxProfit)
				maxProfit = profit;
			if (prices[i] < minSoFar)
				minSoFar = prices[i];
		}

		return maxProfit;
	}

	public static void merge(int[] nums1, int m, int[] nums2, int n) {
		if (n == 0)
			return;
		int nums1Pointer = m - 1;
		int nums2Pointer = n - 1;
		int totalPointer = m + n - 1;

		while (nums1Pointer >= 0 && nums2Pointer >= 0) {
			if (nums1[nums1Pointer] >= nums2[nums2Pointer]) {
				nums1[totalPointer] = nums1[nums1Pointer];
				nums1Pointer--;
			} else {
				nums1[totalPointer] = nums2[nums2Pointer];
				nums2Pointer--;
			}
			totalPointer--;
		}

		if (nums1Pointer >= 0) {
			for (int i = nums1Pointer; i >= 0; i--) {
				nums1[totalPointer] = nums1[i];
				totalPointer--;
			}

		}
		if (nums2Pointer >= 0) {
			for (int i = nums2Pointer; i >= 0; i--) {
				nums1[totalPointer] = nums2[i];
				totalPointer--;
			}
		}
	}

	public static int[] plusOne(int[] digits) {

		for (int i = digits.length - 1; i >= 0; i--) {
			if (digits[i] < 9) {
				digits[i]++;
				return digits;
			}
			digits[i] = 0;
		}
		int[] result = new int[digits.length + 1];
		result[0] = 1;
		return result;

	}

	public static int searchInsert(int[] nums, int target) {
		return findElement(nums, target, 0, nums.length - 1);
	}

	public static int findElement(int[] nums, int target, int start, int end) {
		while (start <= end) {
			int mid = (start + end) / 2;

			if (nums[mid] == target)
				return mid;

			else if (nums[mid] < target)
				start = mid + 1;

			else
				end = mid - 1;
		}
		return end + 1;
	}

	public static int removeElement(int[] nums, int target) {
		int len = nums.length;
		if (len == 0)
			return 0;
		int i = 0;
		int j = 0;

		for (j = 0; j < len; j++) {
			if (nums[j] != target) {
				nums[i] = nums[j];
				i++;
			}
		}
		return i;
	}

	public static int removeDuplicates(int[] nums) {
		int k = 0;
		int end = nums.length - 1;
		for (int i = 0; i < nums.length - 1;) {
			if (end == i)
				break;
			if (nums[i] != nums[i + 1]) {
				k++;
				i++;
			} else {
				rotateBy1(nums, i + 1, end);
				end--;
			}
		}
		return k + 1;
	}

	public static void rotateBy1(int[] nums, int start, int end) {
		int temp = nums[start];
		for (int i = start; i < end; i++) {
			nums[i] = nums[i + 1];
		}
		nums[end] = temp;
	}

	public static int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			map.put(nums[i], i);
		}
		for (int i = 0; i < nums.length; i++) {
			int complement = target - nums[i];
			if (map.containsKey(complement) && map.get(complement) != i) {
				return new int[] { i, map.get(complement) };
			}
		}
		return null;
	}

	public static int[] runningSum(int[] nums) {
		int size = nums.length;
		if (size < 2)
			return nums;
		else {
			int i = 0;
			int[] sums = new int[size];
			int sumSoFar = nums[i];
			while (i < size) {
				sums[i] = sumSoFar;
				if (++i != size)
					sumSoFar += nums[i];
			}
			return sums;
		}
	}

}
