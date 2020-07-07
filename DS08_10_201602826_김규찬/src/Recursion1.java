
public class Recursion1 { //문제 1번, 2번
	
	private int h; //문제 2번의 나누는 횟수를 표시할 정수 h;
	public Recursion1() { //생성자 
		this.h =0; //h를 0으로 초기화 
	}
	
	public String moonjae1(int i) {
		if (i == 1) return "1"; //끝에 도달하였을 때의 탈출 조건
		h++; //함수에 들어온 횟수 즉 나눈 횟수
		if( i % 2 == 0) return moonjae1(i/2) + "0" ; 
		else return moonjae1(i/2) + "1" ; 
	}
	
	public int moonjae2() { //나누는 횟수 출력 
		return h;
	}

	public int moonjae2(int i) { //나누는 횟수 출력 
		this.h = 0; //다른 정수 값을 받아도 실행 가능할 수 있게
		moonjae1(i); //문제 1번 응용
		return h;
	}
}
