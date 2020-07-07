import java.util.*;
public class OrderedTree {
	private Object root;
	private List<OrderedTree> subtrees; //문제 1로 주어진 필드에 에
	//<OrderedTree>만 추가하여 list의  타입을 설정해준다. 
	private int size;

public OrderedTree() {	//빈트리 만들기
}
public OrderedTree(Object root) {
	this.root = root;
	subtrees = new LinkedList<OrderedTree>();
	size =  1;
}

public OrderedTree(Object root, List<OrderedTree> trees) { //문제 1번
	this(root); //위의 생성자를 포함
	for(Iterator<OrderedTree> it = trees.iterator(); it.hasNext();) { //iterator로 tree를 불러온다. 
		Object object = it.next();	//불러온 값을 object에 넣어주고 
		if(object instanceof OrderedTree) { //객체의 형태를 확인
			OrderedTree tree = (OrderedTree)object; //클래스로 만듦
			subtrees.add(tree); //트리를 더해간다. 
			size += size();
		}
		
	}
}
public int size() {
	return size;
}
public void levelorder() {
	Queue<OrderedTree> q = new LinkedList<OrderedTree>();
	String s = "레벨 순서 순회 : ";
	q.add(this);
	while(!q.isEmpty()) { //큐가 비어 있지 않는 동안
		OrderedTree level = (OrderedTree)q.poll(); //순회의 첫번째 값 호출 
		s = s + level.root +" - ";
		for(Iterator<OrderedTree> it = level.subtrees.iterator(); it.hasNext();) {
			q.add((OrderedTree)it.next());	
		}	
	}
	System.out.println(s+ "끝");
}
}
