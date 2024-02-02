
package problems;

import static org.junit.Assert.assertEquals;

import adt.bst.BST;
import adt.bt.BTNode;

/**
 * BSTInsideNodes
 */
public class BSTInternalNodes {

    public int insideNodes(BST<Integer> bst) {
        if(bst.isEmpty()) {
            return 0;
        } else {
            return insideNodes(bst.getRoot()); 
        }
    }

    private int insideNodes(BTNode<Integer> bstNode) {
        int cont = 0;
        if(!bstNode.isEmpty() && bstNode != null) {
            if(bstNode.isLeaf()) { 
                cont += bstNode.getData();
                cont += insideNodes(bstNode.getLeft());
                cont += insideNodes(bstNode.getRight());
       }
    }
            return cont;
    }

    private int insideNodesExtended(BTNode<Integer> bstNode) {
        int cont = 0;
        if(!bstNode.isLeaf()) {
            if(bstNode.getRight() != null && bstNode.getLeft() == null) {
                cont++;
                cont += insideNodes(bstNode.getRight());
            } if (bstNode.getRight() == null && bstNode.getLeft() != null) {
                cont++;
                cont += insideNodes(bstNode.getLeft());
            } if (bstNode.getRight() != null && bstNode.getLeft() != null) {
                cont++;
                cont += insideNodes(bstNode.getRight());
                cont += insideNodes(bstNode.getLeft());
            }
        }
                return cont;
    }

public static void main(String[] args) {
    BSTInteger bst = new BSTInteger();
    BSTInternalNodes a = new BSTInternalNodes();
    bst.insert(10);
    bst.insert(8);
    bst.insert(1);
    bst.insert(9);
    bst.insert(20);
    bst.insert(18);
    bst.insert(25);

   System.out.println(a.insideNodes(bst));

}
}