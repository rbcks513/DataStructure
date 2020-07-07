public class Recursion2 { //���� 3��
	public static void main(String[] args) {
		
		//�迭 ����� 
		int[] a = new int[100];
		for(int i = 0; i <a.length ; i++) {
		//0 ~ 1000 ������ �������� ���� ���� ����� ����  
			 a[i] = (int)(1000*Math.random());
		}
		
		//�迭 ���������� �����ϱ� 
		int k  = 0; //���� �ӽ÷� ������ �ӽ� ���� 
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] > a[j]) {
                    // ������ ���� ���ؼ� ���� ���� �ڿ� ������ �յڰ��� �ٲ۴�
                    k = a[i];
                    a[i] = a[j];
                    a[j] = k;
                }
            }	    
        }
		//�迭 Ȯ�� 
		for(int i = 0; i < a.length/10; i++) {
			for(int j = 0; j < 10; j++ ) {
				System.out.print(a[10*i + j] + " ");
			}
			System.out.println();
		}
		//���� Ž�� �� ��� 
		int answer = BinarySearch(a,90,0,99);
		if (answer == -1) System.out.println("�迭 �� Ÿ�� ���� �����ϴ�.");
		else System.out.println("a["+answer+"] �� ���� �����մϴ�.");
		}
	
	// ���� Ž�� �޼ҵ� 
	static int BinarySearch(int[] a, int x, int low, int high) {
			if(high < low) return -1; // �迭�� ���� ���� ���
			int i = (low + high)/2; 
			if (a[i] == x) return i;
			
			if (a[i] < x) return BinarySearch(a, x, i+1, high);
			else return BinarySearch(a, x, low, i-1);
	}
}
