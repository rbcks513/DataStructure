import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class TestClass {

	public static void main(String[] args) {
		
		Collection bag = new LinkedCollection(); //이론 수업 예제를 이용 collection 생성
		
		try {
			BufferedReader br = new BufferedReader(new FileReader("text.txt"));
			while(br.ready()) { //파일에 읽을 수 있는 데이터가 남아있는지 확인 
			String line = br.readLine(); //파일에서 데이터를 한 줄 읽음
			StringTokenizer parser = new StringTokenizer(line," ,:;-.?!");
			//공백을 포함 특수문자 기준 문자열 line자룸
			while(parser.hasMoreTokens()) {//parser에 토큰이 남아있는지 확인
				String word = parser.nextToken();//토큰 하나 하나를 넣어준다.
				bag.add(word); //토큰 하나하나 bag에 넣어준다.
				}}
				br.close();
			//즉 한줄씩 읽어가며 문장 한 줄을 공백과 특수문자로 나누어서 bag에 넣어준다. 	
			}catch(IOException e) {System.out.println(e); } 
		
		
		long beforeTime = System.currentTimeMillis();
		//어전 순차 탑색과 이진 탐색의 속도를 비교하는 과제에서 가져왔다.
		System.out.println("frequency메소드로 정해진 값 빈도 수 구별");
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
		System.out.println("frequncy메소드 걸린 시간 : "+ secTime +"ms");
		System.out.println("");
		System.out.println("------------------------------------------");
		System.out.println("");
		beforeTime = System.currentTimeMillis();
		System.out.println("frequency2메소드로 정해진 값 빈도 수 구별");
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
		System.out.println("frequency2메소드 걸린 시간 : "+secTime + "ms");
		
		
		
		
	}
	
}
