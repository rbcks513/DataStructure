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
			else left.insert(x); //recursion�� �̿��Ͽ� �Ʒ��� ���������� 
		}
		if(this.key < x) {
			if(this.right == null) right = new BinaryTree(x);
			else right.insert(x); //recursion�� �̿��Ͽ� �Ʒ��� ���������� 
		}
		// if(this.key == x) �� �ʿ䰡 ����
	}
	public void postorder() {
		if(this.left != null) this.left.postorder(); //���� ���� ��ȸ 
		
		if(this.right != null) this.right.postorder(); //���� ��ȸ�� ������ ��ȸ
		
		System.out.println("key " + this.key+ " is visited");
		
	}
	
	
	public int height() {
		if (this.right == null&&this.left==null) return 0; //���� ���� ��Ʈ�� ���̰� 0�̹Ƿ�  
		if (this.right != null) {
			if(this.left != null) { //R�� L��� null�� �ƴ� �� 
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
