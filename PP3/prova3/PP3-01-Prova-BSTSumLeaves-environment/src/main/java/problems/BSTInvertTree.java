package problems;

import javax.swing.tree.TreeNode;

import adt.bst.BST;
import adt.bt.BTNode;

/**
 * BSTInvertTree
 */
public class BSTInvertTree {

    public void invertTree(BST<Integer> bst) {
        if(bst.isEmpty()) return;
        invertTree(bst.getRoot());    
    }

    private void invertTree(BTNode<Integer> node) {
        if((node != null) && (!node.isEmpty())) {
            if(hasRight(node) && hasLeft(node)) {
                BTNode<Integer> aux = node.getRight();
                BTNode<Integer> aux_2 = node.getLeft();

                node.setRight(aux_2);
                node.setLeft(aux);

                invertTree(aux);
                invertTree(aux_2);
            }
        }
    }

    public void preOrder(BST<Integer> bst) {
        preOrder(bst.getRoot());
    }

    private void preOrder(BTNode<Integer> node) {
        if(node != null && !node.isEmpty()) {
            System.out.println(node);
            preOrder(node.getLeft());
            preOrder(node.getRight());
        }
    }

    public boolean hasRight(BTNode<Integer> node) {
        return node.getRight() != null;
    }

    public boolean hasLeft(BTNode<Integer> node) {
        return node.getLeft() != null;
    }
public static void main(String[] args) {
    BSTInteger bst = new BSTInteger();
     BSTInteger bst2 = new BSTInteger();
    BSTInvertTree invertTree = new BSTInvertTree();
    bst.insert(4);
    bst.insert(2);
    bst.insert(7);
    bst.insert(9);
    bst.insert(6);
    bst.insert(2);
    bst.insert(1);
    bst.insert(3);
    
    bst2.insert(2);
    bst2.insert(1);
    bst2.insert(3);



    invertTree.invertTree(bst2);
    invertTree.preOrder(bst);
    }
}