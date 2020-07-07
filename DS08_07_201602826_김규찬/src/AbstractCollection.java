
public abstract class AbstractCollection implements Collection {

	protected AbstractCollection() {}
	@Override
	public boolean add(Object object) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();	
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return (size() == 0);
	}

	@Override
	public abstract Iterator iterator();

	@Override
	public boolean remove(Object object) {
		// TODO Auto-generated method stub
		Iterator it = iterator(); //iterator은 데이터 타입의 영향을 밪지 않는다. 
		if(object == null) while(it.hasNext()) {
			if(it.next() == null) {
				it.remove();
				return true;
			}
		}
		else while(it.hasNext()) {
			if(object.equals(it.next())) {
				it.remove();
				return true;
			}
		}
		return false;
	}

	@Override
	public abstract int size();

	@Override
	public abstract int frequency(Object object);
	@Override
	public abstract int frequency2(Object object);

}
