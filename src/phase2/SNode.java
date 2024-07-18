package phase2;

public class SNode <T extends Comparable<T>> { //Class Node for Single_Linked_List:

	private T data;
	private SNode<T> next;

	public SNode() {

		this.data=null;
	}

	public SNode(T data) {

		this.data=data;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public SNode<T> getNext() {
		return next;
	}

	public void setNext(SNode<T> next) {
		this.next = next;
	}

	@Override
	public String toString() {
		return this.data.toString();
	}

}
