package phase2;

public class TestLinkedList {

	public static void main(String[] args) {

		SLinkedList<Integer>list=new SLinkedList<>();

		list.insert(55);
		System.out.println(list.getTail());
		list.insert(50);
		System.out.println(list.getTail());
		list.insert(65);
		System.out.println(list.getTail());
		list.insert(60);
		System.out.println(list.getTail());
		list.insert(99);
		System.out.println(list.getTail());

		list.traverse();


//		list.delete(50);
//		System.out.println(list.getTail());
//
//		list.delete(60);
//		System.out.println(list.getTail());
//
//		list.delete(99);
//		System.out.println(list.getTail());
//		System.out.println("\n");
//		System.out.println(list.lengthI());
//		System.out.println(list.lengthR());

//		list.reverseI();
//		list.traverse();

//		System.out.println("\n");
//		list.insert(55);
//		list.traverse();
//
//		System.out.println("\n");
//		list.delete(55);
//		list.traverse();
//
//		System.out.println("\n");
//		list.delete(75);
//		list.traverse();

//		System.out.println("\n");
//
//		list.delete(99);
//		list.traverse();
//


//		System.out.println(list.find(55));
//		System.out.println(list.find(75));

//		list.reverseR();
//		list.traverse();

//		list.delete(60);
//		list.delete(99);
//		list.traverse();

	}

}
