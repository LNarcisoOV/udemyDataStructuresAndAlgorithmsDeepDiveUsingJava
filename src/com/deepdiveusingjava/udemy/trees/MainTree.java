package com.deepdiveusingjava.udemy.trees;

public class MainTree {
	public static void main(String args[]) {
		System.out.println("::::: TREES ::::: ");
		System.out.println("");
		System.out.println("- Hierarchical data structure.");
		System.out.println("- Each field in the tree is called 'Node'.");
		System.out.println("- Each node can have a lot of children, but each child ");
		System.out.println("can have one, and only one parent.");
		System.out.println("- The first node of the tree is called 'ROOT' and it doesn't");
		System.out.println("have a parent.");
		System.out.println("- Every tree can have one and only one root node.");
		System.out.println("- Trees are ideal when things contain things or when things");
		System.out.println("descend from other things.");
		System.out.println("- Java class hierarchy is an example of a tree.");
		System.out.println("- A node without children is called 'leaf node'.");
		System.out.println("- If a tree has only one node, is called a singleton tree, because");
		System.out.println("this tree has only the root node.");
		System.out.println("- Every node with descendants(children) is called Subtree.");
		System.out.println("");
		System.out.println("::::: BINARY SEARCH TREE ::::: ");
		System.out.println("- Every node has 0, 1 or 2 children, more than this isn't a binary tree.");
		System.out.println("- Children are referred to as the left child and right child.");
		System.out.println("- Binary search trees. ");
		System.out.println("- Can perform insertions, deletions, and retrievals in O(logN) time. ");
		System.out.println("- The left child always has a smaller value than its parent.");
		System.out.println("- The right child always has a larger value than its parent.");
		System.out.println("- This means, everything left to the root is less than the value of the root, ");
		System.out.println("and everything right to the root is greater than the value of the root, because");
		System.out.println("of that, we can do a binary search.");
		System.out.println("");
		System.out.println("::::: BINARY SEARCH TREE - TRAVERSAL ::::: ");
		System.out.println("- There are 4 ways of traversal a binary tree:");
		System.out.println("  - Level: Visit nodes on each level.");
		System.out.println("  - Pre-order: visit the root of every subtree first.");
		System.out.println("  - Post-order: visit the root of every subtree last.");
		System.out.println("  - In-order: visit left child, then root, then the right child.");
		System.out.println("");
		System.out.println("::::: DELETE NODE ::::: ");
		System.out.println("- Case 1: Node is a leaf.");
		System.out.println("- Case 2: Node has one child.");
		System.out.println("- Case 3: Node has two children.");
		System.out.println("  In the case 3, we have some situation:");
		System.out.println("  - Need to figure out what the replacement node will be.");
		System.out.println("  - What minimal disruption to the existing tree structure.");
		System.out.println("  - Can take de replacement node from the deleted node's left or right subtree.");
		System.out.println("  - If taking it from the left subtree, we have to take the largest value in");
		System.out.println("  the left subtree.");
		System.out.println("  - If taking it from the right subtree, we have to take the smallest value in");
		System.out.println("  the right subtree.");
		System.out.println("  - Choose one and stick to it.");

		Tree intTree = binarySearchTreeInsertion();
		binarySearchTreeTraversalInOrder(intTree);
		System.out.println("");
		gettingNodeByValuesInTheTree(intTree);
		System.out.println("");
		gettingMinimumAndMaximumValuesInTheTree(intTree);
		System.out.println("");
		deletingValuesInTheTree(intTree);
		System.out.println("");
		video100BinarySearchTreeChalenge1();
	}

	private static Tree binarySearchTreeInsertion() {
		Tree intTree = new Tree();
		intTree.insert(25);
		intTree.insert(20);
		intTree.insert(15);
		intTree.insert(27);
		intTree.insert(30);
		intTree.insert(29);
		intTree.insert(26);
		intTree.insert(22);
		intTree.insert(32);
		return intTree;

	}

	private static void binarySearchTreeTraversalInOrder(Tree intTree) {
		System.out.println("Traversing the tree in order: ");
		System.out.print("Tree[");
		intTree.traverseInOrder();
		System.out.println("];");
	}

	private static void gettingNodeByValuesInTheTree(Tree intTree) {
		System.out.println("Getting tree node by values:");
		System.out.println("Getting tree by value 15: " + intTree.get(15));
		System.out.println("Getting tree by value 32: " + intTree.get(32));
		System.out.println("Getting tree by value 514: " + intTree.get(514));
		System.out.println("Getting tree by value 22: " + intTree.get(22));
	}

	private static void gettingMinimumAndMaximumValuesInTheTree(Tree intTree) {
		System.out.println("Getting minimum and maximum values in the tree:");
		System.out.println("Minimum value: " + intTree.min());
		System.out.println("Maximum value: " + intTree.max());
	}

	private static void deletingValuesInTheTree(Tree intTree) {
		System.out.println("Deleting values in the tree:");
		System.out.print("Original Tree[");
		intTree.traverseInOrder();
		System.out.println("]");
		System.out.print("Deleting 15: Tree[");
		intTree.delete(15);
		intTree.traverseInOrder();
		System.out.println("]");
		System.out.print("Deleting 27: Tree[");
		intTree.delete(27);
		intTree.traverseInOrder();
		System.out.println("]");
		System.out.print("Deleting 25(ROOT): Tree[");
		intTree.delete(25);
		intTree.traverseInOrder();
		System.out.println("]");
	}
	

	private static void video100BinarySearchTreeChalenge1() {
		Tree intTree = binarySearchTreeInsertion();
		System.out.println("::::: VIDEO 100 BINARY SEARCH TREE CHALENGE #1 ::::: ");
		System.out.println("Traversing pre order:");
		intTree.traversePreOrder();
		System.out.println();
		System.out.println("Traversing post order:");
		intTree.traversePostOrder();
	}
}
