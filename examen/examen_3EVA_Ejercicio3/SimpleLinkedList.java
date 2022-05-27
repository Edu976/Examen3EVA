package examen_3EVA_Ejercicio3;

public class SimpleLinkedList {

	private Node first;
	private int size;

	public SimpleLinkedList() {
		super();
		this.first = null;
		this.size = 0;
	}

	public SimpleLinkedList(Node first) {
		super();
		this.first = first;
		this.size = 1;
	}

	public SimpleLinkedList(Node first, int size) {
		super();
		this.first = first;
		this.size = size;
	}

	public Node getFirst() {
		return first;
	}

	public void setFirst(Node first) {
		this.first = first;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public boolean add(Node node) {
		try {
			if (size == 0) {
				first = node;
			} else {
				/*
				 * el puntero p apunta al primero
				 * entra en el bucle y avanza el puntero al siguiente si hay un nodo detras
				 */
				Node p = first;
				for (int i = 1; i < size; i++) {
					p = p.getNext();
				}
				// si ya la i es igual a la longitud de la lista next esta apuntando al ultimo nodo
				// y sale del bucle
				// al salir del bucle apunta al que va a ser el nuevo ultimo nodo
				p.setNext(node);
			}
			size++;
			return true;
		} catch (Exception e) {
			System.out.println(e.toString());
			return false;
		}
	}
	
	public boolean add(int position, Node node) {
		// next es el puntero
		// a�adimos en la posicion 0
		// si la posicion es 0 setNext apunta al primero
		try {
			// a�adir al principio
			if(position == 0) {
				node.setNext(first);
				first = node;
			}
			// a�ade al final
			else if(position == size) {
				return add(node);
			}
			//a�ade en la posicion n
			else {
				Node p = first;
				for (int i = 1; i < position; i++) {
					p = p.getNext();
				}
				node.setNext(p.getNext());
				p.setNext(node);
			}
			size++;
			return true;
		}
		catch(Exception e){
			System.out.println(e.toString());
			return false;
		}
	}
	public boolean delete(int position) {
		try {
			// eliminar posicion 0
			if(position == 0) {
				System.out.println("eliminar primeros");
				Node p = first;
				first = first.getNext();
			}
			// eliminar ultima posicion
			else if(position == size - 1) {
				System.out.println("eliminar final");
				Node p = first;
				for(int i = 0; i < size - 1; i++) {
					//System.out.println(i);
					p = p.getNext();
				}
				p.setNext(null);
			}
			// eliminar en medio
			else {
				Node p = first;
				System.out.println("eliminar en medio");
				for(int i = 0; i < position -1; i++) {
					//System.out.println(p);
					p = p.getNext();
				}
				p.setNext(p.getNext().getNext());
			}
			size--;
			return true;
		}
		catch(Exception e) {
			System.out.println(e.toString());
			return false;
		}
	}
	
	public Node get(int position) {
		try {
			if(size != 0 && position <= size) {
				Node p = first;
				for(int i = 1; i <= position; i++) {
					p = p.getNext();
				}
				return p;
			}
			else {
				System.out.println("fuera de indice");
				return null;
			}
		}
		catch(Exception e) {
			System.out.println(e.toString());		
		}
		return null;
	}
	
	public void show() {
		Node p = first;
		for (int i = 0; i < size; i++) {
			System.out.println("[ " + i + " ] ->" + p.getContent());
			p = p.getNext();
		}	
	}
}
