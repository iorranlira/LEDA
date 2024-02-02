package problems;

import static org.junit.Assert.assertEquals;

import javax.swing.tree.TreeNode;

import adt.bst.BST;
import adt.bt.BTNode;

/**
 * BSTIsValid
 */
public class BSTIsValid {

    public boolean isValidBST(BST<Integer> bst) {
        boolean resultado = false;

        if(!bst.isEmpty()) 
            resultado = isValidBST(bst.getRoot());

        return resultado;
    }

    private boolean isValidBST(BTNode<Integer> node)  {
        boolean resultado = false;

        if(!node.isEmpty() && node != null) {
            if(hasLeft(node) && hasRight(node)){
                if((node.getLeft().getData().compareTo(node.getData()) < 0) && (node.getRight().getData().compareTo(node.getData()) > 0)) {
                    resultado = isValidBST(node.getLeft()) && isValidBST(node.getRight());
                }
            }
            if((hasLeft(node)) && (!hasRight(node))) {
                if(node.getLeft().getData().compareTo(node.getData()) < 0) 
                    resultado = isValidBST(node.getLeft());
            }
            if((hasRight(node)) && (!hasLeft(node))) {
                if(node.getRight().getData().compareTo(node.getData()) > 0)
                    resultado = isValidBST(node.getRight());
            }

            if(isLeaf(node)) {
                return true;
            }
        }
                return resultado;
    }

    public boolean hasRight(BTNode<Integer> node) {
        return (node.getRight() != null) && (!node.getRight().isEmpty());
    }
    public boolean hasLeft(BTNode<Integer> node){
        return (node.getLeft() != null) && (!node.getLeft().isEmpty());
    }
    public boolean isLeaf(BTNode<Integer> node){
        return !hasLeft(node) && !hasRight(node);
    }
public static void main(String[] args) {
    BSTInteger bst1 = new BSTInteger();
    BSTInteger bst2 = new BSTInteger();
    BSTIsValid isValid = new BSTIsValid();
    
    //true
    bst1.insert(5);
    bst1.insert(4);
    bst1.insert(3);
    bst1.insert(9);
    
    //false
    BTNode<Integer> root = new BTNode<Integer>(5, null, null, null);
    BTNode<Integer> node2 = new BTNode<Integer>(4, null, null, null);
    BTNode<Integer> node3 = new BTNode<Integer>(1, null, null, null);
    BTNode<Integer> node4 = new BTNode<Integer>(3, null, null, null);
    BTNode<Integer> node5 = new BTNode<Integer>(6, null, null, null);
    root.setLeft(node3); root.setRight(node2);
    node2.setLeft(node4); node2.setRight(node5);

    //true
    bst2.insert(10);
    bst2.insert(12);
    bst2.insert(15);
    bst2.insert(13);
    bst2.insert(20);
    bst2.insert(7);
    bst2.insert(1);
    bst2.insert(5);
    
    //false
    BTNode<Integer> root2 = new BTNode<Integer>(10, null, null, null);
    BTNode<Integer> nodeRoot1 = new BTNode<Integer>(12, null, null, root2);
    BTNode<Integer> nodeRoot2 = new BTNode<Integer>(4, null, null, root2);
    root2.setLeft(nodeRoot2); root2.setRight(nodeRoot1);


    System.out.println("BST 1 " + isValid.isValidBST(bst1));
    System.out.println("ROOT 1 " + isValid.isValidBST(root));
    System.out.println("BST 2 " + isValid.isValidBST(bst2));
    System.out.println("ROOT 2 " + isValid.isValidBST(root2));
}

}