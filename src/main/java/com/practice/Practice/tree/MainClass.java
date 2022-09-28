package com.practice.Practice.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MainClass {

	public static void main(String[] args) {
		TreeNode testNode = test1();

		levelOrder(testNode);

	}

	public static List<List<Integer>> levelOrder(TreeNode root) {
		BTreePrinter.printNode(root);

		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		while (q.size() > 0) {
			q.remove();
		}

		return null;

	}

	public boolean evaluateTree(TreeNode root) {
		if (leafNode(root))
			return root.val == 1 ? true : false;

		else {
			if (root.val == 2) {
				return evaluateTree(root.left) || evaluateTree(root.right);
			} else {
				return evaluateTree(root.left) && evaluateTree(root.right);
			}
		}
	}

	private boolean leafNode(TreeNode root) {
		if (root.left == null && root.right == null)
			return true;
		else
			return false;
	}

	private static TreeNode test1() {
		TreeNode root = new TreeNode(2);
		TreeNode n11 = new TreeNode(7);
		TreeNode n12 = new TreeNode(5);
		TreeNode n21 = new TreeNode(2);
		TreeNode n22 = new TreeNode(6);
		TreeNode n23 = new TreeNode(3);
		TreeNode n24 = new TreeNode(6);
		TreeNode n31 = new TreeNode(5);
		TreeNode n32 = new TreeNode(8);
		TreeNode n33 = new TreeNode(4);
		TreeNode n34 = new TreeNode(5);
		TreeNode n35 = new TreeNode(8);
		TreeNode n36 = new TreeNode(4);
		TreeNode n37 = new TreeNode(5);
		TreeNode n38 = new TreeNode(8);

		root.left = n11;
		root.right = n12;

		n11.left = n21;
		n11.right = n22;
		n12.left = n23;
		n12.right = n24;

		n21.left = n31;
		n21.right = n32;
		n22.left = n33;
		n22.right = n34;
		n23.left = n35;
		n23.right = n36;
		n24.left = n37;
		n24.right = n38;

		return root;
	}
}
