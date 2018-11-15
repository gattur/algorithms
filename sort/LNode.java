package sort;

public class LNode {

	LNode next;
	int data;

	public LNode(int a) {
		data = a;
	}

	public LNode getNext() {
		return next;
	}

	public void setNext(LNode next) {
		this.next = next;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

}
