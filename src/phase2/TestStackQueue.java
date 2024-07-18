package phase2;

public class TestStackQueue {

	public static void main(String[] args) {

		StackQueue<Integer> list=new StackQueue<>();

		list.push(3);
//		list.print();

		list.push(4);
//		list.print();

		list.push(2);
//		list.print();

		list.push(1);
		list.print();

		System.out.println("\n");
		System.out.println(list.peek());

		System.out.println("\n");
		System.out.println(list.pop());
		System.out.println("\n");
		list.print();

		System.out.println("\n");
		System.out.println(list.peek());
	}

}
