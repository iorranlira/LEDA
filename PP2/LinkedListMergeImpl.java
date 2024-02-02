public class LinkedListMergeImpl<T extends Comparable<T>>{
    public SingleLinkedListNode merge(SingleLinkedListNode node1, SingleLinkedListNode node2) {
		SingleLinkedListNode head = new SingleLinkedListNode();
        SingleLinkedListNode auxHead = head;

        while(node1 != null && node2 != null){
            if(node1.getData() < node2.getData()){
                auxHead.setNext(node1);
                node1 = node1.getNext();
            } else {
                auxHead.setNext(node2);
                node2 = node2.getNext();
            } 
                auxHead = auxHead.getNext();
        }

        while(node1 != null){
            auxHead.setNext(node1);
            node1 = node1.getNext();
            auxHead = auxHead.getNext(); 
        }
    
        while(node2 != null){
            auxHead.setNext(node2);
            node2 = (node2.getNext());
            auxHead = auxHead.getNext();
        }
            return head.getNext(); 
    }

public static void main(String[] args) {
    LinkedListMergeImpl a = new LinkedListMergeImpl<>();
    
    
    //lista 1
    SingleLinkedListNode node1_1 = new SingleLinkedListNode(1, null);
    SingleLinkedListNode node1_2 = new SingleLinkedListNode(3, null);
    SingleLinkedListNode node1_3 = new SingleLinkedListNode(5, null);
    node1_1.setNext(node1_2);
    node1_2.setNext(node1_3);   


    //lista2
    SingleLinkedListNode node2_1 = new SingleLinkedListNode(2, null);
    SingleLinkedListNode node2_2 = new SingleLinkedListNode(4, null);
    SingleLinkedListNode node2_3 = new SingleLinkedListNode(6, null);
    node2_1.setNext(node2_2);
    node2_2.setNext(node2_3);

    SingleLinkedListNode b = a.merge(node1_1, node2_1);
    System.out.println(b.getNext().getNext());

}
}