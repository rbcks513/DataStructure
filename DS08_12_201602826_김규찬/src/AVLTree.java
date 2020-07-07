public class AVLTree {
	private int key, height;
	private AVLTree left, right;
	public static final	AVLTree NIL = new AVLTree();
	public AVLTree(int key) {
		this.key = key;
		left = right = NIL;
	}
	public boolean add(int key) {
		int oldSize = size();
		grow(key);
		return size() > oldSize;
	}

	public AVLTree grow(int key) {
		if(this == NIL) return new AVLTree(key);
		if(key == this.key) return this;
		if(key < this.key) left = left.grow(key);
		else right =right.grow(key);
		rebalance();
		height = 1 + Math.max(left.height,right.height);
		return this;
	}
	

	public AVLTree remove(int t) { //Ű�� t
		this.height = this.height();	
		AVLTree TL = this.left;
		AVLTree TR = this.right;
		AVLTree Temp; //�ӽ� ����
		
		if(t == this.key) { //�Է¹��� Ű���� �ش� ��Ʈ�� ���� ��� 
			if(TR != NIL) { //������ �ڽ��� �ִ� ���, �����ڽ��� ����
				int minimumkey = this.minimum(TR).key; //������ �ڽ��� �ּҰ��� 
				this.key = minimumkey; //�ڽ��� Ű������ ����
				if(TR.left== NIL) {//TR�� TRƮ���� �ּڰ��� ���
					this.right = this.right.right; //TR ����
					this.height = this.height(); //���� �缳��
					rebalance(); 
					return this; // 
				}
				else {TR.remove(minimumkey); //������ �ڽ��� Ʈ������ �ּڰ� ����
					return this;
				}
			}
			else if(TL != NIL) { //�ڱ� �ڽ��� �����ϴ� ��
				this.key = TL.key; //Ű���Ű� �ް� 
				Temp = this.left.right; //�ӽ�����
				this.left = this.left.left; //����Ʈ ������ ����
				this.right = Temp; //�ӽ� �� ����
				this.height = this.height(); //���� �缳��
				rebalance();
				return this;
			}
			else { //�ڽ��� �ֻ��� ���̸� �ڽ��� ���� ���
				key = 0;
				return this;
			}
		}
		if(t < this.key) { 
			if(t == TL.key) { //Ž������  �ڽ��� �����ϰ�� ���� ����
				if(TL.left == NIL && TL.right ==NIL) {
					this.left = NIL;
					this.height= this.height(); //���� �缳��
					return this.left; //�ٲ� �� ����
				}
			}
			left.remove(t); // Ű���� ���� ��ȯŽ��	
		}
		if(t > this.key) {
			if(t == TR.key) { //Ž������  �ڽ��� �����ϰ�� ���� ����
				if(TR.left == NIL && TR.right ==NIL) {
					this.right = NIL;
					this.height = this.height(); //���� �缳��			
					return this.right; //�ٲ� �� ����
				}
			}
			right.remove(t);
		}
		rebalance(); //���������� �߷��� �����ֱ� 
		//������ ���� ��ȭ üũ�ϱ�  height = 1 + Math.max(left.height,right.height);
		return this;
	}
	
	
	public AVLTree minimum(AVLTree Node) { //���� ���� ����  Ʈ���� ���� ���ʿ� �����Ѵ�.
		if(Node.left == NIL) return Node; //�ڽ��� ���� �ڽ��� ���� ��� �ڽ��� ���� ���� ���̴�.
		return Node.minimum(Node.left);		

	}
	
	public int height() { //rebalance�޼ҵ带 ����ϱ� ���ؼ� ���������� ���̸� Ȯ���ؾ��Ѵ�. 
		if(this == NIL) return -1;
		if(this.left == NIL && this.right == NIL) {
			return 0;
		}
		int rightHeight = this.right.height();
		int leftHeight = this.left.height();
		int max;
		if(rightHeight > leftHeight) max =rightHeight;
		else max = leftHeight;
		return max + 1;
	}
		

	//���� �־��� ������ ���� 
	
	public int size() {
		if (this == NIL) return 0;
		return 1 + left.size() + right.size();
	}
 	public String toString() {
		if(this == NIL) return "";
		return left + " " + key + right;
	}

	
	private AVLTree() {
		left = right = this;
		height = -1;
	}
	
	private AVLTree(int key, AVLTree left,AVLTree right) {
		this.key = key;
		this.left = left;
		this.right = right;
		height = 1 + Math.max(left.height,right.height);
	}
	
	private void rebalance() {
		if(right.height > left.height+1) {
			if (right.left.height > right.right.height)
				right.rotateRight();
			rotateLeft();
		}
		else if (left.height > right.height+1) {
			if(left.right.height > left.left.height) left.rotateLeft();
			rotateRight();
		}
	}
	
	
	private void rotateLeft() {
		left = new AVLTree(key,left,right.left);
		key = right.key;
		right = right.right;
	}
	
	private void rotateRight() {
		right = new AVLTree(key,left.right,right);
		key = left.key;
		left = left.left;
	}
}
