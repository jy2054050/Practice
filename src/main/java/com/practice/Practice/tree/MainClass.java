package com.practice.Practice.tree;

public class MainClass {

	public static void main(String[] args) {
		
	}
	
	public boolean evaluateTree(TreeNode root) {
		if(leafNode(root)) return root.val ==1 ? true: false;
		
		else {
			if(root.val==2) {
				return evaluateTree(root.left) || evaluateTree(root.right);
			}else {
				return evaluateTree(root.left) && evaluateTree(root.right);
			}
		}
    }

	private boolean leafNode(TreeNode root) {
		if(root.left == null && root.right == null) return true;
		else return false;
	}
}
