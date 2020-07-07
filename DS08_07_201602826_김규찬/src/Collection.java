
public interface Collection {
	public boolean add(Object object); //Collection에 값을 더해주는 메소드
	public boolean isEmpty(); //Collection이 비어있나 확인하는 메소드
	public Iterator iterator(); //반복자
	public boolean remove(Object object); //값을 찾아서 삭제해주는 메소드
	public int size(); //사이즈를 반환하는 메소드
	public int frequency(Object object); //for문에서  get(i)를 이용하여 반복하는 반복문
	public int frequency2(Object object); //for문에서 Iterator를 이용하는 반복문
}
