public class PolindromeLinkedList {
    
    public SingleLinkedListNode findMiddle(SingleLinkedListNode head) {
        if(head == null) return null;

        SingleLinkedListNode ponteiro1 = head;
        SingleLinkedListNode ponteiro2 = head;

        while(ponteiro2 != null & ponteiro2.getNext() != null){
            ponteiro1 = ponteiro1.getNext();
            if(ponteiro2.getNext().getNext() != null){
                ponteiro2 = ponteiro2.getNext().getNext();
            } else {
                ponteiro2 = ponteiro2.getNext();
            }
        }       return ponteiro1;
    }


    public SingleLinkedListNode reverseNode(SingleLinkedListNode node) {
        if(node == null) return null;
        SingleLinkedListNode nextNode = new SingleLinkedListNode();
        SingleLinkedListNode currentNode = node;
        SingleLinkedListNode prevNode = new SingleLinkedListNode();
        
       while(currentNode != null) {
            nextNode = currentNode.getNext(); 
            currentNode.setNext(prevNode); 
            prevNode = currentNode; 
            currentNode = nextNode; 
       }
            node = prevNode; 
            return node;
    }

    public int findIndex(SingleLinkedListNode node) {
        int index = 0;
        while(node != null) {
            index += 1;
            node = node.getNext();
        }
        return index;
    }

    public boolean isPalindrome(SingleLinkedListNode node) {
        SingleLinkedListNode middle = findMiddle(node);
        boolean result = false;
        SingleLinkedListNode auxHead =  node;
        SingleLinkedListNode auxMiddle = middle;
        
        while(auxHead != middle && auxMiddle != null){
            if(auxHead.getData() == middle.getData()){
                result = true;
            }

            auxHead = auxHead.getNext();
            auxMiddle = auxMiddle.getNext();
        }
            return result;
    }
}
