package cola;
	

public interface IStack <T> {

	void push(T elemento);
	public T pop();
	public T top();
	public boolean isEmpty();
	
	
}