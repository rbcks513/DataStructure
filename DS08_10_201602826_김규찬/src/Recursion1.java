
public class Recursion1 { //���� 1��, 2��
	
	private int h; //���� 2���� ������ Ƚ���� ǥ���� ���� h;
	public Recursion1() { //������ 
		this.h =0; //h�� 0���� �ʱ�ȭ 
	}
	
	public String moonjae1(int i) {
		if (i == 1) return "1"; //���� �����Ͽ��� ���� Ż�� ����
		h++; //�Լ��� ���� Ƚ�� �� ���� Ƚ��
		if( i % 2 == 0) return moonjae1(i/2) + "0" ; 
		else return moonjae1(i/2) + "1" ; 
	}
	
	public int moonjae2() { //������ Ƚ�� ��� 
		return h;
	}

	public int moonjae2(int i) { //������ Ƚ�� ��� 
		this.h = 0; //�ٸ� ���� ���� �޾Ƶ� ���� ������ �� �ְ�
		moonjae1(i); //���� 1�� ����
		return h;
	}
}
