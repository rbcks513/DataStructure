
public interface Collection {
	public boolean add(Object object); //Collection�� ���� �����ִ� �޼ҵ�
	public boolean isEmpty(); //Collection�� ����ֳ� Ȯ���ϴ� �޼ҵ�
	public Iterator iterator(); //�ݺ���
	public boolean remove(Object object); //���� ã�Ƽ� �������ִ� �޼ҵ�
	public int size(); //����� ��ȯ�ϴ� �޼ҵ�
	public int frequency(Object object); //for������  get(i)�� �̿��Ͽ� �ݺ��ϴ� �ݺ���
	public int frequency2(Object object); //for������ Iterator�� �̿��ϴ� �ݺ���
}
