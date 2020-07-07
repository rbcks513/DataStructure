
public class TestClass { //문제 1번 2번

	public static void main(String[] args) {
		Recursion1 self = new Recursion1();
		
		System.out.println("17을 2진수로 바꾸면");
		System.out.println(self.moonjae1(17));
		
		System.out.println("17을 2진수로 바꿀 때 나누는 횟수");
		System.out.println(self.moonjae2());
		
		System.out.println("33을 2진수로 바꿀 떄 나누는 횟수");
		System.out.println(self.moonjae2(33));
	}

}
