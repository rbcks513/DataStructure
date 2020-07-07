import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class TestClass {

	public static void main(String[] args) {
		
		Collection bag = new LinkedCollection(); //�̷� ���� ������ �̿� collection ����
		
		try {
			BufferedReader br = new BufferedReader(new FileReader("text.txt"));
			while(br.ready()) { //���Ͽ� ���� �� �ִ� �����Ͱ� �����ִ��� Ȯ�� 
			String line = br.readLine(); //���Ͽ��� �����͸� �� �� ����
			StringTokenizer parser = new StringTokenizer(line," ,:;-.?!");
			//������ ���� Ư������ ���� ���ڿ� line�ڷ�
			while(parser.hasMoreTokens()) {//parser�� ��ū�� �����ִ��� Ȯ��
				String word = parser.nextToken();//��ū �ϳ� �ϳ��� �־��ش�.
				bag.add(word); //��ū �ϳ��ϳ� bag�� �־��ش�.
				}}
				br.close();
			//�� ���پ� �о�� ���� �� ���� ����� Ư�����ڷ� ����� bag�� �־��ش�. 	
			}catch(IOException e) {System.out.println(e); } 
		
		
		long beforeTime = System.currentTimeMillis();
		//���� ���� ž���� ���� Ž���� �ӵ��� ���ϴ� �������� �����Դ�.
		System.out.println("frequency�޼ҵ�� ������ �� �� �� ����");
		System.out.println("America :" + bag.frequency("America"));
		System.out.println("answer :" + bag.frequency("answer"));
		System.out.println("where :" + bag.frequency("where"));
		System.out.println("disabled :" + bag.frequency("disabled"));
		System.out.println("believed :" + bag.frequency("believed"));
		System.out.println("we :" + bag.frequency("we"));
		System.out.println("We :" + bag.frequency("We"));
		System.out.println("free :" + bag.frequency("free"));
		long afterTime = System.currentTimeMillis();
		long secTime = (afterTime - beforeTime);
		System.out.println("frequncy�޼ҵ� �ɸ� �ð� : "+ secTime +"ms");
		System.out.println("");
		System.out.println("------------------------------------------");
		System.out.println("");
		beforeTime = System.currentTimeMillis();
		System.out.println("frequency2�޼ҵ�� ������ �� �� �� ����");
		System.out.println("America :" + bag.frequency2("America"));
		System.out.println("answer :" + bag.frequency2("answer"));
		System.out.println("where :" + bag.frequency2("where"));
		System.out.println("disabled :" + bag.frequency2("disabled"));
		System.out.println("believed :" + bag.frequency2("believed"));
		System.out.println("we :" + bag.frequency2("we"));
		System.out.println("We :" + bag.frequency2("We"));
		System.out.println("free :" + bag.frequency2("free"));
		afterTime = System.currentTimeMillis();
		secTime = (afterTime - beforeTime);
		System.out.println("frequency2�޼ҵ� �ɸ� �ð� : "+secTime + "ms");
		
		
		
		
	}
	
}
