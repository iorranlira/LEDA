package problems;

import java.util.LinkedList;
import java.util.Queue;

import adt.bst.BST;
import adt.bt.BTNode;

/**
 * BSTinBFS
 */
public class BSTinBFS {

    public void BFS(BST<Integer> tree1) {
        if(tree1.isEmpty()) return;
        else BFS(tree1.getRoot());
    }
    
    private void BFS(BTNode<Integer> root) {
        Queue<BTNode<Integer>> queue = new LinkedList<>();
        queue.add(root);
    
        while(!queue.isEmpty()) {

            BTNode aux = queue.remove();

            if(!aux.isEmpty()) {
            System.out.println(aux.getData());
            }

            if(aux.getLeft() != null) {
                queue.add(aux.getLeft());
            }

            if(aux.getRight() != null) {
                queue.add(aux.getRight());
            }
        }
    }

    public static void main(String[] args) {
        BSTInteger bst = new BSTInteger(); 
        BSTinBFS bfs = new BSTinBFS();

		bst.insert(10);
        bst.insert(8);
        bst.insert(1);
        bst.insert(9);
        bst.insert(20);
        bst.insert(18);
        bst.insert(25);
        
        bfs.BFS(bst);
    }
}
