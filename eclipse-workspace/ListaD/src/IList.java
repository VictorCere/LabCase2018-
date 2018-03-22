public interface IList {

	public void addFirst(Integer newElem);

	public void addLast(Integer newElem);

	public void removeFirst();

	public void removeLast();
	
	public void insertAt(int index, Integer newElem);
	
	public boolean isEmpty();

	public boolean contains(Integer elem);

	public int getSize();

	public int getIndexOf(Integer elem);

	public Integer getFirst();

	public Integer getLast();

	public Integer getAt(int index);

	public void removeAll(Integer elem);

	public void removeAt(int index);

}


