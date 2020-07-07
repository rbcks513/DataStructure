public class LinkedCollection extends AbstractCollection{
	
	private static class Node {
		Object object;
		Node prev, next; 
	
		Node() {prev = next = this;}
		Node(Object o, Node p, Node n)
		{object = o; prev = p; next = n;}
	}
	
	private int size;
	private Node head = new Node(); //삽입삭제를 단순화하기 위해 빈 해드 노드 생성
	
	
	public boolean add(Object object) {
		head.prev = head.prev.next = new
				Node(object, head.prev,head);
		++size;
		return true; //no object is rejected 
	}

	public Iterator iterator() {
		return new Iterator() { //중첩클래스(anonymous inner class)
			private Node cursor = head.next;//head다음 head가 가르키는 부분, 실직적인 값을 가지는
		
			private boolean okToRemove = false;
			public boolean hasNext() {return cursor!= head;}
			
			public Object next() { 
				if(cursor == head) throw new RuntimeException(); //비어있을때 예외 처리
				okToRemove = true; //삭제 가능여부 
				Object object = cursor.object;
				cursor = cursor.next;
				return object;
			}
			
			public void remove() {
				if(!okToRemove) throw new IllegalStateException(); //삭제 가능여부 확인
				cursor.prev = cursor.prev.prev;
				cursor.prev.next = cursor;
				--size;
				okToRemove = false;//기본값 false로 설정
				//must call next() again before remove()
 			}	
		};
	}
	
	public int size() {return size;}
	public Object get(int i)  {//노드에서 i번째 값을 가져오는 메소드 
		Node n = head; //비어있는 공간이므로 
		for(int j = 0; j < i; j++) {
				 n = n.next; //
		}
		return n.object;
	}
public int frequency(Object object) { //입력받은 값과 노드 값을 비교하기 위해 
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
