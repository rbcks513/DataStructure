import java.util.*;

public class TestClass1 { //���� 1���� 2��

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//���� Ʈ�� ������ �����ϱ� ���ؼ��� ������ ���� �����ڸ� ƭ�� �����ϰ� 
		//�Ŀ� ��Ʈ�� �����ذ��鼭 �ۼ��Ѵ�.
		OrderedTree tree_77 , tree_44, tree_33, tree_55, tree_99; 
		
		
		//������ ����
		OrderedTree tree_22 = new OrderedTree(22); //������ ���� �����Ͽ��� 
		OrderedTree tree_66 = new OrderedTree(66);
		OrderedTree tree_88 = new OrderedTree(88);
		
		//level 2;
		List<OrderedTree> subtreesof_33 = new LinkedList<OrderedTree>();
		subtreesof_33.add(tree_22);
		tree_33 = new OrderedTree(33,subtreesof_33);
		
		List<OrderedTree> subtreesof_55 = new LinkedList<OrderedTree>();
		subtreesof_55.add(tree_66);
		tree_55 = new OrderedTree(55,subtreesof_55);
		
		
		//level 1;
		List<OrderedTree> subtreesof_99 = new LinkedList<OrderedTree>();
		subtreesof_99.add(tree_88);
		tree_99 = new OrderedTree(99,subtreesof_99);
		
		List<OrderedTree> subtreesof_44 = new LinkedList<OrderedTree>();
		subtreesof_44.add(tree_33);
		subtreesof_44.add(tree_55);
		tree_44 = new OrderedTree(44,subtreesof_44);
		
		//level 0;
		List<OrderedTree> subtreesof_77 = new LinkedList<OrderedTree>();
		subtreesof_77.add(tree_44);
		subtreesof_77.add(tree_99);
		tree_77 = new OrderedTree(77,subtreesof_77);
		
		tree_77.levelorder(); //���� ��ȸ�� �Ͽ��� �� 
	}

}
