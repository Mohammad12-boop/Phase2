package phase2;

public class TestBST {
	public static void main(String[] args) {

		BSTree <Integer> tree=new BSTree<>();

		tree.insert(10);
		tree.insert(5);
		tree.insert(20);
		tree.insert(3);
		tree.insert(7);
		tree.insert(15);
		tree.insert(25);

		tree.traverseInOrder();

		System.out.println("\n");

		tree.traversePreOrder();

		System.out.println("\n");

		tree.traverseLevelOrder();

//		tree.delete(55);
//		tree.traverseInOrder();

//		System.out.println(tree.size());
//
//		System.out.println("\n");
//
//		tree.insert(45);
//
//		tree.traverseInOrder();
//
//		System.out.println("\n");
//		System.out.println(tree.size());
	}



}
