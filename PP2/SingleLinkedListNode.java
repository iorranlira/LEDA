public class SingleLinkedListNode {
	protected Integer data;
	protected SingleLinkedListNode next;

	/**
	 * Constructor of an empty (NIL) node
	 */
	public SingleLinkedListNode() {
	}

	public SingleLinkedListNode(Integer data, SingleLinkedListNode  next) {
		this.data = data;
		this.next = next;
	}

	public Integer getData() {
		return data;
	}

	public SingleLinkedListNode getNext() {
		return next;
	}

	public boolean isNIL() {
		return this.data == null;
	}

	@Override
	public String toString() {
		String resp = null;
		if (!isNIL()) {
			resp = this.data.toString();
		} else {
			resp = "NIL";
		}
		return resp;
	}

	// @SuppressWarnings("unchecked")
	// @Override
	// public boolean equals(Object obj) {
	// 	boolean resp = false;
	// 	if (obj instanceof SingleLinkedListNode) {
	// 		if (!this.isNIL()) {
	// 			resp = this.data.equals(((SingleLinkedListNode<T>) obj).data);
	// 		} else {
	// 			resp = ((SingleLinkedListNode<T>) obj).isNIL();
	// 		}

	// 	}
	// 	return resp;
	// }

	public void setData(Integer data) {
		this.data = data;
	}

	public void setNext(SingleLinkedListNode next) {
		this.next = next;
	}


}