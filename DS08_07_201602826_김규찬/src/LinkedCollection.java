public class LinkedCollection extends AbstractCollection{
	
	private static class Node {
		Object object;
		Node prev, next; 
	
		Node() {prev = next = this;}
		Node(Object o, Node p, Node n)
		{object = o; prev = p; next = n;}
	}
	
	private int size;
	private Node head = new Node(); //���Ի����� �ܼ�ȭ�ϱ� ���� �� �ص� ��� ����
	
	
	public boolean add(Object object) {
		head.prev = head.prev.next = new
				Node(object, head.prev,head);
		++size;
		return true; //no object is rejected 
	}

	public Iterator iterator() {
		return new Iterator() { //��øŬ����(anonymous inner class)
			private Node cursor = head.next;//head���� head�� ����Ű�� �κ�, �������� ���� ������
		
			private boolean okToRemove = false;
			public boolean hasNext() {return cursor!= head;}
			
			public Object next() { 
				if(cursor == head) throw new RuntimeException(); //��������� ���� ó��
				okToRemove = true; //���� ���ɿ��� 
				Object object = cursor.object;
				cursor = cursor.next;
				return object;
			}
			
			public void remove() {
				if(!okToRemove) throw new IllegalStateException(); //���� ���ɿ��� Ȯ��
				cursor.prev = cursor.prev.prev;
				cursor.prev.next = cursor;
				--size;
				okToRemove = false;//�⺻�� false�� ����
				//must call next() again before remove()
 			}	
		};
	}
	
	public int size() {return size;}
	public Object get(int i)  {//��忡�� i��° ���� �������� �޼ҵ� 
		Node n = head; //����ִ� �����̹Ƿ� 
		for(int j = 0; j < i; j++) {
				 n = n.next; //
		}
		return n.object;
	}
public int frequency(Object object) { //�Է¹��� ���� ��� ���� ���ϱ� ���� 
	int fr =0;
	for(int i = 0; i< size; i++ ) {
		if(object.equals(get(i))) fr++;
	}
	return fr;
}
public int frequency2(Object object) {
	int fr =0;
	for(Iterator it = this.iterator();it.hasNext();) {
		if(object.equals(it.next())) fr++;
		}
	return fr;
	}
}
