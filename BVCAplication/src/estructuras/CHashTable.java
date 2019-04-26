package estructuras;

import java.util.Hashtable;
import java.util.LinkedList;

@SuppressWarnings("unused")
public class CHashTable<K, V> {

	@SuppressWarnings("hiding")
	public class Node<K, V> {
		public K key;
		public V value;

		public Node<K, V> siguiente;

		public Node(K key, V value) {
			this.key = key;
			this.value = value;
			siguiente = null;
		}
	}

	private Node<K, V>[] cList;

	public static final Integer size = 1000;

	@SuppressWarnings("unchecked")
	public CHashTable() {
		cList = new Node[size];

	}

	public int fuctionHash(K key) {

		int valorHash = key.hashCode() % size;

		return valorHash;
	}

	public int fuctionHash2(K key) {

		int valorHash = (key.hashCode() & 0x7FFFFFFF) % size;

		return valorHash;
	}

}
