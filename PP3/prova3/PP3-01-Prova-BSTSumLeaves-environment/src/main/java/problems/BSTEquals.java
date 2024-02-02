package problems;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import adt.bst.BST;
import adt.bt.BTNode;

public class BSTEquals {
    public boolean bstEquals(BST<Integer> tree1, BST<Integer> tree2) {
        if(tree1.isEmpty() && tree2.isEmpty()) {
            return true;
        } else if(!tree1.isEmpty() && !tree2.isEmpty()) {
            return bstEquals(tree1.getRoot(), tree2.getRoot());
        }
        else {
            return false;
        }
    }

    private boolean bstEquals(BTNode<Integer> nodeTree1, BTNode<Integer> nodeTree2) {
        boolean resultado = false;
        
        if(!nodeTree1.isEmpty() && !nodeTree2.isEmpty()) {
                if(nodeTree1.equals(nodeTree2)) {
                    if(nodeTree1.getLeft() != null && nodeTree2.getLeft() != null) {
                        resultado = bstEquals(nodeTree1.getLeft(), nodeTree2.getLeft());
                    }   
                    if (nodeTree1.getRight() != null && nodeTree2.getRight() != null) {
                        resultado =  bstEquals(nodeTree1.getRight(), nodeTree2.getRight()); 
                    }
                }
        }  if (nodeTree1.isEmpty() && nodeTree2.isEmpty()) {
            resultado = true;
        } 
        return resultado; 
    }
public static void main(String[] args) {
    BSTInteger bst = new BSTInteger();
    BSTInteger bst_2 = new BSTInteger();
    BSTEquals equals = new BSTEquals();
    
    bst.insert(2);
    bst.insert(1);
    bst.insert(3);


    bst_2.insert(2);
    bst_2.insert(1);
    bst_2.insert(3);

    assertFalse(equals.bstEquals(bst, bst_2));
}

}
