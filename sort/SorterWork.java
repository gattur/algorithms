package sort;

public class SorterWork {

	public static void main(String[] args) {
		Sorter s = new Sorter();
		s.head = new LNode(5);
		s.head.setNext(new LNode(4));
		s.head.getNext().setNext(new LNode(3));
		s.head.getNext().getNext().setNext(new LNode(2));
		s.head.getNext().getNext().getNext().setNext(new LNode(1));
		s.head.getNext().getNext().getNext().getNext().setNext(new LNode(6));
		s.head.getNext().getNext().getNext().getNext().getNext().setNext(new LNode(7));
		s.head.getNext().getNext().getNext().getNext().getNext().getNext().setNext(new LNode(8));
		s.head.getNext().getNext().getNext().getNext().getNext().getNext().getNext().setNext(new LNode(9));
		LNode temp = s.mergeSorter();
		// System.out.println(" "+temp.getNext().getData());
		System.out.println("printin");
		while (temp != null) {
			System.out.println(temp.getData());
			temp = temp.getNext();

		}

	}
}
