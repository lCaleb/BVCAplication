package cola;



public class CList<E> implements CQueue<E> {
	
	
	public class Node<E> {

		public E elemento;

		public Node<E> siguiente;

		public Node(E elemento) {
			this.elemento = elemento;

			siguiente = null;
		}
	}

	private int size;
	private Node<E> cabeza;
	private Node<E> ultimoAgregado;


	public CList() {
		cabeza = null;
		size = 0;
	}


	/// métodos de la lista

	public void add(E elemento) {
		Node<E> nuevo = new Node(elemento);

		if (isEmpty()) {
			cabeza = nuevo;
			ultimoAgregado= cabeza;
			size++;
		} else {

			ultimoAgregado.siguiente=nuevo;
			ultimoAgregado=nuevo;
			size++;
		}

	}

	
	@Override
	public boolean contains(E referencia) {

		Node<E> aux = new Node(referencia);

		boolean encontrado = false;

		while (aux.elemento != null && !encontrado) {
			if (aux.elemento == referencia) {
				encontrado = true;
			} else {

				aux = aux.siguiente;
			}

		}

		return encontrado;
	}

	

	@Override
	public boolean offer(E e) {
		Node<E> nuevo = new Node(e);

		if (isEmpty()) {
			cabeza = nuevo;
			ultimoAgregado= cabeza;
			size++;
		} else {

			ultimoAgregado.siguiente=nuevo;
			ultimoAgregado=nuevo;
			size++;
		}
	
		return true;
	}
	@Override
	public E get(int i) {
		E element= cabeza.elemento;
		for (int j = 0; j < i; j++) {
			element= cabeza.siguiente.elemento;
		}
		return element;
	}

	@Override
	public E poll() {
		Node<E> nuevo= new Node<E>(cabeza.elemento);
		cabeza=cabeza.siguiente;
		size--;
		
		
		return nuevo.elemento;
	}

	@Override
	public E peek() {
		// TODO Auto-generated method stub
		return cabeza.elemento;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return  cabeza == null;
	}

	
}

