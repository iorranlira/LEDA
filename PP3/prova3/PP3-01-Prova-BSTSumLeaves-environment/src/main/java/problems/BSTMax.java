package problems;

import adt.bst.BST;
import adt.bt.BTNode;

/**
 * BSTMax
 */
public class BSTMax {

    public void maxBST(BST<Integer> bst) {
        if(bst.isEmpty()) {
            return;
        } else {
            maxBST(bst.getRoot());
        }
    }

    private void maxBST(BTNode<Integer> root) {
        if(root.getRight() != null) {
            System.out.println(root.getData());
            maxBST(root.getRight());
        }
    }

public static void main(String[] args) {
    BSTMax b = new BSTMax();
    BSTInteger bst = new BSTInteger();

    bst.insert(10);
    bst.insert(8);
    bst.insert(1);
    bst.insert(9);
    bst.insert(20);
    bst.insert(18);
    bst.insert(25);

    b.maxBST(bst);
}

}