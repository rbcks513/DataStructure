public class BinaryTree {
	private int key;
	private BinaryTree left, right;
	
	
	public BinaryTree() {
		
	}
	public BinaryTree(int key) {
		this.key = key;
	}
	
	public BinaryTree(int key,BinaryTree left,BinaryTree right) {
		this(key);
		if( left != null ) this.left = left;
		if (right != null) this.right = right;
	}
	
	public void insert(int x) {
		if(this.key > x) {
			if(this.left == null) left = new BinaryTree(x);
			else left.insert(x); //recursion을 이용하여 아래로 내려가도록 
		}
		if(this.key < x) {
			if(this.right == null) right = new BinaryTree(x);
			else right.insert(x); //recursion을 이용하여 아래로 내려가도록 
		}
		// if(this.key == x) 할 필요가 없다
	}
	public void postorder() {
		if(this.left != null) this.left.postorder(); //왼쪽 먼저 순회 
		
		if(this.right != null) this.right.postorder(); //왼쪽 순회우 오른쪽 순회
		
		System.out.println("key " + this.key+ " is visited");
		
	}
	
	
	public int height() {
		if (this.right == null&&this.left==null) return 0; //가장 높은 루트의 높이가 0이므로  
		if (this.right != null) {
			if(this.left != null) { //R과 L모두 null이 아닐 떄 
				if(this.right.height() > this.left.height()) {
					return this.right.height()+1;
				}
				else return this.left.height()+1;	
			}
			else return this.right.height()+1; 
		}
		else return this.left.height()+1;	
	}
}
