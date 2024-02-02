package problems;

import java.util.LinkedList;
import java.util.Queue;

import javax.swing.tree.TreeNode;

import adt.bst.BST;
import adt.bst.BSTNode;
import adt.bt.BTNode;

/**
 * BSTRangeSum
 */
public class BSTRangeSum {

     public int rangeSumBST(BST<Integer> bst, int low, int high) {
        return rangeSumBST(bst.getRoot(), low, high);
    }

    private int rangeSumBST(BTNode<Integer> node, int low, int high) {
        int soma = 0;

        if(node != null && !node.isEmpty()) {
            if((node.getData() >= low) && (node.getData() <= high)) {
                soma += node.getData();

                if(hasRight(node)) {
                    soma += rangeSumBST(node.getRight(), low, high);
                }

                if(hasLeft(node)){
                    soma += rangeSumBST(node.getLeft(), low, high);
                }

            } else {
                if(hasRight(node)) {
                    soma += rangeSumBST(node.getRight(), low, high);
                }

                if(hasLeft(node)) {
                    soma += rangeSumBST(node.getLeft(), low, high);
                }
            }
        }

        return soma;
    }
    
    public boolean hasRight(BTNode<Integer> node) {
        return node.getRight() != null;
    }

    public boolean hasLeft(BTNode<Integer> node) {
        return node.getLeft() != null;
    }



    public void breadthFirstSearch(BST<Integer> bst) {
        if(bst.isEmpty()) return;
        BTNode<Integer> root = bst.getRoot();

        Queue<BTNode<Integer>> queue = new LinkedList<BTNode<Integer>>();
        queue.add(root);

        while(!queue.isEmpty()) {
            BTNode<Integer> currentNode = queue.poll();
            System.out.println(currentNode.getData());

            if(currentNode.getLeft() != null && currentNode.getLeft().getData() != null) {
                queue.add((currentNode).getLeft());
            }
            if(currentNode.getRight() != null && currentNode.getRight().getData() != null) {
                queue.add(currentNode.getRight());
            }
        }

    }   



    public static void main(String[] args) {
        BSTInteger bst = new BSTInteger();
        BSTRangeSum rangeSum = new BSTRangeSum();

        bst.insert(4);
        bst.insert(2);
        bst.insert(7);
        bst.insert(1);
        bst.insert(3);
        bst.insert(6);
        bst.insert(9);

        rangeSum.breadthFirstSearch(bst);
    }
}