
public class TestClass2 { //문제3번 

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree BT1 = new BinaryTree(); //객체 생성
		
		int[] a = {1,3,5,7,9};
		for(int i =0; i<a.length;i++) {
			if(i==0) BT1 = new BinaryTree(a[i]); //key값 설정의해서 생성자 재호출
			BT1.insert(a[i]);
		}

		BT1.postorder();
		System.out.println("TreeHight : "+BT1.height());
		
		BinaryTree BT2 = new BinaryTree();
		
		int[] b = {77, 44, 55, 99, 33, 66, 88, 22};
		for(int i =0; i<b.length;i++) {
			if(i==0) BT2 = new BinaryTree(b[i]); //key값 설정의해서 생성자 재호출
			BT2.insert(b[i]);
		}
		
		BT2.postorder();
		System.out.println("TreeHight : "+BT2.height());
			
	}
}
