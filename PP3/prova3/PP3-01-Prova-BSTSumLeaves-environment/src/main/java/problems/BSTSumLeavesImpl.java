package problems;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;

import adt.bst.BST;
import adt.bt.BTNode;

public class BSTSumLeavesImpl implements BSTSumLeaves{
	
    public int sumLeaves(BST<Integer> bst){
		int resultado = 0;
		if(!bst.isEmpty()) {
			resultado = sumLeaves(bst.getRoot());
		}
		return resultado; 
	}

	private int sumLeaves(BTNode<Integer> node) {
		int soma = 0;
		if(!node.isEmpty() && node != null) {
			if(node.isLeaf()) {
				soma += node.getData();
				soma += sumLeaves(node.getLeft());
				soma += sumLeaves(node.getRight());
			} else {
				soma += sumLeaves(node.getLeft());
				soma += sumLeaves(node.getRight());
			}
		} 
				return soma;
	}

public boolean isLeaf(BTNode<Integer> node) {
	return (node.getLeft() == null) && (node.getRight() == null);
}

	public static void main(String[] args) {
		BSTInteger bst = new BSTInteger();
		BSTInteger bst_2 = new BSTInteger();
		BSTSumLeavesImpl leavesImpl = new BSTSumLeavesImpl();

		bst.insert(10);
        bst.insert(8);
        bst.insert(1);
        bst.insert(9);
        bst.insert(20);
        bst.insert(18);
        bst.insert(25);

		System.out.println(leavesImpl.sumLeaves(bst)); //53

	}
}


