package problems;

import java.util.LinkedList;
import java.util.Queue;

import adt.bst.BST;
import adt.bt.BTNode;

/**
 * BSTTwoSum
 */
public class BSTTwoSum {

    public boolean findTarget(BTNode<Integer> node, int k) {
        boolean resultado = false;
        
    
        int soma = emLargura(node) + node.getData();

        if(soma == k) {
            resultado = true;
        }
        else {
            if(hasLeft(node) && !node.getLeft().isEmpty())
                resultado = findTarget(node.getLeft(),k);
        }
        if(hasRight(node) && !node.getLeft().isEmpty()) {
            resultado = findTarget(node.getRight(), k);
        }   
    
        return resultado;
    }

 
    public Integer emLargura(BTNode<Integer> node) {
        BTNode<Integer> rootNode = node;
        Queue<BTNode<Integer>> queue = new LinkedList<BTNode<Integer>>();

        queue.add(rootNode);
        while(!queue.isEmpty()){
            BTNode<Integer> currentNode = queue.poll();
            currentNode.getData();  

            if(hasLeft(currentNode) && !currentNode.getLeft().isEmpty()) {
                queue.add(currentNode.getLeft());
            } if (hasRight(currentNode)) {
                queue.add(currentNode.getRight());
            }
                return currentNode.getData();
        }
        return null;


    }
    public boolean hasRight(BTNode<Integer> node) {
        return node.getRight() != null;
    }

    public boolean hasLeft(BTNode<Integer> node) {
        return node.getLeft() != null;
    }

    public static void main(String[] args) {
        BSTInteger bst = new BSTInteger();
        BSTTwoSum esse = new BSTTwoSum();
        bst.insert(5);
        bst.insert(3);
        bst.insert(6);
        bst.insert(2);
        bst.insert(4);
        bst.insert(7);

        System.out.println(esse.findTarget(bst.getRoot(), 9));
    }
}