public class Recursion2 { //문제 3번
	public static void main(String[] args) {
		
		//배열 만들기 
		int[] a = new int[100];
		for(int i = 0; i <a.length ; i++) {
		//0 ~ 1000 사이의 순차적인 랜덤 값을 만들기 위해  
			 a[i] = (int)(1000*Math.random());
		}
		
		//배열 순차적으로 정돈하기 
		int k  = 0; //값을 임시로 저장할 임시 변수 
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] > a[j]) {
                    // 내부의 값을 비교해서 작은 값이 뒤에 있으면 앞뒤값을 바꾼다
                    k = a[i];
                    a[i] = a[j];
                    a[j] = k;
                }
            }	    
        }
		//배열 확인 
		for(int i = 0; i < a.length/10; i++) {
			for(int j = 0; j < 10; j++ ) {
				System.out.print(a[10*i + j] + " ");
			}
			System.out.println();
		}
		//이진 탐색 후 결과 
		int answer = BinarySearch(a,90,0,99);
		if (answer == -1) System.out.println("배열 내 타겟 값이 없습니다.");
		else System.out.println("a["+answer+"] 에 값이 존재합니다.");
		}
	
	// 이진 탐색 메소드 
	static int BinarySearch(int[] a, int x, int low, int high) {
			if(high < low) return -1; // 배열에 값이 없는 경우
			int i = (low + high)/2; 
			if (a[i] == x) return i;
			
			if (a[i] < x) return BinarySearch(a, x, i+1, high);
			else return BinarySearch(a, x, low, i-1);
	}
}
