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
	

	public AVLTree remove(int t) { //키값 t
		this.height = this.height();	
		AVLTree TL = this.left;
		AVLTree TR = this.right;
		AVLTree Temp; //임시 공간
		
		if(t == this.key) { //입력받은 키값이 해당 루트의 값일 경우 
			if(TR != NIL) { //오른쪽 자식이 있는 경우, 왼쪽자식은 무관
				int minimumkey = this.minimum(TR).key; //오른쪽 자식의 최소값을 
				this.key = minimumkey; //자신의 키값으로 복사
				if(TR.left== NIL) {//TR이 TR트리의 최솟값인 경우
					this.right = this.right.right; //TR 삭제
					this.height = this.height(); //높이 재설정
					rebalance(); 
					return this; // 
				}
				else {TR.remove(minimumkey); //오른쪽 자식의 트리에서 최솟값 삭제
					return this;
				}
			}
			else if(TL != NIL) { //자기 자신을 삭제하는 것
				this.key = TL.key; //키값옮겨 받고 
				Temp = this.left.right; //임시저장
				this.left = this.left.left; //레프트 값먼저 연결
				this.right = Temp; //임시 값 연결
				this.height = this.height(); //높이 재설정
				rebalance();
				return this;
			}
			else { //자신이 최상위 값이며 자식이 없는 경우
				key = 0;
				return this;
			}
		}
		if(t < this.key) { 
			if(t == TL.key) { //탐색전에  자식이 리프일경우 먼저 삭제
				if(TL.left == NIL && TL.right ==NIL) {
					this.left = NIL;
					this.height= this.height(); //높이 재설정
					return this.left; //바뀐 곳 리턴
				}
			}
			left.remove(t); // 키값에 따라서 순환탐색	
		}
		if(t > this.key) {
			if(t == TR.key) { //탐색전에  자식이 리프일경우 먼저 삭제
				if(TR.left == NIL && TR.right ==NIL) {
					this.right = NIL;
					this.height = this.height(); //높이 재설정			
					return this.right; //바뀐 곳 리턴
				}
			}
			right.remove(t);
		}
		rebalance(); //지속적으로 발런스 맞춰주기 
		//삭제시 높이 변화 체크하기  height = 1 + Math.max(left.height,right.height);
		return this;
	}
	
	
	public AVLTree minimum(AVLTree Node) { //가장 작은 수는  트리의 가장 왼쪽에 존제한다.
		if(Node.left == NIL) return Node; //자신의 왼쪽 자식이 없는 경우 자신이 가장 작은 값이다.
		return Node.minimum(Node.left);		

	}
	
	public int height() { //rebalance메소드를 사용하기 위해서 지속적으로 높이를 확인해야한다. 
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
		

	//이하 주어진 교과서 참고 
	
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
