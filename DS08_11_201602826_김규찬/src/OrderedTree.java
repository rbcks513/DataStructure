import java.util.*;
public class OrderedTree {
	private Object root;
	private List<OrderedTree> subtrees; //���� 1�� �־��� �ʵ忡 ��
	//<OrderedTree>�� �߰��Ͽ� list��  Ÿ���� �������ش�. 
	private int size;

public OrderedTree() {	//��Ʈ�� �����
}
public OrderedTree(Object root) {
	this.root = root;
	subtrees = new LinkedList<OrderedTree>();
	size =  1;
}

public OrderedTree(Object root, List<OrderedTree> trees) { //���� 1��
	this(root); //���� �����ڸ� ����
	for(Iterator<OrderedTree> it = trees.iterator(); it.hasNext();) { //iterator�� tree�� �ҷ��´�. 
		Object object = it.next();	//�ҷ��� ���� object�� �־��ְ� 
		if(object instanceof OrderedTree) { //��ü�� ���¸� Ȯ��
			OrderedTree tree = (OrderedTree)object; //Ŭ������ ����
			subtrees.add(tree); //Ʈ���� ���ذ���. 
			size += size();
		}
		
	}
}
public int size() {
	return size;
}
public void levelorder() {
	Queue<OrderedTree> q = new LinkedList<OrderedTree>();
	String s = "���� ���� ��ȸ : ";
	q.add(this);
	while(!q.isEmpty()) { //ť�� ��� ���� �ʴ� ����
		OrderedTree level = (OrderedTree)q.poll(); //��ȸ�� ù��° �� ȣ�� 
		s = s + level.root +" - ";
		for(Iterator<OrderedTree> it = level.subtrees.iterator(); it.hasNext();) {
			q.add((OrderedTree)it.next());	
		}	
	}
	System.out.println(s+ "��");
}
}
