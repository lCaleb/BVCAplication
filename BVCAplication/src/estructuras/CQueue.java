package estructuras;



public interface CQueue<E> {

	 public boolean offer(E e);
	 public E poll();
	 public E peek();
	 public int size();
	 public boolean isEmpty();
	 public boolean contains(E e);
	 public E get(int i);
}

