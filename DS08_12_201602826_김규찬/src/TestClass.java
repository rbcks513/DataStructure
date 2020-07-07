public class TestClass {
	public static void main(String args[]) {
		
		AVLTree Tree = new AVLTree(14);
		
		System.out.println("Check add 17 "+Tree.add(17));
		System.out.println("Check add 11 "+Tree.add(11));
		System.out.println("Check add  7 "+Tree.add(7));
		System.out.println("Check add 53 "+Tree.add(53));
		System.out.println("Check add  4 "+Tree.add(4));
		System.out.println("Check add 13 "+Tree.add(13));
		System.out.println("Check add 12 "+Tree.add(12));
		System.out.println("Check add  8 "+Tree.add(8));
		System.out.println("Check Tree" + Tree.toString()+"\n");
		
	
		System.out.println("");
		
		Tree.remove(53);
		System.out.println("53 삭제 : "+Tree.toString()+ " 높이 : " +Tree.height());
		System.out.println("");
		
		Tree.remove(11);
		System.out.println("11 삭제 : "+Tree.toString()+ " 높이 : " +Tree.height());
		System.out.println("");
		
		Tree.remove(7);
		System.out.println(" 7 삭제 : "+Tree.toString()+ " 높이 : " +Tree.height());
		System.out.println("");
		
		Tree.remove(12);
		System.out.println("12 삭제 : "+Tree.toString()+ " 높이 : " +Tree.height());
		System.out.println("");
		
		Tree.remove(14);
		System.out.println("14 삭제 : "+Tree.toString()+ " 높이 : " +Tree.height());
		System.out.println("");
		
		Tree.remove(13);
		System.out.println("13 삭제 : "+Tree.toString()+ " 높이 : " +Tree.height());
		System.out.println("");
		
	}
}
