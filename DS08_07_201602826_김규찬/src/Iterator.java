
public interface Iterator {
	public boolean hasNext(); //반복자에 다음 값이 있으면 true를 반환합니다.
	public Object next(); //반복자에 다음 값을 반환합니다.
	public void remove(); // collection의 마지막으로 반복자에 의해 반환된 값의 밑에 있는 값을 제거 합니다.
}
